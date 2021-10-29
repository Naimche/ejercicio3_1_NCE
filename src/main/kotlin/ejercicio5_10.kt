class Libros(val titulo: String, val autor: String, val numerodepaginas: Long, calificacion: Byte) {
    var nota = calificacion
        set(value) {
            if (value in 0..10) {
                field = value
            }
        }

    init {
        require(calificacion in 0..10) { "La calificacion debe estar entre el 0 y el 10" }
    }
}

class ConjuntoLibros(var nombre: String, var conjunto: Array<Libros?> = arrayOfNulls(10)) {
    var contador:Int = 0
    fun incorporar(c: Libros) {
        if (contador < 10) {
            conjunto[contador] = c
            contador++
        }
    }
}

fun main() {
    var conjunto= ConjuntoLibros("Ficcion")
    var l1 = Libros("Diario de Ana Frank", "Ana Frank", 215L, 8)
    var l2 = Libros("adasd","adads", 1212L, 2)
    conjunto.incorporar(l1)
    conjunto.incorporar(l2)
    println(1)
}