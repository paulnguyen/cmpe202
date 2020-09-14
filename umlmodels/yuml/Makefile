
clean:
	rm -f *.jpg *.svg

install:
	open https://yuml.me/diagram/scruffy/class/draw
	open https://github.com/wandernauta/yuml
	sudo pip install https://github.com/wandernauta/yuml/zipball/master

test:
	yuml -i test.yuml -o test.jpg -f jpg -t class -s scruffy 

test1:
	yuml -i test1.yuml -o test1.jpg -f jpg -t class -s scruffy 

test2:
	yuml -i test2.yuml -o test2.jpg -f jpg -t class -s scruffy 

test3:
	yuml -i test3.yuml -o test3.jpg -f jpg -t class -s scruffy 

test4:
	yuml -i test4.yuml -o test4.jpg -f jpg -t class -s scruffy 

test5:
	yuml -i test5.yuml -o test5.jpg -f jpg -t class -s scruffy 

yuml-post:
	curl -X POST https://yuml.me/diagram/scruffy/class -F 'dsl_text=[A]->[B]'

yuml-get:
	curl -X GET https://yuml.me/$(id).jpg --output yuml.jpg

	 
