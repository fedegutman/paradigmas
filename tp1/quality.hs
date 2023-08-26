module Quality (Quality, newQ, capacityQ, delayQ)
    where

data Quality = Qua String Int Float deriving (Eq, Show)

newQ :: String -> Int -> Float -> Quality
newQ name capacity delay | name == "" = error "Por favor póngale nombre a la ciudad."
                         | capacity < 0 = error "Por favor ingrese una capacidad de túneles positiva."
                         | delay < 0 = error "Por favor ingrese un delay positivo."
                         | otherwise = Qua name capacity delay

capacityQ :: Quality -> Int -- cuantos túneles puede tolerar esta conexión
capacityQ (Qua _ capacity _) = capacity

delayQ :: Quality -> Float  -- la demora por unidad de distancia que sucede en las conexiones de este canal
delayQ (Qua _ _ delay) = delay