package commands

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import organization.MyCollection
import organization.Organization
import tools.Input
import tools.result.Result


/**
 * Remove lower
 *
 * @constructor Create empty Remove lower
 */
class RemoveLower: Command, KoinComponent {

    private val orgs: MyCollection<Organization> by inject()
    private val description: String = "удалить из коллекции все элементы, меньшие, чем заданный"

    /**
     * Action
     *
     * @param input
     * @return
     */
    override fun action(input: Input): Result? {
        val count: Int = input.getNextWord(null).toInt()
        for ( org in orgs ) {
            if ( org.getEmployeesCount()!! >= count ) {
                orgs.remove( org )
            }
        }

        return null
    }

    /**
     * Get description
     *
     * @return
     */
    override fun getDescription(): String = description
}