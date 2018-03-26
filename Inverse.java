import java.text.DecimalFormat;

public class Inverse {
	DecimalFormat f = new DecimalFormat ("##.00");
	public int determinant (double [][] matrix) {
		 int determinant = 0; 
		    if(matrix.length==1) {  
		      determinant =  (int) matrix[0][0];
		      return determinant;
		    }
		    
		    else {
		    	for(int i = 0; i < matrix.length; i++){ 
				      double[][] smaller= new double[matrix.length-1][matrix.length-1]; 
				      for(int j = 1; j < matrix.length; j++) {			//The matrix for the recursive call starts one row below the top
				    	  for(int k = 0; k <matrix.length; k++){			//Iterates across the columns
					          if (k < i){
					            smaller[j-1][k]=matrix[j][k];			
					          }
					          else if (k > i) {
					            smaller[j-1][k-1]=matrix[j][k];
					          }
					       }
				      }
				      if(i % 2 == 0){			//When computing determinant, you must multiply top row by matrix below, and it is positive for even columns, odd for negative ones
				    	  determinant += matrix[0][i] * (determinant(smaller)); 
				      }
				      else{
				    	  determinant += -1 * matrix[0][i] * (determinant(smaller)); 
				      }
				    }
		    	
		    	 return determinant; 
		    }
		   
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
				System.out.print("\t" + f.format(inverse[i][j]) + " ");
			}
			System.out.print ("\n");
		}
	    
	}
}
