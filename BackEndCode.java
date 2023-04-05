import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JPanel;

    public class App extends JPanel {
        private static final long serialVersionUID = 1L;
        private double setDeltaX;
        private ArrayList<Double> coefficients = new ArrayList<>();
        Scanner input = new Scanner(System.in);

    // Constructor
    public App(double d, double c, double b, double a) {
        coefficients.add(d);
        coefficients.add(c);
        coefficients.add(b);
        coefficients.add(a);
    }

    // Class Methods, Instance Methods
    public double computeIntegral(double minX, double maxX) {
        double area = 0.0;
        double numOfRect = (maxX - minX) / getDeltaX();
        for (int i = 0; i < (int) numOfRect; i++) {
            double xValues = (minX) + (i * getDeltaX());
            area = area + (getDeltaX() * ValueAt(xValues));
        }
        return area;
    }

    public double ValueAt(double x) {
        double d = coefficients.get(0);
        double c = coefficients.get(1);
        double b = coefficients.get(2);
        double a = coefficients.get(3);
        double functionValue = (a * Math.pow(x, 3.0)) + (b * Math.pow(x, 2.0)) + (c * x) + d;
        return functionValue;
    }

    public void setDeltaX(double deltaX) {
        if (deltaX > 0) {
            setDeltaX = deltaX;
        } else {
            System.out.println("DeltaX must be greater than zero.");
            System.exit(0);
        }
    }

    public double getDeltaX() {
        return setDeltaX;
    }

    // Draws the polynomial function graph and the rectangles used in Riemann sum
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int width = getWidth();
		int height = getHeight();

		// Draw x and y axis
		g.drawLine(0, height / 2, width, height / 2);
		g.drawLine(width / 2, 0, width / 2, height);

		// Draw polynomial function graph
		double xScale = width / 20.0;
		double yScale = height / 20.0;
		g.setColor(Color.RED);
		for (int x = -10; x <= 10; x++) {
			double y = ValueAt(x);
			int xPixel = (int) (x * xScale + width / 2);
			int yPixel = (int) (-y * yScale + height / 2);
			g.fillOval(xPixel, yPixel, 5, 5);
		}

		// Draw rectangles for Riemann sum
		double minX = -10.0;
		double maxX = 10.0;
		double area = 0.0;
		double numOfRect = (maxX - minX) / getDeltaX();
		for (int i = 0; i < (int) numOfRect; i++) {
			double xValues = (minX) + (i * getDeltaX());
			double yValues = ValueAt(xValues);
			int xPixel = (int) (xValues * xScale + width / 2);
			int yPixel = (int) (-yValues * yScale + height / 2);

			g.setColor(Color.BLUE);
			g.drawRect(xPixel, yPixel, (int) (getDeltaX() * xScale), (int) (yValues * yScale));

			area = area + (getDeltaX() * yValues);
		}

		System.out.println("Approximate area: " + area);
	}
}

