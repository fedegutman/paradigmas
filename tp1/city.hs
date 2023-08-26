module City (City, newC, nameC, distanceC)
    where

import Point

data City = Cit String Point deriving (Eq, Show)

newC :: String -> Point -> City
newC name point | name == "" = error "Por favor póngale nombre a la ciudad."
                | otherwise = Cit name point

nameC :: City -> String
nameC (Cit name _) = name

distanceC :: City -> City -> Float
distanceC (Cit _ coordinates1) (Cit _ coordinates2) = difP coordinates1 coordinates2