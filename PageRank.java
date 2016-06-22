/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analiznumerikeushtrime2;


public class PageRank 
{
	// Metoda qe shumezon dy matrica
    public static double[][] multiplyMatrixes(double[][] A, double[][] B) 
    {
        double[][] rez = new double[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) 
        {
            for (int j = 0; j < B[0].length; j++) 
            {
                for (int k = 0; k < A[0].length; k++) 
                {
                    rez[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return rez;
    }
    
	/**  Method that checks if two matrixes are equal	*/
    public static boolean areMatrixesEqual(double[][] A, double[][] B) 
    {
        boolean res = true;
        for (int i = 0; i < A.length; i++) 
        {
            for (int j = 0; j < B[0].length; j++) 
            {
            	if(A[i][j] != B[i][j])
            	{res = false;}
            }
        }
        return res;
    }
    
    public static double[] PageRankVector(double[][] transitionMatrix,double[][] initialImportance)
    {	
    	boolean notEqual = true;
    	int k = 0;
    	double[][] rez = initialImportance;
    	double[][] rez1 = initialImportance;
    	while(notEqual)
    	{
    		rez =  multiplyMatrixes(transitionMatrix,rez);
    		if(areMatrixesEqual(rez,rez1))
    		{notEqual = false;}
    		rez1 = rez;
    	}
    	double[] rez2 = {rez[0][0],rez[1][0],rez[2][0],rez[3][0]};
    	return rez2;
    }
    
    public static void main(String[] args)
    {
    	double[][] A = {{0,0,1.0,0.5},
    					   {1/3.0,0,0,0},
    					   {1/3.0,1/2.0,0,1/2.0},
    					   {1/3.0,1/2.0,0,0}};
    	double[][] B = {{0.25,0,0,0},
						   {0.25,0,0,0},
						   {0.25,0,0,0},
						   {0.25,0,0,0}};
    	double[] pageRanking = PageRankVector(A,B); 
    	System.out.println("The page rank vector is: \n-------------------------------------------------------------------------------");
    	System.out.println("{"+pageRanking[0]+","+pageRanking[1]+","+pageRanking[2]+","+pageRanking[3]+"}");
    }
}
