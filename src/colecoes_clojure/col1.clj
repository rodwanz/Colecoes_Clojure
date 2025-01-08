(ns colecoes-clojure.col1)

(defn meu-mapa [funcao sequencia]
  (let [primeiro (first sequencia)]
    (funcao primeiro)
    (meu-mapa funcao (rest sequencia))))
;(meu-mapa println ["susanne" "miguel" "rodrigo" "mirian" "jose" "maria"])

(defn meu-mapa [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if primeiro
      (funcao primeiro)
      (meu-mapa funcao (rest sequencia)))))
(meu-mapa println ["susanne" "miguel" "rodrigo" "mirian" "jose" "maria"])


(println "\nMEU MAPA COM PARADA")
(defn meu-mapa [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if primeiro
      (do
        (funcao primeiro)
        (meu-mapa funcao (rest sequencia))))))
(meu-mapa println ["susanne" "miguel" "rodrigo" "mirian" "jose" "maria"])
(meu-mapa println ["susanne" false "miguel" "rodrigo" "mirian" "jose" "maria"])


(println "\n\nMEU MAPA COM PARADA NO NIL")
(defn meu-mapa [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not (nil? primeiro))
      (do
        (funcao primeiro)
        (meu-mapa funcao (rest sequencia))))))
(meu-mapa println ["susanne" "miguel" "rodrigo" "mirian" "jose" "maria"])
(meu-mapa println ["susanne" false "miguel" "rodrigo" "mirian" "jose" "maria"])
(meu-mapa println [])
(meu-mapa println nil)


(defn meu-mapa [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not (nil? primeiro))
      (do
        (funcao primeiro)
        (recur funcao (rest sequencia))))))
(meu-mapa println (range 5000))





