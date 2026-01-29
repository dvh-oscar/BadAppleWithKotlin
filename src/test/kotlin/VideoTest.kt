import com.danvhae.oscar.console.badapple.processors.VideoProcessor.nextFrameToBraille
import kotlinx.coroutines.runBlocking
import org.bytedeco.javacv.FFmpegFrameGrabber
import org.junit.jupiter.api.Test
import java.io.File

object VideoTest {
    @Test
    fun loadVideoFrame() = runBlocking{
        println("start...")
        val grabber = FFmpegFrameGrabber("./inputs/videos/origin.webm")
        grabber.start()

//        grabber.fr
//        val converter = OpenCVFrameConverter.ToMat()

        val scale = 16
        val numberOfX = grabber.imageWidth / (scale * 2)
        val numberOfY = grabber.imageHeight / (scale * 4)

        val start = System.currentTimeMillis()
        while(true){
//            println("\n".repeat(numberOfY))
            val converted = runCatching { grabber.nextFrameToBraille(numberOfX, numberOfY, scale) }.getOrNull() ?: break
//            println(converted)
//            delay(25)
        }
        val end = System.currentTimeMillis()
        grabber.close()
        println("Elapsed: ${end - start}ms")
    }

    @Test
    fun generateFrameTextFiles() = runBlocking{
        println("start...")
        val grabber = FFmpegFrameGrabber("./inputs/videos/origin.webm")
        grabber.start()

        val scale = 16
        val numberOfX = grabber.imageWidth / (scale * 2)
        val numberOfY = grabber.imageHeight / (scale * 4)

        var count = 0
        while(true){
            val converted = runCatching { grabber.nextFrameToBraille(numberOfX, numberOfY, scale) }.getOrNull() ?: break
            File("./output/frames/${count.toString().padStart(5, '0')}.txt").writeText(converted)
            count++
        }
    }

    @Test
    fun readFromGeneratedFrames(){
        print("start...")
        File("./output/frames").listFiles { file -> file.name.endsWith(".txt") }.sorted().map { file ->
            val frame = file.readText()
        }
    }
}