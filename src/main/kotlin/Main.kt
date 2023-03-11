
import modul.SingletonObject.mod
import tools.CommandProcessor
import tools.InputSystem
import org.koin.core.context.GlobalContext.startKoin

fun main() {

    startKoin {
        modules(mod)
    }

    var input: InputSystem = InputSystem()
    var commandProcessor: CommandProcessor = CommandProcessor()
    commandProcessor.process(input)
}