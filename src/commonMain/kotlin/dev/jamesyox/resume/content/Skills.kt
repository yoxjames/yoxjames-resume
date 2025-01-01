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
import dev.jamesyox.statik.css.selector
import kotlinx.css.CssBuilder
import kotlinx.css.FontWeight
import kotlinx.css.LinearDimension
import kotlinx.css.Margin
import kotlinx.css.TextAlign
import kotlinx.css.ch
import kotlinx.css.fontWeight
import kotlinx.css.margin
import kotlinx.css.maxWidth
import kotlinx.css.minWidth
import kotlinx.css.px
import kotlinx.css.textAlign
import kotlinx.css.width
import kotlinx.html.TagConsumer
import kotlinx.html.br
import kotlinx.html.p

private const val maxSkillLineSize = 95
private const val separator = "•"

private val skills = listOf(
    "Kotlin",
    "Kotlin Multiplatform",
    "Jetpack Compose",
    "Compose Multiplatform",
    "Java",
    "Gradle",
    "Android",
    "Linux",
    "Unix",
    "HTML",
    "CSS",
    "Kotlin Coroutines",
    "Kotlin Flow",
    "RxJava",
    "Dagger",
    "Ktor",
    "SQL",
    "React",
)

public fun TagConsumer<*>.Skills() {
    SectionTitle("Skills")
    // Not my favorite code ever, but it works well enough for now.
    val lines = buildList {
        var currentLine = skills.first()
        skills.drop(1).forEach { skill ->
            val proposedNewAddition = "$currentLine $separator $skill"
            if (proposedNewAddition.length > maxSkillLineSize) {
                add(currentLine)
                currentLine = skill
            } else if (skill == skills.last()) {
                add(proposedNewAddition)
            } else {
                currentLine = " $proposedNewAddition"
            }
        }
    }
    p {
        classSelector(Stylesheet.skillsSection)
        lines.forEach {
            +it
            br
        }
    }
}

internal fun CssBuilder.SkillsStyles() {
    selector(Stylesheet.skillsSection) {
        media("print") {
            width = maxSkillLineSize.ch
        }
        media("not print") {
            maxWidth = maxSkillLineSize.ch
            minWidth = 400.px
        }
        margin = Margin(horizontal = LinearDimension.auto, vertical = 0.px)
        textAlign = TextAlign.center
        fontWeight = FontWeight.bold
    }
}