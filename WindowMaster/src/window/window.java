package window;

import java.util.Scanner;

public class window {
	public static void main(String[] args)
	{
		double height= 0;
		double width= 0;
		double perimeter;
		double area;
		double cost;
		
		Scanner sc = new Scanner(System.in);
		String inHeight = null;
		String inWidth = null;
		

		
		do {
			try {
			System.out.print("Please enter window height in feet: ");
			inHeight = sc.next();
			height = Double.parseDouble(inHeight);
			System.out.println();
			}
			catch(NumberFormatException e)
			{
				System.out.println("You can't have " + inHeight + " feet of height. Please enter an actual number.");
				continue;
			}
		}
		while(height==0);
		
		do {
			try {
			System.out.print("Please enter window width in feet: ");
			inWidth = sc.next();
			width = Double.parseDouble(inWidth);
			System.out.println();
			}
			catch(NumberFormatException e)
			{
				System.out.println("You can't have " + inWidth + " feet of width. Please enter an actual number.");
				continue;
			}
		}
		while(width==0);
		
		area = height*width;
		perimeter = (height*2)+(width*2);
		cost = (3.5*area)+(2.5*perimeter);
		System.out.println("Total cost is $"+ String.format("%.2f", cost));
		
		
	}
}
