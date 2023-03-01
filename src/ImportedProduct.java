public class ImportedProduct extends Product
{

    private double customsFee;

    public ImportedProduct(String name, Double price, double customsFee) 
    {
        super(name, price);
        this.customsFee = customsFee;
    }

    public double getCustomsFee() 
    {
        return customsFee;
    }

    public void setCustomsFee(double customsFee) 
    {
        this.customsFee = customsFee;
    }

    public double totalPrice(){
        return super.getPrice() + customsFee;
    }
    
    @Override
    public String priceTag()
    {
        StringBuilder sb = new StringBuilder();

        sb.append(getName());
        sb.append(" $ " + String.format("%.2f", getPrice()));
        sb.append(" (Customs fee: " + "$ " + String.format("%.2f", customsFee) + ")");
           
        return sb.toString();
    }

}
