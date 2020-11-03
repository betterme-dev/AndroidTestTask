# BetterMe Android Test Case

###### Movies client with offline-mode

Create the application which allows user to review the list of ongoing movies and add them to bookmarks with the following requirements:

![Sample of the UI](/ui_sample.png)

> This is just a scheme. You are free to implement your own design

#### Functional requirements

As a user I see the list of ongoing movies for two last weeks period;

As a user I can refresh the list of movies using pull-to-refresh;

As a user I can view the list of movies without internet connection;

As a user I can add or remove each movie to bookmarks (all changes should become visible instantly);

As a user I can share each movie info (via any provider);

As a user I can see the list of my bookmarked movies;

Each data-bound operation should have one of these states at UI:

- empty state
- in progress
- failed (with reason: i.e. connectivity / server issue);
- success (data is shown);

#### Technical requirements

Clean Architecture patterns are mandatory;

Proper dependency injection is required;

Redux / MVP / MVVM / MVI architecture is required;

Unit-tests are mandatory;

#### Notes

You can change this project setup (it's just a template) and use whatever libraries you want;

We expect you to build scalable architecture based on SOLID principles;

We expect that you don’t spend a lot of time by polishing the UI, but some fancy animations will be a big plus;

100% code coverage is not necessary: you are free to test only the most important parts of logic;

#### Resources

The movie database API: https://www.themoviedb.org/documentation/api/discover

Please, obtain your own API key and make sure that we can build your project.