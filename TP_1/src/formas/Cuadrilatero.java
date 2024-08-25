package formas;

public class Cuadrilatero implements IForma {

    private Double largo;

    private Double altura;

    public Cuadrilatero(Double largo, Double altura) {
        this.largo = largo;
        this.altura = altura;
    }

    @Override
    public double perímetro() {
        return this.largo * 2 + this.altura * 2;
    }

    @Override
    public double area() {
        return this.largo * this.altura;
    }

    @Override
    public String getNombreForma() {
        return "CUADRILÁTERO";
    }
}
