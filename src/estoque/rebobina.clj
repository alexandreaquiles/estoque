(ns estoque.rebobina)
;
;(defn recibo
;  [cliente filme valor-de-locacao dias]
;  (println "Recibo para" cliente)
;  (println "Aluguel" filme)
;  (println "Valor total:" (valor-de-locacao dias))
;  )
;
;(def historico [2 3 2 5 6 2 3 4 2])
;
;(defn calcula-faturado-dia [historico]
;  (reduce + (map valor-de-locacao-normal historico)))
;
;(println (calcula-faturado-dia historico))
;
;(defn calcula-faturado-com-dias-extras [historico]
;  (reduce + (map valor-de-locacao-normal (filter #(> % 2) historico))))
;(println (calcula-faturado-com-dias-extras historico))

;(defn valor-de-locacao-normal
;  [days]
;  (+ 2 (* 1.5 (- days 2))))
;
;(defn valor-de-locacao-lancamento
;  [days]
;  (* 3 days))

;(println ((:normal valores-de-locacao) 2))
;(println ((:normal valores-de-locacao) 3))
;(println ((:lancamento valores-de-locacao) 2))

;
;(def rental-values {
;                    :normal normal-rent
;                    :release release-rent
;                    })
;(def data {:days 6
;           :type :normal})
;((-> data
;     :type
;     rental-values) (:days data))
;
;(-> data
;    (-> data
;        :type
;        rental-values)
;    :days)
;
;(:days normal-rent)

;nil

(defn valor-de-locacao-normal
  [dias]
  (let [preco-base 2
        preco-dia-extra 1.5
        dias-extra (- dias 2)]
    (+ preco-base
       (* dias-extra preco-dia-extra))))

(defn valor-de-locacao-lancamento
  [dias]
  (let [preco-base 3]
    (* dias preco-base)))

(def valores-de-locacao
  {:normal     valor-de-locacao-normal,
   :lancamento valor-de-locacao-lancamento})


(def historico [{:nome  "Alexandre"
                 :filme {:titulo "De Volta Para o Futuro"
                         :tipo   :normal}
                 :dias  5},

                {:nome  "Andreia"
                 :filme {:titulo "História Sem Fim"
                         :tipo   :normal}
                 :dias  2},

                {:nome  "Carlos"
                 :filme {:titulo "Rocky VII"
                         :tipo   :lancamento}
                        :dias  3}])


(defn valor-de-locacao-normal
  [days]
  (let [fixed-fee 2
        rest-days (max 0 (- days 2))
        rest-days-fee (* rest-days 1.5)]
    (+ fixed-fee rest-days-fee)))


(defn valor-de-locacao-lancamento
  [days]
  (* days 3))

(def valores-de-locacao {:normal valor-de-locacao-normal
                         :lancamento valor-de-locacao-lancamento})


(defn valor-locacao
  [locacao]
  (let [tipo-filme (-> locacao :filme :tipo)
        aplica-valor-locacao (get valores-de-locacao tipo-filme)
        dias (:dias locacao)
        valor (aplica-valor-locacao dias)]
    valor))

(defn total-historico
  [historico]
  (->> historico
       (map valor-locacao)
       (reduce +)))


(total-historico historico)

(defn usd-para-brl
  [usd]
  (let [taxa-de-conversao 5.88]
    (* usd taxa-de-conversao)))

(defn chf-para-usd
  [chf]
  (let [taxa-de-conversao 1.03]
    (* chf taxa-de-conversao)))



(def chf-para-brl (comp chf-para-usd usd-para-brl))

(chf-para-brl 100)



