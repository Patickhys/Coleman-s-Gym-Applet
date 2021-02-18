#Coleman's -  My Personal Project

## A personal workout app

This application aims to provide advice on *beginner* to *intermediate* level strength training.
A user can use this app to track their daily workout program and their consumption of macronutrients.

## Target audience

A user can be anyone who is looking to start building their strength or anyone who is looking for a comprehensive and customizable training program.

## User Stories

- As a user, I want to be able to keep a log of my food intake.
- As a user, I want to be able to keep a log of the trainings I have done. 
- As a user, I want to be able to keep track of my weight change.
- As a user, I want to be able to view all of my log entries.

- As a user, I want to be able to save my food log to file.
- As a user, I want to be able to reload my file to update them again.


## Phase 4: Task 2

In model.entries, Classes Food, Training and Weight all have robust constructors.
In addition, Food.addAMeal(int carbs, int protein, int fat) throws a NumberFormatException when one of the param given is negative, so it has a robust design.

## Phase 4 : Task 3
If given more time, I would like to further refactor my UI package so that classes related to JPanel can be tidied up and have reduced coupling. Preferably I would also want to introduce a more detailed type hierarchy in my model package so that the code is more concise.
