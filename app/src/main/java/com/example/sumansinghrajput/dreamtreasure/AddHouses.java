package com.example.sumansinghrajput.dreamtreasure;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by Suman Singh Rajput on 23-03-2018.
 */

public class AddHouses extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener  {


    AddModel model;
    TextView id1;
    Spinner spin1;
    TextView id2;
    Spinner spin2;
    TextView id3;
    Spinner spin3;
    EditText id4;
    EditText id5;
    EditText id6;
    EditText id7;
    Button submit;
    Button img;
    Button broker;

    String[] propertyType = { "flat", "house", "villa"  };
    String[] capacity = { "1 RK", "1 BHK", "2 BHK", "3 BHK", "4 BHK"  };
    String[] appartmentType = { "Fully Furnished", "Semi Furnished", "Bare"  };
    Context n1;
    String select1;
    String select2;
    String select3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addhouses);
        id1=(TextView) findViewById(R.id.id1);
        spin1= (Spinner) findViewById(R.id.spin1);
        id2=(TextView) findViewById(R.id.id2);
        spin2= (Spinner) findViewById(R.id.spin2);
        id3=(TextView) findViewById(R.id.id3);
        spin3= (Spinner) findViewById(R.id.spin3);
        id4=(EditText) findViewById(R.id.id4);
        id5=(EditText) findViewById(R.id.id5);
        id6=(EditText) findViewById(R.id.id6);
        id7=(EditText) findViewById(R.id.id7);
        submit=(Button) findViewById(R.id.sub);
        submit.setOnClickListener(this);
        img=(Button) findViewById(R.id.img);
        img.setOnClickListener(this);
        n1 = getApplicationContext();
        broker=(Button) findViewById(R.id.broker);
        broker.setOnClickListener(this);
        spin1.setOnItemSelectedListener(this);
        spin2.setOnItemSelectedListener(this);
        spin3.setOnItemSelectedListener(this);


        ArrayAdapter a1 = new ArrayAdapter(n1,android.R.layout.simple_spinner_item,propertyType);
        a1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin1.setAdapter(a1);
        ArrayAdapter a2 = new ArrayAdapter(n1,android.R.layout.simple_spinner_item,capacity);
        a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin2.setAdapter(a2);
        ArrayAdapter a3 = new ArrayAdapter(n1,android.R.layout.simple_spinner_item,appartmentType);
        a3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin3.setAdapter(a3);
    }
    @Override
    public void onClick(View v) {
        int id=v.getId();
        if(id==R.id.sub)
        {
            model=new AddModel();
            model.setPropertyType(select1);
            model.setCapacity(select2);
            model.setApartmentType(select3);
            model.setAddress(id4.getText().toString());
            model.setCost(id5.getText().toString());
            model.setDescription(id6.getText().toString());
            model.setLandmark(id7.getText().toString());





            String apiEndPoint ="treasure/add_update_house";


            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://enigmatic-tor-16549.herokuapp.com/")
                    .addConverterFactory(JacksonConverterFactory.create())
                    .build();
            AddAPI api = retrofit.create(AddAPI.class);


            Call<PostAPIResponse> call = api.getData(apiEndPoint,model);
            call.enqueue(new Callback<PostAPIResponse>() {
                @Override
                public void onResponse(Call<PostAPIResponse> call, Response<PostAPIResponse> response) {
                    PostAPIResponse response1 = response.body();
                    if (response1 != null && response1.getResponse().equals("success")) {
                        Toast.makeText(getApplicationContext(), "Data successfully added", Toast.LENGTH_SHORT).show();
                    }
                }


                @Override
                public void onFailure(Call<PostAPIResponse> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                }

            });
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int id1 = view.getId();
        if(id1 == R.id.spin1)
        {
            select1 =  parent.getItemAtPosition(position).toString();
        }
        if(id1 == R.id.spin2)
        {
            select2 =  parent.getItemAtPosition(position).toString();
        }
        if(id1 == R.id.spin3)
        {
            select3 =  parent.getItemAtPosition(position).toString();
        }
    }



    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}





