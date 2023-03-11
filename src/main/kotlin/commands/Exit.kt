package commands

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import organization.Organization
import tools.Input
import tools.Result
import java.util.*

class Exit : Command, KoinComponent {

    private val orgs: LinkedList<Organization> by inject()
    private val description: String = "завершить программу (без сохранения в файл)"
    override fun action(input: Input): Result {
        val result = Result(orgs, true)

        return result
    }
    override fun getDescription(): String = description
}