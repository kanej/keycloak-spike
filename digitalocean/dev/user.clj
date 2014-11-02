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
   [digitalocean]))

(defonce credentials
  (let [config-as-text (slurp "credentials.edn")]
    (edn/read-string config-as-text)))

(defonce token (:token credentials))

(defn power-off [token droplet-id]
  (do/run-request :post
              (do/resource-url (str "droplets/" droplet-id "/actions"))
              token
              {:type "power_off"}))