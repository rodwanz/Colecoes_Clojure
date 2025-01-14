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
  (->> pedidos
       c.logic/resumo-por-usuario
       (sort-by :preco-total)
       reverse))

(let [pedidos (c.lojadb/todos-os-pedidos)
      resumo (resumo-por-usuario-ordenado pedidos)]
  (println "Resumo" resumo)
  (println "Primeiro item do resumo" (first resumo))
  (println "Segundo item do resumo" (second resumo))
  (println "Resto" (rest resumo))
  (println "Fazendo a contagem de quantos itens a no resumo" (count resumo))
  (println "Informando a classe onde esta implementado o resumo" (class resumo))
  (println "O enésimo item" (nth resumo 1))
  (println "Busacando o primeiro item, sem que seja vetor não dá" (get resumo 1))
  (println "Pegando os dois primeiros itens" (take 2 resumo)))


(println "\nDEIXANDO SEPARADO OS RESULTADOS")
(defn top-2 [resumo]
  (take 2 resumo))

(let [pedidos (c.lojadb/todos-os-pedidos)
      resumo (resumo-por-usuario-ordenado pedidos)]
  (println "Resumo" resumo)
  (println "Top 2" (top-2 resumo)))

(println "\nFUNÇÕES ANONIMAS")
(let [pedidos (c.lojadb/todos-os-pedidos)
      resumo (resumo-por-usuario-ordenado pedidos)]
  (println "Criando uma função anonima para filtrar quem teve gastos maiores que 500"
           (filter #(> (:preco-total %) 500) resumo))
  (println "Busacando no Resumo se verdadeiramente receberam mais que 500"
           (not (empty? (filter #(> (:preco-total %) 500) resumo))))
  (println "Busacando no Resumo se alguém recebeu mais que 500"
           (some #(> (:preco-total %) 500) resumo)))







