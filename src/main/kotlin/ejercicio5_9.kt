import java.lang.NullPointerException

class Cuenta(val numCuenta: String, var saldo: Double = 0.0) {
    fun consultarSaldo(): String {
        return "Tienes $saldo€"
    }

    fun recibirAbonos(abono: Double): Double {
        saldo += abono
        return saldo
    }

    fun realizarPago(pago: Double): Double {
        saldo -= pago
        return saldo
    }
}

class Persona(val DNI: String) {
    private var contador: Int = 0
    var cuentas: Array<Cuenta?> = arrayOfNulls(3)
    fun incorporar(c: Cuenta) {
        if (contador < 3){
        cuentas.set(contador, c)
        contador++
    }}

    fun esMoroso(): Boolean {
        for (i in 0..2) {
            try {
                if (cuentas[i]!!.saldo < 0) {
                    return true
                }
            } catch (e: NullPointerException) {
                return false
            }
        }
        return false
    }

    fun transferencia(a: Cuenta, b: Cuenta, movimiento: Double) {
        a.realizarPago(movimiento)
        b.recibirAbonos(movimiento)
    }
}


fun main() {
    var p1 = Persona("2132312h")
    var c1 = Cuenta("Num1", 0.0)
    var c2 = Cuenta("Num2", 750.0)
    var c3 = Cuenta("Num1", 0.0)
    var c4 = Cuenta("Num2", 750.0)
    p1.incorporar(c1)
    p1.incorporar(c2)

    p1.incorporar(c3)
    p1.incorporar(c4)
    c1.recibirAbonos(1100.0)
    c2.realizarPago(750.0)

    if (p1.esMoroso()) {
        println("La persona con dni ${p1.DNI} moroso/a")
    }
    p1.transferencia(c1, c2, 20.0)
    println("La cuenta ${c1.numCuenta} tiene actualmente ${c1.saldo}")
    println("La cuenta ${c2.numCuenta} tiene actualmente ${c2.saldo}")
}