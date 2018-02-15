package ir.rayanpayamak.UI;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import ir.rayanpayamak.R;
import ir.rayanpayamak.Tools.DrawableTools;

public class SmsSend extends AppCompatActivity {


    @BindView(R.id.SmsSend_Btn_Person) protected Button Btn_Person;
    @BindView(R.id.SmsSend_Btn_Send) protected Button Btn_Send;
    @BindView(R.id.SmsSend_Btn_Attach) protected Button Btn_Attach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_send);
        this.setTitle("ارسال پیامک");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Drawable myIcon = getResources().getDrawable( R.drawable.ic_menu_sms_black_24dp );
        getSupportActionBar().setIcon(DrawableTools.setTint(myIcon, Color.WHITE));






    }
}
