FlashSpeak Server
=================

# Requirements

* sbt and a Java SDK to build this code
* Praat
* ffmpeg (with whichever decoding libraries you are using, likely opencore-amr

# Set-up

Set the environment variable $FLASHSPEAK_PRAAT_PATH to point to your Praat executable. This can be found from


# What it does

At the moment, this just receives an audio file over a PUT request, turns it into a wav through ffmpeg, and runs a Praat
scriot on it. In future versions, we'll have lots of Praat scripts and other libraries, but we're doing that on-demand
(so we don't over-engineer unused code).