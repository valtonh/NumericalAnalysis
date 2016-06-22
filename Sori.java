
package analiznumerikeushtrime2;



import java.text.DecimalFormat;
//Ushrimi 1 ne 7.4
public class Sori {

	public static String Sori(double[][] A, double[] x0, double[] b,
			double w, int N, double TOL) {
		int n  = A.length; //Numri i ekuacioneve
		int k = 1;
                double sum;
		double[] x = new double[n];
		boolean nesevazhdon = true;
		
		while (k <= N && nesevazhdon) {
			System.out.println("___________________ ");

			for (int i = 0; i < n; i++) {
				sum = 0;

				{
					for (int j = 0; j < n; j++) {

						if (i != j) {
							sum += A[i][j] * x0[j];
						}
					}
				}

				x0[i] = (1 - w) * x0[i] + (w * (b[i] - sum) / A[i][i]);

				DecimalFormat f = new DecimalFormat("0.000000");
				System.out.print(" x" + k + " = " + f.format(x0[i]) + "	");
				System.out.println();

				if (distEuklidiane(x, x0) < TOL) {
					nesevazhdon = false;
				} else {

					k++;

				}

			}
		}
		return ("Nr max i iterimeve ka arritur " + (k - 1));
	}

	public static double distEuklidiane(double[] x, double[] y) {
		double rezultati = 0;
		if (x.length == y.length) {
			for (int i = 0; i < x.length; i++) {
				rezultati =rezultati+ Math.pow(x[i] - y[i], 2);
			}
		}
		return Math.sqrt(rezultati);

	}

	public static void main(String[] args) {
		double[][] A = { { 3, -1, 1 }, { 3, 6, 2 }, { 3, 3, 7 } }; //Matrica
		double[] x0 = { 0, 0, 0 }; // Vektori
		double w = 1.1; // Parametri W
		double[] B = { 1, 0, 4 };// Gjymtyret e lira
		int N = 20; // Numri max i iterimeve
		double TOL = 1e-3; // Toleranca

		System.out.println(Sori(A, x0, B, w, N, TOL));

	}
}
