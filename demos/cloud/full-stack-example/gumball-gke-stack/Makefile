
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

create-namespace:
	kubectl create -f kubernetes-namespace.yaml

kube-namespace-services:
	kubectl get services -n gumball 

docker-ps:
	 docker ps --all --format "table {{.ID}}\t{{.Names}}\t{{.Image}}\t{{.Status}}\t"

docker-ps-ports:
	 docker ps --all --format "table {{.Names}}\t{{.Ports}}\t"

##
## API Test (Docker Compose / Kubernetes)
##

test-ping:
	curl localhost:9000/ping

test-get-inventory:
	curl localhost:9000/gumball

test-update-inventory:
	curl -X PUT \
  	http://localhost:9000/gumball \
  	-H 'Content-Type: application/json' \
  	-d '{ \
  		"CountGumballs": 1000 }' 

test-place-order:
	curl -X POST \
  	http://localhost:9000/order \
  	-H 'Content-Type: application/json'

test-order-status:
	curl -X GET \
  	http://localhost:9000/order \
  	-H 'Content-Type: application/json'

test-process-order:
	curl -X POST \
  	http://localhost:9000/orders \
  	-H 'Content-Type: application/json'



# Jump Box Pod 

jumpbox-create:
	kubectl create  --namespace gumball -f jumpbox.yaml

jumpbox-get:
	kubectl get --namespace gumball pod jumpbox

jumpbox-shell:
	kubectl exec  --namespace gumball -it jumpbox -- /bin/bash

jumpbox-delete:
	kubectl delete --namespace gumball pod jumpbox

jumpbox-docker:
	docker run --name jumpbox -d mongo:3.7



##
## API Test inside Jump Box (Kubernetes Service)
##


jumpbox-ping:
	curl http://gumball-service:9000/ping

jumpbox-get-inventory:
	curl http://gumball-service:9000/gumball

jumpbox-update-inventory:
	curl -X PUT \
  	http://gumball-service:9000/gumball \
  	-H 'Content-Type: application/json' \
  	-d '{ \
  		"CountGumballs": 1000 }' 

jumpbox-place-order:
	curl -X POST \
  	http://gumball-service:9000/order \
  	-H 'Content-Type: application/json'

jumpbox-order-status:
	curl -X GET \
  	http://gumball-service:9000/order \
  	-H 'Content-Type: application/json'

jumpbox-process-order:
	curl -X POST \
  	http://gumball-service:9000/orders \
  	-H 'Content-Type: application/json'


