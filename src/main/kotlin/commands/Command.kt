package commands

import tools.Input
import tools.result.Result

interface Command {
    fun action(input: Input): Result?
    fun getDescription(): String
}