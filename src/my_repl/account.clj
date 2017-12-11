(ns my-repl.account)

(defstruct account :id :tag :balance)

(struct account 1 ::my-repl.account/Savings :100M)
(alias 'acc 'my-repl.account)

(def test-saving (struct account 1 ::acc/Savings 100M))
(def test-checking (struct account 2 ::acc/Checking 250M))

(defmulti interest-rate :tag)
(defmethod interest-rate ::acc/Checking [_] 0M)
(defmethod interest-rate ::acc/Savings [_] 0 0.05M)

(interest-rate test-saving)

(defmulti account-level :tag)
(defmethod account-level ::acc/Checking [acc]
  (if (>= (:balance acc) 5000) ::acc/Premium ::acc/Basic))

(defmethod account-level ::acc/Savings [acc]
  (if (>= (:balacne acc) 1000) ::acc/Premium ::acc/Basic))

(account-level (struct account 1 ::acc/Savings 200M))



