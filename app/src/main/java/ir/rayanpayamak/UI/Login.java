package ir.rayanpayamak.UI;


import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.plattysoft.leonids.ParticleSystem;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.rayanpayamak.App;
import ir.rayanpayamak.BroadcastReceivers.NetworkChangeReceiver;
import ir.rayanpayamak.BroadcastReceivers.NetworkListener;
import ir.rayanpayamak.R;

import ir.rayanpayamak.ServerExchanges.request_json;
import ir.rayanpayamak.Tools.Validation;

import static android.R.attr.phoneNumber;


public class Login extends AppCompatActivity {


    @BindView(R.id.login_Btn_login) protected Button Btn_login;
    @BindView(R.id.login_Txt_Desc) protected TextView Txt_Desc;
    @BindView(R.id.login_Edt_Phone) protected EditText Edt_Phone;











    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);







        NetworkChangeReceiver.internet(new NetworkListener() {
            @Override
            public void network(boolean internet) {

                Log.e("Internet Status ::::: ", "" + internet);

            }
        });

        new ParticleSystem(this, 80, R.drawable.ic_email_cayn_5dp, 10000)
                .setSpeedModuleAndAngleRange(0f, 0.3f, 10, 10)
                .setRotationSpeed(10)
                .setAcceleration(0.000005f, 90)
                .emit(findViewById(R.id.login_img_logo), 1);

        new ParticleSystem(this, 80, R.drawable.ic_message_cayn_5dp, 10000)
                .setSpeedModuleAndAngleRange(0f, 0.3f, 10, 10)
                .setRotationSpeed(10)
                .setAcceleration(0.000005f, 90)
                .emit(findViewById(R.id.login_img_logo), 1);




        Edt_Phone.setTypeface(App.FONT_IRAN_SANS_LIGHT);
        Btn_login.setTypeface(App.FONT_IRAN_SANS);
        Txt_Desc.setTypeface(App.FONT_IRAN_SANS_LIGHT);


        final Intent intent = new Intent(this, Login.class);
        final PendingIntent pending = PendingIntent.getActivity(this, 0, intent, 0);

        Btn_login.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {


                if (TextUtils.isEmpty(Edt_Phone.getText().toString())) {

                    YoYo.with(Techniques.Shake)
                            .duration(700)
                            .playOn(findViewById(R.id.login_Edt_Phone));
                    Edt_Phone.setError("شماره موبایل را وارد کنید");

                    return;
                }

//                Validation validation = new Validation();
//                if (validation.ValidPhoneNumber(Edt_Phone.getText().toString())) {



//                    ArrayList<String> Keys = new ArrayList<String>();
//                    ArrayList<String> Values = new ArrayList<String>();
//
//                    Keys.add("phone");
//                    Values.add(Edt_Phone.getText().toString());

//                    request_json.sendrequest(Login.this, App.SERVER_ADDRESS+"api/entry", Keys, Values, new request_json.GetJson() {
//                        @Override
//                        public void onSuccess(String result) {
//
//
//                            try {
//                                JSONObject jsonObj = new JSONObject(result);
//                                JSONObject jsonstatus = jsonObj.getJSONObject("status");
//                                Log.e("Server Response",jsonObj.toString());
//                                if(jsonstatus.getInt("code")==0){
                                    startActivity(new Intent(Login.this, Verification.class));
                                    overridePendingTransition(R.anim.activity_slide_in, R.anim.activity_slide_out);
                                    finish();
//                                }else{
//                                    Toast.makeText(Login.this, "خطای سرور ", Toast.LENGTH_SHORT).show();
//
//                                }
//
//                                Log.e(" Server Response ",jsonstatus.getString("message"));
//
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }




//
//                        }
//
//                        @Override
//                        public void onError(String result) {
//
//                            Log.e("onError --> ", result);
//                            Toast.makeText(Login.this, "مشکل در ارسال اطلاعات ، لطفا دسترسی به اینترنت خود را چک کنید", Toast.LENGTH_SHORT).show();
//
//                        }
//                    });











//                    notification n = new notification();
//
//                    n.general(intent, pending, Login.this, "رایان پیامک", "کد دریافت شده", R.mipmap.ic_launcher);





//                } else {
//                    Edt_Phone.setError("شماره موبایل وارد شده اشتباه است");
//                    YoYo.with(Techniques.Shake)
//                            .duration(700)
//                            .playOn(findViewById(R.id.login_Edt_Phone));
//                }

            }
        });





    }







}
