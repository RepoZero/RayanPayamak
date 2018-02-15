package ir.rayanpayamak.UI;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.yavski.fabspeeddial.FabSpeedDial;
import io.github.yavski.fabspeeddial.SimpleMenuListenerAdapter;
import ir.rayanpayamak.R;

public class DashBoard extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final int TIME_INTERVAL = 2000;
    private long mBackPressed;


    @BindView(R.id.fab_speed_dial) protected FabSpeedDial fabSpeedDial;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        fabSpeedDial.setMenuListener(new SimpleMenuListenerAdapter() {
            @Override
            public boolean onMenuItemSelected(MenuItem menuItem) {


                if(menuItem.getItemId()==R.id.fab_Sms){
                    startActivity(new Intent(DashBoard.this, SmsSend.class));
                    overridePendingTransition(R.anim.activity_slide_in, R.anim.activity_slide_out);
                }

                if(menuItem.getItemId()==R.id.fab_SM){
                    Toast.makeText(DashBoard.this, "به زودی", Toast.LENGTH_SHORT).show();
                }
                if(menuItem.getItemId()==R.id.fab_Fax){
                    Toast.makeText(DashBoard.this, "به زودی", Toast.LENGTH_SHORT).show();
                }
                if(menuItem.getItemId()==R.id.fab_Email){
                    Toast.makeText(DashBoard.this, "به زودی", Toast.LENGTH_SHORT).show();
                }
                if(menuItem.getItemId()==R.id.fab_social){
                    Toast.makeText(DashBoard.this, "به زودی", Toast.LENGTH_SHORT).show();
                }

                return false;
            }
        });







    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis())
            {
                super.onBackPressed();
                return;
            }
            else { Toast.makeText(getBaseContext(), "برای خروج دکمه back را بزنید", Toast.LENGTH_SHORT).show(); }

            mBackPressed = System.currentTimeMillis();
        }



    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Sms) {
            startActivity(new Intent(DashBoard.this, SmsSend.class));
            overridePendingTransition(R.anim.activity_slide_in, R.anim.activity_slide_out);
        }

        else if (id == R.id.nav_SM){
            Toast.makeText(this, "به زودی", Toast.LENGTH_SHORT).show();
        }

        else if (id==R.id.nav_Fax){
            Toast.makeText(this, "به زودی", Toast.LENGTH_SHORT).show();
        }

        else if (id==R.id.nav_Email){
            Toast.makeText(this, "به زودی", Toast.LENGTH_SHORT).show();
        }

        else if (id==R.id.nav_Social){
            Toast.makeText(this, "به زودی", Toast.LENGTH_SHORT).show();
        }

        else if (id==R.id.nav_Store){
            startActivity(new Intent(DashBoard.this, Store.class));
            overridePendingTransition(R.anim.activity_slide_in, R.anim.activity_slide_out);
        }

        else if (id==R.id.nav_Contacts){
            startActivity(new Intent(DashBoard.this, Contacts.class));
            overridePendingTransition(R.anim.activity_slide_in, R.anim.activity_slide_out);
        }

        else if (id==R.id.nav_Settings){
            startActivity(new Intent(DashBoard.this, Settings.class));
            overridePendingTransition(R.anim.activity_slide_in, R.anim.activity_slide_out);
        }else if(id==R.id.nav_Agent){

            startActivity(new Intent(DashBoard.this, Agent.class));
            overridePendingTransition(R.anim.activity_slide_in, R.anim.activity_slide_out);
        }

        else if (id==R.id.nav_Exit){

                new AlertDialog.Builder(this)
                        .setMessage("آیا میخواهد خارج شوید ؟ ")
                        .setCancelable(false)
                        .setPositiveButton("بله", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                DashBoard.this.finish();
                            }
                        })
                        .setNegativeButton("خیر", null)
                        .show();

        }





        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
