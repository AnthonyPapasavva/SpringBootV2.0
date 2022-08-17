Spring Boot Project Read Me:


# Personal Calendar & To Do List Web Application

This Git repository encapsulates my first attempt at a full-stack Spring Boot web application. The project follows the Enterprise Architect Model consisting of: the back-end developed using Java, a managed H2 database hosted locally, and a front-end developed using JavaScript, HTML, and CSS. The web application that I have produced is a personal to do list and calendar that allows users to add, save, read, and delete their personal appointments for any given day, week, month, and year - the intention being for this functionality to abide by typical CRUD parameters. Additional functionality has been included in the front end where possible for better user experience.

## Project Management Board:

Feel free to have a look through my project management board to see how I got on:

```
https://trello.com/b/7y7ezfvG/springboot-project-personal-appointment-planner-calendar
```

## Getting Started

In order to run this application users should have access to Java 1.8 or higher, Javascript, HTML 5, and CSS. As such, the following deveopment tools are needed:

An IDE of your choice for back-end Java - Eclipse (2022-06) was used during development:
```
https://www.eclipse.org/downloads/
```

A source-code editor of your choice for front-end Javascript, HTML 5, and CSS - Visual Studio Code was used during development:
```
https://code.visualstudio.com/
```

## Testing

### Test Coverage: 76.1%

Unit Testing was carried out using both JUnit and Mockito in the Eclipse IDE. 

Test Driven Development was attempted in the early stages of the project. However due to inexperience I was not confident in my ability to continue down this path for the entirity of the project. In hindsight, I believe I would have achieved higher test coverage and had an easier time testing overall if I had used TDD throughout.

In order to run these tests yourself you must: first fork and then clone this repo, open it in your IDE, select the project, find and click 'Run' in the top toolbar and select 'Coverage As' > 'JUnit Test' - the same result is achieved via right clicking the project in the package explorer and selecting 'Coverage As' > 'JUnit Test'. The test coverage will be logged and shown in the coverage console at the bottom of the IDE.

## Project Summary, Reflections, and Improvements.

My intentions for this assignment were to produce a fully functional GP and Patient Calendar site with a functional log-in page that both cached user IDs, and allowed for multiple users of different authorisation levels to access the planner. I started off strong however, I believe I was far too ambitious within the time frame of the project, as a result finished product suffered. I had to cut my losses with the log-in page and decided to change the scope of my project to a simpler Personal Planner for users; salvaging as much of my front end as possible. 

The biggest issue with my project overall is that due to my unfamiliarity with means of linking the front and back-ends I focused on getting my front-end to work independantly of back-end much like the other sites we created during our Spring training. I have subsequently tried for many hours to learn and implement fetch APIs while essentially working backwards; but for the most part have been unsuccessful without breaking my website completely.

I also have come across a few errors with testing, specifically my controller unit testing which I could not figure out how to fix, limiting my overall testing to lower than I would have liked. Coverage % is maintained due to second entity classes not being used for the mostpart, after project evolution.

I think I could have mitigated these issues better foresight, planning, and most importantly getting more support from experienced trainers early on. Ultimately, I am happy to be making these kinds of mistakes now during the academy so that I can learn from them, target my weaker areas, and develop moving forward. 

Other than these two glaring problems overall I am happy with the work and effort I put into this project. I have organised myself well with my project management board and been able to work dynamically and adapt as the project has evolved to produce a semi functioning full-stack application.

## Acknowledgements

I would like to thank my fellow Cypriot coder Christopher Yiangou who, despite limited contact time, not only took our cohort through JavaScript, HTML, CSS, and Spring during the day but held booster sessions for Java in the evenings for arguably the longest week of my life. A speedrun record of content covered must have been set, I'm sure of it. Chris' patience and expertise in training and coding came in clutch many times for me and I am grateful. Shout out to Piers Barber for his continued willingness to support and be availiable to aid with project issues despite feeling under the weather - I hope you get better soon.
