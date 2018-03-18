package pv239.fi.muni.cz.dailymenupicker.parser.day

import org.jsoup.nodes.Element
import org.jsoup.nodes.TextNode
import pv239.fi.muni.cz.dailymenupicker.parser.Parser
import pv239.fi.muni.cz.dailymenupicker.parser.config.Day
import pv239.fi.muni.cz.dailymenupicker.parser.entity.FoodEntity
import pv239.fi.muni.cz.dailymenupicker.parser.entity.TodayMenuEntity

/**
 * Created by mhajas on 3/17/18.
 */
class DayNameDayParser(val config: Day) : Parser<Element, TodayMenuEntity>() {
    override fun parseType(t: Element): TodayMenuEntity {
        var menu = t.textNodes().map { textNode -> textNode.text() }
        menu = menu.dropWhile{ s -> !s.startsWith("ÚTERÝ")}.takeWhile { s -> !s.startsWith("STŘEDA") }

        return TodayMenuEntity(
                menu.first(),
                menu.drop(1).map { s -> FoodEntity(s) })
    }
}