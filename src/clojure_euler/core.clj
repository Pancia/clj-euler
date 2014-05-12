(ns clojure-euler.core
  (:gen-class))

(defn isdiv? [x y]
  "is x divisible by y"
  (zero? (rem x y)))
  
; sum of all numbers < 1000 that are div by 3 or 5
(defn euler-1 []
  (reduce + 
    (filter #(or (isdiv? % 3) (isdiv? % 5))
      (range 1000))))

(def fibs 
  (lazy-cat [0 1] (map + fibs (rest fibs))))

(defn euler-2 []
  (reduce + 
    (filter even?
      (take-while #(< % 4000000) fibs))))

(defn ispal? [num]
  (= (str num) 
      (apply str (reverse (str num)))))

(defn euler-4 []
  (let [nums (for [x (range 100 1000) y (range 100 1000)] (* x y))]
    (apply max (filter ispal? nums))))

(defn sum-of-squares [nums]
	(reduce + (map #(* % %) nums)))

(defn square-of-sum [nums]
	(. Math pow (reduce + nums) 2))

(defn euler-6 []
  (let [nums (range 1 101)] 
    (- (square-of-sum nums) (sum-of-squares nums))))

(defn -main
  "prints my solutions to euler and 4clojure problems"
  [& args]
  (println "Hello, GitHub!")
  (println (euler-1))
  (println (euler-2))
  (println (euler-4))
  (println (euler-6))
  
  ;some clever code
  ((resolve (symbol "println")) 
    "Say hello to Magic!")
)

(defn char-ify
  [arg]
  (println (clojure.string/split arg #""))
  (clojure.string/split arg #""))

(use 'clojure.data)

(defn str-diff
  [arg1 arg2]
  (let [arg-diff (diff (char-ify arg1) (char-ify arg2))]
    (println arg1 arg2 ":" arg-diff)
    (max 
      (count-not-nil (first arg-diff)) 
      (count-not-nil (second arg-diff))
    )
  )
)

(defn str-neighbor?
  [arg1 arg2]
  (println `(str-diff ~arg1 ~arg2) (str-diff arg1 arg2))
  (= (str-diff arg1 arg2) 1)
)

(defn has-str-neighbor?
  [arg args]
  (println "arg:" arg " args:" args)
  (if (= (count args) 1)
    (str-neighbor? arg (first args))
    (if (str-neighbor? arg (first args))
      true
      (has-str-neighbor? arg (rest args))
    )
  )
)

(defn is-word-chain?
  [arg];of type set
  ;filter out all elements that 
  ;dont have at least 1 neighbor
  (let [ans 
        (for [x arg 
              :when (has-str-neighbor? x (disj arg x))]
          x)]
    (print (= ans ans))
    (println ans) 
    (= ans arg)
  )
)

