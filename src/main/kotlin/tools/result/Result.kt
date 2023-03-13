package tools.result

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import organization.MyCollection
import organization.Organization


//enum class CommandResult{
//    SUCCESS,
//    FAIL,
//}
//data class NewResult(
//    val message: String,
//    val status: CommandResult,
//)

class Result: KoinComponent {
    private val orgs: MyCollection<Organization> by inject()
    private var exit: Boolean?

    constructor(exit: Boolean?) {
        this.exit = exit
    }

    fun getExit(): Boolean? {
        return exit
    }
}