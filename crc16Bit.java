import java.math.BigInteger;
import java.util.*;

public class crc16Bit {

    public static String getReminder(String dividend,String divider){
    
        BigInteger divid  = new BigInteger(dividend,2);

        BigInteger divis  = new BigInteger(divider,2);

        return divid.divide(divis).toString(2);

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the data word");
        String data = sc.nextLine();

        String divider = "10001000000100001";
        
        String concate = "0000000000000000";

        String reminder = getReminder(data+concate,divider);

        System.out.println("Data word at Sender: "+ data);

        System.out.println("Checksum at sender: "+reminder);

        System.out.println("Code Word at sender: "+data+reminder);
        
        String codeWord = data+reminder;

        String checksumAtRec = getReminder(codeWord.replace('1', '0'), divider);

        // System.out.print(checksumAtRec);
        
        if(checksumAtRec.contains("1")){
            System.out.println("Code word is corrupted");
        }
        else{
            System.out.println("Code is not corrupted!");
        }
        sc.close();
    }
}
