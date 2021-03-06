# Kotlin-game-engine
(Note:   This game-engine is not done, and will not come of any use yet.  )
Video-game-engine written in kotlin.  The game-engine server is open-source, but the client may be closed source, with the exception of some clients.  
Currently there is no code, but I'm currently working on some of it.  I'm going to be working on the authentication side of the game-engine, as well as the server-socket, protocol, and file-storage.  Some of the classes may not be used by the server itself, but there will be classes that plugins can use, without having to import classes directly from the standard-library.  This will allow server-owners from running hacks on their server that could harm their host.  These classes will be written specifically to keep people and computers save, while giving functionality to games as well.  
I welcome any and all contributors to this project, and if I am both aware of your contribution, and aware that you want credit, I will be more than happy to give you credit for your contributions.  As for the nerds that just like playing with code, they may not claim these modules as theirs, and may not offer altered versions of this game-engine unless they make it very clear that it is an altered form of this very program, with a link to this repository included in their Readme.  
If you believe you want there to be a change to the original game-engine itself, please feel free to request such changes, I will be willing to talk with you on the subject.  

These are the requirements for all modified/altered versions of this game-engine:
* There must be a link to the URL that points directly to this repository, allowing anyone to find the original.  All versions must have a link to this repository.  
* Every version of this game-engine must have a copy of all requirements, must have the requirements listed.  
* All classes of this project must be safe to use.  I will personally ban you from editing this project if I catch you injecting any form of malware, spyware, or any such bad software or zero-days.  Adding exploits will not be tolerated.  Therefore, this is not the repository for those to edit code, there however may be a URL for a repository duplicate of this one, so that a team may modify the game-engine, and if I agree to the modifications, I'll be updating this repository.  
* There would be classes written to block access to the classes that can be used to access files outside the server's directory, in order to keep the host safe.  

Now that you read the summory, and the requrements, I would like to share what the aim of this project is, which will give you an idea of what I'll accept, versus what I wont:
*   3D must be available.  
*   AI must be available, via plugins at least.  
*   Audio-generation must be available, via plugins at least.  
*   Protocol-programming must be available, but such classes must only accept classes from with in the game itself, not plugins.  
*   Protocol-scanning may be allowed, but that is optional.  
*   Automatic anti-virus scans by the game-engine, for all add-ons, modules, and plugins that are run by it for the first time.  
*   Automatic security-hashing, to make sure each and every class file is from their author and not some cracker (someone that cracks and pirates propertary software applications).  
*   Security analysis must be available to game-developers.  
*   Data-encryption must be available to developers.  
*   Automatic ip/uuid generation, and client-data encryption, to make sure the client data is securely stored, and to allow mac-bans, mac-mutes, mac-kicks, and mac-warns when needed.  IP-bans just wont work for kicking out all hackers.  

Parts of this game-engine will be private and therefore instead of source-code, you will file compilied files instead.  I will be employing methods to protect my work in namespaces such as 'io', especially because the gamming community prefers that no one can gain an advantage via hacked clients.  
