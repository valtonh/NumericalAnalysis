
package analiznumerikeushtrime2;


//Ushtrimi 10.2 Detyra 2 :a)
public class Newton {
	public static double[][] inverseOfMatrix(double[][] A) {
		double[][] result = new double[3][3];
		double detA = A[0][0] * A[1][1] * A[2][2] + A[0][2] * A[1][0] * A[2][1] + A[2][0] * A[1][2] * A[0][1]
				- A[2][0] * A[1][1] * A[0][2] - A[2][2] * A[1][0] * A[0][1] - A[0][0] * A[2][1] * A[1][2];

		result[0][0] = 1 / detA * (A[1][1] * A[2][2] - A[2][1] * A[1][2]);
		result[0][1] = 1 / detA * (A[0][2] * A[2][1] - A[2][2] * A[0][1]);
		result[0][2] = 1 / detA * (A[0][1] * A[1][2] - A[1][1] * A[0][2]);
		result[1][0] = 1 / detA * (A[1][2] * A[2][0] - A[2][2] * A[1][0]);
		result[1][1] = 1 / detA * (A[0][0] * A[2][2] - A[2][0] * A[0][2]);
		result[1][2] = 1 / detA * (A[0][2] * A[1][0] - A[1][2] * A[0][0]);
		result[2][0] = 1 / detA * (A[1][0] * A[2][1] - A[2][0] * A[1][1]);
		result[2][1] = 1 / detA * (A[0][1] * A[2][0] - A[2][1] * A[0][0]);
		result[2][2] = 1 / detA * (A[0][0] * A[1][1] - A[1][0] * A[0][1]);

		return result;
	}

	public static double[][] funksioni(double x1, double x2, double x3) {
		double[][] result = new double[3][3];
		result[0][0] = 3.0 * x1 - Math.cos(x2 * x3) - 1.0 / 2;
		result[1][0] = x1 * x1 - 81.0 * Math.pow(x2 + 0.1, 2) + Math.sin(x3) + 1.06;
		result[2][0] = Math.exp(-x1 * x2) + 20.0 * x3 + (10 * Math.PI - 3) / 3.0;
		return result;
	}

	public static double[][] derivatiFunksionit(double x1, double x2, double x3) {
		double[][] result = new double[3][3];
		result[0][0] = 3;
		result[0][1] = x3 * Math.sin(x2 * x3);
		result[0][2] = x2 * Math.sin(x2 * x3);
		result[1][0] = 2 * x1;
		result[1][1] = -162 * (x2 + 0.1);
		result[1][2] = Math.cos(x3);
		result[2][0] = -1 * x2 * Math.exp(-1 * x1 * x2);
		result[2][1] = -1 * x1 * Math.exp(-1 * x1 * x2);
		result[2][2] = 20;
		return result;
	}

	public static double[][] newtonEquations(int N, double[][] x, double TOL) {
		double[][] y0 = new double[x.length][x.length];
		int k = 0;
		while (k < N) {
			double[][] inversedJ = inverseOfMatrix(derivatiFunksionit(x[0][0], x[1][0], x[2][0]));
			y0 = multiplyMatrixes(inversedJ, funksioni(x[0][0], x[1][0], x[2][0]));
			x = zbritjaEMatricave(x, y0);
			double[] y1 = { y0[0][0], y0[1][0], y0[2][0] };
			if (normaL2(y1) < TOL) {
				return x;
			}
			k++;
		}
		return x;
	}
	
	public static double[][] zbritjaEMatricave(double[][] matrix1, double[][] matrix2) {
		double resultult[][] = new double[matrix1.length][matrix1[0].length];
		if ((matrix1.length == matrix2.length) && (matrix1[0].length == matrix2[0].length)) {
			for (int i = 0; i < matrix1.length; i++){
				for (int j = 0; j < matrix1[0].length; j++) 
					resultult[i][j] += matrix1[i][j] - matrix2[i][j];
			}
		} else {
			System.out.println("Gabim. Matricat kane gjatesi te ndryshme");
		}
		return resultult;
	}
	
	public static double normaL2(double[] vector) {
		double rezultati = 0;
		for (int i = 0; i < vector.length; i++) {
			rezultati=rezultati+ vector[i] * vector[i];
		}
		return Math.sqrt(rezultati);
	}
	
	public static double[][] multiplyMatrixes(double[][] A, double[][] B) {
		double[][] result = new double[A.length][B[0].length];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B[0].length; j++) {
				for (int k = 0; k < A[0].length; k++) {
					result[i][j] += A[i][k] * B[k][j];
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		double[][] A = { { 0.1, -0.1, 0 }, { 0.1, 0.2, 0 }, { -0.1, 0.2, 0 } };
		double[][] x = newtonEquations(5, A, 0.000000000000000001);
		System.out.println("Zgjidhjet e ekuacionit :");
		System.out.println("x1: " + x[0][0] );
                System.out.println("x2: " + x[1][0] );
                System.out.println("x3: " + x[2][0]);
		System.out.println("Zgjidhjet e peraferta: ");
		System.out.println("E1: " + (3.0 * x[0][0] - Math.cos(x[1][0] * x[2][0]) - 1.0 / 2) + " = 0"); 
		System.out.println("E2: " + (x[0][0] * x[0][0] - 81.0 * Math.pow(x[1][0] + 0.1, 2) + Math.sin(x[2][0]) + 1.06) + " = 0");		
		System.out.println("E3: "+ (Math.exp(-x[0][0] * x[1][0]) + 20.0 * x[2][0] + (10 * Math.PI - 3) / 3.0) + " = 0"); 
				
	}
}
