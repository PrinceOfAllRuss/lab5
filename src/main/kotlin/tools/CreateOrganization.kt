package tools

import organization.Organization
import organization.OrganizationType


class CreateOrganization {
    fun create(input: Input): Organization {

        var name: String = "name"
        while(true) {

            name = input.getNextWord("Введите название вашей организации\n")

            if(name.isBlank()) {
                input.outMsg("Неподходящие данные\n")
            }
            else {
                break
            }
        }

        var annualTurnoverOrg: String = "0"
        while(true) {
            try {
                annualTurnoverOrg = input.getNextWord("Введите годовой оборот вашей организации\n")

                if(annualTurnoverOrg.isBlank() || annualTurnoverOrg.toInt() <= 0) {
                    input.outMsg("Неподходящие данные\n")
                }
                else {
                    break
                }
            } catch (e: NumberFormatException) {
                input.outMsg("Неверный тип данных\n")
            }
        }
        var annualTurnover = annualTurnoverOrg.toDouble()

        var employeesCountOrg: String = "0"
        while(true) {
            try {
                employeesCountOrg = input.getNextWord("Введите количество сотрудников в вашей организации\n")

                if (employeesCountOrg.isBlank() || employeesCountOrg.toInt() <= 0) {
                    input.outMsg("Неподходящие данные\n")
                }
                else {
                    break
                }
            } catch (e: NumberFormatException) {
                input.outMsg("Неверный тип данных\n")
            }
        }

        var employeesCount = employeesCountOrg.toInt()

        val organization = Organization(name, annualTurnover, employeesCount)

        var coordinatesX: String = "0"
        var coordinatesY: String = "0"
        while(true) {
            try {
                coordinatesX = input.getNextWord("Введите координаты вашей организации по оси X\n")

                if (coordinatesX.isBlank() || coordinatesX.toInt() <= -312) {
                    input.outMsg("Неподходящие данные\n")
                }
                else {
                    break
                }
            } catch (e: NumberFormatException) {
                input.outMsg("Неверный тип данных\n")
            }
        }
        while(true) {
            try {
                coordinatesY = input.getNextWord("Введите координаты вашей организации по оси Y\n")

                if (coordinatesY.isBlank() || coordinatesY.toInt() > 212) {
                    input.outMsg("Неподходящие данные\n")
                }
                else {
                    break
                }
            } catch (e: NumberFormatException) {
                input.outMsg("Неверный тип данных\n")
            }
        }
        val x = coordinatesX.toInt()
        val y = coordinatesY.toLong()
        organization.setCoordinates(x, y)

        val typeStr = StringBuilder()
        typeStr.append("Выбирете тип вашей организации из данных вариантов\n")
        val organizationType = OrganizationType.values()
        for (i in organizationType.indices) {
            typeStr.append(organizationType[i].toString() + "\n")
        }

        while(true) {
            try {
                val typeOrganization = input.getNextWord(typeStr.toString())
                val type = OrganizationType.valueOf(typeOrganization.uppercase())
                organization.setType(type)
                break
            } catch (e: IllegalArgumentException) {
                input.outMsg("Неподходящие данные\n")
            }
        }

        var address: String = "name"
        var code: String = "007"
        while(true) {
            address = input.getNextWord("Введите название улицы, на которой расположена ваша организация\n")
            if(address.isBlank()) {
                input.outMsg("Неподходящие данные\n")
            }
            else {
                break
            }
        }
        while(true) {
            code = input.getNextWord("Введите код улицы, на которой расположена ваша организация\n")
            if(code.isBlank() || code.length > 27) {
                input.outMsg("Неподходящие данные\n")
            }
            else {
                break
            }
        }
        organization.setPostalAddress(address, code)

        return organization
    }
}
