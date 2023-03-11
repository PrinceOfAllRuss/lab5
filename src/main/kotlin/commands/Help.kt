package commands

import organization.Organization
import tools.Input
import tools.Result
import java.util.*

class Help : Command {
    override fun action(input: Input): Result? {
        input.outMsg(
            "help : вывести справку по доступным командам\n" +
                    "info : вывести информацию о коллекции\n" +
                    "show : вывести все элементы коллекции\n" +
                    "add {element} : добавить новый элемент в коллекцию\n" +
                    "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                    "remove_by_id id : удалить элемент из коллекции по его id\n" +
                    "clear : очистить коллекцию\n" +
                    "save : сохранить коллекцию в файл\n" +
                    "execute_script file_name : считать и исполнить скрипт из указанного файла\n" +
                    "exit : завершить программу (без сохранения в файл)\n" +
                    "insert_at index : добавить новый элемент в заданную позицию\n" +
                    "remove_at index : удалить элемент, находящийся в заданной позиции коллекции\n" +
                    "remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный\n" +
                    "remove_all_by_employees_count employeesCount : удалить из коллекции все элементы, значение поля employeesCount которого эквивалентно заданному\n" +
                    "count_greater_than_annual_turnover annualTurnover : вывести количество элементов, значение поля annualTurnover которых больше заданного\n" +
                    "filter_starts_with_name name : вывести элементы, значение поля name которых начинается с заданной подстроки\n"
        )

        return null
    }
}