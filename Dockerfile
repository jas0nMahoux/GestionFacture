FROM openjdk:17
WORKDIR /
ADD target/*.jar app.jar
RUN useradd -m myuser
USER myuser
EXPOSE 80
CMD java -jar -Dspring.profiles.active=prod app.jar