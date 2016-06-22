/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */


import java.awt.BorderLayout;
import java.util.Scanner;

public class Trap {

   public static void main(String args[]) {
      double   area;      // Store result in area
      double   a, b;      // Left and right endpoints
      int      n;         // Number of trapezoids
      double   h;         // Trapezoid base width

      Scanner sc = new Scanner(System.in);
       System.out.println("a- Kufiri i pare \n b- Kufiri i dyte \n n- Numri i trapezeve");
      System.out.print("Jepe a=");
      a = sc.nextDouble();
       System.out.print("\nJepe b=");
      b = sc.nextDouble();
       System.out.print("\nJepe n=");
      n = sc.nextInt();

      h = (b-a)/n;
      area = trap(a, b, n, h);

      System.out.println("Me n = " + n + " Trapeza, llogaritet");
      System.out.print("siperfaqja nga  " + a + " deri ne " + b+"qe eshte ");
      System.out.println(" = " + area);
      
   }  
   static double trap(double a, double b, int n, double h) {
       double area;   
       double x;
       int i;
   
       area = (f(a) + f(b))/2.0;
       for (i = 1; i <= n-1; i++) {
           x = a + i*h;
           area = area + f(x);
       }
       area = area*h;
   
       return area;
   } 



   static double f(double x) {
      double return_val;  
   
      return_val = x*x + 1;
      return return_val;
   }  // f

}  // class Trap