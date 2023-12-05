# Solution for the home assignment

The task doesn't contain information, which format support the client side.
My assumption: a common approach for REST API is JSON. So, clients will receive data in a JSON format.
There are two transformation steps:
- After parsing our CSV file every line of it is converted to POJO - Player.
- When an application gets a request this POJO is converted to JSON object.

To pars CSV I used opensource OpenCVS library.

The task doesn't contain information whether the contents of the CSV file can change.
My assumption: it has a static content.
So, I implemented in-memory cache into my application. For different request there are three caches. By caching mechanism the application reduce number of disk accesses and improve time of response. On the start of the application scheduled method populates all data from CSV file into in-memory cache.

Since the number of records in the CSV file is large, transmission of the response between server and client may take a significant amount of time.  In this case, the correct approach for the client is to request not all data, but separate blocks of data. The task doesn't contain information if the client support pagination.
My assumption: the client can implement pagination. So I implemented on server side support for limit and offset. Accordingly, the client can additionally send a limit and offset in the request.

The code has a coverage with unit tests. But it isn't 100% because time limit.

The application source code I pushed to my GitHub repositor
https://github.com/david-izhak/csv-rest-api

This repository contains Docker file. It can be used to build Docker image. The CSV file is part of this image.
So, this application can be run in Docker or it can be deployed to Kubernetes like a deployment. Because the CSV file is a part of the Docker image this application doesn’t need PersistentVolume.
I pushed this Docker image to my Docker hub repository. To get this image use next command:
docker pull davidizhak/csv-rest-api:latest

To run this application in Docker use next command:
docker run -p 8080:8080 davidizhak/csv-rest-api:latest

It runs on port 8080. So, to get data use next URL: 
http://localhost:8080/api/players
http://localhost:8080/api/players?limit={10}&offset={50}
http://localhost:8080/api/players/{playerID}


