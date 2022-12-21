package huffman;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;




/**
 * This class contains methods which, when used together, perform the
 * entire Huffman Coding encoding and decoding process
 * 
 * @author Ishaan Ivaturi
 * @author Prince Rawal
 */
public class HuffmanCoding {
    private String fileName;
    private ArrayList<CharFreq> sortedCharFreqList;
    private TreeNode huffmanRoot;
    private String[] encodings;

    /**
     * Constructor used by the driver, sets filename
     * DO NOT EDIT
     * @param f The file we want to encode
     */
    public HuffmanCoding(String f) { 
        fileName = f; 
    }

    /**
     * Reads from filename character by character, and sets sortedCharFreqList
     * to a new ArrayList of CharFreq objects with frequency > 0, sorted by frequency
     */
    public void makeSortedList() {
        StdIn.setFile(fileName);
     
        int given = 0;
        char counter;
    
        int[] freqOfChar = new int[128];

        sortedCharFreqList = new ArrayList();

        while (StdIn.hasNextChar()){
            char charSelected = StdIn.readChar();
           
            given++;
            freqOfChar[charSelected]++;
        }
        
        for (counter = (char)0; (counter < freqOfChar.length); counter++){
            if ((freqOfChar[counter] != 0)){
                CharFreq getCharFreq = new CharFreq(counter,(double)freqOfChar[counter]/given);

                sortedCharFreqList.add(getCharFreq);
                
            } else {
            }
            
        }
        Collections.sort(sortedCharFreqList);

        if (sortedCharFreqList.size() != 1){
        } else {
            CharFreq calculateFreqPerBit = new CharFreq((char)((sortedCharFreqList.get(0).getCharacter() + 1) % 128), 0.0);
            sortedCharFreqList.add(calculateFreqPerBit);
        }

    Collections.sort(sortedCharFreqList);
    }

        

    /**
     * Uses sortedCharFreqList to build a huffman coding tree, and stores its root
     * in huffmanRoot
     */
    public void makeTree() {

        Queue<TreeNode> targetInQueue = new Queue<TreeNode>();
        Queue<CharFreq> sourceInQueue= new Queue<CharFreq>();
        Queue<TreeNode> fillWithBits = new Queue<TreeNode>();

        int counter = 0;
        while(counter < sortedCharFreqList.size()){
            sourceInQueue.enqueue(sortedCharFreqList.get(counter));
            counter++;
        }
        
        int i = 0;
        //use for debugging 

        while(sourceInQueue.isEmpty() != true || targetInQueue.size() != 1){

            TreeNode tempNode1 = null;
            TreeNode tempNode2 = null;
           
            //TEMP NODE 1
            if(targetInQueue.isEmpty()){
                CharFreq deqCalc = sourceInQueue.dequeue();
                tempNode1 = new TreeNode(deqCalc,null,null);
                tempNode1.getData();

            } else if(sourceInQueue.isEmpty()){
                tempNode1 = targetInQueue.dequeue();
                tempNode1.getData();

            } 
             else{ 
                if (sourceInQueue.peek().getProbOcc() <= targetInQueue.peek().getData().getProbOcc()){
                tempNode1 = new TreeNode(sourceInQueue.dequeue(),null,null);
                tempNode1.getData();

            // } else if(sourceInQueue.peek().getProbOcc() == targetInQueue.peek().getData().getProbOcc()) {
            //     tempNode1 = new TreeNode(sourceInQueue.dequeue(),null,null);
            
             } else if(sourceInQueue.peek().getProbOcc() > targetInQueue.peek().getData().getProbOcc()) {
                tempNode1 = targetInQueue.dequeue();
                tempNode1.getData();
            }
        }

            //TEMP NODE 2
            if(targetInQueue.isEmpty()){
                CharFreq deqCalc = sourceInQueue.dequeue();
                tempNode2 = new TreeNode(deqCalc,null,null);
                tempNode2.getData();

            } else if(sourceInQueue.isEmpty()){
                tempNode2 = targetInQueue.dequeue();
                tempNode2.getData();

            } 
             else
            { if (sourceInQueue.peek().getProbOcc() <= targetInQueue.peek().getData().getProbOcc()){
                tempNode2 = new TreeNode(sourceInQueue.dequeue(),null,null);
                tempNode2.getData();

            // } else if(sourceInQueue.peek().getProbOcc() == targetInQueue.peek().getData().getProbOcc()) {
            // tempNode2 = new TreeNode(sourceInQueue.dequeue(),null,null);
            
            } else if(sourceInQueue.peek().getProbOcc() > targetInQueue.peek().getData().getProbOcc()) {
                tempNode2 = targetInQueue.dequeue();
                tempNode2.getData();
        }
    }
            
            TreeNode root = new TreeNode(new CharFreq(null, tempNode1.getData().getProbOcc() + tempNode2.getData().getProbOcc()), tempNode1, tempNode2);
            targetInQueue.enqueue(root);
            i++;
        }
       
        huffmanRoot = targetInQueue.peek();
    }
    

