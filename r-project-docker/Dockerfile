#dockerfile文件


#基础环境镜像，必须是首个命令
FROM java:8
#维护者的信息
MAINTAINER ladyishenlong
#指向了tmp文件，tomcat 默认使用/tmp作为工作目录
VOLUME /tmp
#将target文件夹下以jar结尾的文件加入docker并命名为 aap.jar
ADD target/*.jar app.jar
#指定端口
EXPOSE 8011
ENTRYPOINT ["java","-jar","/app.jar"]
