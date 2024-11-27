plugins {
    id("com.android.application") version "8.1.4" apply false
    id("com.android.library") version "8.1.4" apply false
    id("org.jetbrains.kotlin.android") version "1.9.20" apply false // Atualize para a versão 1.9.20
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}
