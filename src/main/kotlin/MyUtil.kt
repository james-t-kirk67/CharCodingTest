import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import java.io.File

class MyUtil {
    companion object {
        val logger: Logger = LogManager.getLogger(MyUtil::class.java)
        fun readIsoFile(fileName: String): String {
            try {
                val file = File(fileName)

                // Überprüfe, ob die Datei existiert, bevor du sie liest
                if (file.exists()) {
                    //val content = file.readText()
                    val content = file.readText(Charsets.ISO_8859_1)
                    //println("Dateiinhalt:")
                    //logger.info("MyUtil.readIsoFile()")
                    //logger.info(content)
                    return(content)
                } else {
                    return "Die angegebene Datei existiert nicht."
                }
            } catch (e: Exception) {
                println("Fehler beim Lesen der Datei: ${e.message}")
            }
            return "Error"
        }

    }
}
fun main() {
    val logger: Logger = LogManager.getLogger(MyUtil::class.java)
    logger.info("ae: ä / ue:ü")
    logger.info(MyUtil.readIsoFile("./src/test/resources/uumlAnsi.txt"))
}
