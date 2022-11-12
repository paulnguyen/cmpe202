
# Pod

pod-run:
	kubectl apply -f phptest-pod.yaml

pod-list:
	kubectl get pods

pod-desc:
	kubectl describe pods phptest

pod-delete:
	kubectl delete -f phptest-pod.yaml

pod-shell:
	kubectl exec -it phptest -- /bin/bash

pod-logs:
	kubectl logs -f phptest

port-forward:
	kubectl port-forward phptest 8080:80

# Deployment

deployment-create:
	kubectl create -f phptest-deployment.yaml --save-config 

deployment-get:
	kubectl get deployments

deployment-get-pods:
	kubectl get pods -l name=phptest

deployment-pod-shell:
	kubectl exec -it $(pod) -- /bin/bash

deployment-upgrade:
	kubectl apply  -f phptest-deployment.yaml

deployment-delete:
	kubectl delete deployment phptest-deployment

# Service

service-create:
	kubectl create -f phptest-service.yaml

service-get:
	kubectl get services

service-get-ip:
	kubectl get service phptest-service -o wide

service-delete:
	kubectl delete service phptest-service



