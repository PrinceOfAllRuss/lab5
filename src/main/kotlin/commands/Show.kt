package commands

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import organization.MyCollection
import organization.Organization
import tools.Input
import tools.Result
import java.util.*


class Show: Command, KoinComponent {

    private val orgs: MyCollection<Organization> by inject()
    private val description: String = "вывести все элементы коллекции"
    override fun action(input: Input): Result? {
        for (org in orgs) {
            input.outMsg(org.toString())
        }

        return null
    }
    override fun getDescription(): String = description
}