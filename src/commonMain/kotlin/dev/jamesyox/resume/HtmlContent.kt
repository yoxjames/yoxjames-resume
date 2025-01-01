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

import dev.jamesyox.statik.classSelector
import kotlinx.html.TagConsumer
import kotlinx.html.body
import kotlinx.html.div
import kotlinx.html.head
import kotlinx.html.html
import kotlinx.html.lang
import kotlinx.html.link
import kotlinx.html.meta
import kotlinx.html.title
import kotlinx.io.files.Path

internal fun TagConsumer<*>.htmlContent(stylesheetPath: Path, content: TagConsumer<*>.() -> Unit) {
    html {
        lang = "en"
        head {
            meta {
                charset = "UTF-8"
            }
            meta {
                name = "viewport"
                this.content = "width=device-width, initial-scale=1.0"
            }
            link {
                rel = "stylesheet"
                href = stylesheetPath.toString()
            }

            link {
                href = "https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap"
                rel = "stylesheet"
            }
            title { +"James A. Yox" }
        }
        body {
            div {
                classSelector(Stylesheet.siteContainer)
                content()
            }
        }
    }
}
