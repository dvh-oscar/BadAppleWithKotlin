import org.junit.jupiter.api.Test

object UnicodeTest {
    @Test
    fun printUnicode(){
        println(
            "\u2800 \u2801 \u2809"
        )
    }

    @Test
    fun generate(){
        val queue = ArrayList<List<Int>>()
        queue.add(emptyList())

        repeat(5){
            val number = it + 1
            queue.addAll(queue.map { list -> list.toMutableList().apply { add(number) } })
        }

        for(list in queue){
            println(list)
        }
    }


}