    /**
     * Uses huffmanRoot to create a string array of size 128, where each
     * index in the array contains that ASCII character's bitstring encoding. Characters not
     * present in the huffman coding tree should have their spots in the array left null.
     * Set encodings to this array.
     */

    public void makeEncodings() {
      encodings = new String[128];
        arrangeForEncoding(huffmanRoot, "");
        
    }

    private void arrangeForEncoding(TreeNode selectNode, String encodedStringArray){

        if(selectNode.getLeft() == null && selectNode.getRight() == null){
            encodings[selectNode.getData().getCharacter()] = encodedStringArray;
        }
            
        else {
            arrangeForEncoding(selectNode.getLeft(), encodedStringArray +"0");
            arrangeForEncoding(selectNode.getRight(), encodedStringArray +"1");
        }
    }
    




//EXTRA WORK
        //     if(selectNode.getData().getCharacter() == null){
        //         } else {
        //             encodedStringArray[selectNode.getData().getCharacter()] = String.join("");
        //             selectNode.getData();

                 
        //             return;
        //         }
        
        //         if (selectNode.getLeft() == null){
        //         } else {
        //             encodingsArrayList.add("0");
        //             selectNode.getData();
        //         }
        
        //         arrangeForEncoding(selectNode.getLeft(), encodingsArrayList, encodedStringArray);
        //  
        //         } else {
        //             encodingsArrayList.add("1");
        //             selectNode.getData();
        //         }
        
        //         
        //         if (encodingsArrayList.isEmpty()){
        //         } else {
        //             encodingsArrayList.remove(encodingsArrayList.size()-1);
        //             selectNode.getData();
        //         }
        // }



            

    //     ArrayList<String> encodedInto = new ArrayList<>();
    //     String[] encodingSize128 = new String[128];
    //     String[] fillBitString = new String[128];
    //     String[] fillBitFinal = new String[128];
    //     String[] encodings;

    //     arrangeAndEncode(huffmanRoot, encodingSize128, encodedInto);
    //     encodings = encodingSize128;
    // }

  
    
    // private void arrangeAndEncode(TreeNode newNode, String[] encodingSize128){
    //     if(!(newNode.getData().getCharacter() == null)){

    //         encodingSize128[ newNode.getData().getCharacter()] = String.join("");
    //         newNode.getData();
    //         encodings.remove(encodings.size()-1);
    //             return; }

    //     if (!( newNode.getLeft() == null)){
    //          newNode.getData();
    //         encodedInto.add("0"); }

    
    //     if (!(encodedInto.isEmpty())){
    //          newNode.getData();
    //         encodedInto.remove(encodedInto.size()-1); }
    // }


//         ArrayList<String> encodingsArrayList = new ArrayList<>();
//         ArrayList<String> updatedEncodings = new ArrayList<>();
//         String[] encodedFilled = new String[128];
//         String[] encodedStringArray = new String[128];
        
//         arrangeForEncoding(huffmanRoot, encodingsArrayList, encodedStringArray);
//         encodings = encodedStringArray;
//     }
    
//     private void arrangeForEncoding(TreeNode selectNode, ArrayList<String> encodingsArrayList, String[] encodedStringArray){
//         
//         } else {
//             encodedStringArray[selectNode.getData().getCharacter()] = String.join("", encodingsArrayList);
//             
//             encodingsArrayList.remove(encodingsArrayList.size() - 1);
//             return;
//         }


//         arrangeForEncoding(selectNode.getLeft(), encodingsArrayList, encodedStringArray);
//         if (selectNode.getRight() == null){
//         } else {
//             encodingsArrayList.add("1");
//             selectNode.getData();
//         }

//         arrangeForEncoding(selectNode.getRight(), encodingsArrayList, encodedStringArray);
//         if (encodingsArrayList.isEmpty()){
//         } else {
//             encodingsArrayList.remove(encodingsArrayList.size()-1);
//             selectNode.getData();
//         }
// }

