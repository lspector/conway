;; A version of Conway's Game of Life that uses Quil (http://quil.info) for graphics.
;; Represents cell states as spaces and * characters.

;; Lee Spector (lspector@amherst.edu), 2023

;; Requires quil to be added to the project's dependencies.

(ns conway.quil
  (:require [quil.core :as q :include-macros true]
            [quil.middleware :as m]))

(def size 20)

(defn random-world []
  (repeatedly size
              (fn []
                (repeatedly size #(rand-nth [" " "*"])))))

(defn setup []
  (q/no-stroke)
  (random-world))

(defn live-neighbors [world x y]
  (reduce + (for [i [-1 0 1]
                  j [-1 0 1]]
              (if (= i j 0)
                0
                (if (= "*" (nth (nth world (mod (+ x i) size))
                                (mod (+ y j) size)))
                  1
                  0)))))

(defn step-forward [world]
  (for [x (range size)]
    (for [y (range size)]
      (let [neigh (live-neighbors world x y)]
        (if (= " " (nth (nth world x) y))
          (if (= neigh 3) "*" " ")
          (if (<= 2 neigh 3) "*" " "))))))

(defn draw-world [world]
  (dotimes [r size]
    (dotimes [c size]
      (q/fill (if (= (nth (nth world r) c) "*") 0 255))
      (q/rect (* r 10) (* c 10) 10 10))))

(defn life [opts]
  (q/defsketch life
    :host "host"
    :size [200 200]
    :setup setup
    :update step-forward
    :draw draw-world
    :middleware [m/fun-mode]))

#_(life {}) ;; must take an argument
