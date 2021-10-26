class Coche(
    var color: String,
    val marca: String,
    val modelo: String,
    val caballos: Int,
    val puertas: Int,
    val matricula: String
) {
    fun descripcion():String{
        return "El color del coche es $color\nLa marca es $marca\nEl modelo es $modelo\n\"El numero de caballos es $caballos\nEl numero de puertas es $puertas\n La matricula es $matricula"
    }

    override fun toString(): String {
        return this.descripcion()
    }
}
fun solicitarNuevoColor(): String {
    println("¿De que color quieres cambiar el coche?")
    var color = readLine().toString()?:"sinclor"
    return color
}
fun main() {
var c1 = Coche("Rosa", "Audi", "R8", 512, 2, "12832GCV")
    println(c1.descripcion())
var c2 = Coche("Blanco","bmw","i8", 374, 3, "672376ASD")
    println(c2.descripcion())
    c1.color = solicitarNuevoColor()
    println(c1.descripcion())

}