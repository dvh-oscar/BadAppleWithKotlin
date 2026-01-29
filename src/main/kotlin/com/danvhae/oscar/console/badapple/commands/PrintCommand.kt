package com.danvhae.oscar.console.badapple.commands

import com.github.ajalt.clikt.command.SuspendingCliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.types.double
import com.github.ajalt.clikt.parameters.types.int
import com.github.ajalt.clikt.parameters.types.path
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class PrintCommand : SuspendingCliktCommand("print"){
    val frames by argument().path(true)
    val fps by argument().double()
    val clearCommand by argument()

    override suspend fun run() {
        val milliBetweenFrames = (1000 / fps).toLong()
        frames.toFile().listFiles{file -> file.name.endsWith(".txt")}.sorted().forEach{file ->
            val before = System.currentTimeMillis()
//            Runtime.getRuntime().exec(arrayOf(clearCommand))
            withContext(Dispatchers.IO) {
                ProcessBuilder("clear").inheritIO().start().waitFor()
            }
            echo(file.readText())
//            delay(milliBetweenFrames  - System.currentTimeMillis() + before)
//            echo(milliBetweenFrames - System.currentTimeMillis() + before)
//            return
            delay((milliBetweenFrames - System.currentTimeMillis() + before).coerceIn(0, milliBetweenFrames))
        }
    }
}