(ns zenerator.soal.mainan)

(fn []
	(let [bahanv (range 10 20)
				bahanh (range 100 200)
				v (rand-nth bahanv)
				h (rand-nth bahanh)
				jawaban (* v h)]
		{:v v :h h :jawaban jawaban}))
