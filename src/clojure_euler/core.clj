(ns clojure-euler.core
  (:gen-class))

(defn isdiv? [x y]
  "is x divisible by y"
  (zero? (rem x y)))
  
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
  "prints result of project euler solutions"
  [& args]
  (println "Hello, GitHub!")
  (println (euler-1))
  (println (euler-2))
  (println (euler-4))
  (println (euler-6)))




