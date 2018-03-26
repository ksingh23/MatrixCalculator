import java.util.Scanner;

public class Command {

	public static void main(String[] args) {
		int[][] matrix1;
		int[][] matrix2;
		double [][] invertMatrix;
		int m;
		int n;
		int input;
		boolean quit = false;
		Scanner scan = new Scanner (System.in);
		while (quit == false) {
			System.out.println ("Press 1 for addition");
			System.out.println ("Press 2 for subtraction");
			System.out.println ("Press 3 for multiplication");
			System.out.println("Press 4 for reduced row echelon form");
			System.out.println ("Press 5 for inverse");
			System.out.println ("Press 6 for determinant");
			System.out.println("Press 0 to quit");
			input = scan.nextInt ();
			if (input == 1 || input == 2 || input == 3) {
				System.out.print("Enter the number of rows in matrix 1: ");
				m = scan.nextInt();
				System.out.print ("Enter the number of columns matrix 1: ");
				n = scan.nextInt();
				matrix1 = new int [m][n];
				System.out.print("Enter the number of rows in matrix 2: ");
				int p = scan.nextInt();
				System.out.print ("Enter the number of columns in matrix 2: ");
				int q = scan.nextInt();
				matrix2 = new int [p][q];
				for (int i = 0; i < m; i++){
					System.out.println ("Enter row " + (i+1) + " of matrix 1");
					for (int j = 0; j < n; j++){
						matrix1 [i][j] = scan.nextInt();
					}
				}
				
				for (int i = 0; i < p; i++){
					System.out.println ("Enter row " + (i+1) + " of matrix 2");
					for (int j = 0; j < q; j++){
						matrix2 [i][j] = scan.nextInt();
					}
				}
				System.out.println("Matrix 1: \t\t Matrix 2:");
				for (int i = 0; i < m; i++){
					for (int j = 0; j < n; j++){
						System.out.print(matrix1 [i][j] + " ");
					}
					System.out.print ("\n");
				}
				System.out.println();
				System.out.println("Matrix 2:");
				for (int i = 0; i < p; i++){
					for (int j = 0; j < q; j++){
						System.out.print(matrix2 [i][j] + " ");
					}
					System.out.print ("\n");
				}
				System.out.println();
				if (input == 1){
					if (m != p || n != q){
						System.out.println ("Not possible");
					}
					
					else{
						Addition add = new Addition ();
						System.out.println("The sum of these matrices is: ");
						add.addMatrix(matrix1, matrix2);
					}
				}
				
				else if (input == 2){
					if (m != p || n != q){
						System.out.println ("Not possible");
					}
					
					else{
						Subtraction sub = new Subtraction ();
						System.out.println("The difference of these matrices is: ");
						sub.subMatrix(matrix1, matrix2);
					}
				}
				
				else if (input == 3){
					if (n != p){
						System.out.println ("Not possible");
					}
					
					else{
						Multiplication mult = new Multiplication ();
						mult.multMatrix(matrix1, matrix2);
					}
				}
			}
			
			else {
				if (input == 4) {
					System.out.println ("Enter the number of rows in the matrix: ");
					m = scan.nextInt();
					System.out.println ("Enter the number of columns in the matrix: ");
					n = scan.nextInt();
					invertMatrix = new double [m][n];
					for (int i = 0; i < m; i++){
						System.out.println ("Enter row " + (i+1) + " of the matrix");
						for (int j = 0; j < n; j++){
							invertMatrix [i][j] = scan.nextInt();
						}
					}
					
					System.out.print ("Matrix: \n");
					for (int i = 0; i < m; i++){
						for (int j = 0; j < n; j++){
							System.out.print("\t" + invertMatrix [i][j] + " ");
						}
						System.out.print ("\n");
					}
					ReducedRowEchelonForm rref = new ReducedRowEchelonForm ();
					System.out.print ("The rref of this matrix is: \n");
					rref.rref(invertMatrix);
				}
				
				else if (input == 5) {
					System.out.println ("Enter the number of rows in the matrix: ");
					m = scan.nextInt();
					System.out.println ("Enter the number of columns in the matrix: ");
					n = scan.nextInt();
					if (m != n) {
						System.out.println ("Not a square matrix, try again");
					}
					
					else {
						double [][] identity = new double [m][n];
						for (int i = 0; i < m; i++) {
							for (int j = 0; j < n; j++) {
								if (i == j){
									identity[i][j] = 1;
								}
								
								else {
									identity[i][j] = 0;
								}
							}
						}
						
						invertMatrix = new double [m][n];
						Inverse inverter = new Inverse ();
						for (int i = 0; i < m; i++){
							System.out.println ("Enter row " + (i+1) + " of the matrix");
							for (int j = 0; j < n; j++){
								invertMatrix [i][j] = scan.nextDouble();
							}
						}
						
						if (inverter.determinant(invertMatrix) == 0) {
							System.out.println("Not invertible: determinant equals 0");
						}
						
						else {
							System.out.print ("Matrix: \n");
							for (int i = 0; i < m; i++){
								for (int j = 0; j < n; j++){
									System.out.print("\t" + invertMatrix [i][j] + " ");
								}
								System.out.print ("\n");
							}
							System.out.println ("Inverse:");
							inverter.inverse(invertMatrix);
						}
					}	
				}
				
				else if (input == 6) {
					System.out.println ("Enter the number of rows in the matrix: ");
					m = scan.nextInt();
					System.out.println ("Enter the number of columns in the matrix: ");
					n = scan.nextInt();
					if (m != n) {
						System.out.println ("Not a square matrix- try again");
					}
					
					else {
						invertMatrix = new double [m][n];
						for (int i = 0; i < m; i++){
							System.out.println ("Enter row " + (i+1) + " of the matrix");
							for (int j = 0; j < n; j++){
								invertMatrix [i][j] = scan.nextDouble();
							}
						}
						
						Inverse inverter = new Inverse ();
						System.out.println ("The determinant of this matrix is: " + inverter.determinant(invertMatrix));
					}
					
				}
				else if (input == 0) {
					quit = true;
					scan.close ();
				}
			}
		}
	}
}
