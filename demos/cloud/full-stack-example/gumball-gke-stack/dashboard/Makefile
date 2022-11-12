
##
## Kubernetes (Docker for Mac)
##

clean-up:
	kubectl delete --all pods --namespace=gumball
	kubectl delete --all deployments --namespace=gumball
	kubectl delete --all services --namespace=gumball

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

install-dashboard:
	kubectl create -f kubernetes-dashboard.yaml

run-dashboard:
	kubectl port-forward $(pod) 8443:8443 --namespace=kube-system

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



