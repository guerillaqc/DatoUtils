package io.github.guerillaqc.datoutils

import java.util.*
import java.util.regex.Pattern

/**
 * Utility class for converting between between Norwegian dat formats
 */
object Convert {
    // Map from short to long names of month in Norwegian
    private val KORT_TIL_LANG: Map<String, String> = java.util.Map.ofEntries(
        java.util.Map.entry("jan", "januar"),
        java.util.Map.entry("feb", "februar"),
        java.util.Map.entry("mar", "mars"),
        java.util.Map.entry("apr", "april"),
        java.util.Map.entry("mai", "mai"),
        java.util.Map.entry("jun", "juni"),
        java.util.Map.entry("jul", "juli"),
        java.util.Map.entry("aug", "august"),
        java.util.Map.entry("sep", "september"),
        java.util.Map.entry("okt", "oktober"),
        java.util.Map.entry("nov", "november"),
        java.util.Map.entry("des", "desember")
    )

    // Map from long to short names of month in Norwegian
    private val LANG_TIL_KORT: Map<String, String> = java.util.Map.ofEntries(
        java.util.Map.entry("januar", "jan"),
        java.util.Map.entry("februar", "feb"),
        java.util.Map.entry("mars", "mar"),
        java.util.Map.entry("april", "apr"),
        java.util.Map.entry("mai", "mai"),
        java.util.Map.entry("juni", "jun"),
        java.util.Map.entry("juli", "jul"),
        java.util.Map.entry("august", "aug"),
        java.util.Map.entry("september", "sep"),
        java.util.Map.entry("oktober", "okt"),
        java.util.Map.entry("november", "nov"),
        java.util.Map.entry("desember", "des")
    )

    // Pattern for for matching Norwegian date format: dag. mnd. år OR dag. måned år
    private val NORSK_DATO_PATTERN: Pattern = Pattern.compile(
        "^\\s*(\\d{1,2})\\.\\s*([a-zæøå]+)\\.?\\s*(\\d{4})\\s*$",
        Pattern.CASE_INSENSITIVE
    )

    /**
     * Convert from short to long format on Norwegian date
     * @param kortDato date in the format "29. jan. 2025" or similar
     * @return date in the format "29. januar 2025"
     * @throws IllegalArgumentException if the date cannot be parsed
     */
    fun kortTilLangtFormatNorsk(kortDato: String): String {
        val matcher = NORSK_DATO_PATTERN.matcher(kortDato.trim { it <= ' ' })
        require(matcher.matches()) {
            "Invalid date format: " + kortDato +
                    ". Expected format: 'dd. MMM. yyyy' or 'dd. MMM yyyy'"
        }

        val dag = matcher.group(1)
        var maned = matcher.group(2).lowercase(Locale.getDefault())
        val ar = matcher.group(3)

        // Fjern eventuelle punktum fra måneden
        maned = maned.replace(".", "").trim { it <= ' ' }

        val langManed = KORT_TIL_LANG[maned]
        requireNotNull(langManed) { "Unknown month : $maned" }

        return String.format("%s. %s %s", dag, langManed, ar)
    }

    /**
     * Convert from long to short format of Norwegian date
     * @param langDato date in the format "29. januar 2025" or similar
     * @return date in the format "29. jan. 2025"
     * @throws IllegalArgumentException if the date cannot be parsed
     */
    fun langtTilKortFormatNorsk(langDato: String): String {
        val matcher = NORSK_DATO_PATTERN.matcher(langDato.trim { it <= ' ' })
        require(matcher.matches()) {
            "Invalid date format: " + langDato +
                    ". Expected format: 'dd. MMMM yyyy' or 'dd. MMMM. yyyy'"
        }

        val dag = matcher.group(1)
        var maned = matcher.group(2).lowercase(Locale.getDefault())
        val ar = matcher.group(3)

        //Remove any periods from the month
        maned = maned.replace(".", "").trim { it <= ' ' }

        val kortManed = LANG_TIL_KORT[maned]
        requireNotNull(kortManed) { "Unknown month : $maned" }

        return String.format("%s. %s. %s", dag, kortManed, ar)
    }
}