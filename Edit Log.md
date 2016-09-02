# Edit Log

`TODO:`

 - Organize imports
 - Translation
 - Modify UI of 'Add Forward'
 - Boost list encoding problems
 - Add in privilege detection
 - Remove unused import

`Aug 31`

 - Started project
 - Solved dependencies
 - Font change - *Helvetica Neue* for non-Win systems
 - Change home website to github page
 - Change Button scheme - insets to 0
 - Update URL temporarily set to localhost
 - Layout appearance on left column
 - Make SpeedSetFrame not resizable
 - Removed unused variables
 - Added image resource
 - Mac dock icon support
 - **Successfully fixed the TCP bug in Mac OS X** and optimized the CapEnv class
  - Adding pcap4j's separate packet factory module to build path (Not in dependencies)
  - Added a few debug outputs
  - Force exit in some weird scenarios
  - Pass in the server address as a parameter  
  - Force test IP to the remote boost server
  - Fixed the boost list selection bug 
  
	The `Aug 31` version is archived as `Alpha 1.0`
 
** **
 
`Sep 1`
 
 - Complied some referenced classes (pcap4j,fastjson)
 - Deleted unwanted classes in src
 - Moved layout for speed indication
 - Added a ping thread before the loop starts
 - Changed some layout details so they align
 - *Can't test UDP, maybe it won't work*
 - Deleted unwanted reference libraries
 - Fixed some translation
 - Added the reference jars to the repository
 - Tested UI compatibility for Windows