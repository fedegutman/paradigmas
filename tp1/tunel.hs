module Tunel (Tunel, newT, connectsT, usesT, delayT)
   where

import Link
import City
import Quality

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT links |  
           | otherwise = error "No hay capacidad para más tuneles."

connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conceta estas dos ciudades distintas
-- diferencia entre esto y linksl

usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun [Lin _ _ (Qua _ _ delay)]) = delay