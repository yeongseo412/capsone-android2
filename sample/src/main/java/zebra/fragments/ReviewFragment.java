package zebra.fragments;



import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import example.zxing.R;
import zebra.adapters.ReviewAdapter;
import zebra.beans.ReviewHeaderItem;
import zebra.beans.ReviewItem;
import zebra.json.Review;
import zebra.manager.ReviewManager;
import zebra.views.ReviewHeaderView;

/**
 * Created by multimedia on 2016-05-27.
 */

public class ReviewFragment extends Fragment {
    ListView reviewList;
    ReviewAdapter mAdapter;
    ReviewHeaderView reviewHeaderView;

    Button elevenSt_btn, auction_btn, gmarket_btn;

    Review result;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_review,container,false);
        View view2 = inflater.inflate(R.layout.review_header,container,false);

        elevenSt_btn = (Button)view2.findViewById(R.id.eleven);
        auction_btn = (Button)view2.findViewById(R.id.auction);
        gmarket_btn = (Button)view2.findViewById(R.id.gmarket);

        elevenSt_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        auction_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        gmarket_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });

        result = ReviewManager.getInstance().getReview();

        setListView(view);
        return view;
    }

    private void setListView(View view){
        reviewList = (ListView) view.findViewById(R.id.reviewList);
        reviewHeaderView = new ReviewHeaderView(view.getContext());
        ReviewHeaderItem reviewHeaderItem = new ReviewHeaderItem(result.productInfo.productUrl, result.productInfo.productName, result.productInfo.description, result.productInfo.starPoint);
        reviewHeaderView.setReviewHeader(reviewHeaderItem);
        mAdapter = new ReviewAdapter();
        reviewList.setAdapter(mAdapter);
        reviewList.addHeaderView(reviewHeaderView);

        for (int i = 0; i < result.reviews.size(); i++) {
            ReviewItem item = new ReviewItem(result.reviews.get(i).memberUrl,
                    result.reviews.get(i).email ,
                    result.reviews.get(i).starPoint,
                    result.reviews.get(i).reviewText);
            mAdapter.add(item);
        }
    }
}
