package ir.rayanpayamak.UI;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import ir.rayanpayamak.Adapters.RecyclerViewDataAdapter;
import ir.rayanpayamak.Models.SectionDataModel;
import ir.rayanpayamak.Models.SingleItemModel;
import ir.rayanpayamak.R;
import ir.rayanpayamak.Tools.DrawableTools;

public class Store extends AppCompatActivity {

    ArrayList<SectionDataModel> allSampleData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        this.setTitle("فروشگاه");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Drawable myIcon = getResources().getDrawable( R.drawable.ic_menu_store_black_24dp );
        getSupportActionBar().setIcon(DrawableTools.setTint(myIcon, Color.WHITE));


        allSampleData = new ArrayList<SectionDataModel>();


        createDummyData();


        RecyclerView my_recycler_view = (RecyclerView) findViewById(R.id.my_recycler_view);

        my_recycler_view.setHasFixedSize(true);

        RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(this, allSampleData);

        my_recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        my_recycler_view.setAdapter(adapter);




    }

    public void createDummyData() {
        for (int i = 1; i <= 5; i++) {

            SectionDataModel dm = new SectionDataModel();

            dm.setHeaderTitle("دسته بندی" + i);

            ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();
            for (int j = 0; j <= 5; j++) {
                singleItem.add(new SingleItemModel("بسته " + j,"s", "URL " + j));
            }

            dm.setAllItemsInSection(singleItem);

            allSampleData.add(dm);

        }
    }
}
