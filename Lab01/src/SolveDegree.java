import javax.swing.JOptionPane;

import static java.lang.Math.sqrt;

public class SolveDegree {
    public static void main(String[] args) {
        String strSellectDegree = JOptionPane.showInputDialog(
                "Select (number) the degree to solve: \n " +
                "1. First-degree \n " +
                "2. System of first-degree \n " +
                "3. Second-degree"
        );
        double sellectDegree = Double.parseDouble(strSellectDegree);
        if (sellectDegree == 1) {
            String strA = JOptionPane.showInputDialog(
                    "First-degree ax + b = 0 \n" + "Input a: "
            );
            double a = Double.parseDouble(strA);

            String strB = JOptionPane.showInputDialog(
                    "First-degree ax + b = 0 \n" + "Input b: "
            );
            double b = Double.parseDouble(strB);

            if ( a == 0 ) {
                if ( b == 0 ) {
                    JOptionPane.showMessageDialog(null, "Infinitely many roots.");
                } else {
                    JOptionPane.showMessageDialog(null, "No root.");
                }
            }
            else {
                    JOptionPane.showMessageDialog(null, "x = " + -b/a);
            }
        } else if (sellectDegree == 2) {
            String strA11 = JOptionPane.showInputDialog("Input a11: ");
            double a11 = Double.parseDouble(strA11);

            String strA12 = JOptionPane.showInputDialog("Input a12: ");
            double a12 = Double.parseDouble(strA12);

            String strB1 = JOptionPane.showInputDialog("Input b1: ");
            double b1 = Double.parseDouble(strB1);

            String strA21 = JOptionPane.showInputDialog("Input a21: ");
            double a21 = Double.parseDouble(strA21);

            String strA22 = JOptionPane.showInputDialog("Input a22: ");
            double a22 = Double.parseDouble(strA22);

            String strB2 = JOptionPane.showInputDialog("Input b2: ");
            double b2 = Double.parseDouble(strB2);

            double D = a11 * a22 - a21 * a12;
            double D1 = b1 * a22 - b2 * a12;
            double D2 = b2 * a11 - b1 * a21;

            if ( D == 0 ) {
                if ( D1 == 0 && D2 == 0 ) {
                    JOptionPane.showMessageDialog(null, "Infinitely many roots.");
                } else {
                    JOptionPane.showMessageDialog(null, "No root.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "x1 = " + D1/D + "\n" + "x2 = " + D2/D);
            }
        } else if (sellectDegree == 3) {
            String strA = JOptionPane.showInputDialog("Second-degree ax^2 + bx + c = 0 \n" + "Input a: ");
            double a = Double.parseDouble(strA);
            while ( a == 0 ) {
                strA = JOptionPane.showInputDialog("This is not a second-degree equation. \n" + "Input again a: ");
                a = Double.parseDouble(strA);
            }

            String strB = JOptionPane.showInputDialog("Second-degree ax^2 + bx + c = 0 \n" + "Input b: ");
            double b = Double.parseDouble(strB);

            String strC = JOptionPane.showInputDialog("Second-degree ax^2 + bx + c = 0 \n" + "Input c: ");
            double c = Double.parseDouble(strC);

            double delta = b * b - 4 * a * c;
            if ( delta < 0 ) {
                JOptionPane.showMessageDialog(null, "No root.");
            } else if ( delta == 0 ) {
                JOptionPane.showMessageDialog(null, "Double root x = " + -b / (a * 2));
            } else if ( delta > 0 ) {
                JOptionPane.showMessageDialog(
                        null,
                        "x1 = " + (-b + sqrt(delta)) / (a * 2) + "\n" +
                        "x2 = " + (-b - sqrt(delta)) / (a * 2)
                );
            }
        }
    }
}
