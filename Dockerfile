FROM openjdk:11
ADD target/banking-transactions-0.0.1-SNAPSHOT.jar banking-transactions-0.0.1-SNAPSHOT.jar
EXPOSE 8086
ENTRYPOINT ["java","-jar","banking-transactions-0.0.1-SNAPSHOT.jar"]
