import com.danvhae.oscar.console.badapple.BitMaskUtil
import com.danvhae.oscar.console.badapple.BrailleUtil.toBraille
import org.junit.jupiter.api.Test

object UnicodeTest {
    @Test
    fun printUnicode(){
        println(
            "\u2800 \u2801 \u2809"
        )
    }

    @Test
    fun braille(){
        println(
            listOf(
                emptySet(),
                setOf(1),
                setOf(1, 2),
                setOf(1, 2, 3),
                setOf(1, 2, 3, 4)
            ).map { BitMaskUtil[it].toBraille() }
        )
    }

    @Test
    fun bitmask(){
        var temp = 0
        val target = setOf(1, 3, 5)
        repeat(8){
            if((it + 1) in target){
                temp += (2 shl it)
            }
        }

        println(temp)
    }


}