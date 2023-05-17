import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.0.0"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version "1.7.21"
    kotlin("plugin.spring") version "1.7.21"
    kotlin("plugin.jpa") version "1.7.21"
    kotlin("plugin.serialization") version "1.8.21"
}

group = "com.ostdan"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    compileOnly("org.projectlombok:lombok")
    runtimeOnly("org.postgresql:postgresql")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    //Swagger
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.4")
    implementation("org.springframework.boot:spring-boot-starter-validation:3.0.5")

    //jsoup
    implementation("org.jsoup:jsoup:1.15.3")
    //Gson
    implementation("com.google.code.gson:gson:2.8.5")
    //Jackson
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.15.0")

    //Selenium
    implementation ("org.seleniumhq.selenium:selenium-java:4.8.1")


    //Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")

    //Fuel
    implementation("com.github.kittinunf.fuel:fuel:2.3.1")
    implementation("com.github.kittinunf.fuel:fuel-coroutines:2.3.1")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
