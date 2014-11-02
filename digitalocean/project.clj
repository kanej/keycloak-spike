(defproject digitalocean "0.1.0-SNAPSHOT"
  :description "Boot up a test vm on Digital Ocean"
  :url "https://github.com/kanej/keycloak-spike"
  :license {:name "TODO: Choose a license"
            :url "http://choosealicense.com/"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [digitalocean "1.2"]
                 [org.clojure/tools.reader "0.8.11"]]
  :profiles {:dev {:dependencies [[org.clojure/tools.namespace "0.2.7"]]
                   :source-paths ["dev"]}})
