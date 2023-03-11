package tools

import commands.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import organization.Organization
import java.util.*

class CommandProcessor: KoinComponent {

    private val orgs: LinkedList<Organization> by inject()
    private val map: Map<String, Command> by inject()
    fun process(input: Input) {

        var condition: Boolean = true
        var exitCondition = false
        var result: Result? = Result(orgs, exitCondition)

        while (condition)
        {
            var command: String = input.getNextWord(null).lowercase()
            if (!map.keys.contains(command))
            {
                input.outMsg("Такой команды не существует\n")
            }
            else
            {
                result = map.get(command)!!.action(input)
            }

            if (result?.getExit() == true)
            {
                break
            }
        }

    }
}