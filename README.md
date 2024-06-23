<h1>KTOR AUTH</h1>

This project implements a login system with secure token handling (access & refresh) on the backend.

I’m thrilled to share my latest project where I’ve dived deep into Compose Multiplatform Mobile (CMP) and Ktor to create a seamless and secure login experience. Using PostgreSQL for the database and Jetpack Compose for a unified UI across platforms, this project has been a fantastic journey of learning and innovation.

Here’s a quick rundown:
🔐 Backend: Secure token handling with access and refresh tokens.
📱 UI: Shared UI for both Android and iOS using Jetpack Compose.
💾 Database: Reliable and efficient data management with PostgreSQL.

This has been an incredible experience, and I can’t wait to apply these skills to even more projects. If you’re also exploring CMP or Ktor, I’d love to connect and hear about your experiences!


Linkedin Post with demonstration - https://www.linkedin.com/posts/karunesh-palekar-37a247269_cmp-kmp-kmm-activity-7208683881888153601-HRwB?utm_source=share&utm_medium=member_desktop

Remember to change your BASE_URL from the Constant file 

```
object Constant {
    const val BASE_URL = "http://192.20.10.2:8080"
}
```

The backend code will be uploaded soon !! 

--------------------------------------------------------------------------------------------------------------
This is a Kotlin Multiplatform project targeting Android, iOS.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…

