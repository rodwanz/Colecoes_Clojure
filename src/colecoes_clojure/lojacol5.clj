(ns colecoes-clojure.lojacol5
  (:require [colecoes-clojure.lojadb :as c.lojadb]
            [colecoes-clojure.logic :as c.logic]))

(println "\nTENTANDO ENTENDER DENTRO DO KEEP E DO FILTER")
(defn gastou-bastante? [info-do-usuario]
  (> (:preco-total info-do-usuario) 500))

(let [pedidos (c.lojadb/todos-os-pedidos)
      resumo (c.logic/resumo-por-usuario pedidos)]
  (println "Mantendo" (keep gastou-bastante? resumo))
  (println "Filtrando" (filter gastou-bastante? resumo)))


(println "\nTENTANDO ENTENDER DENTRO DO KEEP")
(defn gastou-bastante? [info-do-usuario]
  (println "Gastou bastante?" (:usuario-id info-do-usuario))
  (> (:preco-total info-do-usuario) 500))

(let [pedidos (c.lojadb/todos-os-pedidos)
      resumo (c.logic/resumo-por-usuario pedidos)]
  (println "Mantem os valores retornados pela função" (keep gastou-bastante? resumo)))

