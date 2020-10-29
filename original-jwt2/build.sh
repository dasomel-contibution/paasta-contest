mvn clean package
# local
docker build -t localhost:5000/common-original-jwt2:2.0 .
docker push localhost:5000/common-original-jwt2:2.0

#hub.docker.com
docker build -t dasomel/common-original-jwt12:2.0 .
docker push dasomel/common-original-jwt2:2.0