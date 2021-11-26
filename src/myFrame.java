import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class myFrame extends JFrame {

    Maze currMaze;
    Point2D[] pointsArr;
    double lenConst;
    double widthConst;

    myFrame(Maze ourMaze){
        //JFrame frame = new JFrame(); // create a frame
        this.currMaze = ourMaze;
        initializePoints(ourMaze);
        this.setTitle("zEam!");
        this.setSize(750,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * gonna trnafer vertex from the maze to point cor
     * @param ourMaze - work on maze array that rpresents vertex of graph
     */
    private void initializePoints(Maze ourMaze) {
        int row = ourMaze._row;
        int col = ourMaze._col;
        this.widthConst = ((double)500/col);
        this.lenConst = ((double)500/row);
//        System.out.println("for x scale: "+widthConst+" for y scale:"+lenConst);
        this.pointsArr = new Point2D[row*col];
        for (int i=0; i < this.pointsArr.length; i++){
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
        Point p = new Point(150+(num % col) * this.widthConst, 150+num / col * this.lenConst);
        return p;
    }

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
