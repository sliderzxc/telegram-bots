plugins {
    alias(libs.plugins.kotlin.jvm)
}

dependencies {
    implementation(libs.tgbotapi)
    implementation(projects.githubTrendingRepositories.utils)
    implementation("org.jsoup:jsoup:1.14.3")
}