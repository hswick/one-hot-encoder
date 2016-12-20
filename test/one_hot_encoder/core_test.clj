(ns one-hot-encoder.core-test
  (:require [clojure.test :refer :all]
            [one-hot-encoder.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 1))))

(def test-data [["Sample" "Category" "Numerical"]
                [1 "Human" 1]
                [2 "Human" 1]
                [3 "Penguin" 2]
                [4 "Octopus" 3]
                [5 "Alien" 4]
                [6 "Octopus" 3]
                [7 "Alien" 4]])

(def cols (distinct (map #(nth % 1) (rest test-data))))

(encode cols "Human")

(encode cols "Human" "Penguin")

(encode-coll cols ["Human" "Penguin"])

(encode-table cols [["Human" "Penguin"]
                    ["Human" "Penguin"]
                    ["Human" "Penguin"]
                    ["Human" "Penguin"]
                    ["Human" "Penguin"]])

(def enc (encode ["Human" "Bro" "Foo"] "Human"))

(decode ["Human" "Bro" "Foo"] enc)

