import org.apache.logging.log4j.LogManager
import org.junit.jupiter.api.Test

internal class MyUtilTest {
    @Test
    fun readIsoFileTest() {
        //log.info("ae: ä / ue:ü")
        MyUtil.readIsoFile("./src/test/resources/uumlAnsi.txt")
    }
}