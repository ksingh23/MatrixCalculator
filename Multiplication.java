// Hi there!
public class Multiplication {
	public void multMatrix (int [][] matrix1, int [][] matrix2){
		int [][] prod = new int [matrix1.length][matrix2[0].length];		
		for (int i = 0; i < prod.length; i++){
			for (int j = 0; j < prod [0].length; j++){
				prod [i][j] = 0;
			}
		}
		
		for (int i = 0; i < matrix1.length; i++){			//First loop iterates across the columns of matrix1
			for (int j = 0;  j < matrix2.length; j++){		//Second loop iterates across the rows of matrix2
				for (int k = 0; k < matrix2[0].length; k++){		//This loop iterates across the row/column pair being multiplied
					prod [j][i]+=matrix1 [k][i] * matrix2[j][k];		//First elem in row times first elem in col of matrix2
				}													//j then jumps to the second elem [1][0] of the product matrix, and fills the row, hence why
																	//you use matrix2[j][k]
			}												//Then, i jumps to the next row of the product matrix
		}
		
		for (int i = 0; i < prod.length; i++){				//Prints the product matrix
			for (int j = 0; j < prod [0].length; j++){
				System.out.print (prod [i][j] + " ");
			}
			System.out.print("\n");
		}
	}
}
