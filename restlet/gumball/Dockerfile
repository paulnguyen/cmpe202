FROM openjdk
EXPOSE 8080
ADD ./dist/app.jar /srv/app.jar
ADD ./dist/restlet.jar /srv/restlet.jar
ADD ./dist/restlet-json.jar /srv/restlet-json.jar
ADD ./dist/json.jar /srv/json.jar
CMD java -cp /srv/restlet.jar:/srv/restlet-json.jar:/srv/json.jar:/srv/app.jar api.GumballServer