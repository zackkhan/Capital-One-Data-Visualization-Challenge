In the spirit of the Halloween season,as well as in honor of the mascot of Capital One’s hackathon API Nessie,
I decided to visualize data on mythical creature sightings across the globe. I focused on the three most popular mythical creatures: 
Bigfoot, Chupacabra and the Loch Ness Monster (Nessie). I downloaded a KML file from the Bigfoot Field Researchers Organization (BFRO) 
containing data for all reported Bigfoot sightings (hundreds of reports were included, link: http://www.bfro.net/news/google_earth.asp), 
as well as the KML file for Chupacabra sightings found at (https://www.google.com/maps/d/viewer?mid=112xMhmWH276-yP8Ndzvs_eAGuss&hl=en_US)
. Finally, for Nessie, I simply found the coordinates of lake Loch Ness where he resides. I then changed the file extensions from KML to
XML, then used Microsoft Excel to extract the longitude and latitude data and saved the longitude and latitude data into separate txt
files. Finally, I developed a java program that creates a JSON file by grabbing the longitude and latitude values from the txt files, 
based off the format of the population909500.json provided in the initial WebGL globe example. Since each dataset did not have an equal 
number of data points, I entered data points of magnitude 0 and coordinates (0,0) in order for the JSON file to be compatible with the 
globe program. Within the Java program, which is also included in the Github Repo, I utilized the Scanner class alongside the FileWriter
class to read through the longitude and latitude files and create the JSON file. 

Video Explanation: https://youtu.be/QL1wdtM9YGc 
Live Application: https://zackkhan.github.io/globe/index.html 

