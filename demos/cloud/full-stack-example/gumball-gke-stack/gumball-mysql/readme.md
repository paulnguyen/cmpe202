
# Go Gumball K8S Cloud SQL Example


## Kubernetes Localhost

kubectl create -f mysql-pod.yaml
kubectl get pods --namespace gumball

kubectl create -f mysql-service.yaml
kubectl get --namespace gumball services

kubectl create -f gumball-deployment.yaml --save-config 
kubectl get --namespace gumball deployments

kubectl create -f gumball-service.yaml
kubectl get --namespace gumball services

curl localhost:3000/ping
curl localhost:3000/gumball

export host=<public-id>
curl $host:9000/ping
curl $host:9000/gumball


## Kubernetes on GKE

https://cloud.google.com/sql/docs/mysql/quickstart

1. Go to the Cloud SQL Instances page in the Google Cloud Console.
2. Go to the Cloud SQL Instances page
3. Select your project and click Continue.
4. Click Create Instance.
5. Click MySQL.
6. Enter a value for Instance ID (Instance ID = cmpe281-mysql)
7. Enter a password for the root user (password = cmpe281)
8. Select Option for "Private IP" (Disable Public IP)
9. Use the default values for the other fields.
10. Click Create.
11. Create User and Password (for connection from all hosts)
	User: admin
	Password: cmpe281

- Test Connectivity from Pod Jumpbox

kubectl create -f jumpbox.yaml
kubectl exec -it jumpbox -- /bin/bash

apt-get update
apt-get install mysql-client 

mysql -u admin -p -h <db host> 
mysql -u admin -p -h 10.69.64.3 
	
- Deploy Gumball Service

kubectl create -f kubernetes-namespace.yaml

kubectl create -f gumball-deployment.yaml --save-config 
kubectl get --namespace gumball deployments

kubectl exec  --namespace gumball -it <deployment-pod>  -- /bin/bash
curl localhost:3000/ping
curl localhost:3000/gumball

kubectl create -f gumball-service.yaml
kubectl get --namespace gumball services

- Test Against Service Public IP

export host=<public-id>
curl $host:9000/ping
curl $host:9000/gumball





