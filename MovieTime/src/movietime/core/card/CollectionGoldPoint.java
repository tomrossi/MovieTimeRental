package movietime.core.card;

public class CollectionGoldPoint implements GoldPointInterface {

	private int goldPoint;

	@Override
	public int getGoldPoint() {
		return goldPoint;
	}

	@Override
	public void setGoldPoint(int goldPoint) {
		this.goldPoint = goldPoint;

	}

}
