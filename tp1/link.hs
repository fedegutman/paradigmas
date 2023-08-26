{- Un Link es el medio físico que une dos ciudades. -}

module Link (Link, newL, linksL, connectsL, capacityL, delayL)
   where

import City
import Quality

data Link = Lin City City Quality deriving (Eq, Show)

newL :: City -> City -> Quality -> Link -- genera un link entre dos ciudades distintas
newL = Lin

connectsL :: City -> Link -> Bool   -- indica si esta ciudad es parte de este link
connectsL city (Lin city1 city2 _) = (city == city1) || (city == city2)

linksL :: City -> City -> Link -> Bool -- indica si estas dos ciudades distintas estan conectadas mediante este link
linksL cityA cityB (Lin city1 city2 _) = ((cityA == city1) && (cityB == city2)) || ((cityB == city1) && (cityA == city2))

capacityL :: Link -> Int
capacityL (Lin _ _ quality) = capacityQ quality

delayL :: Link -> Float     -- la demora que sufre una conexion en este canal
delayL (Lin cityA cityB qua) = (delayQ qua)*(distanceC cityA cityB)