package commands

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import tools.Input
import tools.Result

class Help : Command, KoinComponent {

    private val description: String = "вывести справку по доступным командам"
    private val map: Map<String, Command> by inject()
    override fun action(input: Input): Result? {

        for( key in map.keys ) {
            input.outMsg(key + " : " + map.get(key)!!.getDescription() + "\n")
        }

        return null
    }
    override fun getDescription(): String = description
}