package commands

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import organization.MyCollection
import organization.Organization
import tools.Input
import tools.result.Result


class FilterStartsWithName: Command, KoinComponent { //TODO исправить

    private val orgs: MyCollection<Organization> by inject()
    private val description: String = "вывести элементы, значение поля name которых начинается с заданной подстроки"
    override fun action(input: Input): Result? {
        val str: String = input.getNextWord(null)
        for (org in orgs) {
            if (org!!.getName()!!.contains(str)) {
                input.outMsg(org.toString())
            }
        }

        return null
    }
    override fun getDescription(): String = description
}