--------------------
Themes
--------------------
The css and images used to support multiple themes.


--------------------
Stylus
--------------------
http://stylus-lang.com/
We use Stylus to provide css preprocessing. Most of the styles
are defined in .styl files that are compiled into a single .css
file.

Stylus Compression Hack
The css generated by stylus is compressed, so empty elements
are ignored. However, we parse the resulting .css file in order
to generate some of the Java tooling. As a workaround we include
an extra css tag for elements that would otherwise be empty.
This ensures that the css selector is included in the generated
.css without doing anything that really affects the ui.
We use "content: normal" as the placeholder style.


--------------------
Component files
--------------------
There are thousands of lines of css definitions. To improve
maintainability, the css has been organized into smaller
files of related components.

Most of the styles are located in THIS folder; that is, the
folder container the _README you are currently reading. Stylus
allows the use of import/requires and the 'all.styl' file
includes all of the various elements in the correct sequence.


--------------------
Theme files
--------------------

