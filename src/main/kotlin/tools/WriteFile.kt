package tools

import tools.result.Result
import java.io.BufferedWriter
import java.io.FileWriter
import java.io.IOException

class WriteFile {
    fun write(input: Input, s: String): Result? {
        val env = input.getNextWord(null)

        val path = System.getenv(env)
        if (path == null) {
            input.outMsg("Данной переменной не существует\n")
            return null
        }

        val writter: BufferedWriter = BufferedWriter( FileWriter(path) )
        try {
            writter.write(s)
        } catch (e: IOException) {
            input.outMsg("Отказано в доступе\n")
        } finally {
            if ( writter != null ) {
                writter.close()
            }
        }


        return null
    }
}

