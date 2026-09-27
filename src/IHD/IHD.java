package IHD;

import java.util.Scanner;

public class IHD {
	public static void main(String[] args) {
		
		//Creating scanner to ask for user input
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter organic formula: ");
		String formula = reader.next();
		
		int numCarbons = numElement(formula, "C");
		
		int numHydrogens = numElement(formula, "H");
		
		int numNitrogens = numElement(formula, "N");

		int numHalogens = numElement(formula, "F")
						+ numElement(formula, "I")
						+ numElement(formula, "Cl")
						+ numElement(formula, "Br");
		
		System.out.print(findIHD(numCarbons, numHydrogens, numNitrogens, numHalogens));


		reader.close();
	}
	public static int findNextChar(String text, int start) {
		for (int i = start; i<text.length(); i++) {
			if (Character.isLetter(text.charAt(i))) {
	            return i; // Found a letter, return its position
	        }
		}
		return text.length();
	}
	public static int findIHD(int c, int h, int n, int x) {
		System.out.println("\n2 x " + c + " Carbons + " + n + " Nitrogens - " +
			h + " Hydrogens - " + x + " Halogens + 2");
		System.out.println("------------------------------------------------------------");
		System.out.println("                             2                            \n");

		int ihd = (2*c + 2 + n - h - x)/2;
		if (ihd<0) {
			System.out.print("INVALID FORMULA: IHD = ");
		}
		else {
			System.out.print("Units of Hydrogen Deficiency: ");
		}
		return ihd;
	}
	public static int numElement(String text, String element) {
		int index = 0;
		if (element.length()==1) {
			index=1;
		}
		else {
			index=2;
		}
		String numElement = "";
		int indexElement = text.indexOf(element);
		if (text.indexOf(element)==-1) {
			return 0;
		}
		else if (findNextChar(text,indexElement+index)==indexElement+index) {
			return 1;
		}
		else {
			for (int i =indexElement+index ; i<findNextChar(text,i); i++) {
				
				numElement += (text.charAt(i));
				
			}
			int num = Integer.parseInt(numElement);
			return num;
		}
		
	}

}
