import java.util.Scanner;

public class leakyBucket{

    public static void main(String[] args){
        Scanner scan =  new Scanner(System.in);

        System.out.println("Enter the Bucket size: ");
        int bucketSize = scan.nextInt();

        System.out.println("Enter the Outflow Rate of the Data");
        int outFlowRate = scan.nextInt();

        boolean toContinue = true;
      
        int residualBucketSize = 0;

        do{
          System.out.println("Enter your choice: ");
          System.out.println("1.Add the item into Bucket: ");
          System.out.println("2.Exit: ");
           int temp = scan.nextInt();

           switch(temp){
            case 1:System.out.println("Enter the size of the packet: ");
                   int packetSize = scan.nextInt();
                   if(packetSize+residualBucketSize > bucketSize){
                    System.out.println("Bucket size is full need to wait for sometime!!");
                    packetSize = 0 ;
                   } 
                   if(outFlowRate > residualBucketSize+packetSize){
                        System.out.println("Data is outflowed with rate of: "+residualBucketSize+packetSize);
                        residualBucketSize = 0;
                    }
                    else{
                        System.out.println("Data is outflowed with rate of: "+outFlowRate);
                        residualBucketSize = (residualBucketSize+packetSize) - outFlowRate;
                        System.out.println("Residual size of the bucket is : "+residualBucketSize);
                    }
                   break;
            case 2: toContinue = false;
                    break;
           }
        }while(toContinue);
    }
}