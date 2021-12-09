Sample project to reproduce detekt indentation issue

Looks like `continuationIndentSize` isn't taken into account by detekt

Steps to reproduce:
* Verify the kotlin file is formatted properly according to Android Studio
  - Open the project in Android Studio
  - Open the `Hello.kt` file
  - Do Code -> Reformat code
    - Note, nothing changes
* Run detekt
  - `./gradlew detekt`
  - Expected behavior: no issues are found
  - Actual behavior: two `Indentation` issues are found ("Unexpected indentation (16) (should be 12)")


Experiment with:
* `continuationIndentSize`: Try setting this parameter, in `config/detekt.yml`  to `8` or `4`
  - The result is the same
* Android Studio: Verify default formatting:
  - Preferences -> Editor -> Code Style -> Kotlin -> Set from -> "Kotlin style guide"
  - A code reformat doesn't change anything (it was already formatted with this style guide)
* Android Studio: Customize formatting:
  - Preferences -> Editor -> Code Style -> Kotlin -> Tabs and Indents -> Continuation Indent: Put `4` instead of `8`
  - Now detekt passes, regardless of whether its `continuationIndentSize` is set to `4` or `8`
