module Tunel (Tunel, newT, connectsT, usesT, delayT)
   where

import Link
import City
import Quality

data Tunel = Tun [Link] deriving (Eq, Show)

allLinksValid :: [Link] -> Bool
allLinksValid links = all (\link -> capacityL link > 0) links

newT :: [Link] -> Tunel
newT links | allLinksValid links = Tun links
           | otherwise = error "No hay capacidad para más tuneles."

connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conceta estas dos ciudades distintas
-- diferencia entre esto y linksl

usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT link (Tun links) = link `elem` links 

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun links) = sum (map delayL links)