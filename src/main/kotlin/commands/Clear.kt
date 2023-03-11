package commands

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import organization.Organization
import tools.Input
import tools.Result
import java.util.*

class Clear: Command, KoinComponent {

    private val orgs: LinkedList<Organization> by inject()

    override fun action(input: Input): Result
    {
        orgs.clear()
        val result = Result(orgs, false)

        return result
    }
}