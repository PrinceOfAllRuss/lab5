package commands

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import organization.Organization
import organization.OrganizationComparator
import tools.CreateOrganization
import tools.Input
import tools.Result
import java.util.LinkedList

class Add : Command, KoinComponent {

    private val orgs: LinkedList<Organization> by inject()
    private val description: String = "добавить новый элемент в коллекцию"

    override fun action(input: Input): Result {
        val orgComp = OrganizationComparator()
        val creater = CreateOrganization()
        orgs.add(creater.create(input, null))
        orgs.sortWith(orgComp)

        return Result(orgs, false)
    }
    override fun getDescription(): String = description
}

