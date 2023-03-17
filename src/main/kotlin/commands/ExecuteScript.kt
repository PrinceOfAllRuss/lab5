package commands

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import tools.*
import tools.result.Result
import kotlin.collections.ArrayList

/**
 * Execute script
 *
 * @constructor Create empty Execute script
 */
class ExecuteScript: Command, KoinComponent {

    private val absoluteWay: ArrayList<String> by inject()
    private val description: String = "считать и исполнить скрипт из указанного файла"

    /**
     * Action
     *
     * @param input
     * @return
     */
    override fun action(input: Input): Result? {
        val reader = ReadFile()
        val s: String? = reader.read(input)

        if (s == null) {
            return null
        }

        val input = InputFile(s)

        val commandProcessor = CommandProcessor()
            commandProcessor.process(input)

        input.close()

        absoluteWay.removeLast()

        return null
    }

    /**
     * Get description
     *
     * @return
     */
    override fun getDescription(): String = description
}