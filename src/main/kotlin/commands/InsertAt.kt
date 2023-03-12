package commands

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import organization.Organization
import tools.CreateOrganization
import tools.Input
import tools.Result
import java.util.*


class InsertAt: Command, KoinComponent {

    private val orgs: LinkedList<Organization> by inject()
    private val description: String = "добавить новый элемент в заданную позицию"

    override fun action(input: Input): Result? {
        val indexOrg: String = input.getNextWord(null)
        val index = indexOrg.toInt()
        val creater = CreateOrganization()
        orgs.add(index, creater.create(input, null))

        return null
    }
    override fun getDescription(): String = description
}