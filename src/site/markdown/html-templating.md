# HTML Templating Engine in Quarkus

> Describe in your own words the templating engine *Qute* in quarkus.io - See (https://quarkus.io/guides/qute) for a more detailed description.
## Own Description
In JAX-RS applications it is possible to use the Qute Templating Enginge from Quarkus. Before using it, you have to add the extension to the pom.xml and then you are ready to start. In the resource class you can inject new templates, which you have created in the *templates* directory. After the specific function is called, a new template instance is going to start with customized data or information.

> You include a detailed description of a working example (REST Endpoint, HTML Output) in your cloud-application. 
## Working Example
### Rest endpoint
Our app consists of a *list of patients*. How do the patients know who is called to the doctors room? In the *PatientResource* class we inject a new template into the *public TemplateInstance callPatient(@PathParam("id") Integer id)*. We added the attribute *called* to the *Patient* class and overload the constructor of *PatientData* class to fit our needs.
### HTML output
After calling the function *./call{id}* ({id}=[0-9]) in the webbrowser the new list shows a new template instance with the new attribute *Aufgerufen* at the end of each patients row. In this way, the called patient (indicated with *true*) knows he now can enter the doctors room. 

> See [markdown cheatsheet] (https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet) for documenting the features in markdown.
