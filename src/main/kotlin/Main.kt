package io.github.guerillaqc

import io.github.guerillaqc.datoutils.Convert

fun main() {
    println("Convert '29. jan. 2025' to long Norwegian format: ${Convert.kortTilLangtFormatNorsk("29. jan. 2025")}")
    println("Convert '29. januar 2025' to short Norwegian format: ${Convert.langtTilKortFormatNorsk("29. januar 2025")}")
    print("")
    println("Convert '29. jan. 2025 13:45' to long Norwegian format: ${Convert.kortTilLangtFormatMedTidNorsk("29. jan. 2025 13:45")}")
    println("Convert '29. januar 2025 13:45' to short Norwegian format: ${Convert.langtTilKortFormatMedTidNorsk("29. januar 2025 13:45")}")



}