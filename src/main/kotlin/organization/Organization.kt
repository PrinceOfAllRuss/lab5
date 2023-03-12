package organization

import commands.CountGreaterThanAnnualTurnover
import commands.RemoveAllByEmployeesCount
import java.time.LocalDateTime
import java.util.*

class Organization {
    private var id: Int? = Math.round(Math.random() * 10000).toInt() //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private var name: String? = null //Поле не может быть null, Строка не может быть пустой
    private var coordinates: Coordinates? = Coordinates(0, 0L) //Поле не может быть null
    private var creationDate: LocalDateTime? = LocalDateTime.now() //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private var annualTurnover: Double? = null //Поле может быть null, Значение поля должно быть больше 0
    private var employeesCount: Int? = null //Значение поля должно быть больше 0
    private var type: OrganizationType? = null //Поле может быть null
    private var postalAddress: Address? = Address("", "")//Поле может быть null

//    constructor() {
//        id = UUID.randomUUID().toString().toInt()
//        name = null
//
//    }
//    constructor(name: String, annualTurnover: Double, employeesCount: Int) {
//        this.id = Math.round(Math.random() * 10000).toInt()
//        this.name = name
//        val coordinates = Coordinates(0, 0L)
//        this.coordinates = coordinates
//        creationDate = LocalDateTime.now()
//        this.annualTurnover = annualTurnover
//        this.employeesCount = employeesCount
//        type = OrganizationType.PUBLIC
//        val postalAddress = Address(name, name)
//        this.postalAddress = postalAddress
//        this.id = id
//    }

    override fun toString(): String {
        val s = StringBuilder()
        s.append("Id организации: ").append(id)
        s.append("\nИмя организации: ").append(name)
        s.append("\nКоординаты организации: ").append(getCoordinates())
        s.append("\nВремя создания организации: ").append(creationDate)
        s.append("\nГодовой оборот организации: ").append(annualTurnover)
        s.append("\nКоличество сотрудников в организации: ").append(employeesCount)
        s.append("\nТип организации: ").append(type)
        s.append("\nНазвание и код улицы, на которой расположена организация: ").append(getPostalAddress()).append("\n")
        return s.toString()
    }
    fun getEmployeesCount(): Int? = employeesCount
    fun setEmployeesCount(employeesCount: Int) {
        this.employeesCount = employeesCount
    }
    fun getCoordinates(): String? {
        var s = "(" + coordinates!!.getX() + ";" + coordinates!!.getY() + ")"
        return s
    }
    fun getCoordinatesX(): String? {
        return coordinates!!.getX().toString()
    }
    fun getCoordinatesY(): String? {
        return coordinates!!.getY().toString()
    }
    fun setCoordinatesX(x: Int) {
        coordinates!!.setX(x)
    }
    fun setCoordinatesY(y: Long) {
        coordinates!!.setY(y)
    }
    fun getPostalAddress(): String {
        return postalAddress!!.getStreet() + " " + postalAddress!!.getZipCode()
    }
    fun getPostalAddressStreet(): String = postalAddress!!.getStreet()
    fun getPostalAddressZipCode(): String = postalAddress!!.getZipCode()
    fun setPostalAddressStreet(street: String) {
        postalAddress!!.setStreet(street)
    }
    fun setPostalAddressZipCode(zipCode: String) {
        postalAddress!!.setZipCode(zipCode)
    }
    fun getType(): String? = type.toString()
    fun setType(type: OrganizationType) {
        this.type = type
    }
    fun getAnnualTurnover(): Double? = annualTurnover
    fun setAnnualTurnover(annualTurnover: Double) {
        this.annualTurnover = annualTurnover
    }
    fun getName(): String? = name
    fun setName(name: String) {
        this.name = name
    }
    fun getId(): Int? = id
}