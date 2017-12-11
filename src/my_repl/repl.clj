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

(.isVisible frame)

(def population {:zombies 2700, :humans 9})

(get population :zombies)
(population :zombies)
(:zombies population)

(defn pour [lb ub]
  (cond
    (= ub :toujours) (iterate inc lb)
    :else (range lb ub)))

(pour 1 10)


(defn do-blowfish [directive]
  (case directive
    :aquarium/blowfish (prn "feed the fish")
    :crypto/blowfish (prn "encode the fish")
    :blowfish (prn "not sure what to do"))
  )

(ns crypto)
(my-repl.repl/do-blowfish :blowfish)
(my-repl.repl/do-blowfish ::blowfish)
(ns aquarium)
(my-repl.repl/do-blowfish ::blowfish)


(defn best [f xs]
  (reduce #(if (f % %2) % %2) xs))

(best > [ 1 2 3 4 5 9 1 2 3])

(defn split-name
  [user]
  (zipmap [:first :last]
          (.split ^String (:name user) " ")))

(zipmap '(:hi :end) (.split "hello world" " "))

(defn copy-files
  [from to]
  (with-open [in (java.io.FileInputStream. from)
              out (java.io.FileOutputStream. to)]
    (loop [buf (make-array Byte/TYPE 1024)]
      (let [len (.read in buf)]
        (when (pos? len)
          (.write out buf 0 len)
          (recur buf))))))

(defn length-of
  [^String text]
  (.length text))

(length-of "hello world")
