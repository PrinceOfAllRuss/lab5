package commands

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import organization.Organization
import tools.Input
import tools.Result
import java.util.*

class Info : Command, KoinComponent {

    private val orgs: LinkedList<Organization> by inject()

    override fun action(input: Input): Result? {
        input.outMsg("Тип коллекции " + orgs.javaClass.toString())
        return null
    }
}