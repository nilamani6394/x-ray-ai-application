import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.5.4"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.5.21"
	kotlin("plugin.spring") version "1.5.21"
}

group = "com.main"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	// https://mvnrepository.com/artifact/commons-io/commons-io
	implementation("commons-io:commons-io:2.6")
	// https://mvnrepository.com/artifact/ai.djl/api
	implementation("ai.djl:api:0.9.0")
	// https://mvnrepository.com/artifact/ai.djl.tensorflow/tensorflow-api
	implementation("ai.djl.tensorflow:tensorflow-api:0.9.0")
	// https://mvnrepository.com/artifact/ai.djl.tensorflow/tensorflow-engine
	implementation("ai.djl.tensorflow:tensorflow-engine:0.9.0")
	// https://mvnrepository.com/artifact/net.java.dev.jna/jna
	implementation("net.java.dev.jna:jna:5.8.0")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	// https://mvnrepository.com/artifact/ai.djl.tensorflow/tensorflow-native-auto
	runtimeOnly("ai.djl.tensorflow:tensorflow-native-auto:2.3.1")
	// https://mvnrepository.com/artifact/ai.djl.mxnet/mxnet-engine
	runtimeOnly("ai.djl.mxnet:mxnet-engine:0.9.0")
	runtimeOnly("ai.djl.mxnet:mxnet-native-auto:1.8.0")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
