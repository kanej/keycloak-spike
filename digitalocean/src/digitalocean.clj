(ns digitalocean
  (:require [digitalocean.v2.core :as do]))

(defn create-keycloak-droplet [token ssh-key-id]
  (do/create-droplet token nil
    {:name "keycloak"
     :region "lon1"
     :size "512mb"
     :image "coreos-beta"
     :ssh_keys [ssh-key-id]}))

(def destroy-keycloak-droplet
  (do/generic :delete :droplets))
