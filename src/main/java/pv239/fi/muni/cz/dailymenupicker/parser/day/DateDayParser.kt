package pv239.fi.muni.cz.dailymenupicker.parser.day

import org.jsoup.nodes.Element
import pv239.fi.muni.cz.dailymenupicker.parser.Parser
import pv239.fi.muni.cz.dailymenupicker.parser.config.Day
import pv239.fi.muni.cz.dailymenupicker.parser.entity.TodayMenuEntity

/**
 * Created by mhajas on 3/17/18.
 */
class DateDayParser(val config: Day) : Parser<Element, TodayMenuEntity>() {
    override fun parseType(doc: Element): TodayMenuEntity {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}