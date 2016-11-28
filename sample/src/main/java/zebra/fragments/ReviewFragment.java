package zebra.fragments;



import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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
        View view  = inflater.inflate(R.layout.fragment_review, container, false);

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

        // 구매 연결 버튼 초기화
        elevenSt_btn = (Button) reviewHeaderView.findViewById(R.id.eleven);
        auction_btn = (Button)reviewHeaderView.findViewById(R.id.auction);
        gmarket_btn = (Button)reviewHeaderView.findViewById(R.id.gmarket);

        // click listener
        elevenSt_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String encodeStr = result.productInfo.productName;

                try {
                    encodeStr = URLEncoder.encode(encodeStr, "euc-kr");
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://search.11st.co.kr/SearchPrdAction.tmall?method=getTotalSearchSeller&kwd=" + encodeStr));
                    startActivity(intent);
                }
                catch(UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });
        auction_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String encodeStr = result.productInfo.productName;

                try {
                    encodeStr = URLEncoder.encode(encodeStr, "euc-kr");
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://search.gmarket.co.kr/search.aspx?keyword=" + encodeStr));
                    startActivity(intent);
                }
                catch(UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            }
        });
        gmarket_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String encodeStr = result.productInfo.productName;

                try {
                    encodeStr = URLEncoder.encode(encodeStr, "euc-kr");
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://search.auction.co.kr/search/search.aspx?keyword=" + encodeStr));
                    startActivity(intent);
                }
                catch(UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            }
        });


    }
}
