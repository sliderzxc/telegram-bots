plugins {
    alias(libs.plugins.kotlin.jvm)
}

dependencies {
    implementation(libs.tgbotapi)
    implementation("org.jsoup:jsoup:1.14.3")
}