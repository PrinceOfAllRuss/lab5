package tools

import commands.*
import organization.Organization
import java.util.*

class CommandProcessor
{
    fun process(input: Input, orgs: LinkedList<Organization>) {

        var condition: Boolean = true
        var exitCondition = false
        var result: Result? = Result(orgs, exitCondition)

        val help: Help = Help()
        val info: Info = Info()
        val show: Show = Show()
        val add: Add = Add()
        val update: Update = Update()
        val remove_by_id: RemoveById = RemoveById()
        val clear: Clear = Clear()
        val save: Save = Save()
        val execute_script: ExecuteScript = ExecuteScript()
        val exit: Exit = Exit()
        val insert_at: InsertAt = InsertAt()
        val remove_at: RemoveAt = RemoveAt()
        val remove_lower: RemoveLower = RemoveLower()
        val remove_all_by_employees_count: RemoveAllByEmployeesCount = RemoveAllByEmployeesCount()
        val count_greater_than_annual_turnover: CountGreaterThanAnnualTurnover = CountGreaterThanAnnualTurnover()
        val filter_starts_with_name: FilterStartsWithName = FilterStartsWithName()

        var map: Map<String, Command> = mapOf("help" to help, "info" to info, "show" to show, "add" to add,
            "update" to update, "remove_by_id" to remove_by_id, "clear" to clear, "save" to save,
            "execute_script" to execute_script, "exit" to exit, "insert_at" to insert_at, "remove_at" to remove_at,
            "remove_lower" to remove_lower, "remove_all_by_employees_count" to remove_all_by_employees_count,
            "count_greater_than_annual_turnover" to count_greater_than_annual_turnover,
            "filter_starts_with_name" to filter_starts_with_name)

        while (condition)
        {
            var command: String = input.getNextWord(null).lowercase()
            if (!map.keys.contains(command))
            {
                input.outMsg("Такой команды не существует\n")
            }
            else
            {
                result = map.get(command)!!.action(input)
            }

            if (result?.getExit() == true)
            {
                break
            }
        }

    }
}