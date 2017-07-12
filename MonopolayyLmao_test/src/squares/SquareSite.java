package squares;
//extension of square for site squares

public class SquareSite extends Square{
	int sitePrice, ownerNum, siteColorVal, numInGroup, siteMortgage, buildings, buildingCost;
	int[] siteRents;
	private boolean owned, colorGroupOwned, mortgaged;
	//find which site it is
	
	 /**
	  * 
	  * @param squareNum: the number of the square, e.g. the 0th site is square 1
	  * @param siteNum: the number of the site, e.g. e.g. the fourth square is site 1
	  */
	public SquareSite(int squareNum, int siteNum) {
		super(squareNum);
		super.name=SquareInfo.SITE_NAMES[siteNum];
		super.shortName=SquareInfo.SITE_SHORT_NAMES[siteNum];
		super.ownable = true;
		owned = colorGroupOwned = false;
		ownerNum=-1;
		sitePrice=SquareInfo.SITE_PRICES[siteNum];
		siteRents = SquareInfo.SITE_RENTS[siteNum];
		siteMortgage = SquareInfo.SITE_MORTGAGE_VALUE[siteNum];
		buildingCost = SquareInfo.HOUSE_PRICE[siteNum];
		siteColorVal = SquareInfo.SITE_COLOURS[siteNum];
		numInGroup = SquareInfo.NUM_IN_GROUP[siteColorVal];
	}
	
	public boolean isOwned(){
		return owned;
	}
	public void setOwnership(int owner){
		owned=true;
		ownerNum=owner;
	}
	public void setUnowned(){
		owned = colorGroupOwned = false;
		ownerNum=-1;
	}
	public void setColorGroup(boolean b){
		colorGroupOwned = b;
	}
	public boolean getColorGroup(){
		return colorGroupOwned;
	}
	public int owner(){
		return ownerNum;
	}
	public int getColor(){
		return siteColorVal;
	}
	public int price(){
		return sitePrice;
	}
	public int rent(){
		int i = 0+getBuildings();//Adds amount of buildings on current square to change rent given
		if(colorGroupOwned) return 2*siteRents[i];
		else return siteRents[i];
	}
	public int buildingCost(){
		return buildingCost;
	}

	public int mortgage(){
		mortgaged = true;
		return siteMortgage;
	}
	
	public boolean isMortgaged(){
		return mortgaged;
	}
	
	public int redeem(){
		mortgaged = false;
		int interest = (int) 0.1*siteMortgage;
		return (siteMortgage+interest);
	
	}
	public int getBuildings(){
		return buildings;
	}
	public boolean build(){
		if(buildings<5){
			buildings++;
			return true;
		}
		return false;
	}
	public boolean destroy(){
		if(buildings > 0){
			buildings--;
			return true;
		}
		return false;
	}
	public boolean destroyAll(){
		buildings = 0;
		return true;
	}
}