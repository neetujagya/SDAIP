# SDAIP

_Author Neetu Jagya_
_Project version 1.0.0_
_Java Version 9.0.4_

## Summary:
SDAIPis a project created by  with which you can do following
- List all the tasks created by you
- Create a new task under a project
- Edit a task, finish it and delete it
- Save and quit your work


## User manual
Application can be started by running main method of Application.java
Once the application starts running it will show following menu
``` Welcome to Todoly application 
You have X tasks todo and Y tasks are done 
Pick and option
(1) Show Task List (by date or project)
(2) Add New Task
(3) Edit Task (update, mark as done, remove)
(4) Save and Quit
```

## Adding new task
A task can be added by entering option 2 after the above menu is prompted.
It will show following content
```######### Adding new task #########
Please enter title :
Please enter project :
Please enter due date in dd-MM-YYYY :
```

Once all the task has been added successfully then it will display following message
> Task is added successfully

## Showing task list
Task list can be displayed by entering option 1 after the above menu is prompted.
It will show
Please choose :
(1) To sort task by date
(2) To filter task by project

>Tasks sorted by date will be displayed after entering option 1 from the above menu.
>Tasks filtered by project will be displayed after entering option 2 from the above menu.

## Editing task
Task list will be displayed to be edited  by selecting option 3 from the main menu.

It will show the following content
```######### Updating task #########
 Please enter task id to edit:
 Please choose an option :
 (1) Update
 (2) Mark as done
 (3) Remove
 ```

Once the task has been updated successfully then it will display following message
> Task is updated successfully

## Saving and quitting task
 All the tasks will be saved and user will be out from the main menu by entering option 4 from the above menu.