(ns zenerator.soal.regtemplate
	(:require
		[com.ashafa.clutch :as cl]))

(def cdb "sibego")

(defn get-soalid
	[]
	(:soal (read-string (slurp "resources/soalid.edn"))))

(defn update-soalid!
	[current-id]
	(spit "resources/soalid.edn"
				{:soal current-id}))

(defn nambahsoal
	[{:keys [templatesoal function]}]
	(cl/put-document cdb
									 {:templatesoal templatesoal
										:function function
										:soalid   (let [id-baru (inc (get-soalid))]
																(do (update-soalid! id-baru)
																		id-baru))
										:type "template-soal"}))



