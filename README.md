# Wildlife tracker

### Description

Wildlife tacker is An application that allows Rangers to track wildlife sightings from  a nearby forest of Douglas Fir to keep track on the animals and their location, age and health.

### Author

Fiona Wangui.

### Contact information

fiona.maina@student.moringaschool.com

### Demo
Here is a working live demo : 

## Technologies used
* Java.
* Spark.
* Gradle.
* Maven.
* Bootstrap.
* JUnit.

##### Setup instructions

To set up this project:

* Clone the repository by executing the following command in your terminal in the directory of your choice -  git clone https://github.com/Wanguifiona/Wildlife-Tracker
* Navigate into the hero-squad directory - cd wildlifetracker

* Build project

##### Installing
* After cloning to your local machine navigate to the folder you cloned into and open it with intellij.

* Navigate into the src/main/java/App.java and click run in intellij.

* Go to your browser and type localhost:4567

#### Create SQL
psql

CREATE DATABASE wildlife_tracker;

CREATE TABLE animals (id serial PRIMARY KEY, name varchar,health varchar,age varchar, type varchar);

CREATE TABLE sightings (id serial PRIMARY KEY, animalid int,location varchar,rangername varchar,lastseen timestamp);

CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;


##### Build with

* Java - The language used for project.

* Intellij Idea - Intergated development

* Spark - Framework.
 
* Postgressql

## Known bugs

If you find a bug the website couldn't handle the query and or gave undesired results),kindly open on issue here by including your search query and the expected result.

If you'd like to request a new function, feel free to do so by opening an issue here. Please include sample queries and their corresponding results.

### License

*MIT*
Copyright © 2021 *Fiona Maina*

Permission is hereby granted, free of charge, to any person obtaining a copy of this software associated documentation files (the “Software”), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute,sublicense,and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS APPROVED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY , FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORs OR COPYRIGHT HOLDER BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
