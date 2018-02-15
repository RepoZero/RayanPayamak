package ir.rayanpayamak.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.plattysoft.leonids.ParticleSystem;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.rayanpayamak.App;
import ir.rayanpayamak.BroadcastReceivers.NetworkChangeReceiver;
import ir.rayanpayamak.R;
import ir.rayanpayamak.BroadcastReceivers.SmsListener;
import ir.rayanpayamak.BroadcastReceivers.SmsReceiver;
import ir.rayanpayamak.ServerExchanges.request_json;

public class Verification extends AppCompatActivity {


    @BindView(R.id.verfication_txt_desc) protected TextView Txt_Desc ;
    @BindView(R.id.verfication_Edt_VerfyCode) protected EditText Edt_VerfyCode ;
    @BindView(R.id.verfication_Btn_SendVerfyCode) protected Button SendVerfyCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_verification);
        ButterKnife.bind(this);


        Txt_Desc.setTypeface(App.FONT_IRAN_SANS_LIGHT);
        Edt_VerfyCode.setTypeface(App.FONT_IRAN_SANS);
        SendVerfyCode.setTypeface(App.FONT_IRAN_SANS_LIGHT);


        new ParticleSystem(this, 80, R.drawable.ic_email_cayn_5dp, 10000)
                .setSpeedModuleAndAngleRange(0f, 0.3f, 10, 10)
                .setRotationSpeed(10)
                .setAcceleration(0.000005f, 90)
                .emit(findViewById(R.id.verfication_txt_desc), 1);

        new ParticleSystem(this, 80, R.drawable.ic_message_cayn_5dp, 10000)
                .setSpeedModuleAndAngleRange(0f, 0.3f, 10, 10)
                .setRotationSpeed(10)
                .setAcceleration(0.000005f, 90)
                .emit(findViewById(R.id.verfication_txt_desc), 1);




        SmsReceiver.bindListener(new SmsListener() {
            @Override
            public void messageReceived(String meesageSender, String messageText) {

                Toast.makeText(Verification.this, meesageSender+" : "+messageText, Toast.LENGTH_SHORT).show();

                Log.e("Messege Recived ","Sender : " + meesageSender + "|||| Text"+messageText);



                if(meesageSender.equals("98100004963")){

                    String VerfyCode= messageText.replaceAll("[^0-9]", "");
                    Edt_VerfyCode.setText(VerfyCode);

                    SendVeficationRequest();


                    }

            }
        });


        SendVerfyCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(Verification.this, DashBoard.class));
                overridePendingTransition(R.anim.activity_slide_in, R.anim.activity_slide_out);
                finish();

//                SendVeficationRequest();

            }
        });





    }


    public void SendVeficationRequest(){

        ArrayList<String> Keys = new ArrayList<String>();
        ArrayList<String> Values = new ArrayList<String>();

        Keys.add("phone");
        Values.add(Edt_VerfyCode.getText().toString());

        request_json.sendrequest(Verification.this, App.SERVER_ADDRESS+"api/entry", Keys, Values, new request_json.GetJson() {
            @Override
            public void onSuccess(String result) {


                try {
                    JSONObject jsonObj = new JSONObject(result);
                    JSONObject jsonstatus = jsonObj.getJSONObject("status");
                    if(jsonstatus.getInt("code")==0){
                                    startActivity(new Intent(Verification.this, DashBoard.class));
                                    overridePendingTransition(R.anim.activity_slide_in, R.anim.activity_slide_out);
                                    finish();
                        Toast.makeText(Verification.this, ""+jsonstatus.getInt("code"), Toast.LENGTH_SHORT).show();
                    }else{
                        Edt_VerfyCode.setError("کد تایید اشتباه است");

                    }

                    Log.e(" Server Response ",jsonstatus.getString("message"));

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(Verification.this, "مشکل عدم ارتباط با سرور لطفا مجددا امتحان کنید", Toast.LENGTH_SHORT).show();
                }



            }

            @Override
            public void onError(String result) {
                Log.e("onError --> ", result);
                Toast.makeText(Verification.this, "مشکل در ارسال اطلاعات ، لطفا دسترسی به اینترنت خود را چک کنید", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
