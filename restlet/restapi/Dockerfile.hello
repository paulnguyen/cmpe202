FROM openjdk

EXPOSE 8080

ADD ./dist/app.jar /srv/app.jar
ADD ./dist/restlet.jar /srv/restlet.jar

CMD java -cp /srv/restlet.jar:/srv/restlet-json.jar:/srv/app.jar helloworld.HelloWorldServer
