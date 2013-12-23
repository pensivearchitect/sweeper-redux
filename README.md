#Sweeper-redux [![Build Status](https://travis-ci.org/pensivearchitect/sweeper-redux.png)](https://travis-ci.org/[YOUR_GITHUB_USERNAME]/[YOUR_PROJECT_NAME])
A Cross Platform Screenshot Utility

This project is a reimplementation of a utility used by a highly specialized community in an online game that I frequent.

The main reasons for the reimplementations were:

1) Exteremly slow support and development by the author.

2) The utility was platform dependent.

3) It required an internet connection to a fan-site that had frequent uptime problems, and when the site was down the utility was unusable.

4) There is a questionable legal issue with the utility being implemented in a language with the standard library being licensed under the GPLv2, and the minimal source provided with the executable would not compile due to a reliance on custom external libraries. When I consulted someone more knowledgeable about the specifics of GPL (however they were not a lawyer) their response was upon examination, "incompetence".

5) Empty promises of development of implementations for OS X and other UNIX implementations/clones. When potential users would query about the current status of the utility they would recieve angry, and even hostile reponses.

6) I wanted to write something in Scala, a language that highly interests me, and all players of the game already have the JRE installed, which eases dependency management.


##Planned Basic Design and other possibly interesting tidbits

* Sweeper-redux will leverage the cross-platform gui interfaces of the Java standard library (the plan is to use the ScalaFX wrapper) to streamline and provide a consistent interface across platforms.
* The area of the screen to capture will be user defineable, and capture will be triggerable by a user defined key-binding.
* To guarantee consistent behavior the last 3 successful captures will be stored in an immutable linked list. The cons of the list will be asynchronously written to disk to preserve consistent application performance without IO locking or Sweeper terminating due to an IO Exception caused by an implementation specific error.
* Planned binary support will be for Microsoft Windows, OS X, Redhat Linux derivatives, Debian Linux derivatives, and possibly Solaris/AIX/other commercial UNIX implementations, however I do not have access to the latter, nevertheless I will gladly accept patches to provide better support.
