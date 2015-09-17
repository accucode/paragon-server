=======================================
== Introduction
=======================================

This is where we put libraries needed at runtime; i.e.: by Tomcat.

    $project/web/WEB-INF/lib

Note: the application jar file (app.jar) is not included here.
In development the app.jar is typically NOT generated.  Instead,
javac is directed to output class files directly to:

    $project/web/WEB-INF/classes

This way tomcat can be rapidly started without having to re-jar
all of the classes every time.  A process that can become slow
on large projects.

=======================================
== Libraries
=======================================

MySql JDBC Connector

    Use:    Database
    From:   http://www.mysql.com/
    Lic:    GPL
    Last:   12/16/2014
    
        mysql-connector-java-5.1.34-bin.jar

Apache Commons

    Use:    Various
    From:   http://commons.apache.org/
    Lic:    Apache 2.0
    Last:   12/16/2014
    
        commons-codec-1.10.jar
        commons-collections-3.2.1.jar (older version required for Velocity 1.7)
        commons-collections4-4.0.jar  (newer version uses a different package to avoid conflicts)
        commons-fileupload-1.3.1.jar
        commons-io-2.4.jar
        commons-lang-2.6.jar    (older version required for velocity 1.7)        
        commons-lang3-3.3.2.jar (newer version uses a different package to avoid conflicts)       
        commons-logging-1.2.jar

Apache HTTP Components

    Use:    Http, servlet tools.
    From:   http://hc.apache.org/
    Lic:    Apache 2.0
    Last:   12/16/2014
    
        httpcore-4.3.3.jar
        httpclient-4.3.6.jar

Apache Logging

    Use:    Standard logging.
    From:   http://logging.apache.org/log4j/1.2/
    Lic:    Apache 2.0
    Last:   12/16/2014
    
        log4j-1.2.17.jar

Java Mail

    Use:    Email (smtp) interface
    From:   http://www.oracle.com/
    Lic:    Oracle
    Last:   12/16/2014

        mail-1.4.7.jar

Amazon Web Services

    Use:    Java wrapper interface for AWS SDK.
    From:   http://aws.amazon.com/sdk-for-java/
    Lic:    Apache 2.0
    Last:   12/16/2014    

        aws-java-sdk-1.9.11.jar

EnterpriseDT FTP

    Use:    FTP library
    From:   https://enterprisedt.com/products/edtftpj/
    Lic:    LGPL 2.1
    Last:   12/16/2014    

        edtftpj-2.4.0.jar

The Simple API for CSS (SAC)

    Use:    Used to parse css files.
    From:   http://www.w3.org/Style/CSS/SAC/Overview.en.html
    Lic:    W3C
    Last:   12/16/2014    

        sac-1.3.jar

Css Parser

    Use:    Used to parse css files.
    From:   http://cssparser.sourceforge.net/
    Lic:    LGPL
    Last:   12/16/2014    

        cssparser-0.9.14.jar

Bean Shell

    Use:    For live ad hoc debug scripting in production.
    From:   http://www.beanshell.org/
    Lic:    LGPL
    Last:   12/16/2014    

        bsh-2.0b2.jar

Simple JSON

    Use:    Used to format and parse json.
    From:   https://code.google.com/p/json-simple/
    Lic:    Apache 2.0
    Last:   12/16/2014    

        json-simple-1.1.1.jar

JFree Chart

    Use:    Generate chart images with server side code.
    From:   http://www.jfree.org/jfreechart/
    Lic:    LGPL
    Last:   12/16/2014    

        jcommon-1.0.23.jar
        jfreechart-1.0.19.jar

Hibernate

    Use:    Object relational mapping to mySql (ORM)
    From:   http://hibernate.org/orm
    Lic:    LGPL
    Last:   12/16/2014    

        antlr-2.7.7.jar
        dom4j-1.6.1.jar
        hibernate-commons-annotations-4.0.5.Final.jar
        hibernate-core-4.3.7.Final.jar
        hibernate-jpa-2.1-api-1.0.0.Final.jar
        jandex-1.1.0.Final.jar
        javassist-3.18.1-GA.jar
        jboss-logging-3.1.3.GA.jar
        jboss-logging-annotations-1.2.0.Beta1.jar
        jboss-transaction-api_1.2_spec-1.0.0.Final.jar

Hibernate (optional c3po libs)

    Use:    Connection pooling for hibernate
    From:   http://hibernate.org/orm
    Lic:    LGPL
    Last:   12/16/2014    

        c3p0-0.9.2.1.jar
        hibernate-c3p0-4.3.7.Final.jar
        mchange-commons-java-0.2.3.4.jar

Velocity Templates

    Use:    Used for templates and code generation.
    From:   https://velocity.apache.org/
    Lic:    Apache 2.0
    Last:   12/16/2014    

        velocity-1.7.jar












activation.jar
    java activation framwork (jaf) 1.1.1

jsch-0.1.32.jar (used to allow SSH access)

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
    
    
    
    
    
    

antlr-2.7.6.jar
apache-mime4j-0.6.jar
asm-attrs.jar
asm.jar
avalon-logkit-2.1.jar
aws-java-sdk-1.6.12.jar
axis-ant.jar
axis.jar
bsh-2.0b4.jar
c3p0-0.9.5-pre10.jar
cglib-2.2.jar
checkout-sdk.jar
commons-beanutils-1.8.0.jar
commons-codec-1.3.jar
commons-collections-3.2.1.jar
commons-digester-1.7.jar
commons-discovery-0.2.jar
commons-fileupload-1.2.1.jar
commons-io-1.4.jar
commons-lang-2.4.jar
commons-logging-1.1.jar
cssparser-0.9.7.jar
dom4j-1.6.1.jar
edtftpj-1.5.3.jar
ejb3-persistence.jar
hibernate-memcached-1.4-SNAPSHOT.jar
hibernate3.6.5.jar
httpclient-4.3.1.jar
httpcore-4.3.jar
httpmime-4.0.1.jar
iText-2.1.7.jar
jackson-annotations-2.2.3.jar
jackson-core-2.2.3.jar
jackson-databind-2.2.3.jar
jasperreports-3.7.1.jar
javassist-3.12.0.GA.jar
jaxrpc.jar
jcommon-1.0.16.jar
jdom-1.0.jar
jfreechart-1.0.13-experimental.jar
jfreechart-1.0.13-swt.jar
jfreechart-1.0.13.jar
jsch-0.1.32.jar
json_simple-1.1.jar
jta-1.1.jar
junit-4.1.jar
log4j-1.2.14.jar
mail-1.4.4.jar
mchange-commons-java-0.2.8.jar
oro-2.0.8.jar
qdox-1.6.3.jar
saaj.jar
sac-1.3.jar
slf4j-api-1.6.1.jar
slf4j-log4j12-1.6.1.jar
spymemcached-2.10.3.jar
velocity-1.6.3.jar
werken-xpath-0.9.4.jar
wsdl4j-1.5.1.jar
xmlsec-1.4.0.jar