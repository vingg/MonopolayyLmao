package squares;

public class SquareParking extends Square{

	public SquareParking(int squareNum) {
		super(squareNum);
		super.name = super.shortName = SquareInfo.PARKING_NAME;
	}
	
	
}