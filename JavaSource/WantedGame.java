/**
 * Created by developer on 4/10/2015.
 */
public class WantedGame extends Game {

    private String sellerInfo;
    private int price;

    public String getSellerInfo(){
        return this.sellerInfo;
    }

    public int getPrice(){
        return this.price;
    }

    public void setSellerInfo(String inSellerInfo){
        this.sellerInfo = inSellerInfo;
    }

    public void setPrice(int inPrice) {
        this.price = inPrice;
    }

    public WantedGame (String inName, String inDescription, String inSellerInfo, int inPrice){
        super(inName, inDescription);
        this.sellerInfo = inSellerInfo;
        this.price = inPrice;
    }

    public WantedGame (String inSellerInfo, int inPrice){
        super();
        this.sellerInfo = inSellerInfo;
        this.price = inPrice;
    }

}
