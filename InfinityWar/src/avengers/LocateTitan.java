package avengers;

import java.util.Currency;

/**
 * 
 * Using the Adjacency Matrix of n vertices and starting from Earth (vertex 0), 
 * modify the edge weights using the functionality values of the vertices that each edge 
 * connects, and then determine the minimum cost to reach Titan (vertex n-1) from Earth (vertex 0).
 * 
 * Steps to implement this class main method:
 * 
 * Step 1:
 * LocateTitanInputFile name is passed through the command line as args[0]
 * Read from LocateTitanInputFile with the format:
 *    1. g (int): number of generators (vertices in the graph)
 *    2. g lines, each with 2 values, (int) generator number, (double) funcionality value
 *    3. g lines, each with g (int) edge values, referring to the energy cost to travel from 
 *       one generator to another 
 * Create an adjacency matrix for g generators.
 * 
 * Populate the adjacency matrix with edge values (the energy cost to travel from one 
 * generator to another).
 * 
 * Step 2:
 * Update the adjacency matrix to change EVERY edge weight (energy cost) by DIVIDING it 
 * by the functionality of BOTH vertices (generators) that the edge points to. Then, 
 * typecast this number to an integer (this is done to avoid precision errors). The result 
 * is an adjacency matrix representing the TOTAL COSTS to travel from one generator to another.
 * 
 * Step 3:
 * LocateTitanOutputFile name is passed through the command line as args[1]
 * Use Dijkstra’s Algorithm to find the path of minimum cost between Earth and Titan. 
 * Output this number into your output file!
 * 
 * Note: use the StdIn/StdOut libraries to read/write from/to file.
 * 
 *   To read from a file use StdIn:
 *     StdIn.setFile(inputfilename);
 *     StdIn.readInt();
 *     StdIn.readDouble();
 * 
 *   To write to a file use StdOut (here, minCost represents the minimum cost to 
 *   travel from Earth to Titan):
 *     StdOut.setFile(outputfilename);
 *     StdOut.print(minCost);
 *  
 * Compiling and executing:
 *    1. Make sure you are in the ../InfinityWar directory
 *    2. javac -d bin src/avengers/*.java
 *    3. java -cp bin avengers/LocateTitan locatetitan.in locatetitan.out
 * 
 * @author Yashas Ravi
 * 
 */

public class LocateTitan {
    
    public static void main (String [] args) {
        
        if ( args.length < 2 ) {
            StdOut.println("Execute: java LocateTitan <INput file> <OUTput file>");
            return;
        }

        String LocateTitanInputFile = args[0];
        String LocateTitanOutputFile = args[1];

        StdIn.setFile(LocateTitanInputFile);
        // WRITE YOUR CODE HERE
        int numOfGen = StdIn.readInt();
        boolean checkIfComplete = false;

        double[] generatorNums = new double[numOfGen];
        int[][] matrix = new int[numOfGen][numOfGen];

        int i;
        int j;


        for(i = 0; i < numOfGen; i++){
            int level = StdIn.readInt();
            generatorNums[i] = StdIn.readDouble();
            //double generatorNum = StdIn.readDouble();
            //double[] generatorNums = new double[generatorNum];
            //read file into array
        }

        for(i = 0; i < numOfGen; i++){
            for(j = 0; j < numOfGen; j++){
                matrix[i][j] = StdIn.readInt();
                //read file into array
        }
    }
   
        int[][] newMatrix = new int[numOfGen][numOfGen];
        //divide by functionality of both vertices (generators)

        for(i = 0; i < numOfGen; i++){
            for(j = 0; j < numOfGen; j++){
        double calc = (double)matrix[i][j]/(double)(generatorNums[i]*generatorNums[j]);
        int calcFinal = (int) calc;
         //casting to int
        newMatrix[i][j] = (calcFinal);
        }
    }

    // for(int i = 0; i < numOfGen; i++){
    //     for(int j = 0; j < numOfGen; j++){
    //         System.out.print(newMatrix[i][j] + " ");
    //     }
    //     System.out.print("\n");
    // }

    //DIJKSTRA'S

        int[] minCost = new int[numOfGen];
        boolean[] dijkstraSet = new boolean[numOfGen];
     
        
        for(i = 0; i < minCost.length; i++){
            if(i != 0) {
                minCost[i] = Integer.MAX_VALUE;
            } else if (i == 0){
                minCost[0] = 0;
            }
            //System.out.println(minCost[i]);
            checkIfComplete = true;
        }

       
        for(i = 0; i < minCost.length - 1; i++){

            int currentSource = shortestPath(minCost, dijkstraSet, numOfGen);
            //System.out.println(currentSource);

            dijkstraSet[currentSource] = true;

            for(j = 0; j < minCost.length; j++){
                if(minCost[j] > (minCost[currentSource] + newMatrix[currentSource][j]) && minCost[currentSource] != Integer.MAX_VALUE && newMatrix[currentSource][j] > 0 && dijkstraSet[j] == false){
                    minCost[j] = newMatrix[currentSource][j] + minCost[currentSource];
                } 

                // curentSource node does not have a minCost of infinity AND 
                // the total cost frm 0 to the neighbor node is smaller than its current cost){
                // minCost[neighbor node] = minCost[currentSource] + edge cost from currentSource to neighbor node
                }
            }

            StdOut.setFile(LocateTitanOutputFile);
            StdOut.print(minCost[numOfGen - 1]);
            checkIfComplete = true;
        }

