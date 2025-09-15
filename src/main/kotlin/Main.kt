package io.github.guerillaqc

import io.github.guerillaqc.datoutils.Convert
import io.github.guerillaqc.datoutils.Generate

fun main() {
    println("Convert '29. jan. 2025' to long Norwegian format: ${Convert.kortTilLangtFormatNorsk("29. jan. 2025")}")
    println("Convert '29. januar 2025' to short Norwegian format: ${Convert.langtTilKortFormatNorsk("29. januar 2025")}")
    print("")
    println("Convert '29. jan. 2025 13:45' to long Norwegian format: ${Convert.kortTilLangtFormatMedTidNorsk("29. jan. 2025 13:45")}")
    println("Convert '29. januar 2025 13:45' to short Norwegian format: ${Convert.langtTilKortFormatMedTidNorsk("29. januar 2025 13:45")}")
    println("")
    println("Dagens dato norsk kort format ${Generate.dagensDatoNorskKortFormat()}")
    println("Dagens dato norsk langt format ${Generate.dagensDatoNorskLangtFormat()}")
    println("Dagens dato norsk kort format med tid ${Generate.dagensDatoNorskKortFormatMedTid()}")
    println("Dagens dato norsk langt format med tid ${Generate.dagensDatoNorskLangtFormatMedTid()}")
    println("")
    println("Dagens dato norsk kort format pluss 2 dager ${Generate.dagensDatoNorskKortFormatPlussDager(2)}")
    println("Dagens dato norsk langt format pluss 2 dager ${Generate.dagensDatoNorskLangtFormatPlussDager(2)}") // "17. september 2025"
    println("Dagens dato norsk kort format med tid pluss 2 dager ${Generate.dagensDatoNorskKortFormatMedTidPlussDager(2)}")
    println("Dagens dato norsk langt format med tid pluss 2 dager ${Generate.dagensDatoNorskLangtFormatMedTidPlussDager(2)}")

    println("")
    println("Dagens dato norsk kort format minus 2 dager ${Generate.dagensDatoNorskKortFormatMinusDager(2)}")
    println("Dagens dato norsk langt format minus 2 dager ${Generate.dagensDatoNorskLangtFormatMinusDager(2)}")
    println("Dagens dato norsk kort format med tid minus 2 dager ${Generate.dagensDatoNorskKortFormatMedTidMinusDager(2)}")
    println("Dagens dato norsk langt format med tid minus 2 dager ${Generate.dagensDatoNorskLangtFormatMedTidMinusDager(2)}")


}