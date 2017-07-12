package squares;

public class SquareJail extends Square{
	
	public SquareJail(int squareNum){
		super(squareNum);
		super.name = super.shortName = SquareInfo.JAIL_NAME;
	}
}