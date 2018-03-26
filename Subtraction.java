
public class Subtraction {
	public void subMatrix (int [][] matrix1, int [][]matrix2){
		int [][] diff = new int [matrix1.length][matrix1 [0].length];
		for (int i = 0; i < diff.length; i++){
			for (int j = 0; j < diff [0].length; j++){
				diff [i][j] = matrix1 [i][j] - matrix2 [i][j];			//Same as addition, just subtract the elements located at matching indexes
			}
		}
		
		for (int i = 0; i < diff.length; i++){					//Print the matrix
			for (int j = 0; j < diff [0].length; j++){
				System.out.print (diff [i][j] + " ");
			}
			System.out.print("\n");
		}
	}
}
