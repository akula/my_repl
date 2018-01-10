(ns my-repl.4clojure)

(defn sol [ x y]
  (str (* x y)))

(map #(Integer/parseInt (str %)) (vec (sol 9 9)))

(def a [ 1 2 3 4 5])

(conj (vec (rest a)) (first a))

(conj [1 2 3 4 5] 6)

(rest a)

(source cycle)
(take -3 (cycle a))

(split-at 1 [0 1 2 3 4  5 6 7])

(split-at -1 a)

(defn rot [n v](split-at (mod n (count v) ) v))

(flatten (into '() (rot -4 [1 2 3 ])))

(defn roatax [ n v] (flatten (into '() (split-at (mod n (count v)) v)) ))
