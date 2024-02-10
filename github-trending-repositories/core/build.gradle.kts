plugins {
    alias(libs.plugins.kotlin.jvm)
    kotlin("plugin.serialization") version "1.5.31"
}

dependencies {
    implementation(libs.tgbotapi)
    implementation(projects.githubTrendingRepositories.utils)
    implementation("org.jsoup:jsoup:1.14.3")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.0")
}