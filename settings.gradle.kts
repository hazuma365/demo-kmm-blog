rootProject.name = "demo-kmm-blog"

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}
include("common")
include("frontend")
include("untitled")
include("jsMain")
