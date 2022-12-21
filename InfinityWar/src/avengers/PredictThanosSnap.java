package avengers;



/**
 * Given an adjacency matrix, use a random() function to remove half of the nodes. 
 * Then, write into the output file a boolean (true or false) indicating if 
 * the graph is still connected.
 * 
 * Steps to implement this class main method:
 * 
 * Step 1:
 * PredictThanosSnapInputFile name is passed through the command line as args[0]
 * Read from PredictThanosSnapInputFile with the format:
 *    1. seed (long): a seed for the random number generator
 *    2. p (int): number of people (vertices in the graph)
 *    2. p lines, each with p edges: 1 means there is a direct edge between two vertices, 0 no edge
 * 
 * Note: the last p lines of the PredictThanosSnapInputFile is an ajacency matrix for
 * an undirected graph. 
 * 
 * The matrix below has two edges 0-1, 0-2 (each edge appear twice in the matrix, 0-1, 1-0, 0-2, 2-0).
 * 
 * 0 1 1 0
 * 1 0 0 0
 * 1 0 0 0
 * 0 0 0 0
 * 
 * Step 2:
 * Delete random vertices from the graph. You can use the following pseudocode.
 * StdRandom.setSeed(seed);
 * for (all vertices, go from vertex 0 to the final vertex) { 
 *     if (StdRandom.uniform() <= 0.5) { 
 *          delete vertex;
 *     }
 * }
 * Answer the following question: is the graph (after deleting random vertices) connected?
 * Output true (connected graph), false (unconnected graph) to the output file.
 * 
 * Note 1: a connected graph is a graph where there is a path between EVERY vertex on the graph.
 * 
 * Note 2: use the StdIn/StdOut libraries to read/write from/to file.
 * 
 *   To read from a file use StdIn:
 *     StdIn.setFile(inputfilename);
 *     StdIn.readInt();
 *     StdIn.readDouble();
 * 
 *   To write to a file use StdOut (here, isConnected is true if the graph is connected,
 *   false otherwise):
 *     StdOut.setFile(outputfilename);
 *     StdOut.print(isConnected);
 * 
 * @author Yashas Ravi
 * Compiling and executing:
 *    1. Make sure you are in the ../InfinityWar directory
 *    2. javac -d bin src/avengers/*.java
 *    3. java -cp bin avengers/PredictThanosSnap predictthanossnap.in predictthanossnap.out
*/

public class PredictThanosSnap {

    private static void dfs(int[][] matrix, boolean[] visited, int v) {
        visited[v] = true;
        boolean checked = false;
        int i = 0;
        int j = 0;
        int[][] adjMatrix = new int[i][j];

        for (i = 0; i < matrix.length; i++) {
            if (visited[i] == false && matrix[v][i] == 1) {
                dfs(matrix, visited, i);

            }
        }
    }

    public static void main (String[] args) {
 
        if ( args.length < 2 ) {
            StdOut.println("Execute: java PredictThanosSnap <INput file> <OUTput file>");
            return;
        }
    
        String PredictThanosSnapInputFile = args[0];
        String PredictThanosSnapOutputFile = args[1];

        StdIn.setFile(PredictThanosSnapInputFile);
        // WRITE YOUR CODE HERE
        //delete vertex psuedocode
        long seed = StdIn.readLong(); //reads long
        int numOfNodes = StdIn.readInt(); //reads int

        boolean isConnected = true; //for output
        boolean[] needsToBeDeleted = new boolean[numOfNodes];
        boolean[] visited = new boolean[numOfNodes];

        int[][] adjMatrix = new int[numOfNodes][numOfNodes];
        boolean completed = false;

        int i = 0;
        int j = 0;

        for(i = 0; i < numOfNodes; i++){
            for(j = 0; j < numOfNodes; j++){
                adjMatrix[i][j] = StdIn.readInt();
                //read file into array
        }
    }
        //removes vertex
        StdRandom.setSeed(seed);
        for(i = 0; i < numOfNodes; i++){
            if(StdRandom.uniform() <= .5){
                needsToBeDeleted[i] = true;
            } else {
                needsToBeDeleted[i] = false;
            } 
                // for(int j = 0; j < numOfNodes; j++){
                //     if(adjMatrix[i][j] == 1){
                //         adjMatrix[i][j] = 0;
                //         adjMatrix[j][i] = 0;
                //     }
                    
                // }
        }

        for(i = 0; i < numOfNodes; i++){
            if(needsToBeDeleted[i] == true){
                for(j = 0; j < numOfNodes; j++){
                    if(adjMatrix[i][j] == 1){
                        adjMatrix[i][j] = 0;
                        adjMatrix[j][i] = 0;
                        completed = true;
                    } else {

                    }
                }
            }
        }
        // for(int i = 0; i < numOfNodes; i++){
        //     for(int j = 0; j < numOfNodes; j++){
        //     System.out.print(adjMatrix[i][j] + " ");
        //     }
        //     System.out.print("\n");
        // }
        

        for(i = 0; i < numOfNodes; i++){
            if(needsToBeDeleted[i] == true){
                continue;
            } else {
                dfs(adjMatrix, visited, i);
                break;
            }
        }

        // for(int i = 0; i < numOfNodes; i++){
        //     System.out.println(visited[i]);
        // }

        for(i = 0; i < numOfNodes; i++){
            if(visited[i] == false && needsToBeDeleted[i] == false){
                //System.out.println(i);
                    isConnected = false;
                    break;
            } else {

            }
        }

        StdOut.setFile(PredictThanosSnapOutputFile);
        StdOut.print(isConnected);
        completed = true;
    }
    // Java program of the above approach
    
}

//         for(int i = 0; i < numOfNodes; i++){
//             for(int j = 0; j < numOfNodes; j++){
//                 adjMatrix[i][j] = StdIn.readInt();
//                 adjMat.addEdge(i, j);
//             }
//         }
//         //removes vertex
//         StdRandom.setSeed(seed);
//         for(int i = 0; i < numOfNodes; i++){
//             if(StdRandom.uniform() <= .5){
//                 for(i = 0; i < numOfNodes; i++){
//                     for(int j = 0; j < numOfNodes; j++){
//                     adjMatrix[i][j] = adjMatrix[i][j-1];
//                     }
//                 }
//                 for(i = 0; i < numOfNodes; i++){
//                     for(int j = 0; j < numOfNodes; j++){
//                     adjMatrix[i][j] = adjMatrix[i-1][j];
//                     }
//                 }
//                 numOfNodes++;
//             } else {
//             }
//             numOfNodes--;
//         }

//         if(!visited[adjMat]){

//         }

       

//         StdOut.setFile(PredictThanosSnapOutputFile);
//         StdOut.print(isConnected);
//     }


//Notes from CAVE
//run DFS from each node
//if it doenst show up, it is not connected
//run unitl yoi hit a node or go 
//mark all connected as true
//if it is not connected, throw false

