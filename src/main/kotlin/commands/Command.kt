package commands

import tools.Input
import tools.Result

interface Command {
    fun action(input: Input): Result?
    fun getDescription(): String
}