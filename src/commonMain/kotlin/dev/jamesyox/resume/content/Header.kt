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

import dev.jamesyox.resume.Strings
import dev.jamesyox.resume.Stylesheet
import dev.jamesyox.statik.classSelector
import dev.jamesyox.statik.css.selector
import kotlinx.css.Align
import kotlinx.css.CssBuilder
import kotlinx.css.Display
import kotlinx.css.FlexDirection
import kotlinx.css.FlexWrap
import kotlinx.css.FontWeight
import kotlinx.css.JustifyContent
import kotlinx.css.Margin
import kotlinx.css.alignItems
import kotlinx.css.columnGap
import kotlinx.css.display
import kotlinx.css.flexDirection
import kotlinx.css.flexWrap
import kotlinx.css.fontWeight
import kotlinx.css.height
import kotlinx.css.justifyContent
import kotlinx.css.margin
import kotlinx.css.marginTop
import kotlinx.css.px
import kotlinx.css.rowGap
import kotlinx.css.width
import kotlinx.html.TagConsumer
import kotlinx.html.a
import kotlinx.html.div
import kotlinx.html.h1
import kotlinx.html.h3
import kotlinx.html.img
import kotlinx.html.p

public data class PhoneData(
    val display: String,
    val number: String
)

public fun TagConsumer<*>.Header(phoneData: PhoneData?) {
    h1 {
        classSelector(Stylesheet.topName)
        +"James A. Yox"
    }
    h3 {
        classSelector(Stylesheet.topTitle)
        +"${Strings.currentJobTitle} • ${Strings.currentCompanyName}"
    }
    div {
        classSelector(Stylesheet.contactHeader)
        ContactItem(text = "yoxjames", image = "github.svg", link = "https://github.com/yoxjames")
        +"•"
        ContactItem(text = "james-yox", image = "linkedin.svg", link = "https://www.linkedin.com/in/james-yox")
        +"•"
        ContactItem(text = "yoxjames@gmail.com", image = "email.svg", link = "mailto:yoxjames@gmail.com")
        +"•"
        if (phoneData != null) {
            ContactItem(text = phoneData.display, image = "phone.svg", link = "tel:+${phoneData.number}")
        }
    }
}

private fun TagConsumer<*>.ContactItem(text: String, image: String, link: String) {
    a {
        href = link
        classSelector(Stylesheet.contactItem)
        img {
            classSelector(Stylesheet.contactIcon)
            src = image
        }
        p {
            classSelector(Stylesheet.contactText)
            +text
        }
    }
}

public fun CssBuilder.HeaderStyles() {
    selector(Stylesheet.topName) {
        margin = Margin(top = 0.px, bottom = 6.px)
    }
    selector(Stylesheet.topTitle) {
        fontWeight = FontWeight.bold
        margin = Margin(0.px)
    }
    selector(Stylesheet.contactHeader) {
        display = Display.flex
        flexDirection = FlexDirection.row
        flexWrap = FlexWrap.wrap
        justifyContent = JustifyContent.center
        columnGap = 8.px
        rowGap = 8.px
        alignItems = Align.center
        marginTop = 8.px
    }
    selector(Stylesheet.contactItem) {
        display = Display.flex
        flexDirection = FlexDirection.row
        justifyContent = JustifyContent.center
        columnGap = 4.px
        alignItems = Align.center
    }
    selector(Stylesheet.contactIcon) {
        height = 16.px
        width = 16.px
    }
    selector(Stylesheet.contactText) {
        margin = Margin(0.px)
    }
}
