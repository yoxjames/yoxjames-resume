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

import dev.jamesyox.resume.content.Education
import dev.jamesyox.resume.content.Experience
import dev.jamesyox.resume.content.Header
import dev.jamesyox.resume.content.PhoneData
import dev.jamesyox.resume.content.SideProjects
import dev.jamesyox.resume.content.Skills
import kotlinx.html.TagConsumer
import kotlinx.io.files.Path

internal fun TagConsumer<*>.Resume(stylesheetPath: Path, phoneData: PhoneData?) {
    htmlContent(stylesheetPath) {
        Header(phoneData)
        Skills()
        SideProjects()
        Experience()
        Education()
    }
}
