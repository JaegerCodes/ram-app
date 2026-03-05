package com.arkamo.rickandmorty

import org.gradle.api.Project
import java.io.FileInputStream
import java.util.Properties

internal fun Project.loadVersionProperties(): Properties =
    Properties().apply {
        load(FileInputStream(rootProject.file("delivery/version.properties")))
    }
