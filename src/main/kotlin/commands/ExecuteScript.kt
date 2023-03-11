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

    override fun action(input: Input): Result
    {
        val reader = ReadFile()
        val s: String = reader.read(input).toString()

        val input = InputFile(s)

        val commandProcessor = CommandProcessor()
            commandProcessor.process(input, orgs)

        input.close()

        val result = Result(orgs, false)

        return result
    }
}