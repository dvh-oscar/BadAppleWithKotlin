package com.danvhae.oscar.console.badapple

import com.danvhae.oscar.console.badapple.commands.Root
import com.danvhae.oscar.console.badapple.commands.GenerateCommand
import com.danvhae.oscar.console.badapple.commands.TestCommand
import com.github.ajalt.clikt.core.main
import com.github.ajalt.clikt.core.subcommands


object App {
    private const val COMMAND_PREFIX = "java -jar BadAppleWithKotlin.jar"
    @JvmStatic
    fun main(args: Array<String>) = Root()
        .subcommands(GenerateCommand(), TestCommand())
        .main(args)
}