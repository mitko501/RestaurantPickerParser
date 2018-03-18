package pv239.fi.muni.cz.dailymenupicker.parser.menu

import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import pv239.fi.muni.cz.dailymenupicker.parser.Parser
import pv239.fi.muni.cz.dailymenupicker.parser.config.Menu
import pv239.fi.muni.cz.dailymenupicker.parser.exception.AmbiguosMenuElement

/**
 * Created by mhajas on 3/17/18.
 */

class ElementMenuParser(val config: Menu) : Parser<Document, Element>() {
    override fun parseType(t: Document): Element {
        t.run {

            val elements = getElementsByTag(config.elementName)
            if(elements.size == 1) {
                return elements.first()
            }

            val listElements = elements.filter { element -> element.attributes()

                    .filter { attribute -> attribute.key == config.elementAttribute.first && attribute.value == config.elementAttribute.second

                    }.size == 1
            }

            if (listElements.size != 1) {
                throw AmbiguosMenuElement("More or zero menu elements: " + listElements)
            }
            return listElements.first()
        }
    }
}