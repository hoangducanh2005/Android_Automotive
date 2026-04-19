# Road_Reels

Android Automotive OS parked application designed for local video streaming inside in-vehicle infotainment systems.
This project demonstrates how a parked app can safely provide video playback when the vehicle is stationary, while automatically restricting playback once driving starts to comply with driver distraction safety requirements.

---

## 🎬 Demo Video

👉 **[Watch Road_Reels in action](https://your-demo-link.com)**

---

## 🚀 Features

* Local video playback inside Android Automotive emulator
* Built as an AAOS parked app
* Video playback using local media resources
* Automatic playback restriction while driving
* Driver distraction compliance handling
* Safe media lifecycle integration with Automotive system

---

## 🏗️ System Architecture

```text id="7vf8hf"
UI Layer
   ↓
Video Player UI
   ↓
Playback Controller
   ↓
Vehicle State Check
   ↓
ExoPlayer
   ↓
Display Output
```

---

## ⚙️ Main Components

### `MainActivity`

Main entry point of the parked application.

### `VideoPlayerScreen`

Responsible for rendering local video content.

### `Playback Controller`

Controls video lifecycle and playback state.

### `Vehicle State Check`

Monitors whether the vehicle is parked or moving.

### `ExoPlayer`

Video playback engine used for local media streaming.

---

## 🔄 Playback Workflow

1. User opens Road_Reels from AAOS launcher
2. App checks vehicle driving state
3. If vehicle is parked, video playback is allowed
4. ExoPlayer loads local video resource
5. If driving starts, playback immediately stops
6. UI becomes restricted to ensure safe driving

---

## 🔐 Safety Compliance

Road_Reels follows Android Automotive driver distraction rules:

* Video playback allowed only when vehicle is parked
* Playback immediately stops when driving starts
* Prevents unsafe driver interaction during motion

---

## 🚗 Automotive Requirement

```xml id="4u1dl0"
<uses-feature
    android:name="android.hardware.type.automotive"
    android:required="true"/>
```

---

## 🧩 Technologies Used

* Kotlin
* Android Automotive OS
* ExoPlayer
* Car App Library
* Vehicle property integration

---

## 📌 Project Purpose

This project is developed for studying:

* Android Automotive parked app architecture
* Driving safety restrictions
* Video playback lifecycle in AAOS
* Driver distraction compliance

---

## 🔮 Future Improvements

* Playlist support
* External storage video loading
* Multi-format video support
* Improved parked-state detection

---

## 👨‍💻 Author

Hoang Duc Anh
HEDSPI - Hanoi University of Science and Technology
