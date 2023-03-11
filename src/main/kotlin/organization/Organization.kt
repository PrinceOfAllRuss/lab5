package organization

import java.time.LocalDateTime

class Organization {
    private var id: Int //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private var name: String //Поле не может быть null, Строка не может быть пустой
    private var coordinates: Coordinates //Поле не может быть null
    private var creationDate: LocalDateTime //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private var annualTurnover: Double //Поле может быть null, Значение поля должно быть больше 0
    private var employeesCount: Int //Значение поля должно быть больше 0
    private var type: OrganizationType //Поле может быть null
    private var postalAddress: Address //Поле может быть null

    constructor(name: String, annualTurnover: Double, employeesCount: Int) {
        this.id = Math.round(Math.random() * 10000).toInt()
        this.name = name
        val coordinates = Coordinates(0, 0L)
        this.coordinates = coordinates
        creationDate = LocalDateTime.now()
        this.annualTurnover = annualTurnover
        this.employeesCount = employeesCount
        type = OrganizationType.PUBLIC
        val postalAddress = Address(name, name)
        this.postalAddress = postalAddress
        this.id = id
    }

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
    fun getEmployeesCount(): Int = employeesCount
    fun getCoordinates(): String {
        var s = "(" + coordinates.getX() + ";" + coordinates.getY() + ")"
        return s
    }
    fun setCoordinates(x: Int, y: Long) {
        coordinates.setX(x)
        coordinates.setY(y)
    }
    fun getPostalAddress(): String {
        return postalAddress.getStreet() + " " + postalAddress.getZipCode()
    }
    fun setPostalAddress(street: String, zipCode: String) {
        postalAddress.setStreet(street)
        postalAddress.setZipCode(zipCode)
    }
    fun setType(type: OrganizationType) {
        this.type = type
    }
    fun getAnnualTurnover(): Double = annualTurnover
    fun getName(): String = name
    fun getId(): Int = id
}