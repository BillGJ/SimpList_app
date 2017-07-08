# SimpList_app
Just a todo list android app

# Pre-work - *SimpList*

**SimpList** is an android app that allows building a todo list and basic todo items management functionality including adding new items, editing and deleting an existing item.

Submitted by: **Ebillson GRAND JEAN**

Time spent: **3-4** hours spent in total

## User Stories

The following **required** functionality is completed:

* [ ] User can **successfully add and remove items** from the todo list
* [ ] User can **tap a todo item in the list and bring up an edit screen for the todo item** and then have any changes to the text reflected in the todo list.
* [ ] User can **persist todo items** and retrieve them properly on app restart

Some of following optional features will be implemented soon and others will be implemented step by step :

* [ ] Persist the todo items [into SQLite](http://guides.codepath.com/android/Persisting-Data-to-the-Device#sqlite) instead of a text file
* [ ] Improve style of the todo items in the list [using a custom adapter](http://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView)
* [ ] Add support for completion due dates for todo items (and display within listview item)
* [ ] Use a [DialogFragment](http://guides.codepath.com/android/Using-DialogFragment) instead of new Activity for editing items
* [ ] Add support for selecting the priority of each todo item (and display in listview item)
* [ ] Tweak the style improving the UI / UX, play with colors, images or backgrounds

The following **additional** features are implemented:

* for now nothing, but hopefully I'd like to sync the app to the android phone user default calendar app so he can get reminders for undone task.

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src="http://i.imgur.com/FLY6mB6.gif" title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Notes

Describe any challenges encountered while building the app.


While building the app I encountered many challenges : 

1) I didn't master neither Java nor Java for Android though I learned Java's Syntax through Sololearn.

Hence, I had to spend 1 day for a deep understanding of Java . I took some hours to get used with Java's syntax and logic .

After understanding Java's basic concepts (data structure, conditional statement, loops...) I spent like 1 day learning the OOP part of Java (Class, Objects, Methods...). 

In order to ensure myself I really understand these concepts I spent 3-5 hours doing excercises on Java (I did excercices on Conditional statements, loops and OOP precisely because experience shown me that these concepts are very important in any programming language).

Then, I spent some hours reading theorical concepts on Android and I started working on the pre-work submission.

2) I didn't understand the android environment

It took me an entire night to really understand the android environment (through Android Studio, Geny Motion, Intel HAXM , AVD... )

3) I didn't really understand XML's importance

As I did C++ and Qt, I started being accustomed to XML. While I was beginning the app, I realized that XML was also present too. I used the Graphic part to make the design but I met some issues when I was trying to drag some elements, so I had to go through the code to fix them and this was new to me but I adapted myself to the situation

4) I didn't understand how to implement the edit feature in the todo app

As I learn fast, It didn't really take me much time to follow the Codepath guidelines to start building the todo list app. I implemented de add and remove features easily.

Things started becoming hard when I had to understand the "Intent" concepts to launch the second activity so that I can implement the edit feature. It took me a lot of time to understand how to pass the selected item's value to the edit text in the edit form and then return the result in the main activity after clicking "Save".


Globally, these were the main challenges I encountered. Learning something new is never easy, but with commitment, will and persistence it's possible. I have to admit that I spent like 3-4 hours building the app itself but it cost me more time because I had to get some pre-requisites.           



## License

    © Copyright 2017 EGJ Productions

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
