(ns zenerator.routes
  (:require
    [compojure.core :refer :all]
    [zenerator.pages :as page]))

(def home
  (routes
    (GET "/" req
         (page/homepage))))

(def backoffice
  (routes
    (context "/backoffice" req
             (GET "/" req
                  "This is the backoffice"))))

(defroutes
  all-routes
  (routes home backoffice))
