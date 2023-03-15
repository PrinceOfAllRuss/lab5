package commands


import com.thoughtworks.xstream.XStream
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import organization.MyCollection
import organization.Organization
import tools.Input
import tools.WriteFile
import tools.result.Result

class Save: Command, KoinComponent {

    private val orgs: MyCollection<Organization> by inject()
    private val description: String = "сохранить коллекцию в файл"
    override fun action(input: Input): Result? {

        val xml: XStream = XStream()
        var orgsXML: StringBuilder = StringBuilder()
        var i: Int = 0
        var time: String
        var list: List<String>
        var creationDate: StringBuilder = StringBuilder()

        for ( org in orgs ) {
            xml.alias("organization_" + i, org.javaClass)
            orgsXML.append( xml.toXML(org) + "\n")
            ++i
        }

        var collectionXML: StringBuilder = StringBuilder()
        collectionXML.append("<Collection>\n")
        collectionXML.append("\t<dateOfCreation>" + orgs.getCreationDate() + "</dateOfCreation>\n")
        collectionXML.append("</Collection>\n")

        val writer: WriteFile = WriteFile()
        input.outMsg("Введите переменную окружения, содержащую путь к файлу, для записи данных коллекции\n")
        writer.write(input, collectionXML.toString())
        input.outMsg("Введите переменную окружения, содержащую путь к файлу, для записи содержимого коллекции коллекции\n")
        writer.write(input, orgsXML.toString())

        return null
    }
    override fun getDescription(): String = description
}