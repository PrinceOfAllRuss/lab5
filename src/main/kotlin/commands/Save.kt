package commands


import com.thoughtworks.xstream.XStream
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import organization.MyCollection
import organization.Organization
import tools.Input
import tools.WriteFile
import tools.result.Result
import kotlin.text.StringBuilder

class Save: Command, KoinComponent {

    private val orgs: MyCollection<Organization> by inject()
    private val description: String = "сохранить коллекцию в файл"
    override fun action(input: Input): Result?
    {

        val xs: XStream = XStream()
        var orgsXML: StringBuilder = StringBuilder()
        var i: Int = 0

        for ( org in orgs ) {
            xs.alias("organization_" + i, org.javaClass)
            orgsXML.append( xs.toXML(org) + "\n")
            ++i
        }

//        input.outMsg(orgsXML.toString())

        var collectionXML: StringBuilder = StringBuilder()
        collectionXML.append("<Collection>\n")
        collectionXML.append("\t<creationDate>" + orgs.getCreationDate() + "</creationDate>\n")
        collectionXML.append("</Collection>\n")
//        input.outMsg(collectionXML.toString())

        val writer: WriteFile = WriteFile()
        input.outMsg("Введите переменную окружения, содержащую путь к файлу, для записи данных коллекции\n")
        writer.write(input, collectionXML.toString())
        input.outMsg("Введите переменную окружения, содержащую путь к файлу, для записи содержимого коллекции коллекции\n")
        writer.write(input, orgsXML.toString())

        return null
    }
    override fun getDescription(): String = description
}