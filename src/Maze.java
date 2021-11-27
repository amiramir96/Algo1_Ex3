import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * the object represnt a maze via vertexes in m rows X n columns:
 *  the vertexes represented by integers indexes along a array (NOTE!- ea n vertexes can represent a row in the maze!)
 *  the edges represented by edge object that hold two ver fields - from, to AND field of "existence" so we shall know if to paint it in the future proccess
 *  thinking of that ea vertex can hold NOT MORE THAN 2 edges that going FROM him, and same with 2 edges that going TO him
 *  even through we look here on the graph as not mekuvan
 */
public class Maze {

    protected int _row; // how many row
    protected int _col; // how many col
    private List<Edge> edgeList; // hold all edges
    protected List<Edge> printEdges; //which edge to print?
    protected UnionFind uf; // our UnionFind algo structre
    /**
     * create the maze
     * @param m - num of rows
     * @param n - num of col
     */
    public Maze(int m, int n){
        this._row = m;
        this._col = n;
        int totalSize = m*n;
        this.uf = new UnionFind(totalSize); // first stage, all vertex r disjoint
        this.edgeList = new ArrayList<Edge>();
        this.printEdges = new ArrayList<Edge>();

        initializeEdges(this.edgeList, this._row, this._col, totalSize);
    }

    /**
     * shuffle edgeList items so we shall gain a random maze from this proccess
     * run over whole edgeList and edit potential edges which wont close the maze to be irrelevant
     * via using the method dis joint groups of unionfind
     * will remove in the end the entrance and exit "walls" of the maze  (edge that represents them) from the printEdges
     * now the Maze pattern is existing, all is left is to print all the edges
     */
    protected void proccessMaze(){
        int exitEdge = this.printEdges.size() - this._col;
        Collections.shuffle(this.edgeList);
        for (Edge edge : this.edgeList) { //run on all edges
            if (!edge.exist && this.uf.disJointGroups(edge._from, edge._to)) { //if vertexes of edge is disjoint - we shall print it!
                edge.setExistence(true); // will stamp it as true and make union to both vertexes groups
                printEdges.add(edge); // hold it at the print list which we gonna draw in the end
            }
        }
        //remove from print list of edges the entrance and exit walls - so we will be ready to print!
        this.printEdges.remove(exitEdge);
        this.printEdges.remove(0);

    }

    /**
     *
     * @param edgeList maze all pot edges
     * @param row how many rows
     * @param col how many cols
     * @param totalSize amount of vertexes
     */
    private void initializeEdges(List<Edge> edgeList, int row, int col, int totalSize) {
        // move on all the vertexes
        Edge eTemp;
        for (int i=0; i < totalSize; i++){
            // initialize all possible edges in the maze
            if (i+this._col < totalSize){ //there is row below?
                eTemp = new Edge(i, i+_col, uf);
                if (i%this._col == 0 || (i+1)%this._col == 0){
                    // first column or last column - set existence of edge
                    eTemp.setExistence(true);
                    this.printEdges.add(eTemp);
                }
                this.edgeList.add(eTemp);
            }
            if (i%this._col < this._col-1){ // there is col to the right?
                eTemp = new Edge(i, i+1, uf);
                if (i < this._col || i >= totalSize-this._col){ // first row or last row - set existence of edge
                    eTemp.setExistence(true);
                    this.printEdges.add(eTemp);
                }
                this.edgeList.add(eTemp);
            }
        }
    }





}
