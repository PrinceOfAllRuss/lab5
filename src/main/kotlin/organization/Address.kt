package organization

class Address {
    private var street: String //Строка не может быть пустой, Поле не может быть null
    private var zipCode: String //Длина строки не должна быть больше 27, Поле не может быть null

    constructor(street: String, zipCode: String) {
        this.street = street
        this.zipCode = zipCode
    }
    fun getStreet(): String {
        return street
    }
    fun setStreet(street: String) {
        this.street = street
    }
    fun getZipCode(): String {
        return zipCode
    }
    fun setZipCode(zipCode: String) {
        this.zipCode = zipCode
    }
}
