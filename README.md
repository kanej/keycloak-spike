Keycloak + Clojure Spike
========================

Some investigations into working with keycloak from Clojure.

Usage
-----

You need to install vagrant and virtualbox to run the keycloak server as a dev vm.

To start the keycloak server:

    > vagrant up
    > vagrant ssh
    $ fleetctl start ./share/units/keycloak.service

