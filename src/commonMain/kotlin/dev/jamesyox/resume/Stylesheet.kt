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

package dev.jamesyox.resume

import dev.jamesyox.resume.content.ExperienceStyles
import dev.jamesyox.resume.content.HeaderStyles
import dev.jamesyox.resume.content.SideProjectsStyles
import dev.jamesyox.resume.content.SkillsStyles
import dev.jamesyox.statik.css.Selector
import dev.jamesyox.statik.css.selector
import kotlinx.css.Align
import kotlinx.css.BorderStyle
import kotlinx.css.CssBuilder
import kotlinx.css.Display
import kotlinx.css.FontStyle
import kotlinx.css.JustifyContent
import kotlinx.css.JustifyItems
import kotlinx.css.LinearDimension
import kotlinx.css.Margin
import kotlinx.css.Padding
import kotlinx.css.TextAlign
import kotlinx.css.alignContent
import kotlinx.css.backgroundColor
import kotlinx.css.body
import kotlinx.css.borderBottomColor
import kotlinx.css.borderBottomStyle
import kotlinx.css.borderBottomWidth
import kotlinx.css.ch
import kotlinx.css.color
import kotlinx.css.display
import kotlinx.css.fontFamily
import kotlinx.css.fontSize
import kotlinx.css.fontStyle
import kotlinx.css.height
import kotlinx.css.html
import kotlinx.css.`in`
import kotlinx.css.justifyContent
import kotlinx.css.justifyItems
import kotlinx.css.margin
import kotlinx.css.maxWidth
import kotlinx.css.minWidth
import kotlinx.css.padding
import kotlinx.css.pct
import kotlinx.css.pt
import kotlinx.css.px
import kotlinx.css.textAlign
import kotlinx.css.width

// This could be broken up but for a small project it'll do.
public object Stylesheet {
    public val siteContainer: Selector.Class = Selector.Class("site-container")
    public val sectionTitle: Selector.Class = Selector.Class("section-title")
    public val subsectionTitle: Selector.Class = Selector.Class("subsection-title")
    public val subsectionCaption: Selector.Class = Selector.Class("subsection-caption")

    public val detailsList: Selector.Class = Selector.Class("details-list")
    public val detail: Selector.Class = Selector.Class("detail")
    public val twoColumnHeader: Selector.Class = Selector.Class("two-column-header")
    public val location: Selector.Class = Selector.Class("location")
    public val dates: Selector.Class = Selector.Class("dates")

    // Header
    public val topName: Selector.Class = Selector.Class("top-name")
    public val topTitle: Selector.Class = Selector.Class("top-title")
    public val contactHeader: Selector.Class = Selector.Class("contact-header")
    public val contactItem: Selector.Class = Selector.Class("contact-item")
    public val contactIcon: Selector.Class = Selector.Class("contact-icon")
    public val contactText: Selector.Class = Selector.Class("contact-text")

    // Skills
    public val skillsSection: Selector.Class = Selector.Class("skills-section")

    // Experience
    public val companyNameContainer: Selector.Class = Selector.Class("company-name-container")
    public val companyCaption: Selector.Class = Selector.Class("company-caption")

    // Side Projects
    public val projectSummary: Selector.Class = Selector.Class("project-summary")
}

public fun CssBuilder.Stylesheet() {
    html {
        fontFamily = Theme.fontFamilies
    }
    body {
        backgroundColor = Theme.backgroundColor
        margin = Margin(0.px)
        padding = Padding(0.px)
    }
    selector(Stylesheet.sectionTitle) {
        textAlign = TextAlign.left
        color = Theme.darkTextColor
        margin = Margin(bottom = 8.px, top = 12.px)
        if (Theme.sectionBorders) {
            borderBottomStyle = BorderStyle.solid
            borderBottomWidth = Theme.sectionBorderWidth
            borderBottomColor = Theme.borderColor
        }
    }
    "@page" {
        declarations["size"] = "letter"
    }
    "p, li, a" {
        textAlign = TextAlign.left
        color = Theme.defaultTextColor
        fontSize = 11.pt
    }
    selector(Stylesheet.siteContainer) {
        media("print") {
            padding = Padding(0.px)
            width = (8.5).`in`
            height = 11.`in`
        }
        media("not print") {
            padding = Padding(8.px)
            maxWidth = 1200.px
            minWidth = 400.px
        }
        height = 100.pct
        margin = Margin(horizontal = LinearDimension.auto, top = 0.px, bottom = 16.px)
        textAlign = TextAlign.center
    }
    selector(Stylesheet.subsectionTitle) {
        margin = Margin(vertical = 0.px)
        textAlign = TextAlign.left
        alignContent = Align.center
    }
    selector(Stylesheet.detail) {
        textAlign = TextAlign.left
    }
    selector(Stylesheet.detailsList) {
        margin = Margin(vertical = 8.px)
        padding = Padding(left = 4.ch)
    }
    selector(Stylesheet.subsectionCaption) {
        margin = Margin(vertical = 0.px)
        alignContent = Align.center
        color = Theme.defaultTextColor
    }
    selector(Stylesheet.twoColumnHeader) {
        display = Display.flex
        justifyContent = JustifyContent.spaceBetween
        justifyItems = JustifyItems.center
        alignContent = Align.center
    }
    selector(Stylesheet.location) {
        margin = Margin(top = 0.px, bottom = 0.px)
        fontStyle = FontStyle.italic
    }
    selector(Stylesheet.dates) {
        margin = Margin(top = 0.px, bottom = 0.px)
        fontStyle = FontStyle.italic
    }
    HeaderStyles()
    SkillsStyles()
    SideProjectsStyles()
    ExperienceStyles()
}
