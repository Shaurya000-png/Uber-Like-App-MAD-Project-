# Uber-Like Carpool App

An Android Mobile Application Development project for a simple Uber-style carpool workflow with ride offering, ride search, local ride storage, and matching UI screens.

![Status](https://img.shields.io/badge/status-college_project-blue)

## Features

- Offer a ride with driver name, start point, destination, time, and available seats
- Browse available rides in a RecyclerView list
- Open a ride details screen from the search results
- Seed sample rides through an in-memory repository for quick testing

## Tech Stack

- Java for Android activity and model code
- XML layouts for activity, list item, matching, and chat screens
- Gradle Android application project structure
- AndroidX AppCompat, RecyclerView, ConstraintLayout, and CardView
- Material Components for polished inputs and controls

The project includes login and registration screens from the fuller CarPool Connect flow.

## Setup

1. Open the project in Android Studio.
2. Sync Gradle files and let Android Studio download dependencies.
- Store created rides locally using a small JSON-backed helper
- Search local rides by destination from the home screen
3. Run the app on an Android emulator or physical device.
4. Replace `YOUR_GOOGLE_MAPS_API_KEY` in `app/src/main/AndroidManifest.xml` when testing maps.

Create Ride captures destination, date/time, seat count, cost, and the current map camera position.

Joining a ride reduces available seats in the local store and shows simple feedback.

## Project Structure

```text
app/src/main/java/com/example/easycarpool/
  activities/      MVP offer, find, and details screens
  models/          Serializable ride model
  store/           In-memory ride repository

app/src/main/java/com/example/carpoolconnect/
  activities/      Login, register, home, create ride, and details screens
  adapters/        RecyclerView adapter for local rides
  models/          User and ride models
  services/        JSON-backed local ride store

app/src/main/res/
  layout/          Activity and list item layouts
  drawable/        Icons, chat bubbles, and matching score backgrounds
  values/          Colors, strings, and themes
```

The matching and chat screens are included as polished UI prototypes for a fuller ride-share workflow.

## Screen Overview
