(ns estoque.db)

(def order1 {
             :usuario 15
             :items {
                     :bag {
                           :id :bag,
                           :quantity 2,
                           :unit-price 80
                           }
                     :shirt {
                             :id :shirt
                             :quantity 3
                             :unit-price 40
                             }
                     :sneakers {
                                :id :sneakers
                                :quantity 1
                                }}})

(def order2 {
             :usuario 15
             :items {
                     :keyring {
                           :id :keyring,
                           :quantity 10
                           }}})

(def order3 {
             :usuario 10
             :items {
                     :bag {
                           :id :bag,
                           :quantity 1,
                           :unit-price 80
                           }
                     :shirt {
                             :id :shirt
                             :quantity 1
                             :unit-price 40
                             }}})

(def order4 {
             :usuario 10
             :items {
                     :computer {
                           :id :computer,
                           :quantity 1,
                           :unit-price 1000
                           }}})

(def order5 {
             :usuario 17
             :items {
                     :tv {
                                :id :tv,
                                :quantity 1,
                                :unit-price 900
                                }}})

(def order6 {
             :usuario 19
             :items {
                     :table {
                                :id :table,
                                :quantity 1,
                                :unit-price 500
                                }}})

(defn all-orders []
  [order1
   order2
   order3
   order4
   order5
   order6])
