====================
How to release
====================
1)
Create SourceForge Shell
http://sourceforge.net/apps/trac/sourceforge/wiki/Shell%20service

ssh -t <sourceforgeuser>,fornax@shell.sf.net create

2)
mvn -PRELEASE release:prepare
3)
mvn -PRELEASE release:perform -Dsfuser=<sourceforgeuser>
4)
mvn release:clean



====================
plugin.xml
====================
A plugin.xml has been copied to src/main/resources/META-INF/maven. This descriptor will be generated
automatically when packaging the plugin. The one checked in is for testing purposes. It is required
when you try to execute the plugin with m2e workspace resolution. From time to time it should be copied
from a packaged Jar.
