
public class ReducedRowEchelonForm {
	public void rref (double [][] matrix) {
		    for (int p = 0; p < matrix.length; p++){
		        double pivot = matrix[p][p];
		        if (pivot != 0){			//Case if the value present is not equal to zero
		            for (int i = 0; i < matrix[p].length; ++i){
		                matrix[p][i] /= pivot;		//Sets all the pivots equal to 1, and divided the remaining content in the rows to mimic		
		            }
		        }

		        for (int r = 0; r < matrix.length; r++){
		            if (r != p){					
		            	double f = -matrix[r][p];
		                for (int i = 0; i < matrix[r].length; i++){
		                    matrix[r][i] += f * matrix[p][i];
		                }
		            }
		        }
		    }
		    
		    for (int i = 0; i < matrix.length; i++){
				for (int j = 0; j < matrix [0].length; j++){
					System.out.print ("\t" + matrix [i][j] + " ");
				}
				System.out.print("\n");
			}
	}
}
