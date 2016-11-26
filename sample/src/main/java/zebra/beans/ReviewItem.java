package zebra.beans;

/**
 * Created by multimedia on 2016-05-13.
 */
public class ReviewItem {
    public String profileImage;
    public String memberEmail;
    public int ratingBar;
    public String reviewText;


    public ReviewItem(String profileImage, String memberEmail, int ratingBar, String reviewText){
        this.profileImage = profileImage;
        this.memberEmail = memberEmail;
        this.ratingBar = ratingBar;
        this.reviewText = reviewText;
    }
}
