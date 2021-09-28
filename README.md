This is a readme file for this automation Framework - Ariat Resgression Project 
The project is structured into more packages and classes. All the main classes and enums are in src/main/java, the resources like files and TestNG suite xml files are kept in src/test/resources
and the TestNGs tests are kept in src/test/java.
The pom xml file is actually the one that will be collected by the job in Jenkins, everything that is under src/test/resources will be built.
pom xml files contains all the dependencies that are used in this project like: testNg, selenium, webdriver, maven compiler, maven plugin, etc.. (you need to download the resources)
Each page from the application has his corresponding class page, for list of country a switch of list of Home Page classes is defined.
All the steps are defined in txt files in src/test/resources called Test Steps folder.

How to clone the project ?

In your workspace you need to run the following command: 
git clone (ssh/url of the repository) and the project will be downloaded on your local machine.
If you need to implement new tests you will have to create a new branch from master and then create a pull request for it to be merged with master.
After the pull request is approved then the changes will be merged with master branch.

Who to talk to ?

Aila Bogasieru
Email: 
aila.bogasieru@gmail.com
