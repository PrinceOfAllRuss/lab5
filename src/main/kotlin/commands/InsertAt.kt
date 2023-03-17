package commands

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import organization.MyCollection
import organization.Organization
import tools.CreateOrganization
import tools.Input
import tools.result.Result


/**
 * Insert at
 *
 * @constructor Create empty Insert at
 */
class InsertAt: Command, KoinComponent {

    private val orgs: MyCollection<Organization> by inject()
    private val description: String = "добавить новый элемент в заданную позицию"

    /**
     * Action
     *
     * @param input
     * @return
     */
    override fun action(input: Input): Result? {
        val indexOrg: String = input.getNextWord(null)
        val index = indexOrg.toInt()
        val creator = CreateOrganization()
        val org = creator.create(input, null)
        if ( org != null ) {
            orgs.add(index, org)
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