(defrule add-sum
?data <- (data (item ?value))
?old-total <- (total ?total)
=>
(retract ?old-total ?data)
(assert (total (+ ?total ?value))))