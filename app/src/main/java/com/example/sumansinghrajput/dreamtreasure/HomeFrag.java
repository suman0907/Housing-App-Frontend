package com.example.sumansinghrajput.dreamtreasure;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ViewListener;

/**n 17-03-2018.
 */

public class HomeFrag extends Fragment implements View.OnClickListener {

    Context n1;
    CarouselView nancar;

    LayoutInflater layi;
    CardView card1;
    CardView card2;
    ImageView img1;
    ImageView img2;
    TextView txt11;
    TextView txt12;
    TextView txt13;
    TextView txt21;
    TextView txt22;
    TextView txt23;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.homefrag,container,false);
        n1=inflater.getContext();
        layi= inflater;
        nancar=(CarouselView) view.findViewById(R.id.cor1);
        card1=(CardView) view.findViewById(R.id.card1);
        card2=(CardView) view.findViewById(R.id.card2);
        txt11=(TextView) view.findViewById(R.id.txt11);
        txt12=(TextView) view.findViewById(R.id.txt12);
        txt13=(TextView) view.findViewById(R.id.txt13);
        txt21=(TextView) view.findViewById(R.id.txt21);
        txt22=(TextView) view.findViewById(R.id.txt22);
        txt23=(TextView) view.findViewById(R.id.txt23);


        nancar.setOnClickListener(this);
        txt13.setOnClickListener(this);
        txt23.setOnClickListener(this);

        showCarosal();
        return view;





    }



    public void showCarosal() {

        nancar.setViewListener(new ViewListener() {
            @Override
            public View setViewForPosition(int position) {
                View view = layi.inflate(R.layout.imagecol, null);

                ImageView image = (ImageView) view.findViewById(R.id.nanc1);
                if (position == 0) {


                    image.setBackground(n1.getDrawable(R.drawable.pic1));


                }
                if (position == 1) {

                    image.setBackground(n1.getDrawable(R.drawable.pic2));

                    // Picasso pic2 = Picasso.with(n1);
                    // url, center crop and kahan pe lagana hai are main things yahan pe.
                    //pic2.load("http://www.f-covers.com/namecovers/image/awesome-love-heats.jpg
                  //  http://www.f-covers.com/namecovers/image/awesome-love-heats.jpg
                  //  ").fit().centerCrop().into(image);

                }
                if (position == 2) {
                    image.setBackground(n1.getDrawable(R.drawable.pic3));

                    //Picasso pic3 = Picasso.with(n1);
                    // url, center crop and kahan pe lagana hai are main things yahan pe.
                    //pic3.load("https://www.askideas.com/media/13/You-Complete-Me-Heart-Of-Hands-Facebook-Cover-Photo.jpg
                   // https://www.askideas.com/media/13/You-Complete-Me-Heart-Of-Hands-Facebook-Cover-Photo.jpg
                   // ").fit().centerCrop().into(image);

                }

                return view;
            }
        });
        nancar.setPageCount(3);

    }



    @Override
    public void onClick(View v) {
        int id=v.getId();
        if(id==R.id.txt13 )
        {
            Toast.makeText(n1,"Service is coming soon",Toast.LENGTH_SHORT).show();
            Intent intent= new Intent("android.intent.action.ADDHOUSE");
            startActivity(intent);




        }
        if(id==R.id.txt23)
        {
            Toast.makeText(n1,"Welcome to houses in demand",Toast.LENGTH_SHORT).show();
        }

    }
}

