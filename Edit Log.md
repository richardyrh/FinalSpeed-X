# Edit Log

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
  
	The `Aug 31` version is archived as `Alpha`
 
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

** **

 `Sep 2 and Sep 3`
 
 - Implemented language module
 - Added two language files
 - Add privilege testing for Mac/Linux
 - Modified some details for UI
 - Tested on Ubuntu 16.04.1 LTS
  - UDP seems to work just fine
  - TCP didn't work on my VMware Fusion machine, will try a real hardware soon
 - Fixed a bug that may exist on previous versions causing UDP connection failure
 - Made a small change to Map cell renderer
 - Removed all unused imports
 - Deleted declarations for unused variables
 - Fixed raw type warnings
 - Removed some unecessary code
 
 This version is archived as `Beta`.
 
** **
 
 `Sep 6`
 
 - Added language choosing screen
 - Readded new version check
 - Added Traditional Chinese
 - Fixed a few bugs
 - Tested under Ubuntu 16.04.1 LTS and Windows 10

 This is the newest version so far, `1.0`.
 
 **Raise an issue if there's any bug or suggestions.**