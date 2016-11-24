package zebra.beans;

import android.widget.Button;

/**
 * Created by multimedia on 2016-05-26.
 */
public class ReviewHeaderItem {
    public String productUrl, productName, description;
    public Button eleven, auction, gmarket;
    public double ratingBar;

    public ReviewHeaderItem(String productUrl, String productName, String description, Button eleven, Button auction, Button gmarket, double ratingBar){
        this.productUrl = productUrl;
        this.productName = productName;
        this.description = description;

        this.eleven = eleven;
        this.auction = auction;
        this.gmarket = gmarket;

        this.ratingBar = ratingBar;
    }
}
