package commands

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import organization.Organization
import tools.*
import java.util.*
import kotlin.collections.ArrayList

class ExecuteScript: Command, KoinComponent {

    private val absoluteWay: ArrayList<String> by inject()
    private val orgs: LinkedList<Organization> by inject()
    private val description: String = "считать и исполнить скрипт из указанного файла"
    override fun action(input: Input): Result {
        val reader = ReadFile()
        val s: String = reader.read(input).toString()

        val input = InputFile(s)

        val commandProcessor = CommandProcessor()
            commandProcessor.process(input)

        input.close()

        val result = Result(orgs, false)

        return result
    }
    override fun getDescription(): String = description
}