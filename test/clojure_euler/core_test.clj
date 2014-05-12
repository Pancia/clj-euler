(ns clojure-euler.core-test
  (:require [clojure.test :refer :all]
            [clojure-euler.core :refer :all]))

(def clojure-set-1 #{"asd" "asf" "azf" "azq"})
(def clojure-set-2 #{"zqd" "zud" "zuq" "zaq"})

(deftest a-word-chain-test
	(testing "CORE_TEST: char-ify FAILED!"
		(is (= (char-ify "hello") ["h" "e" "l" "l" "o"]))
	)

	(testing "CORE_TEST: str-diff? FAILED!"
		;(is (= (str-diff "cat" "mat") 1))
		;(is (not= (str-diff "cat" "hot") 1))
	)

	(testing "CORE_TEST: str-neighbor? FAILED!"
		;(is (true? (str-neighbor? "cat" "mat")))
		;(is (false? (str-neighbor? "cat" "hot")))
		(is (true? (str-neighbor? "asf" "asd")))
	)

	; (testing "CORE_TEST: has-str-neighbor? FAILED"
 ;  	(is (has-str-neighbor? "asa" clojure-set-2))
 ;  	(is (not (has-str-neighbor? "qux" clojure-set-2)))
	; )

 ;  (testing "CORE_TEST: is-word-chain? FAILED"
 ;  	(is (true? (is-word-chain? clojure-set-1)))
 ;  	(is (false? (is-word-chain? clojure-set-2)))
	; )
)

