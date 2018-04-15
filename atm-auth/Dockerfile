FROM openjdk:8
ADD target/atm-auth.jar atm-auth.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "atm-auth.jar"]