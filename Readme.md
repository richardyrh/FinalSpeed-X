#Read Me

**FinalSpeed-X** is a extended support project for FinalSpeed Java Client originally written by d1sm which was discontinued. FinalSpeed-X is mainly based on the code of FinalSpeed 1.12.

The latest version is `1.0`.

The client is completely compatible with current FinalSpeed servers (You still can't use TCP on an Open-VZ server though).

###Raise an issue for a bug or suggestion.

##For Non-Developers
Download the zip, then run the client using  
*For Mac/Linux Users*  
>If you haven't installed libpcap, install it first.
	
	sudo java -jar FinalSpeed-X\ 1.0.jar
	
*For Windows Users*
>If you haven't installed winpcap, install it first.

Create a batch file under the same directory as the client, name it whatever you want to, ending with ".bat". Inside the batch file, type in one line of code:

	java -jar "FinalSpeed-X 1.0.jar"
	
Save the batch file. Run the client by right clicking the saved file and select `Run in Adminstrator`.
	
##How to Build
Download the code or clone to a local directory then  import it using Eclipse (Haven't tested other IDEs yet). **JDK 1.7** is recommended for best compatibility. Right click on the imported project, click on Configure Build Path, then add in the external jars included in the directory.

Create a run configuration and make the main class `FSClient` under `net.fs.client`

You can find required reference libraries under [reference_lib](reference_lib). Note that some aren't included in the directory is listed inside the file [here](reference_lib/Unincluded_Ref_Libs.md).

To export it to a jar file, right click on the imported project, select export, select runnable jar file, then choose the run configuration for `FSCLient`. Follow the wizard for the rest of the steps (You should be able to do this as a developer).

##Note
Due to the complicated dependencies and my limited abilities, I'm not spending time to try delete some server classes since sometimes they share a same component class with a client.

##Known Issues
* The icon won't show properly under OS X dock. (It even shows properly under Ubuntu's taskbar)  

> Basically everything works under my system...

##Update Log
Can be found under the same directory as this readme file, or click [here](Edit Log.md).