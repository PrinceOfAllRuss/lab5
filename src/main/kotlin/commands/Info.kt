package commands

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import organization.MyCollection
import organization.Organization
import tools.Input
import tools.result.Result

/**
 * Info
 *
 * @constructor Create empty Info
 */
class Info : Command, KoinComponent {

    private val orgs: MyCollection<Organization> by inject()
    private val description: String = "вывести информацию о коллекции"

    /**
     * Action
     *
     * @param input
     * @return
     */
    override fun action(input: Input): Result? {
        input.outMsg( "Тип коллекции " + orgs.javaClass.toString() + "\n" )
        input.outMsg( "Дата инициализации " + orgs.getCreationDate() + "\n" )
        input.outMsg( "Количество элементов " + orgs.size + "\n" )
        return null
    }

    /**
     * Get description
     *
     * @return
     */
    override fun getDescription(): String = description
}