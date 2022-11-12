
##
## Kubernetes (Docker for Mac)
##

version:
	kubectl version

cluster:
	kubectl cluster-info

config:
	kubectl config view

nodes:
	kubectl get nodes

list-pods:
	kubectl get pods

list-all-pods:
	kubectl get pods --all-namespaces

list-system-pods:
	kubectl get pods --namespace=kube-system

dashboard-install:
	kubectl create -f kubernetes-dashboard.yaml

dashboard-proxy:
	kubectl proxy

dashboard-get-token:
	kubectl -n kubernetes-dashboard describe secret $(kubectl -n kubernetes-dashboard get secret | grep admin-user | awk '{print $1}')

dashboard-open:
	open http://localhost:8001/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/.

start-api-proxy:
	kubectl proxy --port=8080 

list-deployments:
	kubectl get deployments

describe-pod:
	kubectl describe pod $(pod)

docker-ps:
	 docker ps --all --format "table {{.ID}}\t{{.Names}}\t{{.Image}}\t{{.Status}}\t"

docker-ps-ports:
	 docker ps --all --format "table {{.Names}}\t{{.Ports}}\t"



