package commands

import tools.Input
import tools.result.Result

class Exit : Command {

    private val description: String = "завершить программу (без сохранения в файл)"
    override fun action(input: Input): Result {
        val result = Result(true)

        return result
    }
    override fun getDescription(): String = description
}