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



