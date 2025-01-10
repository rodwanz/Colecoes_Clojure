(ns colecoes-clojure.lojacol3
  (:require [colecoes-clojure.lojadb :as c.lojadb])  )

(println (c.lojadb/todos-os-pedidos))
(println (group-by :usuario (c.lojadb/todos-os-pedidos)))

(defn minha-funcao-de-agrupamento [elemento]
  (println "Elemento" elemento)
  (:usuario elemento))
(println (group-by minha-funcao-de-agrupamento (c.lojadb/todos-os-pedidos)))
(println (count (vals (group-by :usuario (c.lojadb/todos-os-pedidos)))))
(println (map count (vals (group-by :usuario (c.lojadb/todos-os-pedidos)))))

(->> (c.lojadb/todos-os-pedidos) (group-by :usuario)
     vals (map count ) println)


(defn conta-total-por-usuario [[usuario pedidos]]
   (count pedidos))
(->> (c.lojadb/todos-os-pedidos) (group-by :usuario)
     (map conta-total-por-usuario) println)



(defn conta-total-por-usuario [[usuario pedidos]]
  [usuario (count pedidos)])
(->> (c.lojadb/todos-os-pedidos) (group-by :usuario)
     (map conta-total-por-usuario) println)



(defn conta-total-por-usuario [[usuario pedidos]]
  (count pedidos))
(->> (c.lojadb/todos-os-pedidos) (group-by :usuario)
     (map conta-total-por-usuario) println)


(defn conta-total-por-usuario [[usuario pedidos]]
  {:usuario-id usuario
   :tota-de-pedidos (count pedidos)})
(->> (c.lojadb/todos-os-pedidos) (group-by :usuario)
     (map conta-total-por-usuario) println)


(println "PEDIDOS: devolvendo os três pedidos do usuario 15")
(defn total-do-item [[item-id detalhes]]
  (* (get detalhes :quantidade 0) (get detalhes :preco-unitario 0)))

(defn total-do-pedido [pedido]
  (->> pedido
       (map total-do-item)
       (reduce +)))

(defn total-dos-pedidos [pedidos]
  (->> pedidos
       (map :itens)
       (map total-do-pedido)
       (reduce +)))

(defn quantia-de-pedidos-e-gasto-total-por-usuario [[usuario pedidos]]
  {:usuario-id usuario
   :tota-de-pedidos (count pedidos)
   :preco-total (total-dos-pedidos pedidos)})

(->> (c.lojadb/todos-os-pedidos) (group-by :usuario)
     (map quantia-de-pedidos-e-gasto-total-por-usuario) println)





