(ns zenerator.routes
  (:require
    [compojure.core :refer :all]
    [zenerator.pages :as page]
    [zenerator.soal.regtemplate :as reg]
    [noir.response :as resp]))

(def home
  (routes
    (GET "/" req
         (page/list-soal))
    (GET "/soal/:soalid"
         [soalid]
         (page/keluarin-soal (read-string soalid)))))

(def backoffice
  (routes
    (context "/backoffice" req
             (GET "/" req
                  (page/nambah-soal))
             (POST "/nambahsoal" req
                   (do (reg/nambahsoal (:params req))
                       (resp/redirect "/backoffice/"))))))

(defroutes
  all-routes
  (routes home backoffice))
