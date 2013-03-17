pathfinder
==========

dedicated to Frank ;)

This is the Solution of an Exercise I did some time ago. Requirements are Maven >=3 and Java >=1.6

##How to use

~~~~~~
git clone https://github.com/schasse/pathfinder
cd pathfinder
mvn package
cd target
java -jar pathfinder-0.1.jar
~~~~~~


##Exercise

The aim was to find the best way through a m x m matrix. The path cost is the total of all numbers in the passed cells in the matrix.

First the matrix needed to be generated. It's a pseudo random generation, that each time you execute the program the matrix is the same. Then there were different Levels in solving the problem.

#Level 1
Start in the top left corner, target is the bottom left corner. It's just allowed to go one step right or down.

#Level 2
Start  is any cell on the very left, target is any cell on the very right of the matrix. It's just allowed to go one step up, down and right.

#Level 3
Start is again top left and target bottom right. But this time it's allowed to go one step up, down, left or right. 
