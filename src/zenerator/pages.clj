(ns zenerator.pages
	(:use ring.util.anti-forgery)
	(:require
		[zenerator.layout :as view]
		[selmer.parser :as selmer]
		[zenerator.soal.daftar :as soal]))

(defn homepage
	[]
	(view/render "base.html"
							 {:title "This is the homepage"
								:headline "Wow"}))

(defn list-soal
	[]
	(view/render "listsoal.html"
							 {:soals (soal/all-soals)
								:title "This is list of soals"
								:headline "Ini list soal bung!"}))

(defn nambah-soal
	[]
	(view/render "nambahsoal.html"
							 {:title "Fook yah!"
								:headline "Whatevaaa!"
								:csrf-field (anti-forgery-field)}))

(defn keluarin-soal
	[soal-id]
	(let [{:keys [templatesoal function]}
				(soal/get-soal soal-id)]
		(view/render "container-soal.html"
								 {:title "Soal bung!"
									:headline "Apalaig"
									:soal (selmer/render templatesoal
																			 ((eval (read-string function))))})))
