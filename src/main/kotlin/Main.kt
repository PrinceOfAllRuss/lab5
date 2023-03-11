import modul.SingletonObject.mod
import organization.Organization
import tools.CommandProcessor
import tools.InputSystem
import java.util.LinkedList
import org.koin.core.context.GlobalContext.startKoin

fun main() {

    startKoin {
        modules(mod)
    }

    var orgs: LinkedList<Organization> = LinkedList()
    var input: InputSystem = InputSystem()
    var commandProcessor: CommandProcessor = CommandProcessor()
    commandProcessor.process(input, orgs)
}