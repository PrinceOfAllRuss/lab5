package commands

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import organization.MyCollection
import organization.Organization
import tools.Input
import tools.Result


class RemoveAllByEmployeesCount : Command, KoinComponent {

    private val orgs: MyCollection<Organization> by inject()
    private val description: String = "удалить из коллекции все элементы, значение поля employeesCount которого эквивалентно заданному"
    override fun action(input: Input): Result? {
        val count: Int = input.getNextWord(null).toInt()
        for (org in orgs) {
            if (org.getEmployeesCount() !== count) {
                orgs.remove(org)
            }
        }

        return null
    }
    override fun getDescription(): String = description
}
