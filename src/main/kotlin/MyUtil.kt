import java.io.File

class MyUtil {
    companion object {
        @JvmStatic
        fun myUtilFunction() {
            println("HelloWorld")
        }
        @JvmStatic
        fun readIsoFile(fileName: String): String {
            //val fileName = "bon.txt" // Passe den Dateipfad entsprechend an
            //val fileName = "uumlUTF8.txt" // Passe den Dateipfad entsprechend an
            //val fileName = "uumlAnsi.txt" // Passe den Dateipfad entsprechend an

            try {
                val file = File(fileName)

                // Überprüfe, ob die Datei existiert, bevor du sie liest
                if (file.exists()) {
                    //val content = file.readText()
                    val content = file.readText(Charsets.ISO_8859_1)
                    //println("Dateiinhalt:")
                    return(content)
                    //logger.info(MyClass.convertAnsiToUtf8(content))
                    //logger.info(MyClass.convertWin1252toUtf8(content))
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