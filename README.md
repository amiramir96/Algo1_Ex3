# Algo1_Ex3
Exercise 3 of Algorithems 1 course of Ariel University

## the main task 
given two integers m,n - the algorithm shall paint a maze, represented by m rows and n columns of nodes, the entrance of the maze will be at the left top, and exit at the right bottom

## algorithm
for this task we used the Union Find algorithm with some matchs.<br>
the algo will:<br>
<o1>  
  1. use array of integers to represent each vertex along the graph (ea n consecutive of vertex that represent reminder system of {0,1,2,....,n-1} is a full row of the maze graph)<br>
  2. create all possible edges between to neighboor vertexes<br>
  3. shuffle the list of edges<br>
  4. run on the list and for every edge that wont close circle on the graph:<br>
    a. will use union of both vertexes (another meaning - every edge of two pair nodes that not hold the same parent, will be unioned)<br>
    b. edit "Existence" field of the edge to be True<br>
  5. paint all the Edges with "True" in the existence field<br>
</o1>
running time is O(m*n) - linear running time depenadant on the input

## results
this is the output of the code for given m,n integers output
[image]https://prnt.sc/20xrdjz[image]

#### created by Amir.Sabag and Ori.Darshan

