(ns estoque.pedidos)

;Destructuring a clojure.lang.MapEntry
(defn imprime [[key value]]
  ;(println (valor 0) "<===>" (valor 1))
  (println key "<===>" value)
  value)

(map imprime pedido)

; clojure.lang.MapEntry -> vectors with 2 elements [key value]
;===> [:mochila {:quantidade 2, :preco 80}]
;===> [:camiseta {:quantidade 3, :preco 40}]



;(defn precos-dos-produtos [[_ details]]
;  (* (:quantidade details) (:preco details)))

; Threading first (-> )
; result of the previous call
; will be the FIRST argument of the next function

; Threading last (->> )
;resulta of the previous call
;will be the LAST argument of the next function

;(reduce function collection)

(def pedido {
             :mochila {:quantidade 2
                       :preco 80}

             :camiseta {:quantidade 3
                        :preco 40}

             :chaveiro {:quantidade 5, :preco 0}

             :caneca {:quantidade 1}
             })

(defn gratuito? [item]
  (<= (get item :preco 0) 0))

(gratuito? (:mochila pedido))
(gratuito? (:chaveiro pedido))
(gratuito? (:caneca pedido))
(gratuito? {})

;(filter gratuito? (vals pedido))
;(filter gratuito? pedido)
;(filter (fn [[_ item]] (gratuito? item)) pedido)
(filter #(gratuito? (second %)) pedido)

;(defn pago? [item]
;  (not (gratuito? item)))

(def pago?
  (comp not gratuito?))

(pago? (:mochila pedido))
(pago? (:chaveiro pedido))
(pago? (:caneca pedido))
(pago? {})




(defn precos-dos-produtos [produto]
  (println produto)
  (* (:quantidade produto) (:preco produto)))

(precos-dos-produtos {:quantidade 5 :preco 100})

(precos-dos-produtos (:mochila pedido))

(vals pedido)

(defn total-do-pedido
  [pedido]
  (->> pedido
       vals
      (map precos-dos-produtos)
      (reduce +)))

(total-do-pedido pedido)





(first [:mochila {:quantidade 2, :preco 80}])
(second [:mochila {:quantidade 2, :preco 80}])











