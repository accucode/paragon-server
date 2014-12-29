Hibernate
=========

    This project utilizes Hibernate for Object Relational Mapping (ORM).
    In short, hibernate provides an interface layer between the server-side
    java application and the relational database.
    
    http://hibernate.org/

    
License
========

    Hibernate is dual licensed under either the LGPL or ASL.
    In short, this means we can use it for commercial projects.
    
    http://hibernate.org/community/license/


Auto-gen
========

    On top of the core hibernate library, we generate our own layer
    of code.  The code generation allows us to more safely and easily
    write complex queries.
    
    For example, suppose we have model where each Order is associated
    with a single Customer, and each Order contains a list of Lines.  
    Finally, each Line is associated with a single Product.  In short:
        Customer -->* Orders -->* Lines -->1 Product
        
    Then we can write type-safe, compile-time checked code like this:
    
        E.g.: 
            MyLineCriteria c;
            c = new MyLineCriteria();
            c.whereQuantity().is(5);
            c.joinProduct().whereActive().isTrue();
            c.joinOrder().whereCreatedDate().isAfter(someDate);
            c.joinOrder().joinCustomer().whereName().is("Johnson");
            List<MyLine> v = c.findAll();


.stf files
==========
    
    Code generation is primarily based on model definition files.  The
    model files are located here:
    
        $project/web/WEB-INF/resource/generator/config/model/data/
        
    The model files are formatted as "simple text format" (.stf).
    The stf files are structurally similar to xml, but formatting in a 
    way that is (hopefully) easier to read and edit by hand.    

Auto-save
=========
   
    Hibernate automatically saves any changes to domain models.
    If you retrieve a model from the database and modify it, those 
    changes will be automatically saved when the transaction finishes.
    
    You do NOT have to call "save" every time you make a change.


Attaching Models
================

    Hibernate does not attempt to save every instance to the database.
    To begin saving a particular instance you must tell hibernate about
    that instance the first time.  This is typically done with the 
    convenience method saveDao().  As in:
    
        MyUser e;
        e = new MyUser();
        e.setName("John Doe");
        e.saveDao();
        
    Once the instance has been attached to hibernate, any subsequent changes
    will be automatically persisted without needing to call save again.
    
Deferred SQL
====================

    In many cases, Hibernate does NOT execute sql immediately.  When
    possible, Hibernate defers multiple updates until the end of the 
    transaction and then runs then all at the same time.

Caching, first-level
====================

    One of the advantages of using Hibernate is automatic caching.
    The first type of caching occurs WITHIN a single transaction.
    Between the *begin* and *commit* hibernate caches all instances
    that are retrieved from the database.  This means that you are 
    guaranteed that the following is always true:
    
        MyProduct a = hibernate.findProductByKey("123");
        MyProduct b = hibernate.findProductByKey("123");
        System.println(a == b); // always true.
    
Caching, second-level
=====================

    Hibernate supports a second level cache that works across transactions.
    However, to use this you must either: 1) use a single server, 2) set
    up cross-server caching.  This is disabled by default.
    

Order of Operation
==================

    There is generally little to no relationship between the order in which
    you make changes, and the order in which Hibernate executes the SQL.
    In most cases, this shouldn't matter.  

    HOWEVER... there are some cases where this is important.
    

Inserts before Deletes
======================

    Deletions are NOT guaranteed to be performed before inserts.  We don't
    usually do a lot of deletions so this rarely matters.  However, suppose
    you have a modeled a 1-to-many relationship between Products and 
    Categories, with a unique key constraint that ensures each Category
    is not assigned to the same Product more than once.  The following code
    will crash since the inserts actually occur before the deletes.
    
        aProduct = fetchFromDatabase();
        aProduct.getCategories().clear();
        aProduct.addCategories(newCategories);

    One way to solve this is to simply "flush" the changes after you clear
    the list, and before you add the new categories.  Note: a flush is
    NOT the same as a commit.
    
        aProduct = fetchFromDatabase();
        aProduct.getCategories().clear();
        hibernateSession.flush();
        aProduct.addCategories(newCategories);

    Alternatively, you must rewrite the code such that you avoid inserting
    seemingly duplicate categories prior to the sql deletions.  In some 
    cases this is simple and/or a lot more efficient.  In other cases, its
    just a lot of hassle and you're better off just manually forcing the
    flush.

[end]
