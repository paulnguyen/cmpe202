all: clean

clean:
	mvn clean

compile:
	mvn compile

build: compile
	mvn package

run: build
	echo Starting Spring at:  http://localhost:8081
	mvn spring-boot:run


