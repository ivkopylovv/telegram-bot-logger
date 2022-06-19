# telegram-bot-logger

The bot sits in the chat and remembers who said what and when. Allows you to view past versions of messages and deleted
messages. Allows you to find everything that a certain author said in a certain time interval.

## Technologies

- ``Java 17``
- ``Spring Boot``
- ``Spring MVC``
- ``Spring Data JPA``
- ``Hibernate``
- ``PostgreSQL``
- ``Gradle``
- ``Lombok``
- ``Intellij Idea for IDE``

## Functionality

- ``/getmessages`` - returns all messages of the user who sent the request
- ``/getmessages [username]`` - returns all messages of the selected user
- ``/getmessages [username] [start_date] [end_date]`` - returns all messages of the selected user by period 
