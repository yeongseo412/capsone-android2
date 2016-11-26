package zebra.views;

import android.content.Context;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import example.zxing.R;
import zebra.beans.ReviewHeaderItem;

/**
 * Created by multimedia on 2016-05-13.
 */
public class ReviewHeaderView extends FrameLayout {

    ImageView productImage;
    TextView productName, description;
    RatingBar ratingBar;

    Button elevenSt_btn, auction_btn, gmarket_btn;

    public ReviewHeaderView(Context context) {
        super(context);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.review_header, this);

        productImage = (ImageView)findViewById(R.id.productImage);
        productName = (TextView)findViewById(R.id.productName);
        ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        description = (TextView)findViewById(R.id.description);

        elevenSt_btn = (Button)findViewById(R.id.eleven);
        auction_btn = (Button)findViewById(R.id.aucion);
        gmarket_btn = (Button)findViewById(R.id.gmarket);
    }

    public void setReviewHeader(ReviewHeaderItem reviewHeaderItem){
        Glide.with(getContext()).load(reviewHeaderItem.productUrl).into(productImage);
        productName.setText(reviewHeaderItem.productName);
        ratingBar.setRating((int) reviewHeaderItem.ratingBar);
        description.setText(reviewHeaderItem.description);
    }
}
