====================
How to release
====================
1)
Create SourceForge Shell
http://sourceforge.net/apps/trac/sourceforge/wiki/Shell%20service

ssh -t USER,fornax@shell.sourceforge.net create

2)
mvn -PRELEASE release:prepare
3)
mvn -PRELEASE release:perform
4)
mvn release:clean

