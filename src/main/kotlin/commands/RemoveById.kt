package commands

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import organization.Organization
import tools.Input
import tools.Result
import java.util.*


class RemoveById: Command, KoinComponent {

    private val orgs: LinkedList<Organization> by inject()

    override fun action(input: Input): Result
    {
        val id: Int = input.getNextWord(null).toInt()

        for (i in orgs.indices)
        {
            if (orgs[i].getId().equals(id))
            {
                orgs.removeAt(i)
                break
            }
        }

        val result = Result(orgs, false)

        return result
    }
}