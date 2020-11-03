mvn clean package
# local
docker build -t localhost:5000/common-original:latest .
docker push localhost:5000/common-original:latest

#hub.docker.com
docker build -t dasomel/common-original:latest .
docker push dasomel/common-original:latest


kubectl apply -f deployment.yaml
kubectl apply -f service.yaml