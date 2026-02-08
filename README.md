# Africa Quiz

An Android quiz game that tests your knowledge of African capital cities, featuring an interactive 3D globe powered by Globe.gl.

## Features

- **10 questions per round** randomly selected from all 54 African countries
- **4 multiple-choice answers** per question (1 correct capital + 2 other capitals + 1 major non-capital city)
- **Interactive 3D globe** that animates to the capital's location with a red marker after answering
- **Optional 15-second countdown timer** toggled from the home screen
- **Visual feedback** with green/red color animations on answer selection
- **Results screen** with score percentage, performance message, and full answer review
- **Fully offline** - no internet connection required

## Screenshots

*Coming soon*

## Tech Stack

- **Language:** Kotlin
- **UI:** Jetpack Compose + Material 3
- **Architecture:** MVVM with StateFlow
- **3D Globe:** [Globe.gl](https://globe.gl/) in WebView via `WebViewAssetLoader`
- **Data:** Python scraper (BeautifulSoup) with hardcoded fallback for 54 African countries
- **Min SDK:** 24 (Android 7.0)
- **Build:** AGP 8.13, Gradle 9.3.1

## Build

```bash
./gradlew assembleDebug
```

## Install

```bash
./gradlew installDebug
```

## Data Generation

The quiz data is pre-bundled, but you can regenerate it from Wikipedia:

```bash
cd scripts
pip install -r requirements.txt
python scrape_african_capitals.py
```

This produces `app/src/main/assets/african_capitals.json` containing all 54 African countries with their capitals, coordinates, and a pool of distractor cities.

## Project Structure

```
app/src/main/java/com/example/africaquiz/
├── MainActivity.kt
├── data/                    # Data layer
│   ├── model/               # Country, QuizData
│   ├── local/               # AssetJsonParser (Gson)
│   └── repository/          # QuizRepository
├── domain/                  # Domain layer
│   ├── model/               # Question, QuizResult
│   └── usecase/             # GenerateQuizUseCase, CalculateScoreUseCase
├── ui/                      # Presentation layer
│   ├── theme/               # Dark theme (gold/green/navy)
│   ├── navigation/          # NavGraph (Home → Quiz → Results)
│   ├── components/          # GlobeWebView, AnswerButton, CountdownTimer
│   └── screens/             # HomeScreen, QuizScreen, ResultsScreen
└── util/                    # Constants
```

## License

[MIT](LICENSE)
