package commands

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import tools.*
import kotlin.collections.ArrayList

class ExecuteScript: Command, KoinComponent {

    private val absoluteWay: ArrayList<String> by inject()
    private val description: String = "считать и исполнить скрипт из указанного файла"
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
    override fun getDescription(): String = description
}