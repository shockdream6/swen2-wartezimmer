# Digitaler Warteraum
​
## Dokumentation
​
### mvn site
​
Es wird eine HTML Dokumentation erzeugt, indem man "mvn site" im Terminal eingibt. Im 
Anschluss werden diese HTML generiert und heruntergeladen, diesen Prozess kann man 
auf dem Terminal beobachten.
Den Terminal kann man öffnen, indem man auf das Projekt mit der rechten Maustaste draufklickt und dann "Show in local terminal" auswählt und dann "Terminal".
​
### mvn clean site
​
Da es einige Errors beim Generieren erzeugt hat, habe ich mit dem Befehl "mvn clean site" 
mein Ausgabeverzeichnis gesäubert und die Dokumentation dann erstellt.
​
###site.xml
​
In der site.xml-Datei ist die zentrale Konfigurations-Datei für die Dokumentation unseres
Projektes, ich habe hier auch noch eine neue Dokumentationsdatei "installation.md" erzeugt, in diesem können weitere Instruktionen hinterlegt werden.
Ich habe in der site.xml-Datei einen neuen Eintrag erstellt, hier in diesem Beispiel 
"Google" und habe den dazugehörigen Link beigefügt.
​
###directory site 
​
In der directory site werden alle Angaben und Dokumentationen rund um das Projekt hinterlegt. Diesen file habe ich im src/site-Pfad erstellt und dort die Dokumentation
hinterlegt.
​
### Referencing images
​
Während die source-Dateien im "markdown"-Ordner hinterlegt sind, sind die Bilder in "images" hinterlegt. So ist auch 10-site.png dort hinterlegt (der "ressources"-Ordner sollte dabei nicht Teil des Pfads sein).
​
###Terminal commands
​
Man kann verschiedene Befehle in der Konsole ausführen, diese werden durch Kürzel 
in der Konsole angegeben. 
Mit cd "..." kann man seine derzeite directory ändern und damit in "..."-directory springen. Beispielsweise "cd" und dann das Verzeichnis, in dem das Projekt hinterlegt ist; Dadurch springt man direkt in dieses Verzeinis rein. 
​
Der Befehl "pwd" funktioniert leider bei mir nicht (und auch allgemein bei Microsoft nicht), dieser Befehl wird hauptsächlich bei Linux genutzt. Bei Microsoft wird lediglich "cd", gefolgt von der Eingabe in die Konsole getippt, um somit das aktuelle Verzeichnis anzeigen zu lassen.  
​
Durch "mvn compile" kann man das Projekt compilen, in dem man maven nutzt (Voraussetzung ist, dass man maven installiert hat).
In dem ich "mvn compile" als Befehl im Terminal eingegeben habe, konnte ich das Projekt compilen.
​
###Installations
​
Maven wurde bereits im Rahmen der ersten Abgabe "CloudFirst" heruntergeladen und installiert.
​
###Projektbeschreibung 
​
Einen groben Überblick über unser Projekt und auch eine kurze Beschreibung dazu findet man in der "index.md".
​
###index.html im Browser öffnen 
Nachdem man mit der Eingabe "mvn-site" einen Hypertext zur Dokumentation erstellt hat, kann man mit dem Befehl "mvn site:stage -DstagingDirectory=C:\swenprojekt" im eigenen Verzeichnis einen swenprojekt-Ordner erstellen. In diesem erstellten Ordner befindet sich die "index" Datei, diese kann man nun über den Browser aufrufen. Diese ist ähnlich aufgebaut, wie die homepage "maven.apache.org".
​
### target ordner erstellt
Nachdem wir mit mvn site einen Hypertext erstellt haben, war der target Ordner jedoch leer geblieben. Erst einem Refresh, hat dieser die Inhalte angezeigt.
​
### Quellcode Dokumentation - Java doc
Man kann die Quellcode Dokumentation unter der index.html Datei finden. Dafür geht man unter localhost:8080 auf "Project reports", wählt bei den Dokumenten "Javadoc" aus und kann dann in den jeweiligen Klassen, z.B. die "Patient"-Klasse aufrufen und kann dort die erstellte Java doc einsehen. 

###Gender
Eine Gender-Klasse erstellt, bei der eine Aufzählung von Geschlechtern angegeben sind: darunter fallen weiblich (FEMALE), männlich (MALE) und ein weiteres Geschlecht (DIVERS).

###WaitingStatus
Eine WaitingStatus-Klasse erstellt, bei der eine Aufzählung an verschiedenen Status gibt, in welchem sich der Patient befindet. 
Diese sind aufgeteilt in: WAITING, CALLING, EXAMINING und DISCHARGED.

###Patient

Anpassungen in der Patientenklasse. Dem Patienten werden folgende Attribute zugeordnet: eine PatientenID, eine Wartenummer, der Vor- und Nachname, das Geschlecht, das Geburtsdatum, der aktuelle Status auf der Warteliste, wann der Patient beginnt zu warten und wann diese Wartezeit endet. Die Spanne in dieser Wartezeit wird ebenfalls gemessen.