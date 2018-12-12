package com.example.sumansinghrajput.dreamtreasure;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

/**
 * Created by Suman Singh Rajput on 21-03-2018.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchAdapterBindViewHolder> {

    List<Model> list;
    Context context;
    AppCompatActivity start ;
    public SearchAdapter(List<Model> res,Context c1) {
        list = res;                // 1st
        context = c1;
    }

    @Override
    public SearchAdapterBindViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)   // 3
                .inflate(R.layout.searchadapter,parent,false);
        return new SearchAdapterBindViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SearchAdapterBindViewHolder holder, int position) {


        if(list.get(position).getCost()!= -1) {
            holder.cost.setText("" + list.get(position).getCost());
        }
        if(list.get(position).getAddress()!=null) {
            holder.address.setText(list.get(position).getAddress());
        }
        if(list.get(position).getCapacity()!=null) {
            holder.capacity.setText(list.get(position).getCapacity());
        }
        if(list.get(position).getId()!=null) {
            holder.capacity.setText(list.get(position).getId());
        }
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }


    // 2

    public class SearchAdapterBindViewHolder extends RecyclerView.ViewHolder{

        TextView cost;
        TextView address;
        TextView capacity;// 4
        TextView t5;
        public SearchAdapterBindViewHolder(View itemView) {
            super(itemView);

            cost = (TextView) itemView.findViewById(R.id.t2);
            address = (TextView) itemView.findViewById(R.id.t3);
            capacity = (TextView) itemView.findViewById(R.id.t4);
            t5=(TextView) itemView.findViewById(R.id.t5);
            t5.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    start=new AppCompatActivity();
                    Intent intent = new Intent("android.intent.action.DETAIL");
                    view.getContext().startActivity(intent);



                }
            });

        }
    }
}
