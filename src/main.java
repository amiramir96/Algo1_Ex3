import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class main {

    public static void main(String arg[]){

        Scanner sc= new Scanner(System.in);    //System.in is a standard input stream
        System.out.print("Enter number of Rows - 'm':  ");
        int m = sc.nextInt();
        System.out.print("Enter number of Columns - 'n': ");
        int n = sc.nextInt();
        Maze ourMaze = new Maze(m, n);
        ourMaze.proccessMaze();

//        for (Edge edge : ourMaze.printEdges){
//            System.out.println(edge);
//        }
//        for (int i=0; i < m*n; i++){
//            System.out.print(""+ourMaze.uf.find(i) + " ");
//        }
        myFrame x = new myFrame(ourMaze);
        x.paint(x.getGraphics());
    }


}
