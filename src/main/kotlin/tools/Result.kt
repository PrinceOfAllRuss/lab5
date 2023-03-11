package tools

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

class Result { //TODO dataclass
    private var orgs: LinkedList<Organization>?
    private var exit: Boolean?

    constructor(orgs: LinkedList<Organization>?, exit: Boolean?) {
        this.orgs = orgs
        this.exit = exit
    }

    fun getOrgs(): LinkedList<Organization>? {
        return orgs
    }

    fun getExit(): Boolean? {
        return exit
    }
}