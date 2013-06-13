This is where we put libraries need at runtime; i.e.: by Tomcat.

Note: the application jar file (app.jar) is not included here.
In development the app.jar is typically NOT generated.  Instead,
javac is directed to output class files directly to:

    $project/web/WEB-INF/classes

This way tomcat can be rapidly started without having to re-jar
all of the classes every time.  A process that can become slow
on large projects.


jsch-0.1.32.jar (used to allow SSH access)

mail.jar
    java mail 1.4.1

activation.jar
    java activation framwork (jaf) 1.1.1

http client, apache commons
    httpclient-4.0.1.jar
    httpmime-4.0.1.jar

sac-1.3
	w3c standard interface for CSS parser
	http://www.w3.org/Style/CSS/SAC/
	Open
	
cssparser-0.9.7.jar
	Css parser
	http://cssparser.sourceforge.net/
	GNU Lesser General Public License.