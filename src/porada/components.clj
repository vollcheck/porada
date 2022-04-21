(ns porada.components
  (:require [hiccup.page :as h]
            [porada.data :refer [get-random-def]]))


(defn common [title & body]
  (h/html5
   [:head
    [:meta {:charset "utf-8"}]
    [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge,chrome=1"}]
    [:meta {:name "viewport" :content
            "width=device-width, initial-scale=1, maximum-scale=1"}]
    [:title title]]
   [:body
    [:div {:id "header"}
     [:h1 {:class "container"} "Porada"]]
    [:div {:id "content" :class "container"} body]]))

(defn four-oh-four []
  (common "Page Not Found"
          [:div {:id "four-oh-four"}
           "The page you requested could not be found"]))

(def title "Porada - Clojure Documentation Tip Of The Day")

(defn about []
  (common
   title
   [:body
    [:div
     {:id "content"}
     "Porada is a simple web application sourced from clojuredocs.org"]]))

(defn home []
  (let [r (get-random-def)]
    (common
     title
     [:body
      [:h1 (:name r)]
      [:div {:id "content"} (:doc r)]])))
