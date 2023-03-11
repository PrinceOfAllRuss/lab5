package modul

import org.koin.dsl.module
import organization.Organization
import java.util.*
import kotlin.collections.ArrayList

object SingletonObject {

    val mod = module {
        single<LinkedList<Organization>> { LinkedList() }
        single<ArrayList<String>> { ArrayList() }
    }
}