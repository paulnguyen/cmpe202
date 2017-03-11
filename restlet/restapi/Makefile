all: clean compile 

clean:
	rm -rf build/*
	rm -f dist/app.jar
	find . -name "*.class" -exec rm -rf {} \;

app: compile
	cd build ; jar -cvfe ../dist/app.jar HelloWorldServer .

test: compile app
	java -cp dist/restlet.jar:dist/restlet-json.jar:dist/app.jar helloworld.HelloWorldServer

compile: 
	javac -cp \
	dist/json.jar:\
	dist/restlet.jar:\
	dist/restlet-json.jar:\
	dist/restlet-jackson.jar:\
	dist/jackson-core-2.8.3.jar:\
	dist/jackson-annotations-2.8.3.jar \
	-d build \
	src/mailserver/*.java \
	src/helloworld/*.java

docker-build: app
	docker build -t restapi .
	docker images

docker-clean:
	docker stop restapi
	docker rm restapi
	docker rmi restapi

docker-run:
	docker run --name restapi -td restapi
	docker ps

docker-run-host:
	docker run --name restapi -td --net=host restapi
	docker ps

docker-run-bridge:
	docker run --name restapi -td -p 80:8080 restapi
	docker ps

docker-network:
	docker network inspect host
	docker network inspect bridge

docker-stop:
	docker stop restapi
	docker rm restapi

docker-shell:
	docker exec -it restapi bash 
	
run-hello:
	echo Starting Service at:  http://localhost:8080/restlet/hello
	echo Cloud9 Endpoint: https://design-paulnguyen.c9users.io/restlet/hello
	java -cp build:dist/restlet.jar helloworld.HelloWorldServer

run-client:
	java -cp build:dist/restlet.jar helloworld.HelloWorldClient

run-echo:
	echo Starting Service at:  http://localhost:8111
	java -cp build:dist/restlet.jar helloworld.EchoServer

run-mail-server-filter:
	echo Starting Service at:  http://localhost:8111
	java -cp build:dist/restlet.jar mailserver.MailServerApplication

run-mail-server-resources:
	echo Starting Service at:  http://localhost:8111
	java -cp build:dist/restlet.jar mailserver.MailServerApplication2

run-mail-client:
	echo Running Mail Client
	java -cp build:dist/restlet.jar mailserver.MailClient

run-mail-server-json:
	echo Starting Service at:  http://localhost:8080
	java -cp build:dist/restlet.jar:dist/restlet-json.jar:dist/json.jar mailserver.MailServerApplication3

run-mail-server-jackson:
	echo Starting Service at:  http://localhost:9000
	java -cp build:dist/restlet.jar:dist/restlet-json.jar:dist/json.jar:dist/restlet-jackson.jar:dist/jackson-core-2.8.3.jar:dist/jackson-annotations-2.8.3.jar:dist/jackson-dataformat-smile-2.8.3.jar:dist/jackson-databind-2.8.3.jar:dist/jackson-dataformat-xml-2.8.3.jar:dist/jackson-dataformat-yaml-2.8.3.jar:dist/jackson-dataformat-csv-2.8.3.jar mailserver.MailServerApplication4


