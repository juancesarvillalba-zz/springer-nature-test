# Springer Test Code Problem

## How to run the app ?
### Initial entry point to run the application is Main.java file this class creates an CommandLineConsoleCanvas class and run it.
### Then you can type commands in the console.

## Error Handling:
### Could be the case that an user entered a command with missing or wrong arguments in this case I took the approach to manage a catch-all strategy that will notify 
### the user that something was wrong with that command. 

### Could be the case that an user creates commands that try to draw outside of the dimensions of the canvas, in that case impletation will just draw only inside Canvas dimensions
### For instance if an user creates a Canvas with width= 5 and try to draw an horizontal line with length 20 only a line of length 5 will be draw in the Canvas.  
   
# Package structure and model Decisions

## com.springer.nature.editor.canvas package

*  ICanvas ,Canvas: In a Canvas is possible to execute "draw" commands that will update(draw) shapes in an area.
*  IArea, Area: This class decouple the internal representation (arrays) from the canvas, this allow to change in a future to use other data structure with minimal code changes.     

## com.springer.nature.editor.commands package

*  CanvasCommandFactory: Factory class in charge of parsing commandLine and creates respectively ICommand
*  ICommand, Command and implementations : They are in charge of parsing command arguments and create internal shape representations, each command implements a draw method that delegate to the internal shape representation. Having independents
commands that delegates the drawing allows decoupling between the client and the IShape 
   
## com.springer.nature.editor.console package

* CommandLineConsoleCanvas : Class in charge of accepting commands and add them to the Canvas. This class decouple the reading of commands, another classes could be create for example FileSystemCanvas to read commands from different sources.
  
## com.springer.nature.editor.constants package
  
* Constants: All constants use in the system.
   
## com.springer.nature.editor.shapes package

* IShape , Shape , ComplexShape: Interface and abstract classes for all concrete shapes. 

A IShape has a draw operation that model the concept that a Shape knows how to draw itself in a Canvas. 
  
A ComplexShape : use the composite pattern to model the concept of hierarchy, for instance a Rectangle is compose of 4 Line Shape.
  
* Line , Rectangle both implement IShape because of that they know how to draw itself in a Canvas.  
   
## com.springer.nature.editor.output package

* IOutputFormat , ConsoleOutputFormat : The idea of this class is to have an interface and concrete implementation to decouple ouput operations (drawing) from the Canvas.
This will allow the possibility to change the output mechanism for example from Console to a File implementation.

## com.springer.nature.editor package

* Main : Java class to run the program, it creates  CommandLineConsoleCanvas and run it.
   
# Diagram Entity Relation class
   
* A ER diagram  class with the most important Classess in the system is in the doc folder included as gliffy format, also the same diagram is exported as an png image.   