class TarjetaCredito{

String nombreTitular;
String numeroTarjeta;
double limiteTotal;
double saldoTarjeta;
private boolean activa;

public TarjetaCredito(String nombreTitular, String numeroTarjeta, double saldoTarjeta){
this.nombreTitular = nombreTitular;
this.numeroTarjeta = numeroTarjeta;
this.saldoTarjeta = saldoTarjeta;
}


public boolean realizarCompra(double monto){
    
System.out.println("=======================================");
    if(!activa){
System.out.println("La tarjeta está bloqueada. Transacción rechazada");
return false;
    }

if(monto > saldoTarjeta){
    System.out.println("Compra rechazada. Fondos insuficientes");
    return false;
}
this.saldoTarjeta -= monto;
System.out.println("Compra realizada por: " + monto);
return true;
}

/////////////////////////////
 public void bloquear(){
    this.activa = false;
 }

public void desbloquear(){
    this.activa = true;
}

public boolean activa(){
    return this.activa;
}
//////////////////////////

void pagarResumen(double monto){

        if(!activa){
System.out.println("La tarjeta está bloqueada. Transacción rechazada");
    }

if(monto > saldoTarjeta){
    System.out.println("Compra rechazada. Fondos insuficientes");

this.saldoTarjeta -= monto;

System.out.println("=======================================");
    System.out.println("Pago exitoso de $" + monto);
}
}

void mostrarInformacion(){
System.out.println("=======================================");
System.out.println("Nombre del titular: " + nombreTitular);
System.out.println("Numero de la tarjeta: " + numeroTarjeta);
System.out.println("Saldo de la tarjeta: " + saldoTarjeta);
System.out.println("=======================================");
}

public static void main(String[] args) {
    TarjetaCredito t1 = new TarjetaCredito("Juan Perez", "EV2134-NK4334-733J", 10000);
  TarjetaCredito t2 = new TarjetaCredito("Juan Fernandez", "HG543-BD92-NFB44", 10000);
t1.bloquear();
t1.desbloquear();
t1.activa();
t1.pagarResumen(1000);
t1.realizarCompra(5000);
t1.mostrarInformacion();

t2.activa();
t2.pagarResumen(6459);
t2.mostrarInformacion();

}
}
