package commands

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import organization.Organization
import tools.Input
import tools.Result
import java.util.*


class RemoveAt: Command, KoinComponent {

    private val orgs: LinkedList<Organization> by inject()
    private val description: String = "удалить элемент, находящийся в заданной позиции коллекции"
    override fun action(input: Input): Result {
        val indexOrg: String = input.getNextWord(null)
        val index = indexOrg.toInt()
        orgs.removeAt(index)

        val result = Result(orgs, false)

        return result
    }
    override fun getDescription(): String = description
}
