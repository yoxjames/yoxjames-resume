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

import kotlinx.html.TagConsumer

public fun TagConsumer<*>.Education() {
    SectionTitle("Education")
    TwoColumnHeader(
        firstColumn = { SubsectionTitle("Grinnell College") },
        secondColumn = { Location("Grinnell, IA") }
    )
    TwoColumnHeader(
        firstColumn = { SubsectionCaption("B.A. in Biology") },
        secondColumn = { DateText("May 2012") }
    )
}
