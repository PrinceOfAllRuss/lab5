package commands

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import organization.Organization
import tools.Input
import tools.Result
import java.util.*


class RemoveAllByEmployeesCount : Command, KoinComponent {

    private val orgs: LinkedList<Organization> by inject()

    override fun action(input: Input): Result {
        val orgsNew: LinkedList<Organization> = LinkedList<Organization>()
        val count: Int = input.getNextWord(null).toInt()
        for (org in orgs) {
            if (org.getEmployeesCount() !== count) {
                orgsNew.add(org)
            }
        }

        val result = Result(orgsNew, false)

        return result
    }
}
