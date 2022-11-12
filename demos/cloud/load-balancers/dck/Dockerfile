FROM php:7.2-apache
EXPOSE 80
RUN apt-get update -y
RUN apt-get install stress -y
RUN cp "$PHP_INI_DIR/php.ini-production" "$PHP_INI_DIR/php.ini"
COPY ./*.html /var/www/html/
COPY ./*.php /var/www/html/

