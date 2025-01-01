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
import kotlinx.css.CssBuilder
import kotlinx.css.Margin
import kotlinx.css.margin
import kotlinx.css.px
import kotlinx.html.LI
import kotlinx.html.TagConsumer
import kotlinx.html.a
import kotlinx.html.li
import kotlinx.html.p
import kotlinx.html.ul

public fun TagConsumer<*>.SideProjects() {
    SectionTitle("Side Projects")
    SideProject(
        title = "Kastro",
        summary = "Kotlin Multiplatform library that calculates solar and lunar event times like sunset and sunrise.",
        details = listOf(
            { +"Created to learn more about Kotlin Multiplatform." },
            { +"First library of its kind for Kotlin Multiplatform." },
            {
                +"Implemented in my own home to drive sun-based automation such as turning the lights 20 "
                +"minutes before sundown."
            }
        ),
        link = Strings.kastroSourceCodeUrl
    )
    SideProject(
        title = "Kastro Demo",
        summary = "Web-based demo for testing Kastro in your browser with data visualizations.",
        details = listOf(
            {
                +"Created using Kotlin JS and without any web frameworks as a challenge to learn "
                +"more about web development."
            },
            { +"Serves as \"living documentation\" for Kastro as well an easy way to test the library." },
            {
                +"See it live at "
                a {
                    href = Strings.kastroDemoLiveUrl
                    +Strings.kastroDemoLiveUrl
                }
            },
        ),
        link = Strings.kastroDemoSourceCodeUrl
    )
    SideProject(
        title = "This Resumé",
        summary = "This resumé was generated in Kotlin using kotlinx-html, kotlinx-css, and kotlinx-io.",
        details = listOf(
            { +"Used as a test case for an in progress static content generator." },
            { +"Resume generated using HTML printed to PDF." },
            {
                +"See it live at "
                a {
                    href = Strings.resumeLiveUrl
                    +Strings.resumeLiveUrl
                }
            }
        ),
        link = Strings.resumeSourceCodeUrl
    )
    OpenSourceContributions()
}

private fun TagConsumer<*>.SideProject(
    title: String,
    summary: String,
    details: List<LI.() -> Unit>,
    link: String
) {
    TwoColumnHeader(
        firstColumn = {
            SubsectionTitle(title)
        },
        secondColumn = {
            a {
                href = link
                +link
            }
        }
    )
    ProjectSummary(summary)
    DetailsList {
        details.forEach { detail -> DetailItem { detail() } }
    }
}

private fun TagConsumer<*>.OpenSourceContributions() {
    SubsectionTitle("Open Source Contributions")
    DetailsList {
        OpenSourceContributionItem(
            projectName = "Home Assistant",
            link = Strings.homeAssistantPRUrl
        )
        OpenSourceContributionItem(
            projectName = "Arrow",
            link = Strings.arrowPRUrl
        )
    }
}

private fun TagConsumer<*>.ProjectSummary(summary: String) {
    p {
        classSelector(Stylesheet.projectSummary)
        +summary
    }
}

private fun TagConsumer<*>.OpenSourceContributionItem(projectName: String, link: String) {
    DetailItem {
        +projectName
        +" "
        ul {
            li {
                a {
                    href = link
                    +link
                }
            }
        }
    }
}

internal fun CssBuilder.SideProjectsStyles() {
    selector(Stylesheet.projectSummary) {
        margin = Margin(left = 0.px, right = 0.px, top = 0.px, bottom = 0.px)
    }
}
