#base docker image

FROM openjdk:11
LABEL maintainer="Prafull Gururani"
ADD target/Oblivion-Obv1.0.jar ObvDemo.jar
ENTRYPOINT ["java", "-jar","ObvDemo.jar"]