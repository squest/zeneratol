(ns zenerator.pages
	(:require
		[zenerator.layout :as view]))

(defn homepage
	[]
	(view/render "base.html"
							 {:title "This is the homepage"
								:headline "Wow"}))
