package com.danvhae.oscar.console.badapple

import com.danvhae.oscar.console.badapple.commands.GenerateCommand
import com.danvhae.oscar.console.badapple.commands.PrintCommand
import com.danvhae.oscar.console.badapple.commands.RootCommand
import com.danvhae.oscar.console.badapple.commands.TestCommand
import com.github.ajalt.clikt.command.main
import com.github.ajalt.clikt.core.subcommands
import kotlinx.coroutines.runBlocking


object App {
    @JvmStatic
    fun main(args: Array<String>) = runBlocking {
        RootCommand()
            .subcommands(TestCommand(), GenerateCommand(), PrintCommand())
            .main(args)
    }
}