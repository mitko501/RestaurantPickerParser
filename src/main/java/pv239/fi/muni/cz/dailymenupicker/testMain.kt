package pv239.fi.muni.cz.dailymenupicker

import org.jsoup.Jsoup
import org.xml.sax.InputSource
import pv239.fi.muni.cz.dailymenupicker.parser.WebPageHtmlParser
import pv239.fi.muni.cz.dailymenupicker.parser.config.AttributeType
import pv239.fi.muni.cz.dailymenupicker.parser.config.Day
import pv239.fi.muni.cz.dailymenupicker.parser.config.Menu
import pv239.fi.muni.cz.dailymenupicker.parser.config.Source
import pv239.fi.muni.cz.dailymenupicker.parser.day.getDayParser
import pv239.fi.muni.cz.dailymenupicker.parser.entity.FoodEntity
import pv239.fi.muni.cz.dailymenupicker.parser.exception.UnknownDayParser
import pv239.fi.muni.cz.dailymenupicker.parser.exception.UnknownMenuParser
import pv239.fi.muni.cz.dailymenupicker.parser.menu.getMenuParser
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.io.StringReader
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.parsers.DocumentBuilder



/**
 * Created by mhajas on 3/18/18.
 */
fun main(args: Array<String>) {
    var config = Source("http://www.napurkynce.cz/denni-menu/","WebPageHtmlParser",
            Menu("ElementMenuParser",
                    Day("DayNameDayParser", ""), "pre", AttributeType("", "")))

    val foods = WebPageHtmlParser(config).parse(null)

    println(foods.menuHeader)
    foods.menuItems.forEach { foodEntity: FoodEntity -> println(foodEntity.name) }
}