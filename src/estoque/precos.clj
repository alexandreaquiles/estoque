(ns estoque.precos
  (:require
    [estoque.desconto :as d]))

(println precos)

(precos 0)
(precos 1)
(precos 2)
(precos 99)

(get precos 0)
(get precos 1)
(get precos 2)
(get precos 99)

(get precos 99 -1)

(conj precos 5)

;(conj 5 precos) NOOOO

(def age 10)
(+ age 1)
(println age)

(inc age)


(update precos 0 inc)







(defn my-increment [value]
  (println "incrementing" value)
  (+ value 1))

(update precos 0 my-increment)
(update precos 1 my-increment)





(def precos [30 700 1000])

;for(preco in/of precos)

(map d/valor-descontado precos)

(filter d/mais-caro-que-100? precos)

(map d/valor-descontado (filter #(> % 100) precos))

(map #(* %1 2) (filter even? (range 10)))

(reduce + precos)

;map / reduce / filter


(defn my-sum [a b]
  (println "adding" a "and" b)
  (+ a b))


(reduce my-sum (range 5))

(reduce my-sum [15])
;(reduce my-sum [])

(reduce my-sum 0 precos)

(def precos [30 700 1000])

(reduce + (map d/valor-descontado (filter d/mais-caro-que-100? precos)))














