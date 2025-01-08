(ns colecoes-clojure.col2)

(defn conta [total-ate-agora ellementos]
  "Atentar na utilização do RECUR, e onde ele tem que ser collocado"
  (recur (inc total-ate-agora) (rest ellementos)))
;(println (conta 0 ["susanne" "miguel" "rodrigo" "mirian" "jose" "maria"]))


(defn conta [total-ate-agora ellementos]
  (if (next ellementos)
    (recur (inc total-ate-agora) (next ellementos))))
(println (conta 0 ["susanne" "miguel" "rodrigo" "mirian" "jose" "maria"]))


(defn conta [total-ate-agora elementos]
  (if (next elementos)
    (recur (inc total-ate-agora) (next elementos))
    total-ate-agora))
(println (conta 0 ["susanne" "miguel" "rodrigo" "mirian" "jose" "maria"]))


(defn conta [total-ate-agora elementos]
  (println total-ate-agora elementos)
  (if (next elementos)
    (recur (inc total-ate-agora) (next elementos))
    (inc total-ate-agora)))
(println (conta 0 ["susanne" "miguel" "rodrigo" "mirian" "jose" "maria"]))
(println (conta 0 []))


(defn conta [total-ate-agora elementos]
  (if (seq elementos)
    (recur (inc total-ate-agora) (next elementos))
    total-ate-agora))
(println (conta 0 ["susanne" "miguel" "rodrigo" "mirian" "jose" "maria"]))
(println (conta 0 []))


(defn minha-funcao
  ([parametro1] (println "p1" parametro1))
  ([parametro1 parametro2] (println "p2" parametro1 parametro2)))
(minha-funcao 1)
(minha-funcao 1 2)


(defn conta
  ([elementos] (conta 0 elementos))
  ([total-ate-agora elementos]
              (if (seq elementos)
                (recur (inc total-ate-agora) (next elementos))
                total-ate-agora)))
(println (conta ["susanne" "miguel" "rodrigo" "mirian" "jose" "maria"]))
(println (conta []))







