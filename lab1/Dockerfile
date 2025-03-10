FROM openjdk:11-jdk-slim

WORKDIR /app

COPY . .

# Use alternative mirrors
RUN echo "deb http://deb.debian.org/debian/ bullseye main" > /etc/apt/sources.list && \
    echo "deb http://security.debian.org/debian-security bullseye-security main" >> /etc/apt/sources.list && \
    echo "deb http://deb.debian.org/debian/ bullseye-updates main" >> /etc/apt/sources.list

RUN apt-get update && \
    apt-get install -y openjfx

RUN javac --module-path /usr/share/openjfx/lib --add-modules=javafx.controls -Xlint:unchecked Main.java Employee.java Project.java Task.java TimeLog.java Department.java

ENTRYPOINT ["java", "-Dprism.order=sw", "--module-path", "/usr/share/openjfx/lib", "--add-modules", "javafx.controls", "Main"]