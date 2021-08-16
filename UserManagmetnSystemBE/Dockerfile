FROM java:openjdk-8-jdk-alpine

COPY target/usermanagment-1.0.jar  /home/usermanagment-1.0.jar
RUN chmod 777 /home/usermanagment-1.0.jar

EXPOSE 1010

CMD ["java" , "-jar" , "/home/usermanagment-1.0.jar"]

