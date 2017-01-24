/*
 *  Author: Kevin Hames
 *  Date: 11/29/2016
 *  Description: Three scheduling algorithms calculating distance & total distance the disk travels
 */


public class scheduleAlgs {

	// First in First out
	public static void FIFO(int sequence[])
	{
		// Variables
		String cyl = "Cylinders\t";
		String dis = "Distance\t";
		int loc = 500;
		int total = 0;
		
		// Runs through alg and calculates cylinder & total distance
		for(int i=0; i<sequence.length; i++)	
		{
			cyl += "\t" + sequence[i];
			dis += "\t" + Math.abs(loc-sequence[i]);
			total += Math.abs(loc-sequence[i]);
			loc = sequence[i];
		}
		// Step by step output 
		System.out.println(cyl);
		System.out.println(dis);
		System.out.println("Total Distance: " + total);
	}
	
	// Shortest Seek Time
	public static void SST(int sequence[])
	{
		// Variables
		boolean[] used = new boolean[sequence.length];
		String cyl = "Cylinders\t";
		String dis = "Distance\t";
		int loc = 500;
		int total = 0;
		int min = loc;
		int next = 0;
		
		// Locates shortest distance 
		for(int i=0; i<sequence.length; i++)	
		{
			min = 1000; // max disk distance (ensures next location is found properly) 
		//	System.out.println("count " + i + " loc " + loc);
			for(int j=0; j<sequence.length;j++)
			{	
				if( min >  Math.abs(loc-sequence[j]) && !used[j])
				{
			//		System.out.println("Old Min " + min + " New Min " + (loc-sequence[j]) + " used " + used[j]);
					min =  Math.abs(loc-sequence[j]);
					next = j;
				}	
			}	
				// adds cylinders, distance, and total distance calculation for next location
				used[next] = true;
				cyl += "\t" + sequence[next];
				dis += "\t" + Math.abs(loc-sequence[next]);
				total += Math.abs(loc-sequence[next]);
				loc = sequence[next];
		}
		
		// Step by step Output
		System.out.println(cyl);
		System.out.println(dis);
		System.out.println("Total Distance: " + total);
	}
	
	// Elevator 
	public static void Elevator(int sequence[])
	{
		// variables
		int[] sorted = new int[sequence.length];
		sorted = sequence;
		int temp;
		String cyl = "Cylinders\t";
		String dis = "Distance\t";
		int loc = 500;
		int total = 0;
		
		// Sorts the list in ascending order
		for(int j=0; j < sorted.length; j++)
		{	
			for(int k =j; k < sorted.length; k++)
			{
				if(sorted[j] > sorted[k])
				{
					temp = sorted[j];
					sorted[j] = sorted[k];
					sorted[k] = temp;
				}
			}
		}	
		// uses the sorted list to rearrange in elevator order
		for(int l=sorted.length-1; l >= 0; l--)
		{
			if(sorted[l] < 500)
			{
				temp = sorted[l];
				for(int m = l; m < sorted.length-1; m++)
					sorted[m] = sorted[m+1];
				sorted[sorted.length-1] = temp;
			}
		} 
		// Runs through the final sorted list calculating next & total distance
		for(int i=0; i<sorted.length; i++)	
		{
			cyl += "\t" + sorted[i];
			dis += "\t" + Math.abs(loc-sorted[i]);
			total += Math.abs(loc-sorted[i]);
			loc = sorted[i];
		}
		// Output 
		System.out.println(cyl);
		System.out.println(dis);
		System.out.println("Total Distance: " + total);
	}
}	
