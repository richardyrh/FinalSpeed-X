#Read Me

**FinalSpeed-X** is a extended support project for FinalSpeed Java Client originally written by d1sm which was discontinued. FinalSpeed-X is mainly based on the code of FinalSpeed 1.12.

###The client is a very early version. It's usable, but there are lots of bugs and known issues.

> *Please note that the current version is only tested using Mac OS X El Capitan. Performance on other systems may be unpredictable.*  
> *Although currently the project does contain code for server, it may not function correctly. Use separate server jar.*

##How to Build
Download the code or clone to a local directory then  import it using Eclipse (Haven't tested other IDEs yet). **JDK 1.7** is recommended for best compatibility. Right click on the imported project, click on Configure Build Path, then add in the external jars included in the directory.

Create a run configuration and make the main class `FSClient` under `net.fs.client`

##Note
Due to the complicated dependencies and my limited abilities, I'm not spending time to try delete some server classes since sometimes they share a same component class with a client.

### Why did I translate the project into English?
>面向国际社会，你们还要多学习一个  
>有时间弄多语言

##Known Issues
* Encoding problems making characters show weirdly.
* Both English and Chinese translation is not complete.
* There are no root privelege detection for Mac/Linux yet.
* The icon won't show properly under OS X dock.

##Update Log
Can be found under the same directory as this readme file, or click [here](Edit Log.md).