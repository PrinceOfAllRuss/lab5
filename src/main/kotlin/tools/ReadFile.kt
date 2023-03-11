package tools

import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.IOException
import java.io.Reader
import java.io.InputStreamReader


class ReadFile {
    fun read(input: Input): StringBuilder {
        val env = input.getNextWord("Введите переменную окружения, содержащую путь к файлу\n")
        val path = System.getenv(env)
        val s = StringBuilder()

        try {
            var reader: Reader = InputStreamReader(FileInputStream(path), "UTF8")
            var i = -1

            while ((reader.read().also { i = it }) != -1) {
                s.append(i.toChar())
            }

            s.append("\nexit")

        } catch (e: FileNotFoundException) {
            input.outMsg("Данного файла не существует")
        } catch (e: IOException) {
            input.outMsg("Некорректный ввод данных")
        } finally {
            InputStreamReader(FileInputStream(path), "UTF8").close()
        }

        return s
    }
}