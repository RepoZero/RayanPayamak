package ir.rayanpayamak.UI;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.rayanpayamak.App;
import ir.rayanpayamak.Models.ContactsModel;
import ir.rayanpayamak.R;
import ir.rayanpayamak.Tools.DrawableTools;

public class Contacts extends AppCompatActivity {

    @BindView(R.id.Contacts_Lst)  protected ListView Lst;
    @BindView(R.id.Contacts_Txt_Search)  protected TextView Txt_Search;





    boolean someCondition=false;

     ArrayList<ContactsModel> dataModels;
     ContactsAdapter adapter;

    int lengh;




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.contacts_items, menu);
        MenuItem OkItem = menu.findItem(R.id.ActionBarContacts_Delete);

        if (someCondition) {
            OkItem.setVisible(true);
        }else {
            OkItem.setVisible(false);
        }


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.ActionBarContacts_Delete){


             lengh = dataModels.size();

            ArrayList<String> itemforDelete = new ArrayList<String>();


            for (int i = 0; i < lengh; i++) {
                if(dataModels.get(i).checked){
                    itemforDelete.add(dataModels.get(i).name);


                }
            }

            for (String Object : itemforDelete) {

                for(int i =0;i<lengh;i++){

                if(dataModels.get(i).name==Object)

                    dataModels.remove(i);
                    break;

                }

            }




            adapter = new ContactsAdapter(dataModels, getApplicationContext());
            Lst.setAdapter(adapter);


            item.setVisible(false);
            someCondition=!someCondition;






        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        ButterKnife.bind(this);
        this.setTitle("مخاطبین");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Drawable myIcon = getResources().getDrawable( R.drawable.ic_menu_person_black_24dp);
        getSupportActionBar().setIcon(DrawableTools.setTint(myIcon, Color.WHITE));










        dataModels = new ArrayList<>();

        dataModels.add(new ContactsModel("علیرضا", false));
        dataModels.add(new ContactsModel("حسین محمدی", false));
        dataModels.add(new ContactsModel("علی صادقی", false));
        dataModels.add(new ContactsModel("حسین مشفق", false));
        dataModels.add(new ContactsModel("سید محمد رضا احمدی", false));
        dataModels.add(new ContactsModel("Reza Javadi", false));
        dataModels.add(new ContactsModel("Hossein Moshfegh", false));
        dataModels.add(new ContactsModel("Mohammad Mahdi Meraji", false));
        dataModels.add(new ContactsModel("محمد مهدی معراجی", false));
        dataModels.add(new ContactsModel("محسن غروی", false));
        dataModels.add(new ContactsModel("mohsen Gharavi", false));
        dataModels.add(new ContactsModel("رضا حسینی", false));
        dataModels.add(new ContactsModel("مهران عباسی", false));
        dataModels.add(new ContactsModel("امیر رضایی", false));

        lengh = dataModels.size();

        adapter = new ContactsAdapter(dataModels, getApplicationContext());
        Lst.setAdapter(adapter);

        Lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(Contacts.this, ""+position, Toast.LENGTH_SHORT).show();


            }
        });






        Txt_Search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String TextSearch = Txt_Search.getText().toString();
                boolean isEmpty = StringUtils.isEmpty(TextSearch);
                if(isEmpty){
                    adapter = new ContactsAdapter(dataModels, getApplicationContext());
                    Lst.setAdapter(adapter);



                }else {

                    ArrayList<ContactsModel> SearchdataModels = null;
                    ContactsAdapter Searchadapter;

                    for (int i = 0; i < lengh; i++) {


                        boolean found = dataModels.get(i).name.contains(TextSearch);

                        if (found) {

                            SearchdataModels.add(new ContactsModel(dataModels.get(i).name, dataModels.get(i).checked));

                        }

                    }



                    Searchadapter = new ContactsAdapter(dataModels, getApplicationContext());
                    Lst.setAdapter(Searchadapter);

                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



    }


    public class ContactsAdapter extends ArrayAdapter<ContactsModel> {

        private ArrayList<ContactsModel> dataSet;
        Context mContext;

        // View lookup cache
        private class ViewHolder {
            TextView txtName;
            CheckBox checkBox;
        }

        public ContactsAdapter(ArrayList<ContactsModel> data, Context context) {
            super(context, R.layout.row_contact_item, data);
            this.dataSet = data;
            this.mContext = context;

        }

        @Override
        public int getCount() {
            return dataSet.size();
        }

        @Override
        public ContactsModel getItem(int position) {
            return dataSet.get(position);
        }


        @Override
        public View getView(final int position, View convertView, @NonNull ViewGroup parent) {

            final ViewHolder viewHolder;
            final View result;

            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_contact_item, parent, false);
                viewHolder.txtName = (TextView) convertView.findViewById(R.id.row_contact_item_Txt_name);
                viewHolder.checkBox = (CheckBox) convertView.findViewById(R.id.row_contact_item_Chk_checked);

                result = convertView;
                convertView.setTag(viewHolder);

            } else {
                viewHolder = (ViewHolder) convertView.getTag();
                result = convertView;
            }

            ContactsModel item = getItem(position);
            final ContactsModel dataModel = dataModels.get(position);

            viewHolder.txtName.setText(item.name);
            viewHolder.checkBox.setChecked(item.checked);

            viewHolder.txtName.setTypeface(App.FONT_IRAN_SANS_LIGHT);

            viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    boolean isChecked = viewHolder.checkBox.isChecked();
                    if(isChecked){
                        viewHolder.checkBox.setChecked(false);
                    } else {
                        viewHolder.checkBox.setChecked(true);
                    }



                    viewHolder.checkBox.setChecked(isChecked);

                    dataModel.checked = isChecked;
                    adapter.notifyDataSetChanged();


                    int lengh = Lst.getCount();


                    boolean leastSelected=false;
                    ContactsModel datachecked ;

                    for (int i = 0; i < lengh; i++) {
                        if (dataModels.get(i).checked== true) {
                            leastSelected = true;
                            break;
                        }

                    }



                    if(leastSelected==false){
                        someCondition = false;
                        invalidateOptionsMenu();
                    }else{
                        someCondition = true;
                        invalidateOptionsMenu();
                    }
                }
            });
            viewHolder.txtName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, ""+position, Toast.LENGTH_SHORT).show();
                }
            });




            return result;
        }
    }







}
