
all: clean

clean: 
	find . -name 'gumball' -type f -exec rm -f {} \; 
	go clean

go-get:
	rm -rf src/github.com
	go get -v github.com/codegangsta/negroni
	go get -v github.com/gorilla/mux
	go get -v github.com/unrolled/render
	go get -v github.com/satori/go.uuid
	go get -v database/sql
	go get -v github.com/go-sql-driver/mysql

run:
	go run src/app/$(app).go

main:
	go run src/app/main.go

format:
	go fmt gumball

install:
	go install gumball

build:
	go build gumball

start:
	./gumball 

docker-build: 
	docker build -t gumball .
	docker images

network-create:
	docker network create --driver bridge gumball

network-inspect:
	docker network inspect gumball

mysql-run:
	docker run -d --name mysql --network gumball -td -p 3306:3306 -e MYSQL_ROOT_PASSWORD=cmpe281 mysql:5.5

docker-run:
	docker run -d --name gumball --network gumball -td -p 3000:3000 gumball


docker-shell:
	docker exec -it gumball bash 

kong-shell:
	docker exec -it kong bash 

docker-network:
	docker network ls

docker-network-inspect:
	docker network inspect host

docker-clean:
	docker stop mysql
	docker rm mysql
	docker stop gumball
	docker rm gumball
	docker rmi gumball

docker-ip:
	docker-machine ip

docker-ps:
	 docker ps --all --format "table {{.ID}}\t{{.Names}}\t{{.Image}}\t{{.Status}}\t"

docker-ps-ports:
	 docker ps --all --format "table {{.Names}}\t{{.Ports}}\t"

test-ping:
	curl localhost:3000/ping

test-get-inventory:
	curl localhost:3000/gumball

test-update-inventory:
	curl -X PUT \
  	http://localhost:3000/gumball \
  	-H 'Content-Type: application/json' \
  	-d '{ \
  		"CountGumballs": 1000 }' 

test-place-order:
	curl -X POST \
  	http://localhost:3000/order \
  	-H 'Content-Type: application/json'

test-order-status:
	curl -X GET \
  	http://localhost:3000/order \
  	-H 'Content-Type: application/json'

test-process-order:
	curl -X POST \
  	http://localhost:3000/orders \
  	-H 'Content-Type: application/json'



# Pod  

pod-create:
	kubectl create -f $(pod)-pod.yaml

pod-get:
	kubectl get pods --namespace gumball $(pod)

pod-shell:
	kubectl exec  --namespace gumball -it $(pod) -- /bin/bash

pod-delete:
	kubectl delete pod --namespace gumball $(pod)

# Deployment

deployment-create:
	kubectl create -f gumball-deployment.yaml --save-config 

deployment-get:
	kubectl get --namespace gumball deployments

deployment-get-pods:
	kubectl get pods --namespace gumball -l name=$(pod)

deployment-pod-shell:
	kubectl exec  --namespace gumball -it $(pod) -- /bin/bash

deployment-upgrade:
	kubectl apply --namespace gumball -f gumball-deployment.yaml

deployment-delete:
	kubectl delete deployment --namespace gumball gumball-deployment

# Service

service-create:
	kubectl create -f $(pod)-service.yaml

service-get:
	kubectl get --namespace gumball services

service-get-ip:
	kubectl get --namespace gumball service $(pod)-service -o wide

service-delete:
	kubectl delete --namespace gumball service $(pod)-service



