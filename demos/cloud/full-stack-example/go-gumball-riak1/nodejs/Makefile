all: clean

clean: 
	find . -name '*.log' -type f -exec rm -f {} \; 

run:
	node app.js

docker-build: 
	docker build -t nodejs .
	docker images

docker-run:
	docker run -d --name nodejs --link kong:kong -td -p 8080:8080 nodejs

docker-shell:
	docker exec -it kong bash 

docker-clean:
	docker stop nodejs
	docker rm nodejs
