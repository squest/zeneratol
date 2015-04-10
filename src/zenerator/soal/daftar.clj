(ns zenerator.soal.daftar
	(:require [com.ashafa.clutch :as cl]))

(def cdb "sibego")

(defn get-soal
	[soal-id]
	(let [data-soal (->> {:key soal-id}
											 (cl/get-view cdb "viewSoal" "bySoalId")
											 first :value)]
		{:templatesoal (:templatesoal data-soal)
		 :function (:function data-soal)
		 :soal-id soal-id}))

(defn all-soals
	[]
	(->> (cl/get-view cdb "viewSoal" "bySoalId")
			 (map :value)
			 (map #(hash-map :link (str "/soal/" (:soalid %))
											 :title (str "soal no " (:soalid %))))))
