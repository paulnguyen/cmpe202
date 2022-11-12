

##
## Mongo on Kubernetes
##


rabbitmq-run:
	docker run --name rabbitmq \
			   -p 8080:15672 -p 4369:4369 -p 5672:5672 \
			   -d rabbitmq:3-management

rabbitmq-shell:
	docker exec -it rabbitmq bash 

# Basics 

docker-images:
	docker images

version:
	kubectl version

cluster:
	kubectl cluster-info

nodes:
	kubectl get nodes

pods:
	kubectl get pods --all-namespaces

pod-container-shell:
	kubectl exec -it $(pod) --container $(container) -- /bin/bash

deployments:
	kubectl get deployments

api-proxy:
	kubectl proxy

api-ping:
	curl -X GET http://localhost:8001/api 

api-version:
	curl http://localhost:8001/version

help-list-resources:
	kubectl get --help

help-show-resource:
	kubectl describe --help

help-container-logs:
	kubectl logs --help

help-container-cmd:
	kubectl exec --help

# Pod  

pod-create:
	kubectl create -f rabbitmq-pod.yaml

pod-get:
	kubectl get pods --namespace gumball rabbitmq

pod-shell:
	kubectl exec  --namespace gumball -it rabbitmq -- /bin/bash

pod-delete:
	kubectl delete pod --namespace gumball rabbitmq

# Deployment

deployment-create:
	kubectl create -f rabbitmq-deployment.yaml --save-config 

deployment-get:
	kubectl get --namespace gumball deployments

deployment-get-pods:
	kubectl get pods --namespace gumball -l name=rabbitmq

deployment-pod-shell:
	kubectl exec  --namespace gumball -it $(pod) -- /bin/bash

deployment-upgrade:
	kubectl apply --namespace gumball -f rabbitmq-deployment.yaml

deployment-delete:
	kubectl delete deployment --namespace gumball rabbitmq-deployment

# Service

service-create:
	kubectl create -f rabbitmq-service.yaml

service-get:
	kubectl get --namespace gumball services

service-get-ip:
	kubectl get --namespace gumball service rabbitmq-service -o wide

service-delete:
	kubectl delete --namespace gumball service rabbitmq-service



