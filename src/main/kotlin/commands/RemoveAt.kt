package commands

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import organization.MyCollection
import organization.Organization
import tools.Input
import tools.result.Result


/**
 * Remove at
 *
 * @constructor Create empty Remove at
 */
class RemoveAt: Command, KoinComponent {

    private val orgs: MyCollection<Organization> by inject()
    private val description: String = "удалить элемент, находящийся в заданной позиции коллекции"

    /**
     * Action
     *
     * @param input
     * @return
     */
    override fun action(input: Input): Result? {
        val indexOrg: String = input.getNextWord(null)
        val index = indexOrg.toInt()
        orgs.removeAt(index)

        return null
    }

    /**
     * Get description
     *
     * @return
     */
    override fun getDescription(): String = description
}
