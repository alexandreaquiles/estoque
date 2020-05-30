(ns estoque.store
  (:use clojure.pprint)
  (:require [estoque.db :as e.db]))

;(defn our-grouping-function
;  [element]
;  ;(println "element" element)
;  (:usuario element))

;I want to count the number of orders of each user

;(pprint (map count
;          (vals (group-by our-grouping-function
;                          (e.db/all-orders)))))

(defn price-of-an-item [[_ item-details]]
  (let [quantity (get item-details :quantity 0)
        price(get item-details :unit-price 0) ]
  (*  quantity price)))

(defn price-of-the-items-of-an-order [items]
  (->> items
       (map price-of-an-item)
       (reduce +)))

(defn total-amount-of-the-orders [orders]
  (->> orders
       (map :items)
       (map price-of-the-items-of-an-order)
       (reduce +)))

(total-amount-of-the-orders [e.db/order1 e.db/order2])

(defn count-and-total-amount-by-user
  [[user-id orders]]
  {:user-id user-id
   :number-of-orders (count orders)
   :total-amount (total-amount-of-the-orders orders) })

(->> (e.db/all-orders)
    (group-by :usuario)
     (map count-and-total-amount-by-user)
     pprint)











