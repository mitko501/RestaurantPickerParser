package pv239.fi.muni.cz.dailymenupicker.parser

import org.w3c.dom.Element
import pv239.fi.muni.cz.dailymenupicker.parser.config.Menu
import pv239.fi.muni.cz.dailymenupicker.parser.entity.TodayMenuEntity

/**
 * Created by mhajas on 3/17/18.
 */
abstract class Parser<FROM_TYPE, TO_TYPE> {

    fun parse(t: FROM_TYPE) : TO_TYPE {
        return parseType(t)
    }

    abstract fun parseType(t: FROM_TYPE): TO_TYPE
}