# LinearEquationsSolver
Linear-System-Solver

I doubt anyones reading this but this is my Linear-System-Solver. It does what it says it does. It solves systems of linear equations. Right now,
I'm pretty sure it's set up take input from the command line, and prints the solution to the system, if it has a solution, to the console. It can be 
set up to read input from a file and output from a file. I doubt this thing will work for you, but hey feel free to try.

The SystemSolver only works for systems involving REAL NUMBERS. It has not been adapted to work with imaginary numbers. If I adapt the application to
work with imaginary numbers I will try to remember to update this page.

The main method is located in the Main.java file, which is located under the Main folder. The input format for taking user input from the console is described bellow.

Suppose I want to enter the following system: 

x + 2y + 3z = 4, 
5x + 6y + 7z = 8, 
9x + 10y + 11z = 12, 

When you run the main method, you should be prompted with the following line:

>>> Enter the number of variables: 

From here, you enter the number of variables you need for your system of equations. In the above case, we have variables x, y, and z, so we will need three 
variables:

>>> Enter the number of variables: >3

The next line will ask for the number of equations we need. In this case, we have 3 equations, so for the number of equations we enter 3.

>>> Enter number of equations: >3

The following lines will then prompt the user to enter the system. Each equation we enter needs to be entered as a row. In our example our first row 
is, "x + 2y + 3z = 4" so we will enter the coefficients of each item in the row, then press the enter key.

>>> Enter row 0: 1 2 3 4 >enter

We do the same thing for the last two rows in our example.

>>> Enter row 1: 5 6 7 8 >enter
>>> Enter row 2: 9 10 11 12 >enter

And that's it, hopefully it doesn't crash.


