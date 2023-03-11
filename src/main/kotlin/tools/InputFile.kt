package tools

import java.util.*
import java.util.LinkedList


class InputFile(s: String?) : Input {

    private var input: Scanner = Scanner(s)
    private var list: LinkedList<String> = LinkedList()
    private var index = 0

    override fun getNextWord(qw: String?): String {
        if (index < list.size) {
            return list[index++]
        }
        index = 0
        list = LinkedList()
        val words: List<String> = input.nextLine().split("\\s")
        for (str in words) {
            if (!str.isBlank()) {
                list.add(str)
            }
        }
        if (list.size < 1) {
            list.add("blank")
        }
        return list[index++]
    }

    override fun outMsg(s: String?) {
        if (s == null)
            return
        print(s)
    }

    override fun close() {
        input.close()
    }
}
