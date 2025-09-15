package io.github.guerillaqc.datoutils

fun main() {
    println("Convert '29. jan. 2025' to long Norwegian format: ${Convert.kortTilLangtFormatNorsk("29. jan. 2025")}")
    println("Convert '29. januar 2025' to short Norwegian format: ${Convert.langtTilKortFormatNorsk("29. januar 2025")}")

}