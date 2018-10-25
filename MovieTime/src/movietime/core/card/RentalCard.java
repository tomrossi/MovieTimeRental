package movietime.core.card;

public abstract class RentalCard implements RentalCardPriceStrategy {

	private long number;
	private int id_owner; 
	private double mycredit;
	private double totPricelistMovie;
	private double discount;
	private double totalOrder;

	public RentalCard(int id_owner, long number, double credit) {
		this.number = number;
		this.id_owner = id_owner;
		this.mycredit = credit;
	}

	
	public long getNumber() {
		return number;
	}

	
	public double getCredit() {
		return mycredit;
	}

	
	public int getIDowner() {
		return id_owner;
	}

	
	public double getTotPrice() {
		return totPricelistMovie;
	}

	
	public void setTotPrice(double totPrice) {
		this.totPricelistMovie = totPrice;
	}

	
	public double getDiscount() {
		return discount;
	}

	
	public void setDiscount(double discount) {
		this.discount = discount;
	}

	
	public void setMycredit(double mycredit) {
		this.mycredit = mycredit;
	}

	public double getTotalOrder() {
		return totalOrder;
	}

	public void setTotalOrder(double totalOrder) {
		this.totalOrder = totalOrder;
	}

	public abstract void setGoldPoint(CollectionGoldPoint collection);

}
