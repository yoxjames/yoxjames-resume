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
import kotlinx.css.FontStyle
import kotlinx.css.JustifyContent
import kotlinx.css.Margin
import kotlinx.css.alignItems
import kotlinx.css.columnGap
import kotlinx.css.display
import kotlinx.css.flexDirection
import kotlinx.css.fontStyle
import kotlinx.css.justifyContent
import kotlinx.css.margin
import kotlinx.css.px
import kotlinx.html.TagConsumer
import kotlinx.html.div
import kotlinx.html.p

public fun TagConsumer<*>.Experience() {
    SectionTitle("Experience")
    Company(
        name = Strings.ibottaFullName,
        location = "Denver, CO",
    )
    Job(
        title = Strings.ibottaStaffTitle,
        employmentDates = "December 2022 - Present",
        jobDetails = listOf(
            "Led team to replace XML-based views with Jetpack Compose, which is now used for all new development.",
            "Wrote impression tracking code for Jetpack Compose removing a key blocker to adoption from " +
                    "XML-based views.",
            "Rewrote Gradle build configuration from Groovy to Kotlin using an easy to read declarative style " +
                    "which also led to a 30% reduction in Gradle code size.",
            "Created a library to test Kotlin Multiplatform, which was used to create a pull request tool using " +
                    "Swift and SwiftUI. This tool is used by many teams outside of mobile at Ibotta today.",
            "Created an automation to generate Swift Package Manager artifacts on our continuous integration " +
                    "system for Kotlin Multiplatform libraries."
        )
    )
    PageBreak()
    Job(
        title = Strings.ibottaSeniorTitle,
        employmentDates = "August 2019 - December 2022",
        jobDetails = listOf(
            "Developed a custom tree cache for our GraphQL-based API which cut average load times by 30%.",
            "Converted the Ibotta Android app from Java to Kotlin.",
            "Created a distribution platform for internal tooling that automatically manages updates on end users " +
                    "machines.",
            "During the onset of COVID-19, with a deadline of one week, I was picked to develop the UI for " +
                    "customers to continue redeeming Ibotta offers during the rapid shift to online grocery " +
                    "purchases. The work was completed on schedule and deployed successfully."
        )
    )
    Job(
        title = Strings.ibottaEngineerTitle,
        employmentDates = "March 2018 - August 2019",
        jobDetails = listOf(
            "Developed an Android app with over 10 million installs.",
            "Loaned out to 5+ squads developing features in a wide variety of areas across the app including " +
                "account linking and ad management.",
            "Developed the Ibotta search experience as the only Android engineer and created a list view " +
                "used in 50+ screens today."
        )
    )
    Company(
        name = Strings.cernerFullName,
        caption = "now acquired by Oracle",
        location = "Kansas City, MO",
    )
    Job(
        title = Strings.cernerDevTitle,
        employmentDates = "June 2015 - February 2018",
        jobDetails = listOf(
            "Worked with a small team of engineers developing new features for a large Java based application.",
            "Promoted to Senior Software Engineer within six months of transitioning to a development role within " +
                "the company.",
            "Developed a library to generate mock data for unit testing a legacy proprietary language " +
                "(Cerner Command Language), which created more reliable tests capable of testing " +
                "difficult workflows.",
            "Rewrote several old UI components adding test cases and making them more multithreaded creating " +
                    "a better user experience."
        )
    )
    Job(
        title = Strings.cernerSupportTitle,
        employmentDates = "July 2012 - June 2015",
        jobDetails = listOf(
            "Provided final tier tech support and technical leadership for a 40+ member team.",
            "Identified over 140 production defects and worked with development to prioritize corrections.",
            "Worked with 5 other engineers on a critical support team assigned to the most difficult " +
                "and escalated issues.",
            "Developed programs to correct data integrity issues and mitigate defects; many of which were " +
                "used long after my exit.",
            "Trained 4 software engineers for support roles including 2 based in India."
        )
    )
    Company(
        name = "MathLAN, Computer Science Department, Grinnell College",
        location = "Grinnell, IA",
    )
    Job(
        title = "System Administrator",
        employmentDates = "August 2011 - January 2012",
        jobDetails = listOf(
            "Performed administration and maintenance tasks on a large Linux network (Debian) serving the computer " +
                "science and math departments.",
            "Helped upgrade the network from CFEngine to Puppet configuration management software."
        )
    )
}

internal fun TagConsumer<*>.Company(
    name: String,
    caption: String = "",
    location: String,
) {
    TwoColumnHeader(
        firstColumn = {
            CompanyNameContainer {
                SubsectionTitle(name)
                if (caption.isNotEmpty()) {
                    CompanyCaption(caption)
                }
            }
        },
        secondColumn = { Location(location) }
    )
}

private fun TagConsumer<*>.Job(
    title: String,
    employmentDates: String,
    jobDetails: List<String>
) {
    TwoColumnHeader(
        firstColumn = { SubsectionCaption(title) },
        secondColumn = { DateText(employmentDates) }
    )
    DetailsList(jobDetails)
}

private fun TagConsumer<*>.CompanyNameContainer(content: TagConsumer<*>.() -> Unit) {
    div {
        classSelector(Stylesheet.companyNameContainer)
        content()
    }
}

private fun TagConsumer<*>.CompanyCaption(text: String) {
    p {
        classSelector(Stylesheet.companyCaption)
        +"("
        +text
        +")"
    }
}

internal fun CssBuilder.ExperienceStyles() {
    selector(Stylesheet.companyNameContainer) {
        display = Display.flex
        flexDirection = FlexDirection.row
        columnGap = 6.px
        alignItems = Align.baseline
    }
    selector(Stylesheet.companyCaption) {
        margin = Margin(0.px)
        fontStyle = FontStyle.italic
        justifyContent = JustifyContent.center
    }
}
