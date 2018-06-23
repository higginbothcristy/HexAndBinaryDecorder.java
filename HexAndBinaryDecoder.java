import java.util.Scanner;
import java.lang.String;
import java.lang.Math;

public class HexAndBinaryDecoder {

    public static long hexStringDecode(String hex){
        int[] hexInt = new int[10];
        char[] hexChar = new char[10];
        int trueHexLength = hex.length();

        for(int i=0; i < hex.length(); ++i){
            hexChar[i] = hex.charAt(i);
        }
        int k = 0;
        if((hexChar[0] == '0') && (hexChar[1] == 'x')){
             trueHexLength = hex.length()-2;
             k = 2;
        }
        for(int i = k; i < hex.length(); ++i){
           hexInt[i] = hexCharDecode(hexChar[i]);
        }
        long sum = 0;
        for(int j=0; j < trueHexLength; ++j) {
            sum = sum + ((hexInt[(hex.length()-1)-j]) * ((long)Math.pow(16, j)));
        }

      return sum;
    }
    public static short hexCharDecode(char hexChar){
        short value = 0;

        if(hexChar == '0'){ value = 0;}
        if(hexChar == '1'){ value = 1;}
        if(hexChar == '2'){ value = 2;}
        if(hexChar == '3'){ value = 3;}
        if(hexChar == '4'){ value = 4;}
        if(hexChar == '5'){ value = 5;}
        if(hexChar == '6'){ value = 6;}
        if(hexChar == '7'){ value = 7;}
        if(hexChar == '8'){ value = 8;}
        if(hexChar == '9'){ value = 9;}
        if((hexChar == 'A')||(hexChar == 'a')){ value = 10;}
        if((hexChar == 'B')||(hexChar == 'b')){ value = 11;}
        if((hexChar == 'C')||(hexChar == 'c')){ value = 12;}
        if((hexChar == 'D')||(hexChar == 'd')){ value = 13;}
        if((hexChar == 'E')||(hexChar == 'e')){ value = 14;}
        if((hexChar == 'F')||(hexChar == 'f')){ value = 15;}

    return value;
    }

    public static long binaryStringDecode(String bin){
        long sumB = 0;
        char[] binChar = new char[66];
        int trueBinLength = bin.length();

        for(int i=0; i < bin.length(); ++i){
            binChar[i] = bin.charAt(i);
        }

        if((binChar[0] == '0') && (binChar[1] == 'b')){
            trueBinLength = bin.length()-2;
        }

        for(int j=0; j < trueBinLength; ++j) {
            sumB = sumB + ((Character.getNumericValue(binChar[(bin.length()-1)-j])) * ((long)Math.pow(2, j)));
        }
        return sumB;
    }
    public static String binaryToHex(String bin){
        char[] hexChar = new char[10];
        char[] binChar = new char[66];
        int[] binInt = new int[66];
        int[] hexInt = new int[10];
        int trueBinLength = bin.length();
        int k = 0;
        int b = 0; // binary number

        for(int i=0; i < bin.length(); ++i){
            binChar[i] = bin.charAt(i);
        }
        if((binChar[0] == '0') && (binChar[1] == 'b')){
            trueBinLength = bin.length()-2;
            k = 2;
        }
        for(int i = k; i < bin.length(); ++i){
            binInt[i] = Character.getNumericValue(binChar[i]);
        }
        // add zeros to front of binary to make divisible by 4
        int numZero = 0;
        if ((trueBinLength % 4)> 0) {
            numZero = 4 - (trueBinLength % 4);
        }
        int[] newBin = new int[69];
        trueBinLength = trueBinLength + numZero;

        for (int i = 0; i < (numZero); ++i){
            newBin[i] = 0;
        }
        for(int i=0; i < bin.length(); ++i){
            newBin[i + numZero] = binInt[i];
        }
        int hexLength = (trueBinLength) / 4;

        for (b = 0; b < hexLength; ++b){
            for (int j = ( b*4); j < ((b*4) + 4); ++j) {
                hexInt[b] = hexInt[b] + ((newBin[bin.length() - 1 + numZero - j] * ((int) Math.pow(2, j-(b*4)))));
            }
            if((hexInt[b] > -1) && (hexInt[b] < 10)) {
                hexChar[b] = (char)(hexInt[b] + 48);
            }
            else if(hexInt[b] > 9){
                hexChar[b] = (char)(hexInt[b] + 55);
            }
        }
        for (int i = 0; i < hexLength/2; i++){
            char temp = hexChar[i];
            hexChar[i] = hexChar[hexLength-1-i];
            hexChar[hexLength-1-i] = temp;
        }
        String hexStr = new String(hexChar);

     return hexStr ;
    }
    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);
        long hexStringDecode;
        short hexCharDecode;
        long binaryStringDecode;
        String binaryToHex;
        int option = 0;

        while(option != 4 ) {
            System.out.println("Choose an option: ");
            System.out.println("1. Decode a hex string.");
            System.out.println("2. Decode a binary string.");
            System.out.println("3. Convert binary to hex.");
            System.out.println("4. Quit.");

            option = scnr.nextInt();

            if (option == 1) {
                System.out.println("Please enter the hex string: ");
                String hexString = scnr.next();
                System.out.println("Result: " + hexStringDecode(hexString));
            }
            else if (option == 2) {
                System.out.println("Please enter the binary string: ");
                String bin = scnr.next();
                System.out.println("Result: " + binaryStringDecode(bin));
            }
            else if (option == 3){
                System.out.println("Please enter the binary string: ");
                String bin = scnr.next();
                System.out.println("Result: " + binaryToHex(bin));
            }
        }
            System.out.println("Quitting program.");
    }
}
