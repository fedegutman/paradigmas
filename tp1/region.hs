module Region (Region, newR, foundR, linkR, tunelR, pathR, linksForR, connectedR, linkedR, delayR, availableCapacityForR, usedCapacityForR)
   where

import City
import Link
import Tunel
import Quality

data Region = Reg [City] [Link] [Tunel]

newR :: Region
newR = Reg [] [] []

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg cit links tunels) city = Reg ((city : cit) links tunels)

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg cit links tunels) cityA cityB calidad = Reg (cit (newL cityA cityB calidad : links) tunels)
  
tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades