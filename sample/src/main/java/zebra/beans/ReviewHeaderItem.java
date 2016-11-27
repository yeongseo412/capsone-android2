package zebra.beans;

import android.widget.Button;

/**
 * Created by multimedia on 2016-05-26.
 */
public class ReviewHeaderItem {
    public String productUrl, productName, description;
    public Button eleven, auction, gmarket;
    public int ratingBar;

    public ReviewHeaderItem(String productUrl, String productName, String description, int ratingBar){
        this.productUrl = productUrl;
        this.productName = productName;
        this.description = description;

        this.eleven = eleven;
        this.auction = auction;
        this.gmarket = gmarket;

        this.ratingBar = ratingBar;
    }
}
