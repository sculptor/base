====================
Building from source
====================
This project uses a plugin from an external repository. This repository is 
configured in the profile 'RepositoryManagement' which is not activated by
default. On first time execution you should therefore activate this profile
and run:
   mvn -PRepositoryManagement clean install
