package com.danvhae.oscar.console.badapple.commands

import com.github.ajalt.clikt.core.CliktCommand

class TestCommand : CliktCommand("test"){
    override fun run() {
        echo("Hello Clikt")
    }
}