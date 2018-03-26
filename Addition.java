
public class Addition {
	
	public void addMatrix (int [][] matrix1, int [][]matrix2){
		int [][] sum = new int [matrix1.length][matrix1 [0].length];
		for (int i = 0; i < sum.length; i++){
			for (int j = 0; j < sum [0].length; j++){
				sum [i][j] = matrix1 [i][j] + matrix2 [i][j];		//Addition is simple, just add the two elements at the same index
			}
		}
		
		for (int i = 0; i < sum.length; i++){					//Prints the added matrix
			for (int j = 0; j < sum [0].length; j++){
				System.out.print (sum [i][j] + " ");
			}
			System.out.print("\n");
		}
	}
	
}
