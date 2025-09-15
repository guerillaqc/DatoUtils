package io.github.guerillaqc.datoutils

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

object Generate {

    private val norskLocale = Locale("no", "NO")
    private val formatterKort = DateTimeFormatter.ofPattern("d. MMM yyyy", norskLocale)
    private val formatterKortMedTid = DateTimeFormatter.ofPattern("d. MMM yyyy HH:mm", norskLocale)

    /**
     * * @return the current date in Norwegian short format, ie. "29. jan. 2025"
     */
    fun dagensDatoNorskKortFormat(): String {
        return LocalDate.now().format(formatterKort)
    }

    /**
    * * @return the current date in Norwegian long format, ie. "29. januar 2025"
    */
    fun dagensDatoNorskLangtFormat(): String {
        return Convert.kortTilLangtFormatNorsk(dagensDatoNorskKortFormat())
    }

    /**
     * * @return the current date and time in Norwegian short format and 24-hour time, ie. "29. jan. 2025 13:45"
     */
    fun dagensDatoNorskKortFormatMedTid(): String {
        return LocalDateTime.now().format(formatterKortMedTid)
    }

    /**
     * * @return the current date in Norwegian long format and 24-hour time, ie. "29. jan. 2025 13:45"
     */
    fun dagensDatoNorskLangtFormatMedTid(): String {
        return Convert.kortTilLangtFormatMedTidNorsk(dagensDatoNorskKortFormatMedTid())
    }

    /**
     * * @return the current date plus x days in Norwegian short format.
     */
    fun dagensDatoNorskKortFormatPlussDager(plussDager: Int): String {
        return LocalDate.now().plusDays(plussDager.toLong()).format(formatterKort)
    }

    /**
     * * @return the current date plus x days in Norwegian long format.
     */
    fun dagensDatoNorskLangtFormatPlussDager(plussDager: Int): String {
        val kortFormat = dagensDatoNorskKortFormatPlussDager(plussDager)
        return Convert.kortTilLangtFormatNorsk(kortFormat)
    }

    /**
     * * @return the current date and time minus x days in Norwegian short format.
     */
    fun dagensDatoNorskKortFormatMedTidMinusDager(minusDager: Int): String {
        return LocalDateTime.now().minusDays(minusDager.toLong()).format(formatterKortMedTid)
    }

    /**
     * * @return the current date and time minus x days in Norwegian long format.
     */
    fun dagensDatoNorskLangtFormatMedTidMinusDager(minusDager: Int): String {
        val kortFormat = dagensDatoNorskKortFormatMedTidMinusDager(minusDager)
        return Convert.kortTilLangtFormatMedTidNorsk(kortFormat)
    }

    /**
     * * @return the current date and time plus x days in Norwegian short format.
     */
    fun dagensDatoNorskKortFormatMedTidPlussDager(plussDager: Int): String {
        return LocalDateTime.now().plusDays(plussDager.toLong()).format(formatterKortMedTid)
    }

    /**
     * * @return the current and time plus x days in Norwegian long format.
     */
    fun dagensDatoNorskLangtFormatMedTidPlussDager(plussDager: Int): String {
        val kortFormat = dagensDatoNorskKortFormatMedTidPlussDager(plussDager)
        return Convert.kortTilLangtFormatMedTidNorsk(kortFormat)
    }

    /**
     * * @return the current date minus x days in Norwegian short format.
     */
    fun dagensDatoNorskKortFormatMinusDager(minusDager: Int): String {
        return LocalDate.now().minusDays(minusDager.toLong()).format(formatterKort)
    }

    /**
     * * @return the current date minus x days in Norwegian long format.
     */
    fun dagensDatoNorskLangtFormatMinusDager(minusDager: Int): String {
        val kortFormat = dagensDatoNorskKortFormatMinusDager(minusDager)
        return Convert.kortTilLangtFormatNorsk(kortFormat)
    }
}