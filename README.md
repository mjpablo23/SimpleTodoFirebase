# SimpleTodoPaul
todo list for codepath

http://courses.codepath.com/snippets/intro_to_android/prework

Quick Summary:
To add new item, type into bottom edit text box and press add.
To edit item, tap on an item to bring up edit box. edit and press save. 
To delete item, long press on an item.

This app is a shared todo list that updates in real time. 
Multiple users can see the shared todo list and make updates, 
and changes will be instantly updated to other users.

————————————————————————————————————————————————————————————

# Pre-work - SimpleTodo

SimpleTodo is an android app that allows building a todo list and basic todo items management functionality including adding new items, editing and deleting an existing item.

Submitted by: Paul Yang

Time spent: 15 hours spent in total

## User Stories

The following **required** functionality is completed:

* [y] User can **successfully add and remove items** from the todo list
* [y] User can **tap a todo item in the list and bring up an edit screen for the todo item** and then have any changes to the text reflected in the todo list.
* [y] User can **persist todo items** and retrieve them properly on app restart

The following **optional** features are implemented:

* [y] Persist the todo items [google Firebase]
* [y] Improve style of the todo items in the list [using a custom adapter](http://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView)
* [ ] Add support for completion due dates for todo items (and display within listview item)
* [ ] Use a [DialogFragment](http://guides.codepath.com/android/Using-DialogFragment) instead of new Activity for editing items
* [ ] Add support for selecting the priority of each todo item (and display in listview item)
* [y] added profile images for users

The following **additional** features are implemented:

* [y] added check boxes
*  multiple users can update list at the same time.  changes will be seen in real time.

## Video Walkthrough 

Here's a walkthrough of implemented user stories:

<img src='http://imgur.com/a/ErONc' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Notes

Describe any challenges encountered while building the app.
1) Had trouble figuring out that I needed to implement “onItemClick” instead of “onClick”.  It kept not compiling.  
2) Is onSubmit automatically called when exiting the activity?  or always needs to be explicitly called?

## License

    Copyright [yyyy] [name of copyright owner]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.