public class Main {
    public static void main(String[] args) {
        double d1 = 35.0;
        double d2 = 72.0;
        double d3 = 53.0;
        double t1 = 0.7;
        double t2 = 1.6;
        double t3 = 1.1;
        double l1 = 4.4;
        double l2 = 9.0;
        double l3 = 6.2;
        double precioLitro = 1.42;
        double masaCargaKg = 1450.0;
        double largo = 2.2;
        double ancho = 1.3;
        double alto = 1.0;
        double p1 = 3.2;
        double p2 = 3.8;
        double p3 = 2.7;
        double deprecPorKm = 0.085;
        double volCamionM3 = 12.0;
        double fco2 = 2.64;
        double galPorLitro = 0.264172;
        double vMin = 30.0;
        double vMax = 90.0;
        double va = 40.0;
        double vb = 80.0;
        double ca = 0.05;
        double cb = 0.09;
        double a = -0.0009;
        double b = 0.09;
        double c = 3.8;

        // Velocidades y rendimiento
        double v1 = d1 / t1;
        System.out.println("v1: " + v1);
        double v2 = d2 / t2;
        System.out.println("v2: " + v2);
        double v3 = d3 / t3;
        System.out.println("v3: " + v3);

        double vProm = (d1 * v1 + d2 * v2 + d3 * v3) / (d1 + d2 + d3);
        System.out.println("vprom: " + vProm);

        // Rendimiento por tramo y total (km/L)
        double kml1 = d1 / l1;
        double kml2 = d2 / l2;
        double kml3 = d3 / l3;
        System.out.println("kml1: " + kml1);
        System.out.println("kml2: " + kml2);
        System.out.println("kml3: " + kml3);

        double kmlTotal = (d1 + d2 + d3) / (l1 + l2 + l3);
        System.out.println("kmlTotal: " + kmlTotal);

        // Costos directos
        double costosComb = (l1 + l2 + l3) * precioLitro;
        double deprec = (d1 + d2 + d3) * deprecPorKm;
        double peajes = p1 + p2 + p3;
        double costoDirecto = costosComb + deprec + peajes;
        double costoPorKm = costoDirecto / (d1 + d2 + d3);
        System.out.println("costosComb: " + costosComb);
        System.out.println("deprec: " + deprec);
        System.out.println("peajes: " + peajes);
        System.out.println("costoDirecto: " + costoDirecto);
        System.out.println("costoPorKm: " + costoPorKm);

        // Volumen, densidad y ocupación
        double volumenM3 = largo * ancho * alto;
        double densidad = masaCargaKg / volumenM3;
        double ocupación = volumenM3 / volCamionM3;
        System.out.println("volumenM3: " + volumenM3);
        System.out.println("densidad: " + densidad);
        System.out.println("ocupación: " + ocupación);

        // Emisiones de CO2
        double co2Total = (l1 + l2 + l3) * fco2;
        double co2porKm = co2Total / (d1 + d2 + d3);
        System.out.println("co2Total: " + co2Total);
        System.out.println("co2porKm: " + co2porKm);
        
        // Conversiones y normalizacion
        double vmsProm = vProm * (1000.0 / 3600.0);
        System.out.println("vmsProm: " + vmsProm);
        double galTot = (l1 + l2 + l3) * galPorLitro;
        System.out.println("galTot: " + galTot);

        double vNorm = (vProm - vMin) / (vMax - vMin);
        System.out.println("vNorm: " + vNorm);

        // Promedios y dispersión
        double vMedia = (v1 + v2 + v3) / 3;
        double sigma = Math.sqrt((Math.pow(v1 - vMedia, 2) + Math.pow(v2 - vMedia, 2) + Math.pow(v3 - vMedia, 2)) / 3);
        double vPondT = (t1 * v1 + t2 * v2 + t3 * v3) / (t1 + t2 + t3);
        System.out.println("vMedia: " + vMedia);
        System.out.println("sigma: " + sigma);
        System.out.println("vPondT: " + vPondT);

        // Interpolación lineal
        double cVProm = ca + (cb - ca) * ((vProm - va) / (vb - va));
        double costoMant = cVProm * (d1 + d2 + d3);
        System.out.println("cVProm: " + cVProm);
        System.out.println("costoMant: " + costoMant);

        //Modelo polinomico de rendimiento
        double v = vProm;
        double kmlV = a * Math.pow(v, 2) + b * v + c;
        double kmlModelo = kmlV;
        System.out.println("kmlModelo: " + kmlModelo);
        double litrosModelo = (d1 + d2 + d3) / kmlModelo;
        System.out.println("litrosModelo: " + litrosModelo);

        // índice de eficiencia
        double w1 = 0.25;
        double w2 = 0.25;
        double w3 = 0.25;
        double w4 = 0.25;
        double score = w1 * (1 / costoPorKm) + w2 * kmlTotal + w3 * (1 / co2porKm) + w4 * (1 / (1 + sigma));
        System.out.println("score: " + score);
    }
}