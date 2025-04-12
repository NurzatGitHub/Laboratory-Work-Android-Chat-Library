# Laboratory-Work-Android-Chat-Library

https://github.com/user-attachments/assets/af10a68b-b05b-4324-a2f2-cd3a40bf8fb7

## 📦 Установка

Добавь репозиторий GitHub Packages в `settings.gradle.kts`:

```kotlin
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://maven.pkg.github.com/NurzatGitHub/Laboratory-Work-Android-Chat-Library")
            credentials {
                username = "NurzatGitHub"
                password = "your_personal_access_token"
            }
        }
    }
}

Затем подключи библиотеку в build.gradle.kts:
dependencies {
    implementation("com.github.NurzatGitHub:chatlib:1.0.0")
}

💡 Важно: Вставь свой GitHub Token с правами read:packages в ~/.gradle/gradle.properties:
gpr.user=NurzatGitHub
gpr.key=ghp_ТВОЙ_ТОКЕН