        private static int shortestPath(int[] matrix, boolean[] visited, int v) {
            int tracker = -1;
            int cost = Integer.MAX_VALUE;
            boolean checkIfComplete = false;
     
             for (int i = 0; i < v; i++) {
                 if(visited[i] == false && matrix[i] < cost){
                     cost = matrix[i];

                     tracker = i;
                 } else if (visited[i] == true){
                    
                 } else if (matrix[i] >= cost){

                 } else {
                    
                 }
             }
             checkIfComplete = true;
             return tracker;
         }

    }
   
        



















// //review code below (ADDITIONAL CODE)
// // class Dijkstra {

// //     public static void dijkstra(int[][] graph, int source) {
// //       int count = graph.length;
// //       boolean[] visitedVertex = new boolean[count];
// //       int[] distance = new int[count];
// //       for (int i = 0; i < count; i++) {
// //         visitedVertex[i] = false;
// //         distance[i] = Integer.MAX_VALUE;
// //       }
  
// //       // Distance of self loop is zero
// //       distance[source] = 0;
// //       for (int i = 0; i < count; i++) {
  
// //         // Update the distance between neighbouring vertex and source vertex
// //         int u = findMinDistance(distance, visitedVertex);
// //         visitedVertex[u] = true;
  
// //         // Update all the neighbouring vertex distances
// //         for (int v = 0; v < count; v++) {
// //           if (!visitedVertex[v] && graph[u][v] != 0 && (distance[u] + graph[u][v] < distance[v])) {
// //             distance[v] = distance[u] + graph[u][v];
// //           }
// //         }
// //       }
// //       for (int i = 0; i < distance.length; i++) {
// //         System.out.println(String.format("Distance from %s to %s is %s", source, i, distance[i]));
// //       }
  
// //     }
  
// //     // Finding the minimum distance
// //     private static int findMinDistance(int[] distance, boolean[] visitedVertex) {
// //       int minDistance = Integer.MAX_VALUE;
// //       int minDistanceVertex = -1;
// //       for (int i = 0; i < distance.length; i++) {
// //         if (!visitedVertex[i] && distance[i] < minDistance) {
// //           minDistance = distance[i];
// //           minDistanceVertex = i;
// //         }
// //       }
// //       return minDistanceVertex;
// //     }
// // }




// //loop from part of an array to back around
// // i = 3
// // while (i != 2) {
// //   // some code
// //   i = (i + 1) % arr.length
// // }
