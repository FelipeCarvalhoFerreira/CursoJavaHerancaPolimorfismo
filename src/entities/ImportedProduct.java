package entities;

public class ImportedProduct extends Product{
	
	private Double customsFee;

	public ImportedProduct() {
	}

	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}
	
	public Double totalPrice() {
		double totalPrice = customsFee + price;
		return totalPrice;
	}
	
	@Override
	public String priceTag() {
		return getName() + " " + String.format("R$ %.2f", totalPrice()) + " (Customs fee: R$ " + String.format("%.2f", customsFee) + ")";
	}

}
