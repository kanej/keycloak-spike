(ns user
  "Tools for interactive development with the REPL. This file should
  not be included in a production build of the application."
  (:require
   [clojure.java.io :as io]
   [clojure.java.javadoc :refer [javadoc]]
   [clojure.pprint :refer [pprint]]
   [clojure.reflect :refer [reflect]]
   [clojure.repl :refer [apropos dir doc find-doc pst source]]
   [clojure.set :as set]
   [clojure.string :as str]
   [clojure.test :as test]
   [clojure.tools.namespace.repl :refer [refresh refresh-all]]
   [clojure.tools.reader.edn :as edn]
   [digitalocean.v2.core :as do]
   [digitalocean :refer [create-keycloak-droplet destroy-keycloak-droplet]]))

(defonce credentials
  (edn/read-string (slurp "credentials.edn")))

(defonce token (:token credentials))

(def user-data (slurp "../user-data"))

(defn init []
  (def ssh-key-id
    (-> (do/ssh-keys token)
        :ssh_keys
        first
        :id)))

