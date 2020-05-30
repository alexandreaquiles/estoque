(ns estoque.core)

;Loads the current file into the REPL
;ALT+SHIFT+L (Linux)
;Command+Shift+L(Mac)

;Loads the current LINE into the REPL
;ALT+SHIFT+P (Linux)
;Command+Shift+P

;Extend Selection
;CTRL+W (Linux)
;OPTION+UP (Mac)

;SLURP (Cursive)
;ALT+SHIFT+K (Linux)
;Command+SHIFT+K(Mac)

;map
;associative data structure
;subject -> num of page
;key -> value (pairs)


;(def sumario {"Conhecendo	o	Caelum	Eats"             1
;              "Peça	sua	comida	com	o	Caelum	Eats" 1
;              "Funcionalidades"                         1
;              "A	Arquitetura	do	Caelum	Eats"        13
;              "Exercício:	Executando	o	back-end"     14
;              "Exercício:	Executando	o	front-end"    15
;              "Um	negócio	em	expansão"               15})
;
;(println sumario)
;(keys sumario)
;(vals sumario)
;(count sumario)

;(class "Mochila")
;(class :mochila) ;Keyword

;(keys estoque)
;(vals estoque)

(def estoque {:mochila 10, :camiseta 5})

(assoc estoque :cadeira 3)

(println
  estoque)

;(assoc estoque :mochila 1)

(update estoque :mochila inc)

(defn my-decrement [value]
  (println "decrementing" value)
  (dec value))

(update estoque :mochila #(- % 3))


(dissoc estoque :mochila)
(dissoc estoque :mesa)

(def pedido {
             ;key     ;value
             :mochila {:quantidade 2
                       :preco 80}

             :camiseta {:quantidade 3
                        :preco 40}
             })


(println pedido)

(assoc pedido :chaveiro {:quantidade 1 :preco 10})

(pedido :mochila)
(pedido :mesa)

(get pedido :mochila)
(get pedido :mesa)

;(summary "Monolith")

(:mochila pedido)
(:mesa pedido)

(println (:quantidade (:mochila pedido)))

;(update pedido :mochila inc)
;(update pedido :mochila :quantidade inc)
(update-in pedido [:mochila :quantidade] inc)

(get-in pedido [:mochila :quantidade])

(assoc-in pedido [:mochila :desconto] 10)

;pipeline
;ps -ef | grep java | wc -l

((comp :quantidade :mochila) pedido)










;Threading
(-> pedido
    :mochila
    :quantidade
    println)













(def clients ["João", "Maria", "Pedro"])                    ;vector
(clients 0)
(first clients)
(second clients)
(rest clients)
(next clients)

(def ages { "João" 40, "Maria" 50, "Pedro" 60})                         ;map
(ages "João")
(first ages)
(second ages)
(rest ages)
(next ages)

(first fruits)
(second fruits)
(rest fruits)
(next fruits)

(def prices #{9.99 10.50})                                  ;set
(first prices)
(second prices)
(rest prices)
(next prices)
;doesn't keep the order
;can't duplicate elements

(map println clients)

(rest [])                                        ; empty list
(next [])                                        ;nil

(seq [1 2 3 4])
(seq [])


(defn for-each [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not (nil? primeiro))
      (do (funcao primeiro)
          (recur funcao (next sequencia))))))

(def clients ["João", "Maria", "Pedro"])                    ;vector

(for-each println clients)
(for-each println [])

(first '())
(first nil)
;function call has a stack (arguments, local variables)


(rest '(1))
(rest '())
(first '())
(next '())                                                  ; nil
(first nil)


;recursion
;infinite recursion


(for-each println clients)
(for-each println [])

(for-each println (range 10))
(for-each println (range 100000))

;optimized
;recursion turns into iteration (tail recursive)
;bytecode

;automatically TAIL CALL OPTIMIZATION
;Scala (compiler)
;Haskell
;Elixir
;Scheme (LISP)

;programatically



(defn has-any
  [predicate?, sequence]
  (let [e (first sequence)]
    (if (not (nil? e))
      (or (predicate? e)
          (recur predicate? (next sequence)))
      false)))

; e==>1
; (has-any even? '(3 2))
;e==>3
; (has-any even? '(2))
;e==>2


;(first '())
;(first nil)

(has-any even? [1 3 2])
;=> true

(has-any even? [3 5 1])
;=> false

(has-any even? [])
;=> false

(has-any even? nil)
;=> false

(empty? nil)
(empty? [])
(empty? [1, 2, 3])


(not (empty? nil))
(not (empty? []))
(not (empty? [1, 2, 3]))

(seq nil)
(seq [])
(seq [1 2 3])
(seq '(1 2 3))



(def fruits '("banana" "apple" "pear"))                    ;list

(println fruits)

(defn our-count
  [sequence]
  (println "my sequence is" sequence)
  (loop [amount 0
         elements sequence]
    (if (seq elements)                                     ;not-empty
      (recur (inc amount) (rest elements))
      amount)))

;(count fruits)
(our-count fruits)
;(our-count 0 fruits)




