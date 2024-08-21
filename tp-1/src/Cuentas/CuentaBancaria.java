package Cuentas;

public class CuentaBancaria {
    private Long numero_cuenta;
    private Long dni_cliente;
    private Double saldo_actual;
    private Double interes_anual;

    private static Long SEED_CUENTAS = 100000L;

    private static Long generar_numero_cuenta() {
        SEED_CUENTAS += 1;
        return SEED_CUENTAS;
    }

    public CuentaBancaria() {
        this.numero_cuenta = generar_numero_cuenta();
        this.saldo_actual = 0.0;
        this.interes_anual = 0.0;
    }

    public CuentaBancaria(Long dni, Double saldo, Double interes) {
        this.numero_cuenta = generar_numero_cuenta();
        this.dni_cliente = dni;
        this.saldo_actual = saldo;
        this.interes_anual = interes;
    }

    public void actualizarSaldo() {
        Double interes_diario = this.interes_anual / 365;
        Double aumento = this.saldo_actual * interes_diario;

        this.ingresar(aumento);
    }

    public void ingresar(Double saldo) {
        this.saldo_actual += saldo;
    }

    public void retirar(Double saldo) {
        Boolean hay_saldo = this.saldo_actual > saldo;

        if (!hay_saldo)
            throw new Error("saldo insuficiente");

        this.saldo_actual -= saldo;
    }

    @Override
    public String toString() {
        var saldo = "$" + String.format("%.2f", this.saldo_actual);
        var interes = String.format("%.2f", this.interes_anual * 100) + "%";
        var cuenta = String.format("%,d", this.numero_cuenta);
        var dni = String.format("%,d", this.dni_cliente);

        return "Cuenta Bancaria:" + "\n" +
                "================" + "\n" +

                "Número de Cuenta: " + cuenta + "\n" +
                "DNI del Cliente: " + dni + "\n" +
                "Saldo actual: " + saldo + "\n" +
                "Interés Anual: " + interes + "\n";
    }

}