## Dockerでの実行方法
```
./gradlew dockerfile
cd /mnt/d/Projects/micronaut-labo/GraalVMLabo/build
docker image build -t micronaut-labo/graalvmlabo:latest -f docker/Dockerfile .
docker container run -p 8080:8080 --name graalvmlabo micronaut-labo/graalvmlabo:latest

docker container ls -a
docker container stop graalvmlabo
docker container rm graalvmlabo
docker image ls -a
docker image rm micronaut-labo/graalvmlabo
docker system prune -a
```
```
./gradlew dockerfileNative
cd /mnt/d/Projects/micronaut-labo/GraalVMLabo/build
docker image build -t micronaut-labo/graalvmlabo-native:latest -f docker/DockerfileNative .
docker container run -p 8080:8080 --name graalvmlabo-native micronaut-labo/graalvmlabo-native:latest

docker container ls -a
docker container stop graalvmlabo-native
docker container rm graalvmlabo-native
docker image ls -a
docker image rm micronaut-labo/graalvmlabo-native
docker system prune -a

```

```
Macで成功
sdk use java 21.1.0.r11-grl
gu install native-image
chmod +x gradlew
./gradlew nativeImage
./build/native-image/application
```