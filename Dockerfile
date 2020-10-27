#FROM alpine:3.6
FROM gradle:alpine

VOLUME ["/project"]
WORKDIR ["/project"]

USER root

RUN apk update && \
    apk upgrade && \
    apk --update add \
        #gcc \
        #g++ \
        cmake \
        alpine-sdk boost-dev boost-static libusb-dev llvm-dev llvm-static curl-dev gmp-dev gettext-dev \
        #build-base \
        #bash \
        #libstdc++ && \
    rm -rf /var/cache/apk/*

#ADD ./scripts/cmake-build.sh /build.sh
#RUN chmod +x /build.sh

USER gradle

RUN g++ -v
