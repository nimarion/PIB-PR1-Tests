FROM openjdk:15-jdk-slim

RUN apt-get update && apt-get install curl gpg git -y

COPY library-scripts/zsh.sh /tmp/library-scripts/
RUN bash /tmp/library-scripts/zsh.sh

ENV SDKMAN_DIR="/usr/local/sdkman"
ENV PATH=${SDKMAN_DIR}/bin:${SDKMAN_DIR}/candidates/maven/current/bin:${PATH}
COPY library-scripts/maven.sh /tmp/library-scripts/
RUN apt-get update && bash /tmp/library-scripts/maven.sh "latest" "${SDKMAN_DIR}"