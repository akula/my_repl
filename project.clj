(defproject my_repl "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [criterium "0.4.4"]
                 [alembic "0.3.2"]
                 [curiousprogrammer/clojure-repl "0.1.0"]
                 ]
  :repl {:dependencies [[curiousprogrammer/clojure-repl "0.1.0"]]}
  )
