import java.util.Scanner;

public class main {
    /**
     * get two integers from user and paint a maze of size - m rows X n columns
     */
    public static void main(String arg[]){
        int m, n; //get input from user
        if (arg.length == 0){
            Scanner sc= new Scanner(System.in);
            System.out.print("Enter number of Rows - 'm':  ");
            m = sc.nextInt();
            System.out.print("Enter number of Columns - 'n': ");
            n = sc.nextInt();
        }
        else {
            m = Integer.parseInt(arg[0]);
            n = Integer.parseInt(arg[1]);
        }
        //create maze
        Maze ourMaze = new Maze(m, n);
        ourMaze.proccessMaze();
        //paint maze
        myFrame x = new myFrame(ourMaze);
        x.paint(x.getGraphics());
    }


}
