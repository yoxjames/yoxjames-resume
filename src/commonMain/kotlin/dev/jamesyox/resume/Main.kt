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

import dev.jamesyox.resume.content.PhoneData
import dev.jamesyox.statik.StaticSiteContext
import dev.jamesyox.statik.css.writeCssFile
import dev.jamesyox.statik.html.writeHtmlFile
import dev.jamesyox.statik.io.copyResource
import dev.jamesyox.statik.io.loadResource
import dev.jamesyox.statik.staticSite
import kotlinx.io.files.Path
import kotlinx.io.readLine

public val stylesheetPath: Path = Path("style.css")

// If you were attempting to use this project for your own resume you would obviously need to change these.
private val siteOutputDirectory = Path("/home/yoxjames/resume")
private val resourcesDirectory = Path("/home/yoxjames/IdeaProjects/yoxjames-resume/resources")

public fun main() {
    staticSite(siteOutputDirectory) {
        val phoneData = loadPhoneData(resourcesDirectory)
        writeHtmlFile(Path("index.html")) {
            Resume(stylesheetPath, phoneData)
        }
        writeCssFile(stylesheetPath) { Stylesheet() }
        copyResource(resourcesDirectory, Path("github.svg"))
        copyResource(resourcesDirectory, Path("linkedin.svg"))
        copyResource(resourcesDirectory, Path("email.svg"))
        copyResource(resourcesDirectory, Path("phone.svg"))
    }
}

// Not committed to git repo to protect personal contact info.
private fun StaticSiteContext.loadPhoneData(resourcesDirectory: Path): PhoneData? {
    return when (fileSystem.exists(Path(resourcesDirectory, "phone.txt"))) {
        true -> loadResource(resourcesDirectory, Path("phone.txt")).use {
            val display = it.readLine()
            val number = it.readLine()

            if (display != null && number != null) {
                PhoneData(display, number)
            } else {
                null
            }
        }
        false -> null
    }
}