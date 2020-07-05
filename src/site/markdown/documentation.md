# Technical Writer: Documentation

All documentation is handled by the [Maven Site Plugin](https://maven.apache.org/plugins/maven-site-plugin/). 

## Overview

> Hint: Documentation is written in markdown format.  See [markdown cheatsheet] (https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet) for more details on how to use markdown in your documentation files. 

---

Markdown serves as the basic format from which HTML documentation can be generated automatically. You always maintain your documentation in Markdown and use the build management tool called Maven to generate HTML-based documentation.

The sources for the documentation are in the source folder **site** and with *mvn site* the HTML documentation is generated. 

>Try it out!  mvn site

The final HTML documentation is in the directory **target/site** (Open the HTML Page in the directory *target/site*). If you encounter problems during the generation of the documentation try *mvn clean site* which cleans all output directories first and generates the documentation afterwards. 

> mvn clean site

## site.xml

The **site.xml** file is the central configuration file for the site documentation of your project. 

```
<?xml version="1.0" encoding="ISO-8859-1"?>
<project name="User Management">
  
  <bannerLeft>
    <name>Software Engineering @GIB</name>
    <src>images/logo.gif</src>
    <href>http://maven.apache.org/</href>
  </bannerLeft>
  <bannerRight>
    <src >images/31604sm.png</src>
   </bannerRight>
  
  <body>
    <links>
      <item name="GIB" href="http://www.htwg-konstanz.de/gib" />
    </links>

    <menu name="Swen 1 - Demo Project - User  Management">
      <item name="Description" href="index.html"/>
      <item name="Documentation" href="documentation.html"/>
      <item name="Cloud deployment" href="cloud.html"/>
      <item name="Road Map" href="roadmap.html" />
    </menu>

    <menu ref="reports"/>
  </body>
</project>
```

If you want to add another documentation file (e.g. installation instructions), 

1. create a file **installation.md**, 
2. save this file in the *site* directory of your project; 
3. create an entry in the *menu tag* in the *site.xml* file and make sure you put the *HTML link* into the *item* tag there.

## directory site

In the directory site you store all information about the documentation - project documentation, .... The directory site is located in the src-folder of your project.

![Site directory][site]

In the figure you get an overview of the files stored in the site folder. The source files are typically located in the markdown folder and the images in the resources/images folder. The **mvn site** or **mvn clean site** command then generates a hypertext of documentation from these source files and images automatically.



## Referencing images

Below you find the *src-code* in markdown for the above documentation.

```
![Site directory][site]

In the figure you get an overview of the files stored in the site folder. The source files are typically located in the markdown folder and the images in the resources/images folder. The **mvn site** or **mvn clean site** command then generates a hypertext of documentation from these source files and images automatically.


[site]: images/10-site.png
```

Be aware that the **resources** folder is not part of the path qualifying the image (e.g. images/10-site.png).


[site]: images/10-site.png

# Terminal commands

Start a terminal first:

1. **cd foo** - changes the current working directory to the directory named `foo`
2. **pwd** - display the current working directory on the console/terminal window.
3. **mvn compile** - assuming you have installed the maven package you will compile the current project by using the build management tool maven.

See https://www.techrepublic.com/article/16-terminal-commands-every-user-should-know/ for a description of the most used terminal commands.

# Installations

## Maven

Install Maven on your computer. Maven is pre-installed on the lab's machines. At http://maven.apache.org you will find the necessary information to download for your computer (Windows, MacOs).  

Under MacOs I recommend you to install a package manager. At https://brew.sh/index_de install the package manager *homebrew* first. Then use the command **brew install maven** on your computer and install Maven automatically. Finally, test your installation with the **mvn -version** command.



