Introduction
======================

# Purpose
The purpose of this document is to provide a brief introduction
to the main tools and considerations for someone new.


# Java
The application is primarily written as a hosted Java server.

The coding style is focused on clarity and long-term maintenance
of complex projects that involve hundreds of interconnected 
domain models, and that require decades of active maintenance
and enhancements. 


# Threading
The application server is designed as a multi-JVM, multi-threaded
application. However, although we support a multi-threaded servlet
container, we do assume that each HTTP request is bound to a single
thread until the the request is complete. Also, that thread cannot
be used for other HTTP requests until the current request is complete.
This is the traditional model for Tomcat and is still the default as
of Tomcat 8. The tools used in this distribution will not work correctly
if a thread is shared between multiple overlapping HTTP requests.


# Hosting
The application is designed to be hosted at Amazon (AWS). More 
specifically, we use Amazon's Beanstalk environment and try to 
minimize the complexity of the hosting.


# Multi-Tenant
The application is designed as multi-tenant. Tenants share the same 
servers and database, but their client access is separated by use
of distinct urls. For example, the default "system" tenant used to
bootstrap the application in development uses the host: system.locahost.
If a second tenant is added for "Sample" it may be assigned the host:
sample.localhost.

In this multi-tenant environment, almost everything is assigned to a
specific tenant. 
 

# HTML5
Users interact with the application via web browsers and HTML5.
Most web browsers after 2015 should be compatible. However, testing
is limited to current versions of IE and Chrome. 


# Single Page App
The user experience is delivered as a Single Page App (SPA).
This means that the client browser loads and initial page that
acts as a shell. Thereafter, all interactions between the client
and server are handled as AJAX requests.  
 

# CSS
The CSS is defined using Stylus files (*.styl). The .css files
are automatically converted into .css using an ant script that
executes when the file is saved. The resulting CSS is parsed
and used to generate helper classes in Java so that the application
never needs to rely on string literals. 


# Database
We rely on a Relation Database, and expect the use of MySql.

The database is used as a relatively simple data store. 
That is, are use of the database is primarily limited to
standard crud operations: insert, select, update, delete.

We do NOT use any stored procedures.
We do NOT use any database contraints (except unique indexes).

All business logic and data validation is assumed to be handled
in the application layer.


# Hibernate
We use Hiberate for Object-Relational Mapping (ORM) between the
Java application and the relational database. 

Additionally, we rely on a number of helper classes. The goal
is to write database access code in such a way that it can 
be checked by the compiler for correctness.

For more on hibernate, see hibernate.md. 


# Audit Log
This application includes a detailed audit log of all changes
made to domain models. For example, if you edit a customer, 
the audit log will record who changed it, when it was changed,
and the specific attributes that were modified. 

The audit log is stored as additional tables and records in 
the database, and is integrated as an Hibernate interceptor.
This allows a very robust and generic solution that requires
minimal maintenance.
 
The audit log is recorded as part of the database transaction.
This ensures the audit log is synchronized with the business 
model, but it also significantly increases the overhead of each
transaction. Updating a single customer record may require the
insertion of multiple records into the audit log.


# Business Model
The business model is defined in a series of model definition files.
These files are then used to auto-generate almost all of the boilerplate
tools for POJOs, database criteria, and other stuff. 


# STF Files
The model definition files are in a .stf format. This is structurally
similar to XML but are simpler to read and edit by hand. The project
includes a number of samples, and the parser is built into the tooling.

The samples are identified with the extension: .stf
The parser is: KmStfParser.java


# Logging
We use Log4J to manage logging. Logging is relatively simple but can 
be easily extended as needed. One notable point is that this app
includes a Log4J interceptor that writes all logs to the database.

 
# [end]
