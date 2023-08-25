import Point
import City
import Quality
import Link
import Tunel

coordenadas1 = newP 5 2
coordenadas2 = newP 7 11
coordenadas3 = newP 2 4


bsas = newC "Buenos Aires" coordenadas1
mdq = newC "Mar del Plata" coordenadas2
pinamar = newC "Pinamar" coordenadas3

quality = newQ "Bsas-Mdq" 2 50

mdq_bsas = newL bsas mdq quality

tiempo = delayL mdq_bsas