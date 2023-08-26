
module Region (Region, newR, foundR, linkR, tunelR, pathR, linksForR, connectedR, linkedR, delayR, availableCapacityForR, usedCapacityForR)
   where

import City
import Link
import Tunel
import Quality

data Region = Reg [City] [Link] [Tunel]

newR :: Region
newR = Reg
-- newR = Reg [] [] []

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg cit links tunels) city = Reg (city : cit) links tunels

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg cit links tunels) cityA cityB calidad | cityA `elem` cit && cityB `elem` cit = Reg (cit (newL cityA cityB calidad : links) tunels)
                                                 | otherwise = error "Al menos una de las dos ciudades no está en la región"

ciudadesConsecutivas :: [a] -> [[a]]
ciudadesConsecutivas [] = []
ciudadesConsecutivas [_] = []
ciudadesConsecutivas (x:y:xs) = [x, y] : ciudadesConsecutivas (y:xs)

link2ciudadeslist :: [City] -> Link --pasa una lista de dos ciudades y crea el link entre ellas
link2ciudadeslist [cityA,cityB] = newL cityA cityB _   

tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR Reg cit links tunels [cities] = Reg cit links newT(map link2ciudadeslist (ciudadesConsecutivas [cities])):tunels

connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg cit link tunnels) cityA cityB = connectsT cityA CityB tunnels

linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg cit link tunnels) cityA cityB =  any (linksL cityA cityB) link

encontarTunel :: Region -> City -> City -> Tunel
encontarTunel Reg _ _ tunel cityA cityB = head (filter (connectsT cityA cityB) tunel)

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
delayR Reg _ _ tunnels cityA cityB = delayT (encontarTunel Reg _ _ tunnels cityA cityB)  

availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
