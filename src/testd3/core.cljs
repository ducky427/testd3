(ns testd3.core
  (:require [goog.object :as gobj]
            [cljsjs.d3]))

(def data [{:x 1 :y 5}
           {:x 20 :y 20}
           {:x 40 :y 10}
           {:x 60 :y 40}
           {:x 80 :y 5}
           {:x 100 :y 60}])

(def line-fn (-> js/d3
                 .-svg
                 .line
                 (.x (fn [d] (gobj/get d "x")))
                 (.y (fn [d] (gobj/get d "y")))
                 (.interpolate "linear")))

(defn init!
  []
  (let [cont   (-> js/d3
                   (.select "#app")
                   (.append "svg")
                   (.attr "width" 200)
                   (.attr "height" 200))]
    (-> cont
        (.append "path")
        (.attr "d" (line-fn (clj->js data)))
        (.attr "stroke" "blue")
        (.attr "stroke-with" 2)
        (.attr "fill" "none"))))

(init!)

(defn on-js-reload []

  )
