import Point
import City
import Quality
import Link
import Tunel
import Region

-----------------------------------------
-- Point
coordenadasBsas = newP 5 2
coordenadasPinamar = newP 6 8
coordenadasGesell = newP 7 11
coordenadasMdq = newP 7 14

-----------------------------------------
-- City
buenosAires = newC "Buenos Aires" coordenadasBsas
pinamar = newC "Pinamar" coordenadasPinamar
villaGesell = newC "Villa Gesell" coordenadasGesell
marDelPlata = newC "Mar del Plata" coordenadasMdq

distanciaBsasMdq = distanceC buenosAires marDelPlata

-----------------------------------------
-- Quality
quality1 = newQ "Bsas-Pinamar" 2 50
quality2 = newQ "Pinamar-Gesell" 1 15
quality3 = newQ "Gesell-Mdq" 3 30

qualityError = newQ "conexión Falsa" (-2) 4

-----------------------------------------
-- Link
bsasPinamar = newL buenosAires pinamar quality1
pinamarGesell = newL pinamar villaGesell quality2
gesellMdq = newL villaGesell marDelPlata quality3

enlaceFalso = connectsL villaGesell bsasPinamar
enlaceVerdadera = connectsL villaGesell pinamarGesell

linkFalso = linksL marDelPlata buenosAires bsasPinamar
linkVerdadero = linksL pinamar buenosAires bsasPinamar

delayPinamarGesell = delayL pinamarGesell

-----------------------------------------
-- Tunel
tunel = newT [bsasPinamar, pinamarGesell, gesellMdq]
delaytunel = delayT tunel == (delayL bsasPinamar + delayL pinamarGesell + delayL gesellMdq)

linkTunel = usesT bsasPinamar tunel

puntasV = connectsT buenosAires marDelPlata tunel
puntasF = connectsT pinamar marDelPlata tunel

-----------------------------------------
-- Region








-----------------------------------------