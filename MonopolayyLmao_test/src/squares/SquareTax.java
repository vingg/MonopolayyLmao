package squares;

public class SquareTax extends Square{
	int taxAmount;
	public SquareTax(int squareNum, int taxNum){
		super(squareNum);
		super.name = super.shortName = SquareInfo.TAX_NAMES[taxNum];
		taxAmount = SquareInfo.TAX_AMOUNTS[taxNum];
	}
}