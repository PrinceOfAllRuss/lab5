package commands

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import organization.Organization
import tools.Input
import tools.Result
import java.util.*

class Update: Command, KoinComponent {

    private val orgs: LinkedList<Organization> by inject()
    private val description: String = "обновить значение элемента коллекции, id которого равен заданному"
    override fun action(input: Input): Result? {
        val result = Result(orgs, false)

        return result
    }
    override fun getDescription(): String = description
}