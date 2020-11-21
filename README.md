#Coleman's -  My Personal Project

## A personal workout app

This application aims to provide advice on *beginner* to *intermediate* level strength training.
A user can use this app to generate a personalised workout pregame based on their personal preference on the frequency, intensity and volume of their workouts.

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

In model.entries, Classes Food, Training and Weight all have a robust constructor.
In addition, Food.addAMeal(int carbs, int protein, int fat) throws a NumberFormatException when one of the param given is negative so it has a robust design.