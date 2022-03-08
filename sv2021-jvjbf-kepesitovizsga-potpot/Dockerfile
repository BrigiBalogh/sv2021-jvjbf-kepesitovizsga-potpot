FROM adoptopenjdk:17-jre-hotspot as builder
WORKDIR application
COPY targetsv2021-jvjbf-kepesitovizsga-potpot-1.0-SNAPSHOT.jar gardeningservices.jar
RUN java -Djarmode=layertools -jar gardeningservices.jar extract

FROM adoptopenjdk:17-jre-hotspot
WORKDIR application
#RUN apt update \
    # && apt-get install wget \
    # && apt-get install -y netcat \
    # && wget https://raw.githubusercontent.com/vishnubob/wait-for-it/master/wait-for-it.sh \
    # && chmod +x ./wait-for-it.sh
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./
ENTRYPOINT ["java", \
"org.springframework.boot.loader.JarLauncher"]