import java.util.*;

public class IPinput {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Input an IPv4 address: "); //prompt user for IP
		String ip = input.nextLine(); //user input saved to 'String ip'

		String dot[] = ip.split("\\."); //String split at '.' and each segment is saved to "dot[]" array as element

		System.out.print("Input subnet mask: ");
		String mask = input.nextLine();

		String dot2[] = mask.split("\\."); //same as IP address but for subnet mask

		int IPint[] = new int[4];  //new integer array with size
		for(int i = 0; i < dot.length; ++i) //for loop cycles through "dot[]" array
			IPint[i] = Integer.parseInt(dot[i]); // each element is parsed and added to IPint[] as int

		int MASKint[] = new int[4];  //new integer array for the subnet mask with size
		for(int i = 0; i< dot2.length; ++i) //for loop cycles through "dot2[]" array
			MASKint[i] = Integer.parseInt(dot2[i]); //each element is parsed and added to MASKint[] as int

		//for(int i = 0; i < IPint.length - 1; ++i)
		System.out.println("IP Address entered is: "+IPint[0]+"."+IPint[1]+"."+IPint[2]+"."+IPint[3]);
		System.out.println("Subnet mask entered is: "+MASKint[0]+"."+MASKint[1]+"."+MASKint[2]+"."+MASKint[3]);
		int first = 0; //variable initialized
		int ID[] = new int[4]; //new subnet id array with size

		ID[0] = IPint[0] & MASKint[0];
		ID[1] = IPint[1] & MASKint[1];
		ID[2] = IPint[2] & MASKint[2];
		ID[3] = IPint[3] & MASKint[3];

		System.out.println("Subnet ID is: "+ID[0]+"."+ID[1]+"."+ID[2]+"."+ID[3]);
	}
}
