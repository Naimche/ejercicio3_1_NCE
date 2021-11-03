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

class ConjuntoLibros(val tamanio: Int, var conjunto: Array<Libros?> = arrayOfNulls(tamanio)) {
    var contador: Int = 0
    fun incorporar(c: Libros) {
        contador = 0
        while (conjunto[contador] != null) {
            if (contador < tamanio) {
                contador++
            } else contador = 0
        }
        conjunto[contador] = c
    }

    fun eliminarPorTitulo(a: String): Boolean {
        for (i in 0 until tamanio) {
            if (conjunto[i]?.titulo == a) {
                conjunto[i] = null
                return true
            }
        }
        return false
    }

    fun eliminarPorAutor(b: String): Boolean {
        for (i in 0 until tamanio) {
            if (conjunto[i]?.autor == b) {
                conjunto[i] = null
                return true
            }
        }
        return false
    }

    fun mostrarLibrosAlmacenados(): String {

        for (i in 0 until tamanio) {
            if (conjunto[i]?.titulo !== null) {
                println(conjunto[i]?.titulo)
            }
        }
        return "Todos los libros mostrados"
    }
}

fun main() {
    var a: String
    var conjunto = ConjuntoLibros(3)
    var l1 = Libros("Diario de Ana Frank", "Ana Frank", 215L, 8)
    var l2 = Libros("Harry Potter", "JK", 652L, 2)
    println("Incorporamos los dos libros")
    conjunto.incorporar(l1)
    conjunto.incorporar(l2)
    repeat(80) { print("*") }
    println()
    println("Eliminamos los dos libros")
    conjunto.eliminarPorTitulo("Harry Potter")
    conjunto.eliminarPorAutor("Ana Frank")
    repeat(80) { print("*") }
    println()
    println("AÑADIMOS UN LIBRO Y MOSTRAMOS TODOS LOS LIBROS ALMACENADOS:")
    conjunto.incorporar(l1)
    conjunto.mostrarLibrosAlmacenados()
    repeat(80) { print("*") }
}