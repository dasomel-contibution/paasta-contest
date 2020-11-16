# 표준프레임워크 샘플 프로젝 
## 1. Dockerfile 생성
    FROM tomcat:9.0.39-jdk8-openjdk-buster
    LABEL maintainer=<dasomell@gmail.com>
    
    # WORKDIR /usr/local/tomcat
    ADD ./target/sample-1.0.0.war /usr/local/tomcat/webapps/sample.war
    
    EXPOSE 8080
## 2. deployment.yaml
    apiVersion: apps/v1
    kind: Deployment
    metadata:
      name: egov-sample
      labels:
        app: egov-sample
    spec:
      replicas: 1
      revisionHistoryLimit: 1
      selector:
        matchLabels:
          app: egov-sample
      template:
        metadata:
          labels:
            app: egov-sample
        spec:
          containers:
            - name: egov-sample
              image: dasomel/egov-sample:1.0
              ports:
                - containerPort: 8080
              imagePullPolicy: Always
              resources:
                requests:
                  cpu: 0.5
                  memory: 0.5Gi
                limits:
                  cpu: 0.5
                  memory: 0.5Gi
## 3. service,yml
    apiVersion: v1
    kind: Service
    metadata:
      name: egov-sample
    spec:
      type: NodePort
      selector:
        app: egov-sample
      ports:
      - protocol: TCP
        port: 8080
        targetPort: 8080
        nodePort: 30100
## 4. Complie & package
    mvn clean package
## 5. Dockerizing & push
    docker build . -t dasomel/egov-sample:1.0
    docker push dasomel/egov-sample:1.0
## 6. deploy kubernetes
    kubectl apply -f ./k8s/deployment.yaml
    kubectl apply -f ./k8s/service.yaml
## 7. Confirm
   http://아이피:30100/sample 