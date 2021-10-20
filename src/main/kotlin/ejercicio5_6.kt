class Rectangulo(var base: Double, var altura: Double) {
    fun perimetro(): Double {
        return 2 * base + 2 * altura
    }

    fun area(): Double {
        return base * altura
    }

    override fun toString(): String {
        base.toString()
        altura.toString()

        return "la base es $base y su altura es $altura"
    }
}

fun main(args: Array<String>) {
    var r = Rectangulo(4.0, 2.0)

    println("Para el rectangulo ${r.toString()} el area es ${r.area()} y el perimetro ${r.perimetro()}")
    var r2 = Rectangulo(6.0, 9.0)
    repeat(80) { print("_") }
    println()
    println("Para el rectangulo ${r2.toString()} el area es ${r2.area()} y el perimetro ${r2.perimetro()}")
    repeat(80) { print("_") }
    println()
    var r3 = Rectangulo(3.4, 2.3)
    println("Para el rectangulo ${r3.toString()} el area es ${r3.area()} y el perimetro ${r3.perimetro()}")
    repeat(80) { print("_") }
    println()
}