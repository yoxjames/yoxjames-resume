/*
 * Copyright (c) 2024 James Yox
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU General
 * Public License as published by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with this program.
 *  If not, see <https://www.gnu.org/licenses/>.
 */

package dev.jamesyox.resume.content

import dev.jamesyox.resume.Stylesheet
import dev.jamesyox.statik.classSelector
import kotlinx.html.LI
import kotlinx.html.TagConsumer
import kotlinx.html.UL
import kotlinx.html.div
import kotlinx.html.li
import kotlinx.html.p
import kotlinx.html.style
import kotlinx.html.ul

internal fun TagConsumer<*>.TwoColumnHeader(
    firstColumn: TagConsumer<*>.() -> Unit,
    secondColumn: TagConsumer<*>.() -> Unit
) {
    div {
        classSelector(Stylesheet.twoColumnHeader)
        firstColumn()
        secondColumn()
    }
}

internal fun TagConsumer<*>.Location(text: String) {
    p {
        classSelector(Stylesheet.location)
        +text
    }
}

internal fun TagConsumer<*>.DateText(text: String) {
    p {
        classSelector(Stylesheet.dates)
        +text
    }
}

internal fun TagConsumer<*>.DetailsList(details: List<String>) {
    DetailsList {
        details.forEach { detail ->
            DetailItem { +detail }
        }
    }
}

internal fun TagConsumer<*>.DetailsList(content: UL.() -> Unit) {
    ul {
        classSelector(Stylesheet.detailsList)
        content()
    }
}

internal fun TagConsumer<*>.DetailItem(content: LI.() -> Unit) {
    li {
        classSelector(Stylesheet.detail)
        content()
    }
}

internal fun TagConsumer<*>.PageBreak() {
    div {
        style = "break-after: page"
    }
}
