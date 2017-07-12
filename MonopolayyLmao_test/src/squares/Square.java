package squares;
import core.Coordinates;

//base class for squares
public class Square{
	//see SquareInfo for squareType value explanation
	protected int squareType, squareNum, coordX, coordY;
	protected boolean ownable=false, mortgaged=false;
	protected String name, shortName;
	Square(int num){
		squareNum = num;
		squareType = SquareInfo.SQUARE_TYPES[num];
		//base coordinates for player 0
		coordX = Coordinates.getCoordX(squareNum);
		coordY = Coordinates.getCoordY(squareNum);	
	}
	
	public int getSquareType(){
		return squareType;
	}
	public int getSquareNum(){
		return squareNum;
	}
	public String getName(){
		return name;
	}
	
	public String getShortName(){
		return shortName;
	}
	public boolean isOwnable(){
		return ownable;
	}
	
	public boolean isOwned(){
		return false;
	}
	public int owner(){
		return -1;
	}
	public void setOwnership(int owner){
		return;
	}
	public void setUnowned(){
		return;
	}
	public void setColorGroup(boolean b){
		return;
	}
	public boolean getColorGroup(){
		return false;
	}
	public int getColor(){
		return -1;
	}
	
	public int price(){
		return 0;
	}
	public int rent(){
		return 0;
	}
	public int buildingCost(){
		return 0;
	}

	public int mortgage(){
		return 0;
	}
	
	public boolean isMortgaged(){
		return mortgaged;
	}
	
	public int redeem(){
		return 0;
	}
	public int getBuildings(){
		return 0;
	}
	public boolean build(){
		return false;
	}
	public boolean destroy(){
		return false;
	}
	public boolean destroyAll() { return true; }
}