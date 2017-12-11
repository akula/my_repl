(ns my-repl.repl)

(defn countdown
  [n]
  (when (> n 0)
    (pr n)
    (recur (- n 1))))

(countdown 9)

(java.util.HashMap. {"a" 42 , "b" 33 "d" "99"})

(.-y (java.awt.Point. 1 2))
(throw (Exception. "hahah"))

(defn throw-catch [f]
  [(try
     (f)
     (catch ArithmeticException e "No divingding by zero!")
     (catch Exception e (str "You are so bad " (.getMessage e)))
     (finally (println "returning...")))])
(throw-catch #(/ 10 0))

(throw-catch #(throw (Exception. "hello world")))

(:import [java.util.HashMap])
(java.util.HashMap. {"abc" 42})

(if true :trufy :falsely)

(when (nil? nil) "Actually nil, not false")

(defn print-seq [s]
  (when (seq s)
    (prn (first s))
    (recur (rest s))))

(print-seq [1 2 3 4 5 6])
(print-seq [])

(def guys-name-map {:f-name "Guy" :m-name "Leiws" :l-name "seetls"})

(let [{:keys [f-name m-name l-name]} guys-name-map]
  (str l-name "  " m-name "  " l-name))

(defn xors [max-x max-y]
  (for [x (range max-x) y (range max-y)] [x y (bit-xor x y)]))

(def frame (java.awt.Frame.))

(for [meth (.getMethods java.awt.Frame)
      :let [name (.getName meth)]
      :when (re-find #"Vis" name)] name)

frame

(.isVisible frame)
