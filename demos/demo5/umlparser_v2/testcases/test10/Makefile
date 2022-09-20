
clean:
	rm -f *.class

install:
	open https://yuml.me/diagram/scruffy/class/draw
	open https://github.com/wandernauta/yuml
	sudo pip install https://github.com/wandernauta/yuml/zipball/master

compile:
	javac *.java

yuml:
	yuml -i test10.yuml -o test10.jpg -f jpg -t class -s scruffy 
