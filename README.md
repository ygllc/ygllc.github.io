# ygllc.github.io — Compose Multiplatform (Web) demo

A Kotlin Multiplatform project using Compose Multiplatform that targets the Web (Wasm and JS).  
This repository contains a sample / demo web app implemented with Compose for Web and Kotlin/Wasm, intended as a starting point and reference for building cross-platform UI with Kotlin.

---

## Quick overview

- Project: Kotlin Multiplatform + Compose Multiplatform for Web
- Targets:
  - Wasm (recommended for modern browsers — faster)
  - JS (for broader browser compatibility)
- Main module: `composeApp`

---

## Prerequisites

- JDK 17 (recommended) or a recent JDK 11+  
- Recent Gradle (this repo includes the Gradle wrapper; prefer using the included wrapper)
- A modern browser for Wasm (Chromium, Firefox, Safari). For Wasm debugging, enable browser devtools.

---

## Project structure

- `composeApp/src/`
  - `commonMain/kotlin` — shared code used by all targets
  - `wasmJsBrowserMain` / `jsBrowserMain` (and other platform-specific source sets) — platform-specific implementations
- Other standard Gradle/Kotlin Multiplatform files and configuration are at the repo root.

---

## Development — run locally

Use the Gradle wrapper included in the repository.

- Wasm target (recommended for development on modern browsers)

  macOS / Linux
  ```shell
  ./gradlew :composeApp:wasmJsBrowserDevelopmentRun
  ```

  Windows (PowerShell / CMD)
  ```powershell
  .\gradlew.bat :composeApp:wasmJsBrowserDevelopmentRun
  ```

- JS target (for older browsers / broader compatibility)

  macOS / Linux
  ```shell
  ./gradlew :composeApp:jsBrowserDevelopmentRun
  ```

  Windows
  ```powershell
  .\gradlew.bat :composeApp:jsBrowserDevelopmentRun
  ```

These tasks start a development server and enable hot reload (or fast re-run) for iterative development.

If you are unsure which tasks are available, list tasks:
```shell
./gradlew :composeApp:tasks --all
```

---

## Building for production

Production build task names may vary depending on plugin configuration. If a dedicated production task exists, use it; otherwise run the assemble/build tasks for the `composeApp` module. Example strategy:

1. Inspect available tasks:
   ```shell
   ./gradlew :composeApp:tasks --all
   ```
2. Run an appropriate production bundle or assemble task shown in the list (for example, a `production` or `webpack` related task).

After building, the generated static output (HTML / JS / Wasm / assets) can be served with any static file server or deployed to GitHub Pages, Netlify, Vercel, or your hosting of choice.

---

## Troubleshooting & tips

- Browser caching can hide Wasm/JS changes — do a hard refresh or disable cache while developing.
- If you see toolchain or JDK issues, confirm `JAVA_HOME` points to a supported JDK and that the Gradle wrapper is used (`./gradlew`).
- If you get platform-specific compilation errors, verify the correct source set is being edited (commonMain vs platform-specific).
- Use the browser devtools to inspect JS/Wasm output and console logs.

---

## Learn more & resources

- Kotlin Multiplatform: https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html
- Compose Multiplatform: https://github.com/JetBrains/compose-multiplatform
- Kotlin/Wasm: https://kotl.in/wasm
- Compose/Web discussion Slack: #compose-web on Kotlin Slack (https://slack-chats.kotlinlang.org/c/compose-web)
- Report issues: YouTrack (Compose Multiplatform project) — https://youtrack.jetbrains.com/newIssue?project=CMP

---

## Contributing

Contributions and feedback welcome! If you find bugs or want to propose improvements:
- Open an issue describing the problem or feature request
- Fork the repo, make your changes on a feature branch, and open a pull request with a clear description and any reproduction steps

Please follow standard GitHub contribution practices and include meaningful commit messages.

---

## License

This repository does not include a license file. If you intend to share or reuse code from this project, consider adding a LICENSE file (e.g., MIT, Apache 2.0) so others know how they may use it.

---

## Contact

If you have questions or want to share feedback about Compose/Web or Kotlin/Wasm, the Kotlin Slack channel linked above is a good public place to start.

Enjoy building with Kotlin Multiplatform and Compose!
Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html),
[Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform/#compose-multiplatform),
[Kotlin/Wasm](https://kotl.in/wasm/)…

We would appreciate your feedback on Compose/Web and Kotlin/Wasm in the public Slack channel [#compose-web](https://slack-chats.kotlinlang.org/c/compose-web).
If you face any issues, please report them on [YouTrack](https://youtrack.jetbrains.com/newIssue?project=CMP).
