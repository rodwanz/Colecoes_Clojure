(ns colecoes-clojure.lojacol4
  (:require [colecoes-clojure.lojadb :as c.lojadb]
            [colecoes-clojure.logic :as c.logic]))

(println (c.lojadb/todos-os-pedidos))
(println (c.logic/resumo-por-usuario (c.lojadb/todos-os-pedidos)))

(let [pedidos (c.lojadb/todos-os-pedidos)
      resumo (c.logic/resumo-por-usuario pedidos)]
  (println "Resumo" resumo)
  (println "Ordenação" (sort-by :preco-total resumo))
  (println "Ordenação reversa" (reverse (sort-by :preco-total resumo)))
  (println "Ordenação por id" (sort-by :usuario-id resumo))
  (println (get-in pedidos [0 :itens :mochila :quantidade])))

(defn resumo-por-usuario-ordenado [pedidos]
  "Threading last"
  (->> pedidos (sort-by :preco-total)))

(let [pedidos (c.lojadb/todos-os-pedidos)
      resumo (resumo-por-usuario-ordenado pedidos)]
  (println "Resumo" resumo))











