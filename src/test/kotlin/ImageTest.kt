import com.danvhae.oscar.console.badapple.processors.ImageProcessor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.bytedeco.javacpp.indexer.UByteIndexer
import org.bytedeco.opencv.global.opencv_imgcodecs.imread
import org.bytedeco.opencv.opencv_core.Mat
import org.junit.jupiter.api.Test
import java.util.concurrent.Executors


object ImageTest {

    @Test
    fun imageTypeTest(){
//        val source = imread("/Users/march/Downloads/image.png")
//        println(source.type())
        listOf(
            "./inputs/images/1bit.png",
            "./inputs/images/color.png"
        ).forEach{
            println("$it : ${imread(it).type()}")
        }
    }

    @Test
    fun imagePixelTest(){
        val source = imread("./inputs/images/1bit.png")
        val mat = Mat()
        source.copyTo(mat)
        val indexer: UByteIndexer = mat.createIndexer()
        println(ImageProcessor.calculateAverage(indexer, 32, 16, 8.toDouble(), source.cols(), source.rows()))
    }



    @Test
    fun imageToBraille() = runBlocking{
//        val source = imread()
        val scope = CoroutineScope(SupervisorJob() + Executors.newVirtualThreadPerTaskExecutor().asCoroutineDispatcher())
        val source = imread("./inputs/images/1bit.png")
        val mat = Mat()
        source.copyTo(mat)
        val indexer: UByteIndexer = mat.createIndexer()
//        val line = (0 until 64).joinToString(""){
//            val x = it.toLong()
//            ImageProcessor.brailleAt(indexer, x, 0, 8).toString()
//        }

//        println(line)
        val lines = HashMap<Int, String>()
        val scale = 4
        val numberOfX = source.cols() / (scale * 2)
        val numberOfY = source.rows() / (scale * 4)
        val startAt = System.currentTimeMillis()
        (0 until numberOfY).toList().map{ y ->
            scope.launch {
                val yLong = y.toLong()
                lines[y] =
                    (0 until numberOfX).joinToString(""){x ->
                        ImageProcessor.brailleAt(indexer, x.toLong(), yLong, scale.toDouble(), source.cols(), source.rows()).toString()
                    }

            }
        }.joinAll()
        val endAt = System.currentTimeMillis()
//        File("./output/image.txt").writeText(lines.values.joinToString("\n"))
//        repeat(16){
//            println(ImageProcessor.brailleAt(indexer, 0L, it.toLong(), 8))
//        }
//        indexer.s
        indexer.close()
        source.clone()

        println("${endAt - startAt}ms")


    }
}