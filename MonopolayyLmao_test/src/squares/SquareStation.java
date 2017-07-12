package squares;

public class SquareStation extends Square{

	int stationPrice, ownerNum;
	int[] stationRents;
	private boolean owned;
	/**
	 * 
	 * @param squareNum
	 * @param stationNum
	 */
	public SquareStation(int squareNum, int stationNum) {
		super(squareNum);
		super.name=SquareInfo.STATION_NAMES[stationNum];
		super.shortName=SquareInfo.STATION_SHORT_NAMES[stationNum];
		super.ownable = true;
		owned = false;
		ownerNum=-1;
		stationPrice=SquareInfo.STATION_PRICE;
		stationRents = SquareInfo.STATION_RENTS;
	}
	
	public boolean isOwned(){
		return owned;
	}
	
	public void setOwnership(int owner){
		owned=true;
		ownerNum=owner;
	}
	public void setUnowned(){
		owned=false;
		ownerNum=-1;
	}
	public int owner(){
		return ownerNum;
	}
	public int price(){
		return stationPrice;
	}
	public int rent(){
		return stationRents[0];
	}
}