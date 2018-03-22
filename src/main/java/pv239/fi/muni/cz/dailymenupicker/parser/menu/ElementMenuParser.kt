package pv239.fi.muni.cz.dailymenupicker.parser.menu

import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import pv239.fi.muni.cz.dailymenupicker.parser.Parser
import pv239.fi.muni.cz.dailymenupicker.parser.TodayMenuParser
import pv239.fi.muni.cz.dailymenupicker.parser.config.Menu
import pv239.fi.muni.cz.dailymenupicker.parser.day.getDayParser
import pv239.fi.muni.cz.dailymenupicker.parser.entity.TodayMenuEntity
import pv239.fi.muni.cz.dailymenupicker.parser.exception.AmbiguosMenuElement

/**
 * Created by mhajas on 3/17/18.
 */

class ElementMenuParser(val config: Menu, val nextParser: TodayMenuParser<Element> = getDayParser(config.dayParser)) : TodayMenuParser<Document>() {
    override fun parse(t: Document): TodayMenuEntity {
        t.run {

            val elements = getElementsByTag(config.elementName)
            if(elements.size == 1) {
                return nextParser.parse(elements.first())
            }

            val listElements = elements.filter { element -> element.attributes()

                    .filter { attribute -> attribute.key == config.elementAttribute.attributeName && attribute.value == config.elementAttribute.attributeValue

                    }.size == 1
            }

            if (listElements.size != 1) {
                throw AmbiguosMenuElement("More or zero menu elements: " + listElements)
            }
            return nextParser.parse(listElements.first())
        }
    }
}