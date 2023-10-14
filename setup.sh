#!/bin/bash

java_version="8u181"
additional="b13"
jdk_version="1.8.0_181"
echo $java_version
wget "https://repo.huaweicloud.com/java/jdk/$java_version-$additional/jdk-$java_version-linux-x64.tar.gz"

mkdir /opt/jdk
tar -xf "jdk-$java_version-linux-x64.tar.gz" -C "/opt/jdk"

update-alternatives --install /usr/bin/java java "/opt/jdk/jdk$jdk_version/bin/java" 100

update-alternatives --install /usr/bin/javac javac "/opt/jdk/jdk$jdk_version/bin/javac" 100

