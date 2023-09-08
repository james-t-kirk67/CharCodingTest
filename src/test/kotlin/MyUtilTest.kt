import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.junit.jupiter.api.Test

internal class MyUtilTest {
    val logger: Logger = LogManager.getLogger(MyUtil::class.java)
    @Test
    fun readIsoFileTest() {
        logger.info("ae: ä / ue:ü")
        logger.info(MyUtil.readIsoFile("./src/test/resources/uumlAnsi.txt"))
    }
}