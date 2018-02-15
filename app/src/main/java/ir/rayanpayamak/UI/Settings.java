package ir.rayanpayamak.UI;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


import com.esafirm.imagepicker.features.ImagePicker;
import com.esafirm.imagepicker.model.Image;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.rayanpayamak.App;
import ir.rayanpayamak.R;
import ir.rayanpayamak.Tools.DrawableTools;



public class Settings extends AppCompatActivity {




    @BindView(R.id.Settings_Txt_TypeUserTitle) protected TextView Txt_TypeUserTitle;
    @BindView(R.id.Settings_Radio_Real) protected RadioButton Radio_Real;
    @BindView(R.id.Settings_Radio_Legal) protected RadioButton Radio_Legal;


    @BindView(R.id.Settings_Txt_DescriptionCoercion) protected TextView Txt_DescriptionCoercion;


    @BindView(R.id.Settings_Lin_Person) protected LinearLayout Lin_Person; /// Person Panel
    @BindView(R.id.Settings_Txt_PersonTitle) protected TextView Txt_PersonTitle;
    @BindView(R.id.Settings_Edt_Name) protected EditText Edt_Name;
    @BindView(R.id.Settings_Edt_Family) protected EditText Edt_Family;
    @BindView(R.id.Settings_Edt_NationalCode) protected EditText Edt_NationalCode;
    @BindView(R.id.Settings_Edt_RealEmail) protected EditText Edt_RealEmail;
    @BindView(R.id.Settings_Btn_NationalCard) protected Button Btn_NationalCard;
    @BindView(R.id.Settings_Btn_BirthCertificate) protected Button Btn_BirthCertificate;
    @BindView(R.id.Settings_Btn_Bill) protected Button Btn_Bill;
    @BindView(R.id.Settings_Txt_NationalCard) protected TextView Txt_NationalCard;
    @BindView(R.id.Settings_Txt_BirthCertificate) protected TextView Txt_Certificate;
    @BindView(R.id.Settings_Txt_Bill) protected TextView Txt_Bill;


    @BindView(R.id.Settings_Lin_Commercial) protected LinearLayout Lin_Commercial; // Commerical Panel
    @BindView(R.id.Settings_Txt_CommercialTitle) protected TextView Txt_CommercialTitle;
    @BindView(R.id.Settings_Edt_CompanyName) protected EditText Edt_CompanyName;
    @BindView(R.id.Settings_Edt_CompanyNationId) protected EditText Edt_CompanyNationId;
    @BindView(R.id.Settings_Edt_EconomicCode) protected EditText Edt_EconomicCode;
    @BindView(R.id.Settings_Edt_CompanyPhone) protected EditText Edt_CompanyPhone;
    @BindView(R.id.Settings_Edt_CompanyPostalCode) protected EditText Edt_CompanyPostalCode;
    @BindView(R.id.Settings_Edt_ManagerName) protected EditText Edt_ManagerName;
    @BindView(R.id.Settings_Edt_ManagerPhone) protected EditText Edt_ManagerPhone;
    @BindView(R.id.Settings_Edt_ManagerNationalCode) protected EditText Edt_ManagerNationalCode;
    @BindView(R.id.Settings_Edt_legalEmail) protected EditText Edt_legalEmail;
    @BindView(R.id.Settings_Btn_Foundation) protected Button Btn_Foundation;
    @BindView(R.id.Settings_Btn_Newspaper) protected Button Btn_Newspaper;
    @BindView(R.id.Settings_Txt_Foundation) protected TextView Txt_Foundation;
    @BindView(R.id.Settings_Txt_Newspaper) protected TextView Txt_Newspaper;







    int REQUEST_CODE_PICKER=0;

    ArrayList<Image> NationalCard;
    ArrayList<Image> BirthCertificate;
    ArrayList<Image> Bill;
    ArrayList<Image> Foundation;
    ArrayList<Image> Newspaper;

    boolean GetNationalCard=false;
    boolean GetBirthCertificate=false;
    boolean GetBill=false;
    boolean GetFoundation=false;
    boolean GetNewspaper=false;

