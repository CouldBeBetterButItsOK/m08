package m08uf1.activity.ocaex1

import java.util.Scanner

fun main() {
    println("Joc de l'oca")
    println("Cuants jugadors sereu ?")
    val scanner = Scanner(System.`in`)
    var joc = Joc(scanner.nextInt())
    joc.start()
    joc.jugar()


}