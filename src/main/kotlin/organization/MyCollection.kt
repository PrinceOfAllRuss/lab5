package organization

import java.time.LocalDateTime
import java.util.LinkedList

class MyCollection<T>: LinkedList<T>() {
    private val creationDate : LocalDateTime? = LocalDateTime.now()
    fun getCreationDate(): LocalDateTime? = creationDate

}