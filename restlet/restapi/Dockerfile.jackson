FROM openjdk

EXPOSE 9000

ADD ./dist/app.jar /srv/app.jar
ADD ./dist/restlet.jar /srv/restlet.jar
ADD ./dist/restlet-json.jar /srv/restlet-json.jar
ADD ./dist/json.jar /srv/json.jar
ADD ./dist/restlet-jackson.jar /srv/restlet-jackson.jar
ADD ./dist/jackson-core-2.8.3.jar /srv/jackson-core-2.8.3.jar
ADD ./dist/jackson-annotations-2.8.3.jar /srv/jackson-annotations-2.8.3.jar
ADD ./dist/jackson-dataformat-smile-2.8.3.jar /srv/jackson-dataformat-smile-2.8.3.jar
ADD ./dist/jackson-databind-2.8.3.jar /srv/jackson-databind-2.8.3.jar
ADD ./dist/jackson-dataformat-xml-2.8.3.jar /srv/jackson-dataformat-xml-2.8.3.jar
ADD ./dist/jackson-dataformat-yaml-2.8.3.jar /srv/jackson-dataformat-yaml-2.8.3.jar
ADD ./dist/jackson-dataformat-csv-2.8.3.jar /srv/jackson-dataformat-csv-2.8.3.jar 

CMD java -cp /srv/app.jar:/srv/restlet.jar:/srv/restlet-json.jar:/srv/json.jar:/srv/restlet-jackson.jar:/srv/jackson-core-2.8.3.jar:/srv/jackson-annotations-2.8.3.jar:/srv/jackson-dataformat-smile-2.8.3.jar:/srv/jackson-databind-2.8.3.jar:/srv/jackson-dataformat-xml-2.8.3.jar:/srv/jackson-dataformat-yaml-2.8.3.jar:/srv/jackson-dataformat-csv-2.8.3.jar mailserver.MailServerApplication4