package ir.rayanpayamak.UI;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ir.rayanpayamak.R;
import ir.rayanpayamak.Tools.DrawableTools;

public class Agent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        this.setTitle("پنل نمایندگی ");
        Drawable myIcon = getResources().getDrawable( R.drawable.ic_menu_agent_black_24dp );
        getSupportActionBar().setIcon(DrawableTools.setTint(myIcon, Color.WHITE));
    }
}
