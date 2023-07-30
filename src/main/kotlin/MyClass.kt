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
                    println("Dateiinhalt:")
                    println(content)
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
        fun readBon2() {
            //val fileName = "bon.txt" // Passe den Dateipfad entsprechend an
            //val fileName = "uumlUTF8.txt" // Passe den Dateipfad entsprechend an
            val fileName = "uumlAnsi.txt" // Passe den Dateipfad entsprechend an

            try {
                val file = File(fileName)

                // Überprüfe, ob die Datei existiert, bevor du sie einliest
                if (file.exists()) {
                    val inputStream = FileInputStream(file)
                    val inputStreamReader = InputStreamReader(inputStream, Charsets.ISO_8859_1)
                    val bufferedReader = BufferedReader(inputStreamReader)

                    var line: String?
                    while (bufferedReader.readLine().also { line = it } != null) {
                        logger.info(line)
                        println(line)
                    }

                    bufferedReader.close()
                } else {
                    println("Die angegebene Datei existiert nicht.")
                }
            } catch (e: Exception) {
                println("Fehler beim Lesen der Datei: ${e.message}")
            }
        }
        fun convertAnsiToUtf8(ansiString: String): String {
            // Wandele den ANSI-String in Byte-Array mit der ANSI-Codierung um
            val ansiBytes = ansiString.toByteArray(Charsets.ISO_8859_1)
            println(byteArrayToHexString(ansiBytes))
            // Konvertiere die Byte-Array in UTF-8-codierten String
            return String(ansiBytes, Charsets.UTF_8)
        }
        fun convertWin1252toUtf8(cp1252String: String): String{
            val utf8Bytes = cp1252String.toByteArray(Charsets.UTF_8)
            println(byteArrayToHexString(utf8Bytes))
            return String(utf8Bytes, Charsets.ISO_8859_1)
        }
        fun byteArrayToHexString(byteArray: ByteArray): String {
            val hexChars = "0123456789ABCDEF"
            val result = StringBuilder()
            for (byte in byteArray) {
                val highNibble = (byte.toInt() and 0xF0) ushr 4
                val lowNibble = byte.toInt() and 0x0F
                result.append(hexChars[highNibble])
                result.append(hexChars[lowNibble])
            }
            return result.toString()
        }
    }
}

fun main() {
    MyClass.doSomething()
    MyClass.readBon()
}

