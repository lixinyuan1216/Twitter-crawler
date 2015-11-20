# Twitter-crawler
A simple crawler based on Twitter API. It includes both front end web application and background end database design and implementation. 

For the database part, twitter profiles (content, location, time) related to some interesting topics for five cities will be harvested via API. MAP/REDUCE is applied to avoid duplicates. The content attribute is used to make a sentiment analysis, which is based on a library from Stanford (http://nlp.stanford.edu/sentiment/code.html). The "time" attribute is used to get the weather situation in specific time, which is based on API from "worldweatheronline".

For the web application part, AJAX and Google Chart JS library is necessary to make function proper work. Asynchronous refresh via AJAX is applied to avoid frequent whole page refresh. 

