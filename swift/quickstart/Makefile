all: clean 

clean:
	docker stop swift
	docker rm swift
	docker rmi paulnguyen/swiftdocker 

ubuntu:
	docker run -d --name swift \
		-v /tmp:/tmp \
		-v "/Users/pnguyen/Desktop/GIT/github/code/swift/swiftdocker:/home/root/swift" \
		ubuntu:18.04 tail -f /dev/null

save:
	docker commit swift paulnguyen/swiftdocker
	docker push paulnguyen/swiftdocker

start:
	docker run --privileged -d --name swift \
		-v /tmp:/tmp \
		-v "/Users/pnguyen/Desktop/GIT/github/code/swift/swiftdocker:/home/root/swift" \
		 paulnguyen/swiftdocker tail -f /dev/null	

bash:
	docker exec -it swift bash 

install:
	apt-get update
	apt-get install vim
	apt-get install clang 
	apt-get install make
	apt-get install libpython2.7
	apt-get install libxml2
	#apt-get install libatomic1
	#apt-get install libedit2
	#apt-get install libpython2.7-dev
	#apt-get install libcurl3
	

hello:
	mkdir Hello 
	cd Hello
	swift package init
	swift build
	swift test 

ver:
	swift -version

bashrc:
	PATH=$PATH:/root/swift/bin
	export PATH
	#LD_LIBRARY_PATH=$LD_LIBRARY_PATH:/root/swift/lib
	#export LD_LIBRARY_PATH



