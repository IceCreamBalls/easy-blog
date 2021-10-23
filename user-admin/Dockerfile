# springBoot和Docker整合
# VERSION 0.0.1
# Author: KingYiFan
# 安装jdk8
FROM java:8

#维护者
MAINTAINER cheeringandann<1647513375@qq.com>

VOLUME /temp

#将jar包添加到docker容器并更名为draw.jar 并放到/kingyifan目录
ADD  ./target/user-admin-0.0.1-SNAPSHOT.jar user-admin.jar

#映射端口号
EXPOSE 8090

# 运行jar包
ENTRYPOINT ["java","-Xmx80m","-jar", "user-admin.jar"]