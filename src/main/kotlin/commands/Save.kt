package commands

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import organization.MyCollection
import organization.Organization
import tools.Input
import tools.Result
import java.util.*

class Save: Command, KoinComponent {

    private val orgs: MyCollection<Organization> by inject()
    private val description: String = "сохранить коллекцию в файл"
    override fun action(input: Input): Result?
    {
        return null
    }
    override fun getDescription(): String = description
}