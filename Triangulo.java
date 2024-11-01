import javax.swing.*;
import java.awt.*;

public class Triangulo extends JPanel {
    private int lado1, lado2, lado3;

    public Triangulo(int lado1, int lado2, int lado3) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    public double calcularArea() {
        double s = (lado1 + lado2 + lado3) / 2.0;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }

    public double calcularPerimetro() {
        return lado1 + lado2 + lado3;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.CYAN);

        
        int x1 = 100, y1 = 100;
        int x2 = x1 + lado1, y2 = y1;
        int x3 = x1 + lado1/2, y3 = y1 - (int)(Math.sqrt(3)/2 * lado1);

        int[] xPoints = {x1, x2, x3};
        int[] yPoints = {y1, y2, y3};
        g.drawPolygon(xPoints, yPoints, 3);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Triangulo triangulo = new Triangulo(100, 100, 100); 
        frame.add(triangulo);

        frame.setVisible(true);

        System.out.println("Área del triángulo: " + triangulo.calcularArea());
        System.out.println("Perímetro del triángulo: " + triangulo.calcularPerimetro());
    }
}