package squares;

public class SquareGoToJail extends Square{

	public SquareGoToJail(int squareNum) {
		super(squareNum);
		super.name = super.shortName = SquareInfo.GO_TO_JAIL_NAME;
	}
	
}