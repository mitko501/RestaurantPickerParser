package pv239.fi.muni.cz.dailymenupicker.parser.day

import org.jsoup.nodes.Element
import pv239.fi.muni.cz.dailymenupicker.parser.Parser
import pv239.fi.muni.cz.dailymenupicker.parser.config.Day
import pv239.fi.muni.cz.dailymenupicker.parser.entity.TodayMenuEntity

/**
 * Created by mhajas on 3/17/18.
 */

fun getDayParser(config: Day): Parser<Element, TodayMenuEntity>? {
    return when (config.dayParserType) {
        "DayNameDayParser" -> DayNameDayParser(config)
        "DateDayParser" -> DateDayParser(config)
        else -> null
    }
}