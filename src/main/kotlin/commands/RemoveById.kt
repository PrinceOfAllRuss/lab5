package commands

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import organization.MyCollection
import organization.Organization
import tools.Input
import tools.result.Result


/**
 * Remove by id
 *
 * @constructor Create empty Remove by id
 */
class RemoveById: Command, KoinComponent {

    private val orgs: MyCollection<Organization> by inject()
    private val description: String = "удалить элемент из коллекции по его id"

    /**
     * Action
     *
     * @param input
     * @return
     */
    override fun action(input: Input): Result? {
        val id: Int = input.getNextWord(null).toInt()

        for ( org in orgs ) {
            if ( org.getId() == id ) {
                orgs.remove( org )
                break
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