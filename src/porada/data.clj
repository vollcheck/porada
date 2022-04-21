(ns porada.data
  (:require [clojure.java.io :as java]
            [cheshire.core :as cheshire]))

(def data-filename "resources/vars.json")
;;(def data-filename "resources/example-definition2.json")

(def draw-fn (comp rand-nth first vec))

(defn get-random-def
  ([]
   (get-random-def data-filename))
  ([filename]
   (-> filename
       clojure.java.io/reader
       (cheshire/parsed-seq true)
       (draw-fn))))
