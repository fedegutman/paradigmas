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

buenosAiresFalsa = newC "Buenos Aires Falsa" coordenadasBsas -- ciudad en las mismas coordenadas que Buenos Aires

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
region = newR

region1 = foundR region buenosAires
region2 = foundR region1 buenosAiresFalsa -- Prueba de que no se puede tener dos ciudades en el mismo lugar dentro de una region
region3 = foundR region1 pinamar

region4 = linkR region3 buenosAires pinamar quality1
region5 = linkR region4 buenosAires pinamar quality2 -- Prueba de que no se puede crear un nuevo enlace entre ciudades si ya existe uno.
region6 = foundR region4 villaGesell
region7 = foundR region6 marDelPlata
region8 = linkR region7 pinamar villaGesell quality2
region9 = linkR region8 villaGesell marDelPlata quality3

region10 = tunelR region9 [buenosAires, pinamar, villaGesell, marDelPlata]
region11 = tunelR region9 [pinamar, buenosAiresFalsa] -- Prueba que no se puede establecer un tunel cuando alguna ciudad no se encuentra en la region. 

conexionvalida = connectedR region10 buenosAires marDelPlata

enlaceValido = linkedR region10 pinamar villaGesell



-----------------------------------------