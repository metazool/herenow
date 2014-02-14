(ns herenow.routes.home
  (:use compojure.core)
  (:require [herenow.views.layout :as layout]
            [herenow.util :as util]))


(defn home-page []
  (layout/render
    "base.html"))


(defroutes home-routes
  (GET "/" [] (home-page)))
