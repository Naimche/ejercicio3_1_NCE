class Cuenta(val numCuenta: String, var saldo: Double = 0.0) {
    fun consultarSaldo(): String {
        return "Tienes $saldo€"
    }

    fun recibirAbonos(abono: Int): String {
        saldo += abono
        return "Has recibido $abono€, tu saldo es $saldo€"
    }

    fun realizarPago(pago: Int): String {
        saldo -= pago
        return "Has realizado un pago de $pago€, tu saldo es $saldo€"
    }

    fun moroso(): Unit {
        if (saldo < 0) {
            println("Tu saldo es negativo debes $saldo€")
        } else {
            println("Tu saldo es positivo, tienes $saldo€")
        }
    }
}

class Persona(val DNI: String) {
    var cuentas: Array<Cuenta> = arrayOf()
    fun incorporar(c: Cuenta) {
        if (cuentas.size < 3) {
            cuentas += c
        }
    }

    fun esMoroso(): Boolean {
        for (i in 0..2) {
            if (cuentas[i]!!.saldo < 0) {
                return true
            }
        }
        return false
    }
}


fun main() {
    var p1 = Persona("2132312h")
    var c1 = Cuenta("Num1", 0.0)
    var c2 = Cuenta("Num2", 700.0)
    p1.incorporar(c1)
    p1.incorporar(c2)
    c1.recibirAbonos(1100)
    c2.realizarPago(750)
    if (p1.esMoroso() == true) {
        println("La persona con dni ${p1.DNI} moroso/a")
    }
}