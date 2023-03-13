package commands

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import organization.MyCollection
import organization.Organization
import organization.OrganizationComparator
import tools.CreateOrganization
import tools.Input
import tools.result.Result

class Add : Command, KoinComponent {

    private val orgs: MyCollection<Organization> by inject()
    private val description: String = "добавить новый элемент в коллекцию"

    override fun action(input: Input): Result? {
        val orgComp = OrganizationComparator()
        val creator = CreateOrganization()
        orgs.add(creator.create(input, null))
        orgs.sortWith(orgComp)

        return null
    }
    override fun getDescription(): String = description
}

