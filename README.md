# simple-database-challenge
[Thumbtack Simple Database Challenge](https://www.thumbtack.com/challenges/simple-database)

## Execution Instructions
## Thought Process

I decided to implement my solution in Java, which I am fairly familiar with, but to use a few new technologies. My experience in Java is limited to introductory CS classes which mainly focused on algorithmic design and simple object-oriented classes. Therefore, I decided to use a new IDE, Intellij and new Java libraries, JUnit and Mockito. This also gave me a chance to explore Javadocs which I have not previously been introduced to.
My approach was inspired by the MVC pattern which I am only vaguely familiar with. The idea was that I could explore the paradigm by attempting to divide my solution along the same lines. This is also the reason for the naming of the DatabaseModel and DatabaseController.

### DatabaseModel

I began with an idea of what the database itself should be able to do. Regardless of the implementation, a user should be able to add database entries, get a value given the key, remove database entries, and determine the number of times a value appears in the database. These methods formed the IDatabaseModel interface, with the idea that different implementations would still need that basic functionality.
My implementation of this interface revolved around the idea that HashMaps are the best way to store key-value pairs as they are essentially O(1). This data structure is incredibly good for the first three methods in our interface, but it would lead to a O(N) complexity for finding the number of times a value appears in the database. I spent some time trying to find a data structure that would have O(1) complexity for all 4 basic operations, my thought was that a HashTree might be useful if it had O(1) lookups for keys and O(logN) lookups for values, but that was not the case. I finally realized that by keeping two HashMaps, one mapping key to value and the other mapping value to the number of times it appears, I could get O(1) time for every operation. Although this meant that each method would be slightly more complex because I could have to make sure the state of the two HashMaps were in sync, the overall complexity of the methods is low and the database is quite fast.

### DatabaseController

My model was mainly concerned with managing the data store, which meant that I needed to find some other way to manage transactions. I decided to implement this by way of a controller which would be fed "commands", in some form, and manage the state of the model. This would effectively separate the implementation of data and control commands. The controller would be fed commands by the "view", which I called a DatabaseSocket. These would take the form "TYPE NAME VALUE", with the final two fields being optional. When the controller is given a command string, it will translate it into a command and act on the model in the desired way.
This left a gaping hole in terms of the actual implementation of a command. While it would be nice to implement a processor (the commands really remind me of assembly instructions) which could interpret our command strings and call functions based on them, this type of controller wouldn't be very modular. Instead, I decided that the controller will create commands based upon the input and then “execute” those commands on the model. This system is particularly nice for data commands as the controller can defer the actual execution to the commands.
The other role of the controller is to manage transactions. I decided to interpret transactions as a serious of operations that can be undone. Thus each command in a transaction is immediately executed but a series of steps to reverse the effects of the transaction is stored. Each transaction is an element in a stack and comprised of a stack of commands. Every time a data command is executed in a transaction, the controller adds a command that would undo the effects of the command to the transaction.
Control commands are actually executed on the controller itself and can manage the transaction state. These commands can create a new transaction, rollback the last transaction or commit all transactions. To create a new transaction, the controller simply adds a new stack of commands to the stack of transactions. Every following data command will add a rollback command to that stack. To rollback that transaction, each of the commands in the stack is popped and executed. Finally, to commit the transactions, the stack can simply be emptied as the changes have already been applied to the model
### Commands
All commands need to execute some sort of functionality and therefore, depending on the type of command, have an execute method for models or controllers. This allows the controller to defer the implementation of the command to the command, which can utilize the functionality supplied by the model and controller interfaces.
To abstract some of the command behavior, I created a command class which implemented the command interface and essentially provided an example of a “blank” command. Commands therefore have a default functionality and each type of command (data or control) can override as necessary. Abstract classes for these types simplified the implementation of type-specific functionality.
Similarly, to the execute functions, each command could generate its own rollback command or return a default command which would do nothing.
### DatabaseSockets
Database sockets were essentially my version of a view which allowed the user to interact with the controller with different input types. The interface had two methods which allowed the user to receive input and to provide the user with input. This separated the implementation of the database model and controller with the user’s method of interaction.
### Potential Areas of Improvement
The controller could defer parsing the input into commands to a parser which would reduce the complexity of generating commands.
The abstraction of commands could be cleaner. I don’t particularly like the Command class, but it does provide some important functionality.
Test coverage is extremely weak. Every class should have each of its methods unit tested and a few integration tests should be incorporated with the provided sample input. 
## Performance Considerations
Set, Get, Unset and Numequalto should be roughly O(1). This might change based on the precise implementation of HashMap.
Begin is O(1) as it simply creates a new stack
Commands are separate form the implementation of transactions. The only difference between the execution of data commands inside and outside of a transaction is the number of constant time operations that must be performed, since data commands also generate a rollback command during a transaction.
Rollback commands take O(m) time (For m commands in a transaction) because each command in the transaction must be rolled back.

