
all: clean compile 

clean:
	rm -rf build/*
	rm -f dist/app.jar
	find . -name "*.class" -exec rm -rf {} \;

app: compile
	cd build ; jar -cvfe ../dist/app.jar GumballServer .

test: compile app
	java -cp dist/restlet.jar:dist/restlet-json.jar:dist/json.jar:dist/app.jar api.GumballServer

compile: 
	javac -cp dist/restlet.jar:dist/restlet-json.jar:dist/json.jar -d build \
	src/gumball/*.java \
	clients/loadtestclient/*.java \
	src/api/*.java

run:
	echo Starting Service at:  http://localhost:8080
	java -cp build:dist/restlet.jar:dist/restlet-json.jar:dist/json.jar api.GumballServer

loadtest:
	echo Starting Load Test on localhost
	java -cp build:dist/restlet.jar:dist/restlet-json.jar:dist/json.jar RunLoadTest 5

docker-build: app
	docker build -t gumball .
	docker images

docker-clean:
	docker stop gumball
	docker rm gumball
	docker rmi gumball

docker-run:
	docker run --name gumball -td gumball
	docker ps

docker-run-host:
	docker run --name gumball -td --net=host gumball
	docker ps

docker-run-bridge:
	docker run --name gumball -td -p 80:8080 gumball
	docker ps

docker-network:
	docker network inspect host
	docker network inspect bridge

docker-stop:
	docker stop gumball
	docker rm gumball

docker-shell:
	docker exec -it gumball bash 
	
