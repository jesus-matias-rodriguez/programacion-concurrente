import formas.Circulo;
import formas.Cuadrilatero;
import formas.Forma;
import formas.IForma;

class App {
    private static void print_forma(IForma forma) {
        System.out.println(
            "Forma: "     + forma.getNombreForma() + "\n" +
            "Perímetro: " + forma.perímetro()      + "\n" +
            "Area: "      + forma.area()           + "\n"
        );
    }

    private static void print_forma(Forma forma) {
        System.out.println(
            "Forma: "     + forma.getNombreForma() + "\n" +
            "Perímetro: " + forma.perimetro()      + "\n" +
            "Area: "      + forma.area()           + "\n"
        );
    }

    public static void main(String[] args) {
        var rect = new Cuadrilatero(3.0, 2.0);
        print_forma(rect);

        var circ = new Circulo(1.0);
        print_forma(circ);
    }
}