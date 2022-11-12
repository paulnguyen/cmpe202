

## ===============
## Jump Box Docker
## ===============


### Create Jump Box Container

	docker run --name jumpbox -t -d ubuntu

### Jump Box Shell

	docker exec -it jumpbox bash 

### Delete Jump Box

	docker stop jumpbox
	docker rm jumpbox


## =======================
## Jump Box Kubernetes POD
## =======================


### Create Jump Box POD

	kubectl create  --namespace gumball -f jumpbox.yaml

### Get Jump Box POD

	kubectl get --namespace gumball pod jumpbox

### Jump Box POD Shell

	kubectl exec  --namespace gumball -it jumpbox -- /bin/bash

### Delete Jump Box POD

	kubectl delete --namespace gumball pod jumpbox


## =========================
## Install Tools in Jump Box
## =========================

	
### Install Curl & Ping in your "Jump Box"
	
	apt-get update
	apt-get install curl
	apt-get install iputils-ping
	
### Install Redis Client in your "Jump Box"

	apt install redis-server

	redis-cli -h <host> -p 6379
		
### Install Riak Client in your "Jump Box"

	http://docs.basho.com/riak/kv/2.2.3/setup/installing/debian-ubuntu/
	
	curl https://packagecloud.io/gpg.key | apt-key add -
	apt-get install -y apt-transport-https

	apt-get isntall vim

	RUN SCRIPT:

	#!/bin/bash
	HOSTNAME=`hostname -f`
	FILENAME=/etc/apt/sources.list.d/basho.list
	OS=ubuntu
	DIST=precise
	PACKAGE_CLOUD_RIAK_DIR=https://packagecloud.io/install/repositories/basho/riak
	curl "${PACKAGE_CLOUD_RIAK_DIR}/config_file.list?os=${OS}&dist=${DIST}&name=${HOSTNAME}" > $FILENAME

	apt-get update
	apt-get install riak

	riak start
	riak ping
	riak console
	riak-admin test
	
### Install MySQL Client in your "Jump Box"

	apt-get update
	apt-get install mysql-client 
	
	mysql -u <user> -p -h <db host> <db name>

### Install Mongo Client in your "Jump Box"

	https://docs.mongodb.com/manual/tutorial/install-mongodb-on-ubuntu/

	apt-get update
	apt-get install mongodb
	
	mongo <host>:<port>/<database> -u <username> -p <password>


