/*
 *  Author: Kevin Hames
 *  Date: 11/29/2016
 *  Description: Creates sequences for disk scheduling, analyzed by three
 *  algorithms in scheduleAlgs.java
 */

public class DiskScheduling {

	public static void main(String[] args) {
		
		// Variables 
		int[] cylinders = new int[12];
		int count = 1;
		
		// Repeats scheduling algs for 12 sets of cylinder values
		while(count <= 12)
		{	
			// Creates an array of 12 random cylinder values to be scheduled 
			for(int i=0; i<cylinders.length; i++)
			{	
				cylinders[i] = (int) (Math.random()*1000);
			}
			
			// Output formatting
			System.out.println("Set " + count + " FIFO");
			scheduleAlgs.FIFO(cylinders);
			System.out.println();
			System.out.println("Set " + count + " SST");
			scheduleAlgs.SST(cylinders);
			System.out.println();
			System.out.println("Set " + count + " Elevator");
			scheduleAlgs.Elevator(cylinders);
			System.out.println();
			count++;
		}
	}

}
