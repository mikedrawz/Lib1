@Suppress("DSL_SCOPE_VIOLATION") // is needed to avoid a known false positive
plugins {
    alias(libs.plugins.kotlin.multiplatform)
	alias(libs.plugins.android.library)
    `maven-publish`
}


group = "com.example.mdrawz"
version = project.property("version")!!

// *************************************************************************************************************
// Dependency repositories
// *************************************************************************************************************
repositories {
    mavenLocal()
    mavenCentral()
	google()
}

kotlin {
	jvm {
		compilations.all {
			kotlinOptions.jvmTarget = libs.versions.jvm.target.get()
		}
		testRuns["test"].executionTask.configure {
			useJUnitPlatform()
		}
	}

	android {
		compilations.all {
			kotlinOptions {
				jvmTarget = libs.versions.jvm.target.get()
			}
		}
		publishLibraryVariants("release")
	}

	sourceSets {
		val commonMain by getting {
			dependencies {
			}
		}
		val commonTest by getting {
			dependencies {
				implementation(kotlin("test"))
			}
		}
		val jvmMain by getting
		val jvmTest by getting
		val androidMain by getting
		val androidTest by getting
	}
}

// *************************************************************************************************************
// Android configuration
// *************************************************************************************************************
android {
	namespace = "com.example.mdrawz"
	compileSdk = 32
	defaultConfig {
		minSdk = 21
		targetSdk = 32
	}
}
