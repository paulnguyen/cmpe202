all: clean

clean:
	mvn clean

compile:
	mvn compile

build: compile
	mvn package

run: build
	echo Starting Spring at:  http://localhost:8080
	java -jar target/spring-starbucks-api-3.1.jar --spring.profiles.active=dev

run-dev: build
	echo Starting Spring at:  http://localhost:8080
	java -jar target/spring-starbucks-api-3.1.jar --spring.profiles.active=dev

run-test: build
	echo Starting Spring at:  http://localhost:8080
	java -jar target/spring-starbucks-api-3.1.jar --spring.profiles.active=test



# MySQL DB


mysql:
	docker run -d --network starbucks --name mysql -td -p 3306:3306 -e MYSQL_ROOT_PASSWORD=cmpe172 mysql:8.0

mysql-shell:
	docker exec -it mysql bash 


# Docker

docker-build: build
	docker build -t spring-starbucks-api .
	docker images

starbucks-network:
	docker network create --driver bridge starbucks

docker-run: docker-build
	docker run --network starbucks -e "MYSQL_HOST=mysql" --name spring-starbucks-api -td -p 8080:8080 spring-starbucks-api	

docker-clean:
	docker stop spring-starbucks-api
	docker rm spring-starbucks-api
	docker rmi spring-starbucks-api

docker-shell:
	docker exec -it spring-starbucks-api bash 

docker-push:
	docker login
	docker build -t $(account)/spring-starbucks-api:latest .
	docker push $(account)/spring-starbucks-api:latest
	docker build -t $(account)/spring-starbucks-api:v3.1 .
	docker push $(account)/spring-starbucks-api:v3.1

# Compose

network-ls:
	docker network ls 

network-create:
	docker network create --driver bridge starbucks-network

network-prune:
	docker network prune

compose-up:
	docker-compose up --scale starbucks=2 -d

lb-up:
	docker-compose up -d lb 

starbucks-up:
	docker-compose up -d starbucks

mysql-up:
	docker-compose up -d mysql 

compose-down:
	docker-compose down 	

lb-stats:
	echo "user = admin | password = admin"
	open http://localhost:1936

lb-test:
	open http://localhost


# Pod

pod-run:
	kubectl apply -f pod.yaml

pod-list:
	kubectl get pods

pod-desc:
	kubectl describe pods spring-starbucks-api

pod-delete:
	kubectl delete -f pod.yaml

pod-shell:
	kubectl exec -it spring-starbucks-api -- /bin/bash

pod-logs:
	kubectl logs -f spring-starbucks-api

# Deployment

deployment-create:
	kubectl create -f deployment.yaml --save-config 

deployment-get:
	kubectl get deployments

deployment-get-pods:
	kubectl get pods -l name=spring-starbucks-api

deployment-pod-shell:
	kubectl exec -it $(pod) -- /bin/bash

deployment-upgrade:
	kubectl apply  -f deployment.yaml

deployment-delete:
	kubectl delete deployment spring-starbucks-api-deployment

# Service

service-create:
	kubectl create -f service.yaml

service-get:
	kubectl get services

service-get-ip:
	kubectl get service spring-starbucks-api -o wide

service-delete:
	kubectl delete service spring-starbucks-api

# Ingress

ingress-apply:
	kubectl apply -f ingress.yaml

ingress-ip:
	kubectl get ingress spring-starbucks-api-ingress


