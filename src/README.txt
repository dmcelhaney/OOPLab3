For Lab 4 I will be implementing the Facade and Template Method Patterns.
These will reduce the complexity of my code and make it more reusable.
I am going to add a Facade class to simplify the JFreeChart code. I am going to use the Template Method Pattern to read the player's file.
Created the ChartFacade class to call JFreeChart createBarChart method that simplifies the call in the PlayerChartPanel class.
Created the abstract FileReader class and CSVFileReader class that extends FileReader.
This will allow for us to add another type of FileReader (e.g. excel document reader) that extends FileReader if needed in the future.