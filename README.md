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

## running the code
project can be cloned as it is <br>
do not remove any file from the SRC folder or the code wont compilize <br>
the main file can get argument input (from cmd) either input from user meanwhile running <br>
the code split to 2 main proccesses: <br>
  1. create the maze, edge and loop over the edge list via using union-find, and creating the "printEdge" list (for painting phase) <br>
  2. paint phase - use "linear transformation" function to take ea idx of vertex num and make for that ver a cordinates in the plane of the frame window that gonna be painted, then painting the edges via drawing lines between every two points of given relevant edge (reminder - existence filed = true) <br>
<br>
side note: we used the Swing built in system of java to paint the maze 



## results
this is the output of the code for given m,n integers output <br>
![Screenshot_2](https://user-images.githubusercontent.com/89981387/143723839-8ef9f7d2-8e54-46cb-a6a4-be42f8ef4888.png)

#### created by Amir.Sabag and Ori.Darshan

