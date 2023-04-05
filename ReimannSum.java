import java.util.Scanner;
import javax.swing.JFrame;

public class ClientApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the fourth-degree coefficient: ");
        double a = input.nextDouble();

        System.out.print("Enter the third-degree coefficient: ");
        double b = input.nextDouble();

        System.out.print("Enter the second-degree coefficient: ");
        double c = input.nextDouble();

        System.out.print("Enter the first-degree coefficient: ");
        double d = input.nextDouble();

        App p = new App(d, c, b, a);

        System.out.print("Enter the value of delta x: ");
        double deltaX = input.nextDouble();
        p.setDeltaX(deltaX);

        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(p);
        frame.setVisible(true);
    }
}
