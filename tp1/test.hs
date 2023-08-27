import Point
import City
import Quality
import Link
import Tunel
-- import Region

-----------------------------------------

coordenadasBsas = newP 5 2
coordenadasPinamar = newP 6 8
coordenadasGesell = newP 7 11
coordenadasMdq = newP 7 14

-----------------------------------------

buenosAires = newC "Buenos Aires" coordenadasBsas
pinamar = newC "Pinamar" coordenadasPinamar
villaGesell = newC "Villa Gesell" coordenadasGesell
marDelPlata = newC "Mar del Plata" coordenadasMdq

distanciaBsasMdq = distanceC buenosAires marDelPlata

-----------------------------------------

quality1 = newQ "Bsas-Pinamar" 2 50
quality2 = newQ "Pinamar-Gesell" 1 15
quality3 = newQ "Gesell-Mdq" 3 30

-----------------------------------------

bsasPinamar = newL buenosAires pinamar quality1
pinamarGesell = newL pinamar villaGesell quality2
gesellMdq = newL villaGesell marDelPlata quality3

delayPinamarGesell = delayL pinamarGesell

-----------------------------------------

tunel = newT [bsasPinamar, pinamarGesell, gesellMdq]


-----------------------------------------