
public class Inverse {
	public boolean checkInvertible (double [][] inversionMatrix) {
		int [][] identity = {{1,0,0},{0,1,0},{0,0,1}};
		boolean invertible = true;
		for (int i = 0; i < inversionMatrix.length; i++) {
			for (int j = 0; j < inversionMatrix.length; j++) {
				if (inversionMatrix[i][j] != identity[i][j]) {
					invertible = false;
					break;
				}
			}
		}
		
		return invertible;
	}
	
	public void inverse (double [][] matrix) {
		double [][] inverse = new double [matrix.length][matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (i == j){
					inverse[i][j] = 1;
				}
				
				else {
					inverse[i][j] = 0;
				}
			}
		}
		for (int p = 0; p < matrix.length; p++){
	        double pivot = matrix[p][p];
	        if (pivot != 0){			//Case if the value present is not equal to zero
	            for (int i = 0; i < matrix[p].length; i++){
	            	inverse[p][i] /= pivot;
	            	matrix[p][i] /= pivot;		//Sets all the pivots equal to 1, and divided the remaining content in the rows to mimic		
	            }
	        }

	        for (int r = 0; r < matrix.length; r++){
	            if (r != p){					
	                double f = -matrix[r][p];
	                for (int i = 0; i < matrix[r].length; i++){
	                	inverse[r][i] += f * inverse[p][i];
	                    matrix[r][i] += f * matrix[p][i];
	                }
	            }
	        }
	    }
	    
		for (int i = 0; i < inverse.length; i++){
			for (int j = 0; j < inverse.length; j++){
				System.out.print("\t" + Math.round(inverse[i][j]) + " ");
			}
			System.out.print ("\n");
		}
	    
	}
}
