# 표준프레임워크 샘플 프로젝트
## 1. /k8s/deployment.yaml
    apiVersion: apps/v1
    kind: Deployment
    metadata:
      name: sample-boot2-keycloak
      labels:
        app: sample-boot2-keycloak
    spec:
      replicas: 2
      revisionHistoryLimit: 1
      selector:
        matchLabels:
          app: sample-boot2-keycloak
      template:
        metadata:
          labels:
            app: sample-boot2-keycloak
        spec:
          containers:
            - name: sample-boot2-keycloak
              image: dasomel/sample-boot2-keycloak:1.0.0
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
## 2. /k8s/service.yml
    apiVersion: v1
    kind: Service
    metadata:
      name: sample-boot2-keycloak
    spec:
      type: NodePort
      selector:
        app: sample-boot2-keycloak
      ports:
      - protocol: TCP
        port: 8080
        targetPort: 8080
        nodePort: 30103
## 3. build & dockerizing
    ./gradlew clean war bootRepackage
    docker build . -t dasomel/sample-boot2-keycloak:1.0.0
    docker push dasomel/sample-boot2-keycloak:1.0.0
## 4. kubernetes build & deploy
    kubectl apply -f ./k8s/deployment.yaml
    kubectl apply -f ./k8s/service.yaml
## 5. Confirm
    
    
## 1. local-ingress.yaml
##### kubectl apply -f ./k8s/local-ingress.yaml
    apiVersion: networking.k8s.io/v1beta1
    kind: Ingress
    metadata:
      name: opdc-ingress
    spec:
      rules:
        - host: sample.io
          http:
            paths:
              - path: /sample
                backend:
                  serviceName: egov-sample
                  servicePort: 8080
              - path: /maven
                backend:
                  serviceName: sample-boot
                  servicePort: 8080
        - host: sample2.io
          http:
            paths:
              - path: /gradle
                backend:
                  serviceName: sample-boot2
                  servicePort: 8080
## 2. Confirm
    http://127.0.0.1:30102/keycloak/egovSampleList.do
    http://sample2.io/keycloak/egovSampleList.do
    