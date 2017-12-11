(ns my-repl.core
  (:require [clojure.string :as str]))

(require '[clojure-repl.java :as java])
(java/jmethods java.util.Date) 
(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))


(defn my-print [ob] (.write *out* ob))

(my-print "hello world, just say something")

(defn my-println [ob] (my-print ob )
                       (.write *out* "\n"))
(my-println "hi")

(defn my-print [ob]
  (cond
    (nil? ob) (.write *out* "nil")
    (string? ob) (.write *out* ob)
    (vector? ob) (my-print-vector ob))
  )

(require '[clojure.string :as str])

(defn my-print-vector [ob]
  (.write *out* "[")
  (.write *out* (str/join " " ob))
  (.write *out* "]"))
(my-print nil)
(my-print [ 1 2 3])

(defmulti my-print class)
(defmethod my-print String [s] (.write *out* s))
(my-print "hello")
(defmethod my-print nil [s] (.write *out* "nil"))
(my-print nil)
(defmethond my-print Vector [s])
(defmethod my-print Number [n]
  (.write *out* (.toString n)))
(my-print 0.2001)
(isa? Integer Number)
(defmethod my-print :default [s]
  (.write *out* "#<")
  (.write *out* (.toString s)
          )
  (.write *out* ">"))

(my-print (java.sql.Date. 0))
(defmethod my-print java.util.Collection [c]
  (.write *out*  "(")
  (.write *out* (str/join " " c))
  (.write *out* ")") )

(my-print (take 6 (cycle [ 1 2 3])))

(my-print [1 2 3 4 5])

(def beans {:red 10
            :blue 22
            :green 11})

(reduce + (vals ( select-keys beans [:red :green])))

(select-keys beans [:red :green])


;;juxt  ((juxt a b c) x) => [(a x) (b x) (c x)]

((juxt :red :green) beans)


(def weird-map {"a" 100 "b" 200 [:foo :bar] 300})


(def a-str-then-foo-bar-map
  (juxt #(get % "a")
        #(get % "b")))

(a-str-then-foo-bar-map weird-map)

(def book {:title "clojure book"
           :author {:name "Ryan Neufeld"
                    :residence {:country "USA"}}})

(assoc book :author
       (assoc (:author book) :residence
              (assoc (:residence (:author book)) :country "Canada")))

(assoc-in book [:author :residence :country] "UUB")


(def website {:clojure-cook-book {:hits 1366}})

(update-in website [:clojure-cook-book :hits] + 1000)

(def retail-data (atom {:customers [{ :id 123 :name "Luke"}
                                    {:id 213 :name "Ryan"}]
                        :orders [{:sku "Q2MN" :customers 123 :qty 4}
                                 {:sku "43XP" :customers 213 :qty 2}]}))

(def chessboard {[:a 5] [:white :king]
                 [:a 4] [:white :pawn]
                 [:d 4] [:black :king]})

(defn move
  "Given a map representing a chessboard, move the piece at src to dest"
  [board source dest]
  (-> board
      (dissoc source)
      (assoc dest (board source))))

(move chessboard [:a 5] [:a 4] )
