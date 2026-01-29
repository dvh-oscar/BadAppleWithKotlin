package com.danvhae.oscar.console.badapple.commands

import com.github.ajalt.clikt.command.SuspendingCliktCommand

class RootCommand : SuspendingCliktCommand("BadAppleWithKotlin"){
    override suspend fun run() = Unit
}