FROM openjdk:17-jdk AS base


EXPOSE 8080

ADD target/bookingJar.jar    bookingJar.jar


ENTRYPOINT ["java", "-jar", "/bookingJar.jar"]



