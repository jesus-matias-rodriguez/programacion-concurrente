package formas;

public class Cuadrilatero extends Forma {

    private Double largo;

    private Double altura;

    public Cuadrilatero(Double largo, Double altura) {
        super("CUADRILATERO");
        this.largo = largo;
        this.altura = altura;
    }

    @Override
    public double perimetro() {
        return this.largo * 2 + this.altura * 2;
    }

    @Override
    public double area() {
        return this.largo * this.altura;
    }
}
