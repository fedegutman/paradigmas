module Tunel (Tunel, newT, connectsT, usesT, delayT)
   where

import Link
import City
import Quality

data Tunel = Tun [Link] deriving (Eq, Show)


newT :: [Link] -> Tunel
newT = Tun

firstcity :: City -> Tunel -> Bool
firstcity city (Tun (first: rest)) = connectsL city first && not (connectsL city (head rest))

lastcity :: City -> Tunel -> Bool
lastcity city (Tun links) = connectsL city (last links) && not (connectsL city (last (init links)))

connectsT :: City -> City -> Tunel -> Bool
connectsT cityA cityB (Tun links) | length links == 1 = linksL cityA cityB (head links)
                                  | null links = False
                                  | otherwise = (firstcity cityA (Tun links) && lastcity cityB (Tun links)) || (firstcity cityB (Tun links) && lastcity cityA (Tun links))

usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT link (Tun links) = link `elem` links

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun links) = sum [ delayL link | link <- links]