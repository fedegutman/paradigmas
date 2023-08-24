module Tunel (Tunel, newT, connectsT, usesT, delayT)
   where

import Link
import City
import Quality

data Tunel = Tun [Link] deriving (Eq, Show)


newT :: [Link] -> Tunel
newT = Tun 

eslaprimera :: City -> Tunel -> Bool
eslaprimera city (Tun []) = False
eslaprimera city (Tun (primera: lossiguientes)) = connectsL city primera && not (connectsL city (head lossiguientes))

eslaultima :: City -> Tunel -> Bool
eslaultima city (Tun []) = False
eslautlima :: City -> Tunel -> Bool
eslautlima city (Tun [links]) = connectsL city (last [links]) && not (connectsL city (last (init [links])))


connectsT :: City -> City -> Tunel -> Bool
connectsT cityA cityB (Tun enlaces) = (eslaprimera cityA (Tun enlaces) && eslaultima cityB (Tun enlaces)) ||(eslaprimera cityB (Tun enlaces) && eslaultima cityA (Tun enlaces))
-- diferencia entre esto y linksl

usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT link (Tun links) = link `elem` links 

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun links) = sum (map delayL links)