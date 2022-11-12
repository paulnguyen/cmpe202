
# Go Gumball K8S Pod Example


## Kubernetes Localhost

* Build and push Gumball image to Docker Hub

	use docker.sh
	- login
	- build
	- push

* Run Pod

	kubectl apply -f pod.yaml
	kubectl get pods
	kubectl describe pods gumball
	kubectl port-forward gumball 3000:3000
	kubectl exec -it gumball -- /bin/bash
	kubectl logs -f gumball
	kubectl delete -f pod.yaml

	curl localhost:3000/ping
	curl localhost:3000/gumball


## Kubernetes GKE

* Build and push Gumball image to Docker Hub

	use docker.sh
	- login
	- build
	- push

* Run Pod

	kubectl apply -f pod.yaml
	kubectl get pods
	kubectl describe pods gumball

	k8s / workload / gumball / expose --> port 3000
	kubectl create -f pod-frontend.yaml
	kubectl get services --watch

	curl $host:3000/ping
	curl $host:3000/gumball




