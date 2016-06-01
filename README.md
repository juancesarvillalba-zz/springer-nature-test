# Springer Test Code Problem

## How to run the app ?
### Initial entry point to run the application is Main.java file this class creates an CommandLineConsoleCanvas class and run it.
### Then you can type commands in the console.
 
   
# Package structure and model Decisions

## com.springer.nature.editor.canvas package

*  ICanvas ,Canvas: In a Canvas is possible to execute "draw" commands that will update(draw) shapes in an area.
*  IArea, Area: This class decouple the internal representation (arrays) from the canvas, this allow to change in a future to use other data structure with minimal code changes.     

## com.springer.nature.editor.commands package


*  CanvasCommandFactory: Factory class in charge of parsing commandLine and creates respectively ICommand
*  ICommand, Command and implementations : They are in charge of parsing command arguments and create internal shape representations, each command implements a draw method that delegate to the internal shape representation.
   
## com.springer.nature.editor.console package

* CommandLineConsoleCanvas : Class in charge of accepting commands and add them to the Canvas. This class decouple the reading of commands, another classes could be create for example FileSystemCanvas to read commands from different sources.
  
## com.springer.nature.editor.constants package
  
* Constants: All constants use in the system.
   
## com.springer.nature.editor.shapes package

* IShape , Shape , ComplexShape: Interface and abstract classes for all concrete shapes. 

A IShape has a draw operation that model the concept that a Shape knows how to draw itself in a Canvas. 
  
A ComplexShape : use the composite pattern to model the concept of hierarchy, for instance a Rectangle is compose of 4 Line Shape.
  
* Line , Rectangle both implement IShape because of that they know how to draw itself in a Canvas.  
   

## com.springer.nature.editor package

* Main : Java class to run the program, it creates  CommandLineConsoleCanvas and run it.
   
   
   
   