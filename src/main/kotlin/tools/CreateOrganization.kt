package tools

import organization.Organization
import organization.OrganizationType


class CreateOrganization {
    fun create(input: Input): Organization {

        var name: String = "name"
        while(true) {

            name = input.getNextWord("Введите название вашей организации\n")

            if(name.isBlank()) {
                input.outMsg("Пустая строка")
            }
            else {
                break
            }
        }

        var annualTurnover = input.getNextWord("Введите годовой оборот вашей организации\n").toDouble()
//        var annualTurnoverOgr: String = "0"
//
//        try {
//            annualTurnoverOgr = input.getNextWord("Введите годовой оборот вашей организации\n")
//            if (annualTurnoverOgr.toInt() < 0) {
//                annualTurnoverOgr = "0"
//            }
//        } catch (e: NullPointerException) {
//            input.outMsg("Пустая строка")
//            annualTurnoverOgr = input.getNextWord("Введите годовой оборот вашей организации\n")
//        }
//        var annualTurnover = annualTurnoverOgr.toDouble()


        var employeesCount = input.getNextWord("Введите количество сотрудников в вашей организации\n").toInt()

//        var employeesCountOrg: String = "0"
//        try {
//            var employeesCountOrg = input.getNextWord("Введите количество сотрудников в вашей организации\n")
//            if (employeesCountOrg.toInt() < 0) {
//                var employeesCountOrg = null
//            }
//        } catch (e: NullPointerException) {
//            input.outMsg("Пустая строка")
//            val employeesCountOrg = input.getNextWord("Введите количество сотрудников в вашей организации\n")
//        }
//        val employeesCount = employeesCountOrg.toInt()

        val organization = Organization(name, annualTurnover, employeesCount)

        val coordinatesX = input.getNextWord("Введите координаты вашей организации, сначала Х, потом У\n")
        val coordinatesY = input.getNextWord(null)
        val x = coordinatesX.toInt()
        val y = coordinatesY.toLong()
        organization.setCoordinates(x, y)

        val typeStr = StringBuilder()
        typeStr.append("Выбирете тип вашей организации из данных вариантов\n")
        val organizationType = OrganizationType.values()
        for (i in organizationType.indices) {
            typeStr.append(organizationType[i].toString() + "\n")
        }

        val typeOrganization = input.getNextWord(typeStr.toString())
        val type = OrganizationType.valueOf(typeOrganization.uppercase())
        organization.setType(type)
        val address = input.getNextWord("Введите название и код улицы, на которой расположена ваша организация\n")
        val code = input.getNextWord(null)
        organization.setPostalAddress(address, code)

        return organization
    }
}
