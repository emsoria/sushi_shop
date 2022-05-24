# sushi_shop

Presented in this repository is my incomplete implementation of the "Sushi Shop Project".

Firstly I enjoyed the chance to learn about and experiment with new technologies such as Spring Boot and H2. Unfortunately I was not able to finish and I would like to explain my vision for the project, if I had been familiar with the Spring Boot framework and the H2 database engine:

1. I was not able to implement serialization & de-serialization of the JSON objects in time but I would have kept looking for a suitable library that would be able to appropriately handle this functionality (in a REST-safe manner).

2. Ideally, I would have used a combination of Event Handling and multi-threading to allow the server to handle orders in (near) real-time. However I could not familiarize myself with these libraries/funcionalities in time, so I decided to implement a solution where the passage of time and its implications (i.e. changing states etc), would occur when someone calls an endpoint. I recognize that this is, of course, is a flawed solution but I believe it was a good compromise given the constraints.

3. Lastly, I would have implemented appropriate error-handling and input validation - both for the endpoints and the underlying data structures. I considered the (de)serialization of JSON and creation of the CRUD endpoints to be a bigger priority and, sadly, did not get around to it. I appreciate the value and importance of clean (& functional code) and I would take efforts to ensure that the code I produce would be exactly that: well-tested and safe.
