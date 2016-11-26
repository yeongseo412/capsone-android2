package zebra.beans;

/**
 * Created by multimedia on 2016-05-25.
 */
public class SearchItem {

    public String productUrl;
    public String productName;
    public int ratingBar;
    public String barcode;

    public SearchItem(String productUrl, String productName, int ratingBar, String barcode){
        this.productUrl = productUrl;
        this.productName = productName;
        this.ratingBar = ratingBar;
        this.barcode = barcode;
    }
}
