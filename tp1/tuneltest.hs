module Tunel (Tunel, newT, connectsT, usesT, delayT)
   where

import Link
import City
import Quality

data Tunel = Tun [Link] deriving (Eq, Show)


newT :: [Link] -> Tunel
newT = Tun 

connectsT :: City -> City -> Tunel -> Bool

usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT link (Tun links) = link `elem` links 

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun links) = sum (map delayL links)