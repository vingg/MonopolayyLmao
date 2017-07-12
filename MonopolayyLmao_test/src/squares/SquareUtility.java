package squares;

public class SquareUtility extends Square{

	int utilityPrice, ownerNum;
	int[] utilityRents;
	private boolean owned;

	
	public SquareUtility(int squareNum, int utilityNum) {
		super(squareNum);
		super.name=SquareInfo.UTILITY_NAMES[utilityNum];
		super.shortName=SquareInfo.UTILITY_SHORT_NAMES[utilityNum];
		super.ownable = true;
		owned = false;
		ownerNum=-1;
		utilityPrice=SquareInfo.UTILITY_PRICE;
		utilityRents = SquareInfo.UTILITY_RENTS;
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
		return utilityPrice;
	}
	public int rents(){
		return utilityRents[0];
	}
}