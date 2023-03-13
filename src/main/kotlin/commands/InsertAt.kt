package commands

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import organization.MyCollection
import organization.Organization
import tools.CreateOrganization
import tools.Input
import tools.Result
import java.util.*


class InsertAt: Command, KoinComponent {

    private val orgs: MyCollection<Organization> by inject()
    private val description: String = "добавить новый элемент в заданную позицию"

    override fun action(input: Input): Result? {
        val indexOrg: String = input.getNextWord(null)
        val index = indexOrg.toInt()
        val creator = CreateOrganization()
        orgs.add(index, creator.create(input, null))

        return null
    }
    override fun getDescription(): String = description
}