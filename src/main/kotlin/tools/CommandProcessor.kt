package tools

import commands.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import tools.result.Result

class CommandProcessor: KoinComponent {

    private val map: Map<String, Command> by inject()
    fun process(input: Input) {

        var result: Result? = Result(false)

        while ( true ) {
            var command: String = input.getNextWord(null).lowercase()

            if ( !map.keys.contains(command) ) {
                input.outMsg("Такой команды не существует\n")
            }
            else {
                try {
                    result = map.get(command)!!.action(input)
                } catch ( e: NumberFormatException ) {
                    input.outMsg("Неверные данные\n")
                    if ( input.javaClass == InputFile("").javaClass ) {
                        continue
                    }
                }
            }

            if (result?.getExit() == true) {
                break
            }
        }

    }
}