package com.intelligence.mfarm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import com.intelligence.mfarm.R;
import com.intelligence.mfarm.adapters.FarmerBuyingAdapter;
import com.intelligence.mfarm.model.SellerItem;

import org.parceler.Parcels;

import java.util.ArrayList;

public class BuyFarmInputActivity extends AppCompatActivity implements FarmerBuyingAdapter.OnCardClickListener {

    private RecyclerView mRecyclerView;
    private FarmerBuyingAdapter mAdapter;
    private ArrayList<SellerItem> mSellerItemArrayList = new ArrayList<>();
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_farm_input);

        initLayout();
    }

    private void initLayout() {
        mRecyclerView = findViewById(R.id.provider_items_recycler_view);
        mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        for (int i = 0; i < 5; i++) {
            SellerItem sellerItem = new SellerItem();
            sellerItem.setItem_name("Rice");
            sellerItem.setItem_description("Freshly harvested pishori rice from Mwea Tebere irrigation sector");
            sellerItem.setSeller_name("Mkulima Bora");
            sellerItem.setItem_cost("Ksh. 36,210");
            sellerItem.setItem_post_time("12 mins");

            mSellerItemArrayList.add(sellerItem);

            for (int j = 0; j < 3; j++) {
                sellerItem = new SellerItem();
                sellerItem.setItem_name("Beans");
                sellerItem.setItem_description("Healthy yellow beans gathered from the fertile fields of Nyandarua");
                sellerItem.setSeller_name("Kamau Mwangi");
                sellerItem.setItem_cost("Ksh. 16,000");
                sellerItem.setItem_post_time("1 hour");

                mSellerItemArrayList.add(sellerItem);
            }


        }
        mAdapter = new FarmerBuyingAdapter(mSellerItemArrayList, this, this);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onCardClick(int position) {
        mSellerItemArrayList.get(position);
        Intent intent = new Intent(this, SellerItemDetailsActivity.class);
        intent.putExtra("item", Parcels.wrap(mSellerItemArrayList));
        intent.putExtra("pos", position);
        startActivity(intent);
    }
}
