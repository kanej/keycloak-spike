docker pull jboss/keycloak

docker run -it --name keycloak -p 8080:8080 -p 9090:9090 jboss/keycloak
