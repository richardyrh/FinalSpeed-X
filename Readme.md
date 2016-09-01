#Read Me

**FinalSpeed-X** is a extended support project for FinalSpeed Java Client originally written by d1sm which was discontinued. FinalSpeed-X is mainly based on the code of FinalSpeed 1.12.

###The client is a very early version. It's usable, but there are lots of bugs and known issues.

> *Please note that the current version is only tested using Mac OS X El Capitan. Performance on other systems may be unpredictable.*  
> *Although currently the project does contain code for server, it may not function correctly. Use separate server jar.*

##How to Build
Download the code or clone to a local directory then  import it using Eclipse (Haven't tested other IDEs yet). **JDK 1.7** is recommended for best compatibility. Right click on the imported project, click on Configure Build Path, then add in the external jars included in the directory.
> Since I haven't pack some of the libraries into jars or remove unused references for the convenience of debugging, there may be lots of source files and redundant code.

Create a run configuration and make the main class `FSClient` under `net.fs.client`

##Note
Start a ping session to the server that shall be boosted before opening the client. There're still lots of UI issues that needed to be solved.

##Known Issues
* Unless manually start up a ping thread, the client won't be able to find a usable TCP network interface.
* Encoding problems making characters show weirdly.
* Both English and Chinese translation is not complete.
* The boost list may behave strangely, such as not highlighting the chosen item.
* There are no root privelege detection for Mac/Linux yet.
* You'll have to manually change `testIp_tcp` under method `detectMac_tcp()` in the class [`capEnv.java`](src/net/fs/cap/CapEnv.java).

##Update Log
Can be found under the same directory as this readme file, or click [here](Edit Log.md).