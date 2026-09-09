# Kotlin MOTIS API Client

A simple Kotlin JVM library for the MOTIS Routing Services API.

[![GitHub License](https://img.shields.io/github/license/MeecoLabs/motis-client-kotlin?style=flat-square)](https://github.com/MeecoLabs/motis-client-kotlin/blob/main/LICENSE)
[![Release](https://jitpack.io/v/MeecoLabs/motis-client-kotlin.svg?style=flat-square)](https://jitpack.io/#MeecoLabs/motis-client-kotlin)

The backend configurations included in this repo are the staging and production instances provided by the [Transitous](https://transitous.org/) project. Please familiarise yourself with the [usage requirements](https://transitous.org/api/) before using them.


## Usage

1. Follow instructions on [jitpack](https://jitpack.io/#MeecoLabs/motis-client-kotlin) to add the Gradle dependencies.
2. Create an API service instance using the `MotisAPI` object.
3. Make API calls.

e.g.
```kotlin
val motisApi = MotisAPI.create("MyUserAgent/1.0")

val result = motisApi.plan(fromPlace = "48.311943,14.280252", toPlace = "48.243017,14.337695")
```

## Internals

Under the hood we use various open source libraries:

- HTTP calls: [Retrofit](https://lysine.dev/retrofit/) and [OkHttp](https://lysine.dev/okhttp/)
- JSON (de)serialisation:  [`kotlinx.serialization`](https://github.com/Kotlin/kotlinx.serialization/blob/master/formats/README.md#json)
