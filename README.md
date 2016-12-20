# one-hot-encoder

A tiny Clojure library designed to perform feature extraction on categorical data using one hot encoding.
https://en.wikipedia.org/wiki/One-hot

## Usage

```clojure
(def test-data [["Sample" "Category" "Numerical"]
                [1 "Human" 1]
                [2 "Human" 1]
                [3 "Penguin" 2]
                [4 "Octopus" 3]
                [5 "Alien" 4]
                [6 "Octopus" 3]
                [7 "Alien" 4]])

(def cols (distinct (map #(nth % 1) (rest test-data))))

(encode cols "Human")#=> [1 0 0 0]

(encode cols "Human" "Penguin")#=> [1 1 0 0] 

(encode-coll cols ["Human" "Penguin"])#=> [1 1 0 0]

(encode-table cols [["Human" "Penguin"]
                    ["Human" "Penguin"]
                    ["Human" "Penguin"]
                    ["Human" "Penguin"]
                    ["Human" "Penguin"]])
#=> ([1 1 0 0] [1 1 0 0] [1 1 0 0] [1 1 0 0] [1 1 0 0])		    

(def enc (encode ["Human" "Bro" "Foo"] "Human"))

(decode ["Human" "Bro" "Foo"] enc)#=> ("Human")
```

Implementation taken from top answer [here](https://www.quora.com/What-is-one-hot-encoding-and-when-is-it-used-in-data-science)
## License

Copyright © 2016 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
