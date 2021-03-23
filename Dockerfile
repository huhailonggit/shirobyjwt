FROM java:8
ADD ./target/shirobyjwt-0.0.1-SNAPSHOT.jar //
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' > /etc/timezone
ENTRYPOINT ["java", "-Dfile.encoding=utf-8","-jar", "/shirobyjwt-0.0.1-SNAPSHOT.jar"]