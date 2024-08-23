package cuentas;

import java.util.Random;

public class CuentaSueldo extends CuentaBancaria implements OperacionesBancarias {
    @SuppressWarnings("unused")
	private Integer legajo;
    
    @SuppressWarnings("unused")
    private String institucion;
    
    @SuppressWarnings("unused")
    private String beneficios;
    
    @SuppressWarnings("unused")
    private Long cbu;
    
    private Double tope;

    private void validar_cbu(Long cbu) {
        var digitos = cbu.toString().length();
        if (digitos != 18)
            throw new Error("cbu invalido: " + digitos);
    }

    public CuentaSueldo() {
        super();
        this.tope = 0.0;
    }

    public CuentaSueldo(Long cbu) {
        // Simula traer los datos de un usuario por medio del cbu
        super(
                Math.abs(new Random().nextLong()),
                new Random().nextDouble() * 10000,
                new Random().nextDouble());

        validar_cbu(cbu);
        this.cbu = cbu;
        this.tope = OperacionesComunes.TOPE_FIJO;
    }

    @Override
    public void retirar(Double saldo) {
        if (saldo > this.tope)
            throw new Error("supero el tope de retiro: $" + OperacionesComunes.TOPE_FIJO);

        super.retirar(saldo);
    }

    public void transferir(Double monto, Long cbu) {
        var cuenta_destino = new CuentaSueldo(cbu);

        try {
            super.retirar(monto);
            cuenta_destino.ingresar(monto);
        } catch (Exception e) {
            throw new Error("no se pudo realizar la transferencia: " + e.getMessage());
        }
    }

    public void transferir(Double monto, String alias) {
        // simula buscar el cbu por medio de un alias
        long cbu = (long) ((Math.random() * 9e17) + 1e17);

        this.transferir(monto, cbu);
    }

    @Override
    public void pagarServicio() {
        throw new UnsupportedOperationException("Unimplemented method 'pagarServicio'");
    }

    @Override
    public void cambiarAlias() {
        throw new UnsupportedOperationException("Unimplemented method 'cambiarAlias'");
    }

    @Override
    public void transferenciaAltoMonto(double monto) {
        throw new UnsupportedOperationException("Unimplemented method 'transferenciaAltoMonto'");
    }

}
