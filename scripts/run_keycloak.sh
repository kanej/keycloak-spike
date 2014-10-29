docker pull jboss/keycloak

docker run -it --name keycloak -p 80:8080 -p 90:9090 jboss/keycloak
