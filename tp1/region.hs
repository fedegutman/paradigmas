module Region (Region, newR, foundR, linkR, {-tunelR,-} connectedR, linkedR, delayR, availableCapacityForR)
   where

import City
import Link
import Tunel
import Quality

data Region = Reg [City] [Link] [Tunel]

newR :: Region
newR = Reg [] [] []

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg cities links tuneles) city | not (locationTaken cities city) = Reg (city : cities) links tuneles
                                      | otherwise = error "Ya hay una ciudad en esas coordenadas."

locationTaken :: [City] -> City -> Bool
locationTaken cities newcity = null ([city | city <- cities, distanceC city newcity == 0])

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg cit links tuneles) cityA cityB quality | (cityA `elem` cit) && (cityB `elem` cit) = Reg cit (newL cityA cityB quality : links) tuneles
                                                 | existingLink links cityA cityB = error "Ya existe un enlace entre estas ciudades."
                                                 | otherwise = error "Al menos una de las dos ciudades no está en la región."

existingLink :: [Link] -> City -> City -> Bool
existingLink links cityA cityB = not (null [link | link <- links, linksL cityA cityB link])

consecutiveCities :: [a] -> [[a]]
consecutiveCities [] = []
consecutiveCities [_] = []
consecutiveCities (x:y:xs) = [x, y] : consecutiveCities (y:xs)

-- link2ciudadeslist :: [City] -> Link -- pasa una lista de dos ciudades y crea el link entre ellas
-- link2ciudadeslist [cityA, cityB] = newL cityA cityB _
{-
tunelR :: Region -> [City] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR (Reg cit links tuneles) cities | (cityA `elem` cit) && (cityB `elem` cit)
                                     | 
                                     | Reg cit links newT (map link2ciudadeslist (consecutiveCities [cities])):tuneles
-}

connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg _ _ tuneles) cityA cityB = not (null [tunel | tunel <- tuneles, connectsT cityA cityB tunel])

linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg _ links _) cityA cityB = not (null [link | link <- links, linksL cityA cityB link])

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
delayR (Reg cities links tuneles) cityA cityB | connectedR (Reg cities links tuneles) cityA cityB = sum [delayT tunel | tunel <- tuneles, connectsT cityA cityB tunel]
                                              | otherwise = error "Las ciudades no están conectadas por un tunel."

--CHEQUEAR

availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
availableCapacityForR (Reg cities links tuneles) cityA cityB | not (linkedR (Reg cities links tuneles) cityA cityB) = error "Las ciudades no están conectadas por un enlace."
                                                             | otherwise = capacityL (head (filter (linksL cityA cityB) links))

--CHEQUEAR
                  