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
import kotlinx.html.TagConsumer
import kotlinx.html.h2
import kotlinx.html.h3
import kotlinx.html.h4

internal fun TagConsumer<*>.SectionTitle(title: String) {
    h2 {
        classSelector(Stylesheet.sectionTitle)
        +title
    }
}

internal fun TagConsumer<*>.SubsectionTitle(title: String) {
    h3 {
        classSelector(Stylesheet.subsectionTitle)
        +title
    }
}

internal fun TagConsumer<*>.SubsectionCaption(title: String) {
    h4 {
        classSelector(Stylesheet.subsectionCaption)
        +title
    }
}
