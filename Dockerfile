FROM registry.access.redhat.com/ubi8/openjdk-11:1.15

ENV LANGUAGE='en_US:en'
ENV JAVA_OPTS="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"
ENV JAVA_APP_JAR="/deployments/quarkus-run.jar"

COPY --chown=185 target/quarkus-app/ /deployments/

EXPOSE 8080
USER 185
