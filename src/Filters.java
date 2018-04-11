
public class Filters {
	public static float gaussianFilter[][] = 
		{
			{0.0625f, 0.125f, 0.0625f},
			{0.125f, 0.25f , 0.125f},
			{0.0625f, 0.125f, 0.0625f}
		};
	
		//filtri per risaltare i contorni
	public static float laplaceFilter1[][] = 
		{
			{0, 1, 0},
			{1, -4 , 1},
			{0, 1, 0}
		};
	
	public static float laplaceFilter2[][] = 
		{
			{-1,-1,-1},
			{-1,8,-1},
			{-1,-1,-1}
		};
	

	public static float horizontalLineDetection[][] = 
		{
			{-1, -1, -1},
			{2, 2, 2},
			{-1, -1, -1}
		};	
	
	public static float verticalFilter[][] = 
		{
			{-1, 2, -1},
			{-1, 2, -1},
			{-1, 2, -1}
		};	
		
	public static float degreesFilter[][] = 
		{
			{-1, -1, 2},
			{-1, 2, -1},
			{2, -1, -1}
		};	
	public static float embossFilter[][] = 
		{
			{-2, -1, 0},
			{-1, 1, 1},
			{0, 1, 2}
		};
}
