(ns digitalocean
  (:require [digitalocean.v2.core :as do]))

(defn create-keycloak-droplet [token ssh-key-id user-data]
  (do/create-droplet token nil
    {:name "keycloak"
     :region "lon1"
     :size "512mb"
     :image "coreos-beta"
     :private_networking true
     :ssh_keys [ssh-key-id]
     :user_data user-data}))

(def destroy-keycloak-droplet
  (do/generic :delete :droplets))
