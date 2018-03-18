package pv239.fi.muni.cz.dailymenupicker.parser.menu

import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import pv239.fi.muni.cz.dailymenupicker.parser.Parser
import pv239.fi.muni.cz.dailymenupicker.parser.config.Menu

/**
 * Created by mhajas on 3/18/18.
 */
fun getMenuParser(config: Menu): Parser<Document, Element>? {
    return when (config.menuParserType) {
        "ElementMenuParser" -> ElementMenuParser(config)
        else -> null
    }
}