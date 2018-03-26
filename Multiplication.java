
public class Multiplication {
	public void multMatrix (int [][] matrix1, int [][] matrix2){
		int [][] prod = new int [matrix1.length][matrix2[0].length];
		for (int i = 0; i < prod.length; i++){
			for (int j = 0; j < prod [0].length; j++){
				prod [i][j] = 0;
			}
		}
		
		for (int i = 0; i < matrix1.length; i++){
			for (int j = 0;  j < matrix2.length; j++){
				for (int k = 0; k < matrix2[0].length; k++){
					prod [j][i]+=matrix1 [k][i] * matrix2[j][k];
				}
			}
		}
		
		for (int i = 0; i < prod.length; i++){
			for (int j = 0; j < prod [0].length; j++){
				System.out.print (prod [i][j] + " ");
			}
			System.out.print("\n");
		}
	}
}
