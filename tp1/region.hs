module Region (Region, newR, foundR, linkR, tunelR, connectedR, linkedR, delayR, availableCapacityForR)
   where

import City
import Link
import Tunel
import Quality

data Region = Reg [City] [Link] [Tunel] deriving (Show)

newR :: Region
newR = Reg [] [] []

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg cities links tuneles) city 
   | not (locationTaken cities city) = Reg (city : cities) links tuneles
   | otherwise = error "Ya hay una ciudad en esas coordenadas."

locationTaken :: [City] -> City -> Bool -- indica si ya existe una ciudad con mismas coordenadas
locationTaken citylist newcity = not (null ([city | city <- citylist, distanceC city newcity == 0]))

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg cities links tuneles) cityA cityB quality 
   | (cityA `notElem` cities) || (cityB `notElem` cities) = error "Al menos una de las dos ciudades no está en la región."
   | existingLink links cityA cityB = error "Ya existe un enlace entre estas ciudades."
   | otherwise = Reg cities (newL cityA cityB quality : links) tuneles

existingLink :: [Link] -> City -> City -> Bool -- indica si existe un link entre dos ciudades en una lista de links
existingLink links cityA cityB = not (null [link | link <- links, linksL cityA cityB link])

consecutiveCities :: [City] -> [[City]] -- separa una lista de ciudades en pares [[A,B], [B,C], [C,D]...]
consecutiveCities [] = []
consecutiveCities [_] = []
consecutiveCities (x:y:xs) = [x, y] : consecutiveCities (y:xs)

tunelR :: Region -> [City] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR (Reg cities links tuneles) citylist 
   | not (null [city | city <- citylist, city `notElem` cities]) = error "Al menos una de las ciudades de la lista no se encuentra en la región."
   | not (validLinks (Reg cities links tuneles) (consecutiveCities citylist)) = error "Hay enlances faltantes entre las ciudades."
   | not (tunnelCapacity (Reg cities links tuneles) (linksQuality (Reg cities links tuneles) (consecutiveCities citylist))) = error "Alguno de los enlaces no soporta el tunel."
   | otherwise = Reg cities links (newT (path (Reg cities links tuneles) (consecutiveCities citylist)) : tuneles)

path :: Region -> [[City]] -> [Link] -- devuelve una lista con los links necesarios para unir los extremos del tunel
path (Reg cities links tuneles) connections = [findLink pair links | pair <- connections]

findLink :: [City] -> [Link] -> Link -- busca en una lista de enlaces el link que une un par de ciudades
findLink pair links = head [link | link <- links, linksL (head pair) (last pair) link]

validLinks :: Region -> [[City]] -> Bool -- indica si existen links suficientes para conectar los pares de ciudades
validLinks (Reg cities links tuneles) connections = length [pair | pair <- connections, existingLink links (head pair) (last pair)] == length connections

connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg _ _ tuneles) cityA cityB = not (null [tunel | tunel <- tuneles, connectsT cityA cityB tunel])

linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg _ links _) cityA cityB = not (null [link | link <- links, linksL cityA cityB link])

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
delayR (Reg cities links tuneles) cityA cityB 
   | connectedR (Reg cities links tuneles) cityA cityB = head [delayT tunel | tunel <- tuneles, connectsT cityA cityB tunel]
   | otherwise = error "Las ciudades no están conectadas por un tunel."

availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
availableCapacityForR (Reg cities links tuneles) cityA cityB 
   | not (linkedR (Reg cities links tuneles) cityA cityB) = error "Las ciudades no están conectadas por un enlace."
   | otherwise = capacityL (findLink [cityA, cityB] links) - existingTunnels (Reg cities links tuneles) (findLink [cityA, cityB] links)

existingTunnels :: Region -> Link -> Int -- indica cuantos tuneles existen en un link
existingTunnels (Reg _ _ tuneles) link = length [tunel | tunel <- tuneles, usesT link tunel]

linksQuality :: Region -> [[City]] -> [Int] -- dada una lista de ciudades devuelve una lista con la calidad de cada enlace que las une
linksQuality (Reg cities links tuneles) citylist = [availableCapacityForR (Reg cities links tuneles) (head pair) (last pair) | pair <- citylist]

tunnelCapacity :: Region -> [Int] -> Bool -- indica si todas las ciudades de una lista soportan un tunel.
tunnelCapacity (Reg cities links tuneles) qualities = length [quality | quality <- qualities, quality > 0] == length qualities