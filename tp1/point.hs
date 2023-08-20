module Point (Point, newP, difP) 
    where

data Point = Poi Int Int deriving (Eq, Show)

newP :: Int -> Int -> Point
newP x y = Poi x y

difP :: Point -> Point -> Float  -- distancia absoluta # preguntar que hacemos con estos comentarios
difP (Poi x1 y1) (Poi x2 y2) = sqrt $ fromIntegral ((x2 - x1)^2 + (y2 - y1)^2)