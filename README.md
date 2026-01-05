# Activity ITE App (Student Activity Tracker)

A native Android application designed to track, display, and filter academic and extracurricular activities for students. Developed using **Kotlin** and following modern Android development practices.

## Project Overview

The app allows students (targeting ITE/RUPP context) to view their profile and a list of activities they have participated in. It fetches data from a remote API and allows filtering based on academic years.

## Key Features

- **User Profile:** Displays cover image, profile picture, name, and bio.  
- **Activity Feed:** Scrollable list of activities using RecyclerView.  
- **Year Filtering:** Filter activities by Year 1, Year 2, Year 3, or Year 4.  
- **Dynamic Image Loading:** Efficient image caching with Picasso.  
- **API Integration:** Fetches data dynamically using Retrofit.  
- **Modern UI:** Clean design using CardView, RelativeLayout, and rounded corners.  

## Tech Stack & Libraries

- **Language:** Kotlin  
- **Minimum SDK:** 21+  
- **View Binding** for safer XML interaction  
- **Networking:** Retrofit 2 + GSON Converter  
- **Image Loading:** Picasso  
- **UI Components:** RecyclerView, CardView, ConstraintLayout, RelativeLayout, Material Design  

## Project Structure

├─ api/ # Retrofit interfaces and model classes (e.g., Activities.kt)
├─ adapter/ # ActivitiesAdapter.kt
├─ MyActivitiesActivity.kt # Main activity for profile and activity list
├─ res/layout/ # activity_my_activities.xml
└─ res/values/ # colors, styles, etc.

markdown
Copy code

- **ActivitiesAdapter.kt:** Binds activity data to RecyclerView.  
- **MyActivitiesActivity.kt:** Handles API calls, filtering, and UI logic.  
- **activity_my_activities.xml:** Layout with profile header, filter tabs, and activity list.  

## Getting Started

1. **Clone the repository:**
```bash
git clone https://github.com/Chanheng-Ngen/android_ativities_app.git
Open in Android Studio: Select "Open an existing project".

Sync Gradle: Let Android Studio download dependencies.

Configure API: Set the Base URL in Retrofit to your backend server.

Run the App: Connect a device or start an emulator and run.

How Filtering Works
The filter bar allows users to select Year 1–4.

Clicking a year updates the text color to indicate selection.

The adapter filters the activity list for the selected year.

If no activities exist for the year, a "Not Found" message is displayed.

Author
Ngen Chanheng (SMUEK) – RUPP, Year 3 Software Engineer

License
This project is for educational purposes.
