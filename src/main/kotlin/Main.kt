
import modul.SingletonObject.mod
import tools.CommandProcessor
import tools.InputSystem
import org.koin.core.context.GlobalContext.startKoin
import tools.ConversionXMLtoObject

fun main() {

    startKoin {
        modules(mod)
    }
    var convertor = ConversionXMLtoObject()
    var input: InputSystem = InputSystem()
    convertor.convert(input)

    var commandProcessor: CommandProcessor = CommandProcessor()
    commandProcessor.process(input)
}