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

import kotlinx.css.Color
import kotlinx.css.LinearDimension
import kotlinx.css.px

public interface ResumeTheme {
    public val fontFamilies: String
    public val backgroundColor: Color
    public val darkTextColor: Color
    public val defaultTextColor: Color
    public val sectionBorders: Boolean
    public val borderColor: Color

    public val sectionBorderWidth: LinearDimension
}

// Global static var. For something this simple it's fine but should look into an implementation similar to Compose.
public var Theme: ResumeTheme = PaperTheme

public object PaperTheme : ResumeTheme {
    public override val fontFamilies: String = "Open Sans, sans serif"
    public override val backgroundColor: Color = Color.transparent
    public override val darkTextColor: Color = Color("#000000")
    public override val defaultTextColor: Color = Color("#4d4d4d")
    public override val sectionBorders: Boolean = true
    public override val borderColor: Color = defaultTextColor

    public override val sectionBorderWidth: LinearDimension = 2.px
}

public object WebTheme : ResumeTheme {
    public override val fontFamilies: String = "Open Sans, sans serif"
    public override val backgroundColor: Color = Color.transparent
    public override val darkTextColor: Color = Color("#000000")
    public override val defaultTextColor: Color = Color("#4d4d4d")
    public override val sectionBorders: Boolean = true
    public override val borderColor: Color = defaultTextColor

    public override val sectionBorderWidth: LinearDimension = 2.px
}
