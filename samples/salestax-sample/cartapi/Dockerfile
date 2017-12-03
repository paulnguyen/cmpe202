FROM openjdk

EXPOSE 8080

ADD ./build/libs/cartapi-all.jar /srv/cartapi-all.jar

CMD java -cp /srv/cartapi-all.jar api.CartServer
