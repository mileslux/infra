FROM centosjava8
EXPOSE 8080
EXPOSE 19000
ENV JAVA_OPTS="-agentlib:jdwp=transport=dt_socket,address=19000,suspend=n,server=y"
ADD build/distributions/infra-1.0.tar /
ADD src/main/resources/application.yaml /
ENTRYPOINT ["/infra-1.0/bin/infra", "server", "/application.yaml"]
