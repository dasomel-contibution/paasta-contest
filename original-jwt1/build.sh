mvn clean package
# local
docker build -t localhost:5000/common-original-jwt1:1.0 .
docker push localhost:5000/common-original-jwt1:1.0

#hub.docker.com
docker build -t dasomel/common-original-jwt1:1.0 .
docker push dasomel/common-original-jwt1:1.0

kubectl apply -f ./k8s/deployment.yaml
kubectl apply -f ./k8s/service.yaml