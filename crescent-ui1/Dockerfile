FROM nginx:alpine

# Added Maintainer Info here. Details of Anshul Gautam
LABEL maintainer="anshulgammy@outlook.com"

# Added a volume
VOLUME ui-datavolume:/volume/data/ui

EXPOSE 7700

COPY nginx.conf /etc/nginx/nginx.conf

WORKDIR /usr/share/nginx/html

COPY dist/Crescent/ .