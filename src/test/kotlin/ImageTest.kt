import com.danvhae.oscar.console.badapple.BitMaskUtil
import com.danvhae.oscar.console.badapple.BrailleUtil.toBraille
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.asCoroutineDispatcher
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
        val value = indexer[0, 0]
        println(value)
    }

    @Test
    fun imageToBraille(){
//        val source = imread()
        val scope = CoroutineScope(SupervisorJob() + Executors.newVirtualThreadPerTaskExecutor().asCoroutineDispatcher())
        val source = imread("./inputs/images/1bit.png")
        val mat = Mat()
        source.copyTo(mat)
        val indexer: UByteIndexer = mat.createIndexer()
        source.clone()





    }
}