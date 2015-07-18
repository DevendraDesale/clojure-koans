(ns koans.20-partition
  (:require [koan-engine.core :refer :all]))

(meditations
  "To split a collection you can use the partition function"
  (= '((0 1) (2 3)) (partition 2 (range 4)))

  "But watch out if there are not enough elements to form final list of size n"
  (= '((:a :b :c)) (partition 3 [:a :b :c :d :e]))

  "You can use partition-all to also get partitions with less than n elements"
  (= '((0 1 2) (3 4)) (partition-all 3 (range 5)))

  "If you need to, you can start each sequence with an offset
  By default the offset will be equal to the number of elements in list."
  (= '((0 1 2) (5 6 7) (10 11 12)) (partition 3 5 (range 13)))

  "Consider padding the last sequence with some default values..."
  (= '((0 1 2) (3 4 5) (6 :hello)) (partition 3 3 [:hello] (range 7)))

  "... but notice that they will only pad up to the given sequence length"
  (= '((0 1 2) (3 4 5) (6 :these :are)) (partition 3 3 [:these :are "my" "words"] (range 7)))
  
  "Few tricks with partitions"
  (= '((0)(1)(2)(3)(4)(5)(6)(7)(8)(9)(10)(11)(12)) (partition 1 (range 13)))
  
  "we can create the sliding window with the help of partition."
  (= '((0 1)(1 2)(2 3)(3 4)) (partition 2 1 (range 5)))
  )


