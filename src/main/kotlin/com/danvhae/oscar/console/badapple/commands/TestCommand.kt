package com.danvhae.oscar.console.badapple.commands

import com.github.ajalt.clikt.command.SuspendingCliktCommand
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class TestCommand : SuspendingCliktCommand("test"){
    override suspend fun run() {
        echo("Hello Clikt")
        repeat(5){
            echo(it)
            delay(1_000)
        }
        withContext(Dispatchers.IO) {
            ProcessBuilder("clear").inheritIO().start().waitFor()
        }
        echo("done")
    }
}