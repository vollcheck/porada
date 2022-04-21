(ns porada.core
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.route :as route]
            [ring.adapter.jetty :as ring]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [hiccup.page :as page]
            ;; [porada.data :refer [get-random-def]]
            [porada.components :refer [home about four-oh-four]]))

(defroutes routes
  (GET "/" [] (home))
  (GET "/about" [] (about))
  (route/not-found (four-oh-four)))

(def application (wrap-defaults routes site-defaults))

(defonce server
  (ring/run-jetty application {:port 8080 :join? false}))

(defn start-server []
  (.start server))

(defn stop-server []
  (.stop server))

(defn -main []
  (println "Hey"))

(comment
  (defn restart []
    (stop-server)
    (start-server))

  (restart)

  (:name (get-random-def))

  )
