package edu.pingpong.arnoldEnumType.domain;

public enum Planeta {

    MERCURY (3.303e+23, 2.4397e6),
    VENUS (4.869e+24, 6.0518e6),
    EARTH (5.976e+24, 6.37814e6),
    MARS (6.421e+23, 3.3972e6),
    JUPITER (1.9e+27, 7.1492e7),
    SATURN (5.688e+26, 6.0268e7),
    URANUS (8.686e+25, 2.5559e7),
    NEPTUNE (1.024e+26, 2.4746e7);

    private double masa = 0d;
    private double radio = 0d;

    private static final double G = 6.67300E-11;

    private Planeta(double masa, double radio){
        this.masa = masa;
        this.radio = radio;
    }

    public double getMasa() {
        return masa;
    }

    public double getRadio() {
        return radio;
    }

    public double gravedadSuperficie(double masaPlaneta, double radio){
        return (G * masaPlaneta) / Math.pow(radio, 2);
    }

    public double tuMasa(double pesoTierra){
        return pesoTierra / gravedadSuperficie(Planeta.EARTH.getMasa(), Planeta.EARTH.getRadio());
    }

    public double pesoSuperficie(double pesoTierra){
        return tuMasa(pesoTierra) * gravedadSuperficie(getMasa(), getRadio());
    }

    public static Planeta[] getPlanetasTerrestres(){
        
        Planeta[] planetasTerrestres = new Planeta[4];
		
		for(int i=Planeta.MERCURY.ordinal(); i<Planeta.JUPITER.ordinal(); i++){
			planetasTerrestres[i] = Planeta.values()[i];
		}
        return planetasTerrestres;
    }
}
