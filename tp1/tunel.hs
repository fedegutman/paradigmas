module Tunel (Tunel, newT, connectsT, usesT, delayT)
   where

import Link
import City
import Quality

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT |
     | otherwise = error "No hay capacidad para más tuneles."

connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conceta estas dos ciudades distintas
connectsT cityA cityB (Tun [Lin city1 city2 _]) = ((cityA == city1) && (cityB == city2)) || ((cityB == city1) && (cityA == city2))
-- diferencia entre esto y linksl

usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun [Lin _ _ (Qua _ _ delay)]) = delay