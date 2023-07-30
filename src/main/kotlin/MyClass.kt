import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import java.io.*


class MyClass {
    companion object {
        val logger: Logger = LogManager.getLogger(MyClass::class.java)

        fun doSomething() {
            logger.info("Rübezahl frisst Ähren. Hätte, hätte Fahrradkette")
        }
        fun readBon() {
            //val fileName = "bon.txt" // Passe den Dateipfad entsprechend an
            //val fileName = "uumlUTF8.txt" // Passe den Dateipfad entsprechend an
            val fileName = "uumlAnsi.txt" // Passe den Dateipfad entsprechend an

            try {
                val file = File(fileName)

                // Überprüfe, ob die Datei existiert, bevor du sie liest
                if (file.exists()) {
                    //val content = file.readText()
                    val content = file.readText(Charsets.ISO_8859_1)
                    println(content)
                    logger.info("Function MyClass.readBon() Dateiinhalt:")
                    logger.info(content)
                    //logger.info(MyClass.convertAnsiToUtf8(content))
                    //logger.info(MyClass.convertWin1252toUtf8(content))
                } else {
                    println("Die angegebene Datei existiert nicht.")
                }
            } catch (e: Exception) {
                println("Fehler beim Lesen der Datei: ${e.message}")
            }
        }
    }
}

fun main() {
    //MyClass.doSomething()
    //MyClass.readBon()
    MyUtil.readIsoFile("./src/test/resources/uumlAnsi.txt")
}


