package com.danvhae.oscar.console.badapple.commands

import com.danvhae.oscar.console.badapple.processors.VideoProcessor.nextFrameToBraille
import com.github.ajalt.clikt.command.SuspendingCliktCommand
import com.github.ajalt.clikt.core.Context
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.types.double
import com.github.ajalt.clikt.parameters.types.file
import com.github.ajalt.clikt.parameters.types.int
import com.github.ajalt.clikt.parameters.types.path
import org.bytedeco.javacv.FFmpegFrameGrabber
import java.nio.file.Paths
import kotlin.io.path.exists

class GenerateCommand : SuspendingCliktCommand("generate"){
    val videoFile by argument().file()
    val output by argument().path(false)
    val scale by argument().double()

    override fun help(context: Context): String {
        return "generate frames from video"
    }
    override suspend fun run() {
        val grabber = FFmpegFrameGrabber(videoFile)
        grabber.start()

        if(!output.exists()) output.toFile().mkdirs()
        var frameNumber = 0
        while(true){
            frameNumber++
            val frame = runCatching {grabber.nextFrameToBraille(scale)}.getOrNull() ?: break
            val path = Paths.get(output.toString(), "${frameNumber.toString().padStart(7, '0')}.txt")
            path.toFile().writeText(frame)
        }

    }

}