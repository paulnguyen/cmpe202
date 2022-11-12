

# Go Gumball Sample Stack on Kubernetes

kubectl create -f kubernetes-namespace.yaml
kubectl create -f kubernetes-dashboard.yaml
kubectl get pods --namespace=kube-system
export pod=<dashboard-pod>
kubectl port-forward $pod 8443:8443 --namespace=kube-system


# Kubernetes Localhost

## Mongo

kubectl create -f mongo-pod.yaml
kubectl get pods --namespace gumball mongo
kubectl exec  --namespace gumball -it mongo -- /bin/bash

kubectl create -f mongo-service.yaml
kubectl get --namespace gumball services

-- Gumball MongoDB Collection (Create Document)

Database Name: cmpe281
Collection Name: gumball

> mongo

use cmpe281
show dbs

db.createUser(
   {
     user: "admin",
     pwd: "cmpe281",  
     roles: [ "readWrite", "dbAdmin" ]
   }
) ;


db.gumball.insert(
    { 
      Id: 1,
      CountGumballs: NumberInt(281),
      ModelNumber: 'M102988',
      SerialNumber: '1234998871109' 
    }
) ;

-- Gumball MongoDB Collection - Find Gumball Document

db.gumball.find( { Id: 1 } ) ;


## RabbitMQ

kubectl create -f rabbitmq-pod.yaml
kubectl get pods --namespace gumball rabbitmq
kubectl exec  --namespace gumball -it rabbitmq -- /bin/bash

kubectl create -f rabbitmq-service.yaml
kubectl get --namespace gumball services

-- RabbitMQ Create Queue:  

Queue Name: gumball
Durable:	no

> rabbitmqadmin declare queue name=gumball durable=false
> rabbitmqadmin list queues vhost name node messages 

export host=localhost
export user=guest
export passwd=guest

rabbitmqadmin -u $user -p $passwd -H $host list queues name node messages

## Gumball API

kubectl create -f gumball-deployment.yaml --save-config 
kubectl get --namespace gumball deployments
kubectl get pods --namespace gumball -l name=gumball
kubectl exec  --namespace gumball -it <pod> -- /bin/bash

kubectl create -f gumball-service.yaml
kubectl get --namespace gumball services

curl localhost:3000/ping
curl localhost:3000/gumball

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

export host=<public-ip>

curl $host:9000/ping
curl $host:9000/gumball

export host=<public-ip>

test-place-order:
	curl -X POST \
  	http://$host:9000/order \
  	-H 'Content-Type: application/json'

test-order-status:
	curl -X GET \
  	http://$host:9000/order \
  	-H 'Content-Type: application/json'

test-process-order:
	curl -X POST \
  	http://$host:9000/orders \
  	-H 'Content-Type: application/json'



# Kubernetes on GKE

* https://cloud.google.com/solutions/using-gcp-services-from-gke


## Mongo

-- Install MongoDB (From Marketplace) into Google Compute Engine VM

* https://console.cloud.google.com/marketplace/details/bitnami-launchpad/mongodb
* https://docs.bitnami.com/google/infrastructure/mongodb/get-started/first-steps/
* https://docs.bitnami.com/google/infrastructure/mongodb/administration/change-reset-password/

1. Click "Launch" from Marketplace
2. Select "cmpe281" Project
3. Set the following options:
  - Deployment Name:  mongodb
  - Machine Type:     micro
  - Boot Disk:        standard persistent disk (10 GB)
  - Networking:       (leave as default cmpe281 network)
4. Click "Deploy"
5. Note the:
  - Admin User:       root
  - Temp Password:    GvTWo8TRnqdi (for example)
6. Go to Compute Engine -> VM Instances
7. Note the "Internal IP Address" 
  - For Example:      10.138.0.9 (Internal IP for MongoDB VM)
8. Connect via SSH


-- Gumball MongoDB Collection (Create Document)

Database Name: cmpe281
Collection Name: gumball

> ssh into instance
> mongo --username root --password --host <host>

> mongo --username root --password --host 10.138.0.9
  (enter temp password from deployment)

use cmpe281
show dbs

db.createUser(
   {
     user: "admin",
     pwd: "cmpe281",  
     roles: [ "readWrite", "dbAdmin" ]
   }
) ;

db.gumball.insert(
    { 
      Id: 1,
      CountGumballs: NumberInt(281),
      ModelNumber: 'M102988',
      SerialNumber: '1234998871109' 
    }
) ;

-- Gumball MongoDB Collection - Find Gumball Document

db.gumball.find( { Id: 1 } ) ;


## Create GKE Namespace

kubectl create -f kubernetes-namespace.yaml


## RabbitMQ

-- Install RabbitMQ (From Marketplace)

* https://www.rabbitmq.com/getstarted.html
* https://console.cloud.google.com/marketplace/details/google/rabbitmq
* https://github.com/GoogleCloudPlatform/click-to-deploy/blob/master/k8s/rabbitmq/README.md

1. Click "Configure" from Marketplace
2. Select "cmpe281" Project
3. Set the following options:
   - GKE Cluster:               cmpe281
   - GKE Namespace:             gumball
   - Instance Name:             rabbitmq
   - # of Replicas:             3
   - Username:                  rabbit
   - RabbitMQ Service Account:  (create new one)
4. On GKE Applications for RabbitMQ.  Get Admin User's Password.
   - Username = rabbit
   - Password = ZracSMjs9k8b
