#Read Me

**FinalSpeed-X** is a extended support project for FinalSpeed Java Client originally written by d1sm which was discontinued. FinalSpeed-X is mainly based on the code of FinalSpeed 1.12.

###The client is a very early version. It's usable, but there are lots of bugs and known issues.

> *Please note that the current version is only tested using Mac OS X El Capitan. Performance on other systems may be unpredictable.*  
> *Although currently the project does contain code for server, it may not function correctly. Use separate server jar.*

##For Non-Developers
Download the zip, then run the client using  
*For Mac/Linux Users*  
>If you haven't installed libpcap, install it first.
	
	sudo java -jar FinalSpeed-X\ Beta.jar
	
*For Windows Users*
>If you haven't installed winpcap, install it first.

Create a batch file under the same directory as the client, name it whatever you want to, ending with ".bat". Inside the batch file, type in one line of code:

	java -jar "FinalSpeed-X Beta.jar"
	
Save the batch file. Run the client by right clicking the saved file and select `Run in Adminstrator`.
	
##How to Build
Download the code or clone to a local directory then  import it using Eclipse (Haven't tested other IDEs yet). **JDK 1.7** is recommended for best compatibility. Right click on the imported project, click on Configure Build Path, then add in the external jars included in the directory.

Create a run configuration and make the main class `FSClient` under `net.fs.client`

You can find required reference libraries under [reference_lib](reference_lib). Note that some aren't included in the directory is listed inside the file [here](reference_lib/Unincluded_Ref_Libs.md).

To export it to a jar file, right click on the imported project, select export, select runnable jar file, then choose the run configuration for `FSCLient`. Follow the wizard for the rest of the steps (You should be able to do this as a developer).

##Note
Due to the complicated dependencies and my limited abilities, I'm not spending time to try delete some server classes since sometimes they share a same component class with a client.

### Why did I translate the project into English?
>面向国际社会 你们还要多学习一个  
>西方哪个国家我没去过  
>你们看不懂英文怎么和华莱士谈笑风生 怎么增长姿势水平  
>不学英语的话我就生气了  
>P.S. 忠于国家忠于党 牢记社会主义核心价值观 我为国家发展做贡献

##Known Issues
* Encoding problems making characters show weirdly.
* Both English and Chinese translation is not complete.
* There are no root privelege detection for Mac/Linux yet.
* The icon won't show properly under OS X dock.

##Update Log
Can be found under the same directory as this readme file, or click [here](Edit Log.md).