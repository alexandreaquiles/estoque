(ns estoque.desconto)

;Good Practices

;split code into smaller pieces
; reuse
; compose
;readability

;PREDICATE - it returns true or false
;IMPERATIVE x DECLARATIVE

;(defn mais-caro-que-100?
;  [valor-bruto]
;  (println "called mais-caro-que-100? with" valor-bruto)
;  (> valor-bruto 100))
;(mais-caro-que-100? 1000)
;(mais-caro-que-100? 100)


;HIGH ORDER FUNCTIONS
;FIRST CLASS CITIZEN - FUNCTIONAL PROGRAMMING LANGUAGE
;IMMUTABILITY - Persistent Data Structures (Vector)
;ANONYMOUS FUNCTION

;(defn sorteado? [_]
;  (> (rand) 0.5))

;(println (valor-descontado (fn [valor-bruto] (> valor-bruto 100) ) 1000))

;(println (valor-descontado #(> %1 100) 1000))
;(println (valor-descontado #(> % 100) 1000))

;(println (valor-descontado (> valor-bruto 100) 1000))

;(println (valor-descontado (fn [_] (> (rand) 0.5)) 300))

;(println (valor-descontado #(> (rand) 0.5) 300))

(defn mais-caro-que?
  [valor-de-comparacao valor-bruto]
  (> valor-bruto valor-de-comparacao))



;(defn mais-caro-que?
;  [valor-de-comparacao]
;  (fn [valor-bruto] (> valor-bruto valor-de-comparacao) )
;  #(> % valor-de-comparacao))

(def mais-caro-que-100? (fn [valor-bruto] (> valor-bruto 100) ))
;
;(if (> valor-bruto 100)
;  valor-bruto)

(defn valor-descontado
  "Retorna o valor descontado que é 90% do valor bruto" ;docstring
  [ valor-bruto]
    (let [taxa-de-desconto (/ 10 100)
          desconto (- 1 taxa-de-desconto)]
      (* valor-bruto desconto)))

;(mais-caro-que? 100)

;(println (valor-descontado (partial mais-caro-que? 100)  1000))

;HIGH ORDER FUNCTIONS
; receive functions as arguments
; return functions
