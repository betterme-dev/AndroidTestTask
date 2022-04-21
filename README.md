# BetterMe Android Test Case

###### Movies client with offline-mode

Create the application which allows user to review the list of ongoing movies and add them to bookmarks with the following requirements:

![Sample of the UI](/ui_sample.png)

#### Technical requirements

1. Provide proper logic for movies persistence (there are two sources: remote and local) and
 retrieval (you might be interested in `MoviesRepository`), cover this logic with unit tests.

2. There are pieces of code in this project which make some smell, some of them make this project
 not work properly. Even though, it's compiling.

3. Make sure, the movies list is displayed properly, and favorites functionality works fine as well.

4. Provide error handling where it's needed (wrap exceptions, provide error placeholders on the UI layer, etc).

5. Implement movie details screen / dialog / bottom sheet.

#### Notes

- Just imagine `MoviesRestStore` is a component which interacts with the real Movies database API
(even though it's not :D).