    /**
     * Using encodings and filename, this method makes use of the writeBitString method
     * to write the final encoding of 1's and 0's to the encoded file.
     * 
     * @param encodedFile The file name into which the text file is to be encoded
     */
    public void encode(String encodedFile) {
        String compressFile = "";
        String compressor;
        StdIn.setFile(fileName);
        String encoder;
        ArrayList<String> bitFill = new ArrayList<String>();

        while(StdIn.hasNextChar()){
            compressFile = compressFile + encodings[(int) StdIn.readChar()];
        }
        writeBitString(encodedFile, compressFile);
        // System.out.print(encodings);
    }


    
    
    
    /**
     * Writes a given string of 1's and 0's to the given file byte by byte
     * and NOT as characters of 1 and 0 which take up 8 bits each
     * DO NOT EDIT
     * 
     * @param filename The file to write to (doesn't need to exist yet)
     * @param bitString The string of 1's and 0's to write to the file in bits
     */
    public static void writeBitString(String filename, String bitString) {
        byte[] bytes = new byte[bitString.length() / 8 + 1];
        int bytesIndex = 0, byteIndex = 0, currentByte = 0;

        // Pad the string with initial zeroes and then a one in order to bring
        // its length to a multiple of 8. When reading, the 1 signifies the
        // end of padding.
        int padding = 8 - (bitString.length() % 8);
        String pad = "";
        for (int i = 0; i < padding-1; i++) pad = pad + "0";
        pad = pad + "1";
        bitString = pad + bitString;

        // For every bit, add it to the right spot in the corresponding byte,
        // and store bytes in the array when finished
        for (char c : bitString.toCharArray()) {
            if (c != '1' && c != '0') {
                System.out.println("Invalid characters in bitstring");
                return;
            }

            if (c == '1') currentByte += 1 << (7-byteIndex);
            byteIndex++;
            
            if (byteIndex == 8) {
                bytes[bytesIndex] = (byte) currentByte;
                bytesIndex++;
                currentByte = 0;
                byteIndex = 0;
            }
        }
        
        // Write the array of bytes to the provided file
        try {
            FileOutputStream out = new FileOutputStream(filename);
            out.write(bytes);
            out.close();
        }
        catch(Exception e) {
            System.err.println("Error when writing to file!");
        }
    }

    /**
     * Using a given encoded file name, this method makes use of the readBitString method 
     * to convert the file into a bit string, then decodes the bit string using the 
     * tree, and writes it to a decoded file. 
     * 
     * @param encodedFile The file which has already been encoded by encode()
     * @param decodedFile The name of the new file we want to decode into
     */

    public void decode(String encodedFile, String decodedFile) {
        StdOut.setFile(decodedFile);
        
        TreeNode tempRoot = huffmanRoot;
        String readBits = readBitString(encodedFile);
        String decoder = "";

        int counter = 0;

        for(int i = 0; counter < readBits.length(); i++){
            if(readBits.charAt(counter) == '1'){
                tempRoot = tempRoot.getRight();
                counter ++; 
            }
            else if(readBits.charAt(counter) == '0'){
                tempRoot = tempRoot.getLeft();
                counter ++;
            }

            if(tempRoot.getRight() == null && tempRoot.getLeft() == null){
                decoder += tempRoot.getData().getCharacter();
                tempRoot = huffmanRoot;
            }
        }
        StdOut.print(decoder);
    }
    
    //     decodingFileMethod(encodedFile, decodedFile, huffmanRoot);
    //     String decoded; 
    //     StdOut.print(decodedFile);
    // }

    // private TreeNode decodingFileMethod(String encodedFile, String decodedFile, TreeNode baseRoot){
    
    //     decodedFile = "";
    //     String encodedF = readBitString(encodedFile);
    //     TreeNode testingNode;
    //     TreeNode ptr;

    //     while(!(encodedF.length() == 0)){
        
    //     int countForEncode = 0;
    //     int num = 0;
    //     TreeNode treeNodeBaseRoot = baseRoot;
    //     treeNodeBaseRoot.getData();
    //     baseRoot.getData();

    //     if(treeNodeBaseRoot.getData().getCharacter() == null) {
    
            
    //         countForEncode++;     
    //     }

    //     decodedFile += treeNodeBaseRoot.getData().getCharacter();
    //     treeNodeBaseRoot.getData();

    //     encodedF = encodedF.substring(countForEncode);
    // }
    
    // return huffmanRoot;




    /**
     * Reads a given file byte by byte, and returns a string of 1's and 0's
     * representing the bits in the file
     * DO NOT EDIT
     * 
     * @param filename The encoded file to read from
     * @return String of 1's and 0's representing the bits in the file
     */
    public static String readBitString(String filename) {
        String bitString = "";
        
        try {
            FileInputStream in = new FileInputStream(filename);
            File file = new File(filename);

            byte bytes[] = new byte[(int) file.length()];
            in.read(bytes);
            in.close();
            
            // For each byte read, convert it to a binary string of length 8 and add it
            // to the bit string
            for (byte b : bytes) {
                bitString = bitString + 
                String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
            }

            // Detect the first 1 signifying the end of padding, then remove the first few
            // characters, including the 1
            for (int i = 0; i < 8; i++) {
                if (bitString.charAt(i) == '1') return bitString.substring(i+1);
            }
            
            return bitString.substring(8);
        }
        catch(Exception e) {
            System.out.println("Error while reading file!");
            return "";
        }
    }

    /*
     * Getters used by the driver. 
     * DO NOT EDIT or REMOVE
     */

    public String getFileName() { 
        return fileName; 
    }

    public ArrayList<CharFreq> getSortedCharFreqList() { 
        return sortedCharFreqList; 
    }

    public TreeNode getHuffmanRoot() { 
        return huffmanRoot; 
    }

    public String[] getEncodings() { 
        return encodings; 
    }
}
