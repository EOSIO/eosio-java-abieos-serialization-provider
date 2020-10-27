FROM gradle@sha256:e006904a980138bf492cd242cbfe564affcc53865953898f20d861a4c9a33ea1
RUN apt-get update && \
    apt-get install -y g++-8 gcc-8 cmake && \
    update-alternatives --install /usr/bin/gcc gcc /usr/bin/gcc-7 700 --slave /usr/bin/g++ g++ /usr/bin/g++-7 && \
    update-alternatives --install /usr/bin/gcc gcc /usr/bin/gcc-8 800 --slave /usr/bin/g++ g++ /usr/bin/g++-8 && \
    apt-get clean && \
    g++ -v