    String PathNationalCard;
    String PathBirthCertificate;
    String PathBill;
    String PathFoundation;
    String PathNewspaper;



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.settings_items, menu);
        MenuItem OkItem = menu.findItem(R.id.ActionBarContacts_Delete);



        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getGroupId()==R.id.ActionBarSettings_Ok){
            Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);
        this.setTitle("تنظیمات");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Drawable myIcon = getResources().getDrawable( R.drawable.ic_menu_settings_black_24dp );
        getSupportActionBar().setIcon(DrawableTools.setTint(myIcon,Color.WHITE));



        Txt_TypeUserTitle.setTypeface(App.FONT_IRAN_SANS_LIGHT);
        Txt_PersonTitle.setTypeface(App.FONT_IRAN_SANS_LIGHT);
        Txt_CommercialTitle.setTypeface(App.FONT_IRAN_SANS_LIGHT);
        Radio_Real.setTypeface(App.FONT_IRAN_SANS_LIGHT);
        Radio_Legal.setTypeface(App.FONT_IRAN_SANS_LIGHT);
        Txt_DescriptionCoercion.setTypeface(App.FONT_IRAN_SANS_LIGHT);
        Edt_Name.setTypeface(App.FONT_IRAN_SANS_LIGHT);
        Edt_Family.setTypeface(App.FONT_IRAN_SANS_LIGHT);
        Edt_NationalCode.setTypeface(App.FONT_IRAN_SANS_LIGHT);
        Edt_RealEmail.setTypeface(App.FONT_IRAN_SANS_LIGHT);
        Btn_NationalCard.setTypeface(App.FONT_IRAN_SANS_LIGHT);
        Btn_BirthCertificate.setTypeface(App.FONT_IRAN_SANS_LIGHT);
        Btn_Bill.setTypeface(App.FONT_IRAN_SANS_LIGHT);
        Txt_NationalCard.setTypeface(App.FONT_IRAN_SANS_LIGHT);
        Btn_Bill.setTypeface(App.FONT_IRAN_SANS_LIGHT);
        Txt_Certificate.setTypeface(App.FONT_IRAN_SANS_LIGHT);
        Txt_Bill.setTypeface(App.FONT_IRAN_SANS_LIGHT);
        Edt_CompanyName.setTypeface(App.FONT_IRAN_SANS_LIGHT);
        Edt_CompanyNationId.setTypeface(App.FONT_IRAN_SANS_LIGHT);
        Edt_EconomicCode.setTypeface(App.FONT_IRAN_SANS_LIGHT);
        Edt_CompanyPhone.setTypeface(App.FONT_IRAN_SANS_LIGHT);
        Edt_CompanyPostalCode.setTypeface(App.FONT_IRAN_SANS_LIGHT);
        Edt_ManagerName.setTypeface(App.FONT_IRAN_SANS_LIGHT);
        Edt_ManagerPhone.setTypeface(App.FONT_IRAN_SANS_LIGHT);
        Edt_ManagerNationalCode.setTypeface(App.FONT_IRAN_SANS_LIGHT);
        Edt_legalEmail.setTypeface(App.FONT_IRAN_SANS_LIGHT);
        Btn_Foundation.setTypeface(App.FONT_IRAN_SANS_LIGHT);
        Btn_Newspaper.setTypeface(App.FONT_IRAN_SANS_LIGHT);
        Edt_ManagerPhone.setTypeface(App.FONT_IRAN_SANS_LIGHT);
        Txt_Newspaper.setTypeface(App.FONT_IRAN_SANS_LIGHT);


        Lin_Person.setVisibility(View.GONE);
        Lin_Commercial.setVisibility(View.GONE);
        Txt_DescriptionCoercion.setVisibility(View.GONE);


        Radio_Real.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Txt_DescriptionCoercion.setVisibility(View.VISIBLE);

                    Lin_Person.setVisibility(View.VISIBLE);
                    Lin_Commercial.setVisibility(View.GONE);
                }else{
                    Lin_Person.setVisibility(View.GONE);
                }
            }
        });


        Radio_Legal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Txt_DescriptionCoercion.setVisibility(View.VISIBLE);

                    Lin_Commercial.setVisibility(View.VISIBLE);
                    Lin_Person.setVisibility(View.GONE);
                }else{
                    Lin_Commercial.setVisibility(View.GONE);
                }
            }
        });





        Btn_NationalCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                REQUEST_CODE_PICKER=1;
                ImagePicker.create(Settings.this).limit(1).imageTitle("انتخاب تصویر").theme(R.style.ImagePickerTheme)
                        .start(REQUEST_CODE_PICKER);
            }
        });

        Btn_BirthCertificate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                REQUEST_CODE_PICKER=2;
                ImagePicker.create(Settings.this).limit(1).imageTitle("انتخاب تصویر").theme(R.style.ImagePickerTheme)
                        .start(REQUEST_CODE_PICKER);
            }
        });

        Btn_Bill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                REQUEST_CODE_PICKER=3;
                ImagePicker.create(Settings.this).limit(1).imageTitle("انتخاب تصویر").theme(R.style.ImagePickerTheme)
                        .start(REQUEST_CODE_PICKER);
            }
        });

        Btn_Foundation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                REQUEST_CODE_PICKER=4;
                ImagePicker.create(Settings.this).limit(1).imageTitle("انتخاب تصویر").theme(R.style.ImagePickerTheme)
                        .start(REQUEST_CODE_PICKER);
            }
        });


        Btn_Newspaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                REQUEST_CODE_PICKER=5;
                ImagePicker.create(Settings.this).limit(1).imageTitle("انتخاب تصویر").theme(R.style.ImagePickerTheme)
                        .start(REQUEST_CODE_PICKER);
            }
        });













    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && data != null) {

            switch (requestCode) {

                case 0 :
                    Log.e("AcivityResult","Error : Code is 0");
                    break;

                case 1 :
                     NationalCard= (ArrayList<Image>) ImagePicker.getImages(data);
                     Txt_NationalCard.setText(NationalCard.get(0).getPath());
                     GetNationalCard=true;
                     PathNationalCard = NationalCard.get(0).getPath();
                    break;

                case 2:
                    BirthCertificate= (ArrayList<Image>) ImagePicker.getImages(data);
                    Txt_Certificate.setText(BirthCertificate.get(0).getPath());
                    GetBirthCertificate=true;
                    PathBirthCertificate= BirthCertificate.get(0).getPath();
                    break;


                case 3:
                    Bill= (ArrayList<Image>) ImagePicker.getImages(data);
                    Txt_Bill.setText(Bill.get(0).getPath());
                    GetBill=true;
                    PathBill= Bill.get(0).getPath();
                    break;

                case 4:
                    Foundation= (ArrayList<Image>) ImagePicker.getImages(data);
                    Txt_Foundation.setText(Foundation.get(0).getPath());
                    GetFoundation=true;
                    PathFoundation= Foundation.get(0).getPath();
                    break;

                case 5:
                    Newspaper= (ArrayList<Image>) ImagePicker.getImages(data);
                    Txt_Newspaper.setText(Newspaper.get(0).getPath());
                    GetNewspaper=true;
                    PathNewspaper= Newspaper.get(0).getPath();
                    break;


            }
        }

    }




}
