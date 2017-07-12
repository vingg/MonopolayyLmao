package core;
public class Coordinates {
		private static final int[] coordX = {558, 505, 455, 405, 355, 
											303, 255, 203, 155, 105,
											  4,  11,  11,  11,  11,
											 11,  11,  11,  11,  11, 
											 11, 105, 152, 203, 255, 
											303, 355, 405, 455, 505,
											562, 596, 596, 596, 596, 
											596, 596, 596, 596, 596 };
		
		
		private static final int[] coordY = {558, 573, 573, 573, 573,
											 573, 573, 573, 573, 573,
											 569, 506, 454, 406, 356,
											 304, 256, 204, 156, 106,
											  30,   5,   5,   5,   5,
											   5,   5,   5,   5,   5,
											  29, 106, 156, 204, 256,
											 304, 356, 406, 454, 506 };
		
		private static final int[] jailCoords = {53, 555};
		
	public static int getCoordX(int location){
		return coordX[location];
	}
	public static int getCoordY(int location){
		return coordY[location];
	}
	public static int getJailCoordX(){
		return jailCoords[0];
	}
	public static int getJailCoordY(){
		return jailCoords[1];
	}
}
