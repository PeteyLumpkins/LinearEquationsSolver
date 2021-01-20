# LinearEquationsSolver
This application solves systems of linear equations using [guassian elimination](https://en.wikipedia.org/wiki/Gaussian_elimination) and back substitution. It can determine whether a system of linear equations
has a specific solution, multiple solutions, or no solutions.

# Goal
The goal of this project was to reinforce the what I had been studying in my coursework over the past semester, namely linear algebra and intro to object-oriented programming. 

# Functionality
- Determine if linear system of equations has one solution, more than one solution, or no solutions
- Solve systems of linear equations involving floating point values
- Can solve linear systems of equations with M-variables and N-equations (rows != cols)

# What I learned
- How to implement guassian elimination algorithm
- Matrix operations
- Object-Oriented Design
- Exposure to Command design pattern
- Experience using Java

# How to get started
First, make sure you have java installed on your system. Java 15.0.1 will work, however any version of java later than java 8 will work (I think).

In order to run the program, navigate to the file main.java and run the file.
```
LinearEquationsSolver >>> src >>> Main >>> main.java
```

Hopefully the program does not crash. If all goes smoothly, the console should look like this:
```
>>> Enter number of variables: 
```
Examples on how to use the application will be described in the tutorial section below.

# Tutorial
This will be the tutorial for how to use the linear system of equations solver, and what kind of input parameters the program 
will accept.

### A simple example
Suppose that we have three variables (X1, X2, X3) and a system of linear equations as follows:
```
1 * (X1) + 1 * (X2) + 2 * (X3) = 9
2 * (X1) + 4 * (X2) - 3 * (X3) = 1
3 * (X1) + 6 * (X2) - 5 * (X3) = 0
```
This system of linear equations has the corresponding coefficient:
```
[1, 1, 2, 9]
[2, 4, -3, 1]
[3, 6, -5, 0]
```
Now, when we run the main.java file, the console will ask the user to input the number of variables in our system of equations. In this case, we are dealing with 3 variables (X1, X2, X3), so we enter 3.
```
Enter number of variables: >3
```
Once we enter the number of variables, we will be prompted to enter then number of equations. In this case, we have 3 rows in our 
coefficient matrix above, and therefore 3 equations, so we enter 3.
```
Enter number of variables: >3
Enter number of equations: >3
```
The program will now prompt us for each equation. We want to enter the corresponding row of the coefficient matrix for each equation in our system, with each coefficient seperated by a space (see below).
```
Enter number of variables: >3
Enter number of variables: >3
Enter row 0: >1 1 2 9
Enter row 1: >2 4 -3 1
Enter row 2: >3 6 -5 0

X1 = 1.0
X2 = 2.0
X3 = 3.0


Process finished with exit code 0
```
After we enter each of the rows in the coefficient matrix, the program will solve the system and print out the solution.

### Disclaimers
- This program does not work with complex numbers. It is something I'd like to implement in the future, but for now it only works with floating point values and integers.
- The program assumes that your input is valid. If you say that your system of equations has 3 variables and 3 equations, the program expects 4 coefficients per row. If you enter more than 4 coefficients the program will produce an incorrect result.
