package com.danvhae.oscar.console.badapple.processors

import org.bytedeco.javacpp.indexer.UByteIndexer
import org.bytedeco.javacv.FFmpegFrameGrabber
import org.bytedeco.javacv.OpenCVFrameConverter

object VideoProcessor {
    fun FFmpegFrameGrabber.nextFrameToBraille(
        scale: Double
    ): String{
        return OpenCVFrameConverter.ToMat().use { converter ->
            val frame = grabImage() ?: throw NoSuchElementException("no more frame")
            val mat = converter.convert(frame)
            mat.createIndexer<UByteIndexer>().use { indexer ->
                ImageProcessor.process(indexer, scale, imageWidth, imageHeight)
            }
        }
    }
}