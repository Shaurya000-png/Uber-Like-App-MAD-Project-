# Uber-Like Carpool App

An Android Mobile Application Development prototype for a simple Uber-style carpool workflow with ride offering, ride search, local ride storage, and matching UI screens.

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

- `ec_activity_main.xml`: entry screen for offering or finding a ride
- `ec_activity_offer_ride.xml`: form for adding a quick sample ride
- `ec_activity_find_ride.xml`: RecyclerView ride search results
- `activity_home.xml`: local ride list with destination search
- `activity_create_ride.xml`: map-backed ride creation form
- `activity_ride_matching.xml` and `activity_chat.xml`: later-stage UI prototype screens

## Implementation Notes

- `easycarpool` is the simple MVP flow for quickly demonstrating offer and find ride behavior.
- `carpoolconnect` is the expanded flow with local storage, home search, and map-based ride creation.
- `RideStore` persists rides locally with Gson so created rides survive screen changes.
- The create ride screen uses the current map camera target as a lightweight start location input.

## Current Limitations

- The app is a college prototype, so not every screen is wired into one final production flow.
- Authentication screens exist from an earlier Firebase direction, while local ride features use device storage.
- Payment, live tracking, and production driver matching are out of scope.

## Manual Testing

- Sync the Gradle project successfully in Android Studio.
- Add a ride from the offer screen and confirm it appears in the list.
- Create a local ride from the CarPool Connect flow and reopen the home screen.
- Type part of a destination and confirm the ride list filters correctly.
- Open ride details and join a ride to verify the seat count path.

## Roadmap

- Reconnect authentication screens to a consistent backend or Firebase project
- Implement real route and schedule compatibility scoring
- Add pickup and destination markers with route drawing on Google Maps
- Wire chat UI to a real message store
- Improve empty states and error handling across the MVP screens

## Course Context

This project was built for a Mobile Application Development submission and focuses on Android UI, activity navigation, local data handling, and practical ride-share flows.
