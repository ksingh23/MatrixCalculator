
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
		            if (r != p){				//Checks if entry being changed is a pivot (i.e. [1][1], [2][2])	
		            	double f = -matrix[r][p];		//Factor to multiply by entry to change the elements in the row below it 
		                for (int i = 0; i < matrix[r].length; i++){
		                    matrix[r][i] += f * matrix[p][i];	//Row below changes by subtracting the factor from the element above (i.e. if r = 1 and p = 0, then the operation is R2 = R2 - factor * R1 
		                }		//Does this for all the elements in a row
		            }
		        }		//The if check for r = p is done outside the factor loop because row operations affect the whole row, not just each element being set to 0
		    }
		    
		    for (int i = 0; i < matrix.length; i++){				//Prints the matrix 
				for (int j = 0; j < matrix [0].length; j++){
					System.out.print ("\t" + matrix [i][j] + " ");
				}
				System.out.print("\n");
			}
	}
}
