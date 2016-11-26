package zebra.beans;

/**
 * Created by multimedia on 2016-05-29.
 */
public class MyReviewItem {

    public String productImage;
    public String memberEmail;
    public int ratingBar;
    public String reviewText;

    public MyReviewItem(String productImage, String memberEmail, int ratingBar, String reviewText){
        this.productImage = productImage;
        this.memberEmail = memberEmail;
        this.ratingBar = ratingBar;
        this.reviewText = reviewText;
    }

}
