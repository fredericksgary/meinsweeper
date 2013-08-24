(ns meinsweeper.data-queries)

(defn all-equal [potentially-equal]
  ;; or just (apply = potentially-equal)
  (= 1 (count (distinct potentially-equal))))

(defn indices-of-equality [maps]
  ;; (filter (comp all-equal? (apply juxt maps)) (keys (first maps)))
  (filter (fn [key]
            (let [elements-at-index (map #(get % key) maps)]
              (all-equal elements-at-index)))
          (keys (first maps))))
