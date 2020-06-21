FROM java:8

VOLUME /tmp

ADD SpringbootAssignment-0.0.1-SNAPSHOT.jar SpringbootAssignment.jar

RUN bash -c 'touch /SpringbootAssignment.jar'

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/SpringbootAssignment.jar"]