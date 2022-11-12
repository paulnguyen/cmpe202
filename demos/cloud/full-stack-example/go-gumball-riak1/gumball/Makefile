
##
## Gumball Riak
##

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
	go get -v github.com/streadway/amqp
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

compose-up:
	docker-compose up 

compose-down:
	docker-compose down 	

mysql-up:
	docker-compose up -d mysql

riak-up:
	docker-compose scale coordinator=1 member=4

riak-up-1:
	docker-compose scale coordinator=1 member=1

riak-up-3:
	docker-compose scale coordinator=1 member=3

riak-up-4:
	docker-compose scale coordinator=1 member=4

riak-down:
	docker-compose stop coordinator
	docker-compose stop member	

nodejs-up:
	docker-compose scale nodejs=1 

nodejs-down:
	docker-compose stop nodejs
	docker-compose rm nodejs

gumball-up:
	docker-compose scale gumball=1 

gumball-scale:
	docker-compose scale gumball=2 

gumball-down:
	docker-compose stop gumball
	docker-compose rm gumball

gumball-logs:
	docker logs gumball_gumball_1

cassandra-up:
	docker-compose scale cassandra=1

kong-up:
	docker-compose scale kong=1

gumball-shell:
	docker exec -it gumball_gumball_1 bash
	#docker exec -it gumball_gumball_run_1 bash

mysql-shell:
	docker exec -it gumball_mysql_1 bash

cassandra-shell:
	docker exec -it gumball_cassandra_1 bash

kong-shell:
	docker exec -it gumball_kong_1 bash 

riak-status:
	docker-compose exec coordinator riak-admin cluster status 

riak-console:
	open http://localhost:8098/admin/ 

riak-logs:
	docker-compose logs

riak-inspect-coordinator:
	docker inspect gumball_coordinator_1

riak-shell:
	docker exec -it $(node) bash 

riak-shell-node1:
	docker exec -it gumball_coordinator_1 bash
	#riak ping
	#riak-admin test

riak-shell-node2:
	docker exec -it gumball_member_1 bash

riak-shell-node3:
	docker exec -it gumball_member_2 bash

riak-shell-node4:
	docker exec -it gumball_member_3 bash

riak-shell-node5:
	docker exec -it gumball_member_4 bash

riak-nodes:
	docker ps -q -f label=com.basho.riak.cluster.name=riakkv

riak-hosts:
	./riakhosts.sh

riak-inspect:
	docker inspect $(node)

docker-network:
	docker network ls

docker-network-inspect:
	docker network inspect host

network-create:
	docker network create gumball_network

network-prune:
	docker network prune	

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
  	http://localhost:3000/order/$(id) \
  	-H 'Content-Type: application/json'

test-process-order:
	curl -X POST \
  	http://localhost:3000/order/$(id) \
  	-H 'Content-Type: application/json'

kong-add-api:
	curl -X POST \
  	http://localhost:8001/apis \
  	-H 'Content-Type: application/json' \
  	-d '{ \
	"name": "goapi", \
	"request_path": "/goapi", \
	"strip_request_path": "true", \
	"preserve_host": "true", \
	"upstream_url": "http://gumball:3000/" \
	}'

kong-add-auth:
	curl -X POST \
  	http://localhost:8001/apis/goapi/plugins \
    -H 'content-type: multipart/form-data;' \
    -F name=key-auth

kong-add-client:
	curl -X POST \
  	http://localhost:8001/consumers/ \
    -H 'content-type: multipart/form-data;' \
    -F username=apiclient

kong-add-apikey:
	curl -X POST \
  	http://localhost:8001/consumers/apiclient/key-auth \
    -H 'Content-Type: text/plain'

kong-test-ping:
	curl -X GET \
  	http://localhost:8888/goapi/ping \
  	-H 'Content-Type: application/json' \
  	-H 'apikey: $(key)'

kong-test-inventory:
	curl -X GET \
  	http://localhost:8888/goapi/gumball \
  	-H 'Content-Type: application/json' \
  	-H 'apikey: $(key)'

kong-test-place-order:
	curl -X POST \
  	http://localhost:8888/goapi/order \
  	-H 'Content-Type: application/json' \
  	-H 'apikey: $(key)' 

kong-test-get-order:
	curl -X GET \
  	http://localhost:8888/goapi/order/$(id) \
  	-H 'Content-Type: application/json' \
  	-H 'apikey: $(key)' 

kong-test-process-order:
	curl -X POST \
  	http://localhost:8888/goapi/order/$(id) \
  	-H 'Content-Type: application/json' \
  	-H 'apikey: $(key)' 


