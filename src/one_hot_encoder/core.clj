(ns one-hot-encoder.core)

(defn index-setter [encoding-row l v]
  (try
    (.set l (.indexOf encoding-row v) 1)
    (catch Exception e
      (throw (Exception. (str "Index not found for: " v "\n"))))))

;;Need error detection for empty args
(defn encode
  ([encoding-row & args]
   (let [l (java.util.ArrayList. (repeat (count encoding-row) 0))]
    (doseq [a args] (index-setter encoding-row l a))
    l)))

(defn encode-coll [encoding-row coll]
  (apply (partial encode encoding-row) coll))

(defn encode-table [encoding-row table]
  (map (partial encode-coll encoding-row) table))

(defn decode [encoding-row binary-vec]
  (filter #(not (nil? %))
          (map (fn [category v] (if (= v 1) category nil))
               encoding-row binary-vec)))

