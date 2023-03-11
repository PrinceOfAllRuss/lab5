package organization

class Coordinates {
    private var x: Int //Значение поля должно быть больше -312, Поле не может быть null
    private var y: Long//Максимальное значение поля: 212
    constructor(x: Int, y: Long) {
        this.x = x
        this.y = y
    }
    fun getX(): Int {
        return x
    }
    fun getY(): Long {
        return y
    }
    fun setX(x: Int) {
        this.x = x
    }
    fun setY(y: Long) {
        this.y = y
    }
}