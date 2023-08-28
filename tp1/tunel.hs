module Tunel (Tunel, newT, connectsT, usesT, delayT)
   where

import Link
import City
import Quality

data Tunel = Tun [Link] deriving (Eq, Show)


newT :: [Link] -> Tunel
newT = Tun

firstcity :: City -> Tunel -> Bool -- indica cual es la primera ciudad en un enlace
firstcity city (Tun (first: rest)) = connectsL city first && not (connectsL city (head rest))

lastcity :: City -> Tunel -> Bool -- indica cual es la última ciudad en un enlace
lastcity city (Tun links) = connectsL city (last links) && not (connectsL city (last (init links)))

connectsT :: City -> City -> Tunel -> Bool -- indica si éste túnel conecta estas dos ciudades distintas
connectsT cityA cityB (Tun links) | length links == 1 = linksL cityA cityB (head links)
                                  | null links = False
                                  | otherwise = (firstcity cityA (Tun links) && lastcity cityB (Tun links)) || (firstcity cityB (Tun links) && lastcity cityA (Tun links))

usesT :: Link -> Tunel -> Bool  -- indica si este túnel atraviesa ese link
usesT link (Tun links) = link `elem` links

delayT :: Tunel -> Float -- la demora que sufre una conexion en este túnel
delayT (Tun links) = sum [ delayL link | link <- links]