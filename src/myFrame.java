import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

/**
 * this obj purpose is to paint maze which meanse:
 *  get input of maze object
 *  extract his edges
 *  transfer the vertex which represented by integers to cordinates of (x,y) of a point in horizon
 *  paint the maze via draw lines -> draw ea edge -> draw a line from vertex v1 to v2 -> draw a line from (x1,y1) to (x2,y2)
 */

public class myFrame extends JFrame {
    Maze currMaze;
    Point2D[] pointsArr;
    double lenConst;
    double widthConst;

    /**
     * const the window for painting (create a frame)
     * @param ourMaze get a maze
     */
    myFrame(Maze ourMaze){
        this.currMaze = ourMaze;
        initializePoints(ourMaze);
        this.setTitle("zEam!");
        this.setSize(750,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * gonna trnafer vertex from the maze to point cordinates
     * @param ourMaze - work on maze array that rpresents vertex of graph
     */
    private void initializePoints(Maze ourMaze) {
        int row = ourMaze._row;
        int col = ourMaze._col;
        //dist between point to point to be proportional
        this.widthConst = ((double)500/col);
        this.lenConst = ((double)500/row);
        this.pointsArr = new Point2D[ourMaze.uf.vertex.length]; //amount of points as amount of vertexes of the maze
        for (int i=0; i < this.pointsArr.length; i++){
            //for more info look on linearTrans func details
            this.pointsArr[i] = linearTrans(i, row, col);
        }
    }

    /**
     * transfering a integer num that represent idx at array to point x,y
     * formula is:
     * for integer num x cordinate -> num modulu column * widthConst (will split equally over page)
     * for integer num y cordinate -> num modulu column * lenConst (will split equally over page)
     * @param num as writen above.
     * @param row - amount of rows
     * @param col - amount of cols
     * @return relevant point
     */
    private Point2D linearTrans(int num, int row, int col) {
        // the "neto" window is 500*500 size in the middle of the whole 750*750 picture
        Point p = new Point(125+(num % col) * this.widthConst, 125+num / col * this.lenConst);
        return p;
    }

    /**
     * paint the maze
     * move through the whole printEdges list of the maze and paint ea edge via the (x,y) cordinates (from -> to)
     * @param g - built in of JAVA implement
     */

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D)g;

        for(Edge edge: this.currMaze.printEdges){
            int from = edge._from;
            int to = edge._to;
            g2D.drawLine((int)this.pointsArr[from].getX(),(int)this.pointsArr[from].getY(),
                    (int)this.pointsArr[to].getX(), (int)this.pointsArr[to].getY());
        }
    }


}
