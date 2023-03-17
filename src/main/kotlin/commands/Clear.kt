package commands

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import organization.MyCollection
import organization.Organization
import tools.Input
import tools.result.Result

/**
 * Clear
 *
 * @constructor Create empty Clear
 */
class Clear: Command, KoinComponent {

    private val orgs: MyCollection<Organization> by inject()
    private val description: String = "очистить коллекцию"

    /**
     * Action
     *
     * @param input
     * @return
     */
    override fun action(input: Input): Result? {
        orgs.clear()
        return null
    }
    override fun getDescription(): String = description
}