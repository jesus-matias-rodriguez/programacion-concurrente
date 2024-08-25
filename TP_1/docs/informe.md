# Programación Orientado a Objetos
Informe del desarrollo del trabajo practico 1 de la materia Programación Concurrente
sobre la programación orientada a objetos, el trabajo fue desarrollado en java con el
propósito de entender:
- Los objetos
- Herencia.
- Las clases
- Las clases abstractas
- Interfaces
- Polimorfismo
- Sobre carga de métodos

El informe va a tratar sobre los puntos del trabajo practico:

- 2: Aplicación de herencia y sobre carga de métodos.
- 5: Creación de objetos de una implementación de una clase Abstracta
- 6: Utilización de interfaces

## 2. Desarrollo de la clase Cuenta Sueldo
A partir de la clase definida en el ejemplo anterior, cree una nueva clase **CuentaSueldo**, que herede de **CuentaBancaria** y posea los siguientes atributos propios:
- legajo (entero)
- institución (string)
- beneficios (string)
- CBU (entero largo de 18 dígitos)
- tope (double)

```java
public class CuentaSueldo extends CuentaBancaria {
    private Integer legajo;
    private String institucion;
    private String beneficios;
    private Long cbu;
    private Double tope;
...
}

```

Además debe poseer los siguientes métodos:
- Constructor por defecto y constructor con CBU (el cual es un número de 18 dígitos) y tope fijado en 15.000
```java
   // Crea una nueva cuenta bancaria
   public CuentaSueldo() {
        super();
        this.tope = 0.0;
    }

    public CuentaSueldo(Long cbu) {
        // Simula traer los datos de la cuenta bancaria por medio del cbu
        super(
                Math.abs(new Random().nextLong()),
                new Random().nextDouble() * 10000,
                new Random().nextDouble());

        validar_cbu(cbu);
        this.cbu = cbu;
        this.tope = CuentaSueldo.TOPE_FIJO; // Constante estática de 15.000
    }
```
- Sobrescribir el método `retirar(double)`, para que además de permitir sacar una cantidad de la cuenta (si hay saldo), no permita extracciones superiores al tope.
```java
    @Override
    public void retirar(Double saldo) {
        if (saldo > this.tope)
            throw new Error("supero el tope de retiro: $" + this.TOPE_FIJO);

        super.retirar(saldo);
    }

```
- `transferir(monto, CBU)`: este método simulará una transferencia a otra cuenta por el monto ingresado (siempre y cuando haya saldo) y decrementará el saldo de la cuenta. Para la "transferencia", muestre el saldo final de la cuenta.
```java
  public void transferir(Double monto, Long cbu) {
        var cuenta_destino = new CuentaSueldo(cbu);

        try {
            super.retirar(monto); // lanza una excepción si no hay saldo 
            cuenta_destino.ingresar(monto);
        } catch (Exception e) {
            throw new Error("no se pudo realizar la transferencia: " + e.getMessage());
        }
    }
```

- Sobrecargue el método `transferir(monto, Alias)` de la clase `CuentaSueldo` para que acepte un alias alfanumérico.
```java
  public void transferir(Double monto, String alias) {
        // simula buscar el cbu por medio de un alias
        long cbu = (long) ((Math.random() * 9e17) + 1e17);

        this.transferir(monto, cbu);
    }
```

## 5. Cree la clase Circulo
Al igual que en el punto anterior, cree una clase `Circulo` que herede de `Forma` e implemente los métodos `area()` y `perímetro()` de un círculo. Desde el `main()` cree un objeto de tipo `Circulo` y muestre la ejecución de los métodos `area()` y `perímetro()`.

```java
public class Circulo extends Forma {
    private Double radio;

    public Circulo(Double radio) {
        super("CIRCULO");
        this.radio = radio;
    }

    @Override
    public double perimetro() {
        return 2 * Math.PI * this.radio;
    }

    @Override
    public double area() {
        return Math.PI * this.radio * this.radio;
    }

}
```

```java
class App {
    private static void print_forma(Forma forma) {
        // getNombreForma() devuelve el atributo privado NombreForma
        System.out.println(
            "Forma: "     + forma.getNombreForma() + "\n" +
            "Perímetro: " + forma.perimetro()      + "\n" +
            "Area: "      + forma.area()           + "\n"
        );
    }

    public static void main(String[] args) {
        var circ = new Circulo(1.0);
        print_forma(circ);
    }
}
```

```console
Forma: CIRCULO
Perímetro: 6.283185307179586
Area: 3.141592653589793
```
## 6. Cambie la clase Forma por una interfaz
Realice lo mismo que en el punto 4) pero en lugar de utilizar una clase abstracta `Forma`, hágalo mediante una interfaz.

```java
public interface IForma {
    double perímetro();
    double area();
    String getNombreForma();
}
```

```java
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
```
```java
class App {
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
    }
}
```
```console
Forma: CUADRILÁTERO
Perímetro: 10.0
Area: 6.0
```