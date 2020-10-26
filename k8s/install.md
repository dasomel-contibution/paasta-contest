# 1. mariadb
## pv, pvc 생성(로컬용)
    * CaaS에서는 권한문제로 PV생성 안
    kubectl apply -f mariadb-hostpath.yaml
## mariadb 생성(테스트 중)
    helm install mariadb bitnami/mariadb --set auth.rootPassword=비밀번호 --set primary.persistence.existingClaim=mariadb-pvc --set primary.service.type=NodePort --set primary.service.nodePort=31000