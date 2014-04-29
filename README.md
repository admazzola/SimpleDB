PatchingGameLauncher
====================

A game launcher for Sands of Osiris that automatically pushes new game updates to the players


DEPENDENCIES: OrbWeaver (my other project), must be added to the Build Path as a project or imported as a jar library


This is mostly just the GUI and some code that renders an HTML feed from a website.  The heavy lifting (file transfer) is done by OrbWeaver, a library designed to synchronize a file stored on a master server to all of the clients.  This can be retrofitted to act as a patcher for any other java game relatively easily.  The jar is downloaded from the server and then stored in APPDATA.  That jar is then executed when the launch button is pressed in the GUI.
