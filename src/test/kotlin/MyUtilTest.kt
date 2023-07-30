import org.apache.logging.log4j.LogManager
import org.junit.jupiter.api.Test

internal class MyUtilTest {
    @Test
    fun readIsoFileTest() {
        //03.05.2023  12:42  8017/1  000001/1   2735
        log.info("ae: ä / ue:ü")
        log.info(MyUtil.readIsoFile("./src/test/resources/uumlAnsi.txt"))
    }

    companion object {
        var log = LogManager.getLogger()
    }
}