5. On GKE Services for RabbitMQ.  Note the Service Name.
   (i.e. RabbitMQ Service Name = rabbitmq-rabbitmq-svc)

* The deployment creates two services:

    1. A client-facing service, to be used for client connections to the RabbitMQ cluster with port forwarding or using a LoadBalancer

    2. Service discovery - a headless service for connections between the RabbitMQ nodes.

* The RabbitMQ K8s application has the following ports configured:

    1. ports 5671 and 5672 are enabled for communication from AMQP clients
    2. port 4369 is enabled to allow for peer discovery
    3. port 15672 is enabled for RabbitMQ administration over HTTP API
    4. port 25672 is enabled as a distribution port for communication with CLI tools


-- Open Up Access to RabbitMQ Service

kubectl patch service/rabbitmq-rabbitmq-svc \
  --namespace gumball \
  --patch '{"spec": {"type": "LoadBalancer"}}'

open http://<external-ip>:15672


-- RabbitMQ Create Queue:  

Queue Name: gumball
Durable:  no

Web Portal:

open http://<external-ip>:15672
create new transient queue named "gumball"

Or on Command Line:

> rabbitmqadmin declare queue name=gumball durable=false
> rabbitmqadmin list queues vhost name node messages 


## Setup GKE Firewall Rule to Allow Pods access to VMs

* https://cloud.google.com/kubernetes-engine/docs/troubleshooting#autofirewall
* https://cloud.google.com/sdk/gcloud/reference/compute/firewall-rules/create
* https://cloud.google.com/kubernetes-engine/docs/how-to/exposing-apps

-- Create Firewall Rule 

1. Find your cluster's network:
   
   > gcloud container clusters describe cmpe281 --zone us-central1-c --format=get"(network)"
   > cmpe281

2. Then get the cluster's IPv4 CIDR used for the containers:

   > gcloud container clusters describe cmpe281 --zone us-central1-c --format=get"(clusterIpv4Cidr)"
   > 10.16.0.0/14

3. Finally create a firewall rule for the network, with the CIDR as the source range, 
   and allow all protocols:

   > gcloud compute firewall-rules create "cmpe281-to-all-vms-on-network" --network="cmpe281" --source-ranges="10.16.0.0/14" --allow=tcp:27017

   > Creating firewall...done.
   > NAME                           NETWORK  DIRECTION  PRIORITY  ALLOW       DENY  DISABLED
   > cmpe281-to-all-vms-on-network  cmpe281  INGRESS    1000      tcp:27017         False


## Setup GKE Jumpbox 

* https://docs.mongodb.com/manual/tutorial/install-mongodb-on-ubuntu/

kubectl create --namespace gumball -f jumpbox.yaml
kubectl exec  --namespace gumball -it jumpbox  -- /bin/bash

apt-get update
apt-get install curl
apt-get install iputils-ping
apt-get install python3

curl -Ls https://raw.githubusercontent.com/rabbitmq/rabbitmq-management/v3.8.3/bin/rabbitmqadmin > rabbitmqadmin
chmod +x rabbitmqadmin
cp rabbitmqadmin /usr/local/bin
ln -s /usr/bin/python3 /usr/bin/python


## Test MongoDB & RabbitMQ Connectivity from Jumpbox

kubectl exec  --namespace gumball -it jumpbox  -- /bin/bash

mongo --username admin --password --host 10.138.0.9 cmpe281
(Password: cmpe281)

db.gumball.find( { Id: 1 } ) ;

rabbitmqadmin -u rabbit -p <password> -H <host-ip-address> -P 15672 list queues name node messages

export host=10.81.11.48 
export host=rabbitmq-rabbitmq-svc
export passwd=ZracSMjs9k8b

rabbitmqadmin -u rabbit -p $passwd -H $host -P 15672 list queues name node messages

kubectl --namespace gumball get service rabbitmq-rabbitmq-svc --output yaml
 

## Gumball API

-- Test Gumball API inside POD

kubectl create -f gumball-pod.yaml
kubectl exec  --namespace gumball -it gumball  -- /bin/bash
kubectl logs --namespace gumball gumball

curl localhost:3000/ping
curl localhost:3000/gumball

curl -X POST \
  http://localhost:3000/order \
  -H 'Content-Type: application/json'


-- Deploy Gumball API Cluster

kubectl create -f gumball-deployment.yaml --save-config 
kubectl get --namespace gumball deployments

export pod=<gumball-pod-inside-deployment>

kubectl exec  --namespace gumball -it $pod -- /bin/bash
kubectl logs --namespace gumball $pod
    
curl localhost:3000/ping
curl localhost:3000/gumball

curl -X POST \
  http://localhost:3000/order \
  -H 'Content-Type: application/json'

curl -X GET \
  http://localhost:3000/order \
  -H 'Content-Type: application/json'

curl -X POST \
  http://localhost:3000/orders \
  -H 'Content-Type: application/json'


-- Deploy Gumball API Service

kubectl create -f gumball-service.yaml
kubectl get --namespace gumball services


-- Test Against Service IP

export host=<public-id>

curl $host:9000/ping
curl $host:9000/gumball

curl -X POST \
  http://$host:9000/order \
  -H 'Content-Type: application/json'

curl -X GET \
  http://$host:9000/order \
  -H 'Content-Type: application/json'

curl -X POST \
  http://$host:9000/orders \
  -H 'Content-Type: application/json'





