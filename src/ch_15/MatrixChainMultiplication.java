package ch_15;

import java.util.Arrays;

/*
    Context :- For simple code of multiplying two matrices A(of dimension p X q) and B (q X r), the complexity depends on the number of scalar
    multiplications required to multiply the two matrices which will be equal to p*q*r. Two matrices(A and B) are said to be compatible for
    multiplication if the number of column in first matrix is equal to the number of rows in the second matrix i.e A*B is possible iff
    #column(A) = #row(B).
    Suppose we are given a chain of compatible matrices A1A2A3...An and we want to multiply this chain and get the resultant matrix. There can
    be many possible order in which this matrix could be multiplied(For eg:- For a chain A1A2A3 you can multiply in ((A1A2)A3) or (A1(A2A3)))).
    Both the order will give the same resultant matrix but there can be a huge difference in the number of scalar multiplication done to compute
    that matrix and as a result one order of computation can be faster than the other order. To give the essence of that lets discuss an example.
    Suppose we have a chain of matrix A,B,C with dimensions 10 X 100, 100 X 5 and 5 X 50 respectively. Now we can multiply as follows :-
    1. When we multiply AB first -> (AB)C in which case the number of multiplication would be 10*100*5 (For result of AB, call it D(with dim 10 X 5)) + 10*5*50(For DC) = 7500
    2. When we multiply BC first -> A(BC) in which case the number of multiplication would be 100*5*50 (For result of BC, Call it D(with dim 100 X 50)) + 10*100*50(For AD) = 75000
    There is a difference of 10 times.

    Problem :- For a given chain of matrix A1A2...An, find the order of multiplying the matrices such that the number of scalar multiplication
    is minimum.
 */

public class MatrixChainMultiplication {

    /*
    Naive Recursive Approach -> We know that if the Chain contain only 1 matrix then it is a trivial case where no multiplication needs to be done and the number of multiplications
    required would be 0. If the size is greater than 1 then lets suppose that it has an order which contain the minimum number of multiplication when this is parenthesized at
    matrix k. So, m[1, n] has minimum multiplication when matrix is bifurcated at k. Also, that m[1,k] and m[k+1, n] will also be containing the
    parenthesization such that they are minimum. Why? Because if there was any other way then we could replace that with k and get a lesser value which
    contradicts or assumption. So, our m[1,n] = m[1,k] + m[k+1,n] + row(A1)*col(Ak)*col(An). The 3rd part was added because
    A1...An = (A1..Ak)(A[k+1]...An) => A1...Ak will give a matrix of dim row(A1) X col(Ak) And A[k+1]...An will give a matrix with dim row(A[k+1]) X An
    Also, since both the matrix are compatible, col(Ak) = row(A[k+1]). hence the third part(row(A1)*col(Ak)*col(An)) is added.
     */


    public static void matrixChainRecursive(int[] dimensions){
        int[][] optimalIndex = new int[dimensions.length-1][dimensions.length-1]; // this array will be used to store the optimal value of k where a given chain A[i]...A[j] should be parenthesized
        matrixChainHelper(dimensions, optimalIndex, 0, dimensions.length-2); // j = dimensions.length - 2 because A[n] matrix will have the dimensions as dim[n] * A[n+1].
        // Since last valid dim index is dim.length - 1 so valid n will be one less than the last valid dim[index]
        printOrder(optimalIndex, 0, dimensions.length-2);
    }

    private static int matrixChainHelper(int[] dim, int [][] optimalIndex, int i, int j){
        if (i == j) // Trivial case of chain of size 1
            return 0;
        int min = Integer.MAX_VALUE;  // Initializing the min
        for (int k = i; k < j; k++){
            int altMin = matrixChainHelper(dim, optimalIndex, i, k) + matrixChainHelper(dim, optimalIndex, k+1, j) +
                    dim[i] * dim[k+1] * dim[j+1]; // When chain A[i]...A[j] broken into A[i]...A[k] and A[k+1]...A[j]
            if (altMin < min){
                min = altMin;
                optimalIndex[i][j] = k;
            }
        }
        return min;
    }

    private static void printOrder(int [][] s, int i, int j){
        if (i == j) // The chain contain only one matrix
            System.out.print("A" + i);
        else { // The chain is greater than 1 so needs to be bifurcated
            System.out.print("(");
            printOrder(s, i, s[i][j]);
            printOrder(s, s[i][j]+1, j);
            System.out.print(")");
        }
    }


    /*
    Dynamic programming Approach(Bottom up) :-
    If you have followed the above discussion and observed carefully, our main problem is consist of similar types of smaller problems. Also, our bigger
    problem solution is consist of the solutions of the smaller subproblems. This means that our problem has the optimal substructure i.e the optimal solution
    for a bigger problem can be created by using the optimal solutions of smaller subproblems. Let us analyse that there exist an optimal substructure for the
    problem. Suppose we want to solve for the chain A1A2...An and suppose that it has an optimal solution which has a parenthesis after Ak. Then, we can
    write the above multiplication as (A1A2...Ak)(A[k+1]A[k+2]...An). Also from the previous discussions it should be clear that A1...Ak and Ak+1...An will be
    contain the optimal solution for their chain. Hence, our problem posses the optimal substrucure. Also, in dynamic programming or problem size is defined by
    the length of the chain i.e for solving the problem for a greater length we have to solve all the problems of smaller lengths as they constitute the solution
    for the greater length.
     */
    public static void matrixChainBottomUp(int[] dimensions){
        int[][] matMul = new int[dimensions.length-1][dimensions.length-1]; // Will be used to store the minimum number of multiplication required for Chain A[i]...A[j]
        int[][] optimalIndex = new int[matMul.length][matMul.length]; // Will be used to store the optimal value of k for a chain A[i]...A[j]
        for(int i = 0; i < matMul.length; i++){
            Arrays.fill(matMul[i], Integer.MAX_VALUE); // Initializing the matrix
            matMul[i][i] = 0; // Trivial case of chain of length 1
        }
        for (int l = 2; l <= matMul.length; l++){  // Here we are calculating in the increasing order of length of chain.l denotes the size of chain.
            //The calculation for size 1 is already done during initialization. The max size of chain can be the entire chain which is the length of the matMul array
            for (int i = 0; i <= matMul.length - l; i++){ // the upper bound of i lets analyse:- when i == j then size = 1 => j-i = l-1
                // so i = j-l+1. Now i will be max when j is max. Max value of j is reached when j is the last matrix i.e A[j] = A[n]. The index
                // corresponding to that would be matMul.length - 1. Therefore i = matMul.length - 1 - l + 1 => i = matMul.length - l. So the max
                // value of i can be matMul.length - l
                int j = i + l -1; // from the equation j - i = l - 1
                for (int k = i; k < j; k++){ // k is recording the bifurcation of chain A[i]...A[j]
                    if(matMul[i][j] > matMul[i][k] + matMul[k+1][j] + dimensions[i] * dimensions[k+1] * dimensions[j+1]){
                        matMul[i][j] = matMul[i][k] + matMul[k+1][j] + dimensions[i] * dimensions[k+1] * dimensions[j+1];
                        optimalIndex[i][j] = k;
                    }
                }
            }
        }
        printOrder(optimalIndex, 0, matMul.length-1);
    }

}
