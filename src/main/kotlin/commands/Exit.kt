package commands

import tools.Input
import tools.result.Result

/**
 * Exit
 *
 * @constructor Create empty Exit
 */
class Exit : Command {

    private val description: String = "завершить программу (без сохранения в файл)"

    /**
     * Action
     *
     * @param input
     * @return
     */
    override fun action(input: Input): Result {
        val result = Result(true)

        return result
    }

    /**
     * Get description
     *
     * @return
     */
    override fun getDescription(): String = description
}