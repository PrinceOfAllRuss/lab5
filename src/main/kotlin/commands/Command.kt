package commands

import tools.Input
import tools.result.Result

/**
 * Command
 *
 * @constructor Create empty Command
 */
interface Command {
    /**
     * Action
     *
     * @param input
     * @return
     */
    fun action(input: Input): Result?

    /**
     * Get description
     *
     * @return
     */
    fun getDescription(): String
}