package tools

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import organization.MyCollection
import organization.Organization
import java.util.LinkedList


enum class CommandResult{
    SUCCESS,
    FAIL,
}
data class NewResult(
    val message: String,
    val status: CommandResult,
)

class Result: KoinComponent { //TODO dataclass
    private val orgs: MyCollection<Organization> by inject()
    private var exit: Boolean?

    constructor(exit: Boolean?) {
        this.exit = exit
    }

    fun getOrgs(): LinkedList<Organization>? {
        return orgs
    }

    fun getExit(): Boolean? {
        return exit
    }
}