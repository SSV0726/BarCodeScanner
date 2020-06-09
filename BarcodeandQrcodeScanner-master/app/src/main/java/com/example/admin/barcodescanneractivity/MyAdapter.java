package com.example.admin.barcodescanneractivity;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;

import java.util.List;
import java.util.zip.Inflater;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    List<ListItem> listItems;
    private Context context;


    public MyAdapter(List<ListItem> lst , Context cntxt){
        this.listItems =lst;
        this.context = cntxt;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.resourcerecycler,parent,false);

        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        final ListItem itemofthelist = listItems.get(position);

        holder.head.setText( itemofthelist.getHeading());
        holder.price.setText( Integer.toString(itemofthelist.getPrice()) );
        holder.count.setText(Integer.toString(itemofthelist.getCount()));

        if( itemofthelist.imageURL.compareTo("loading") == 0) {

            //Glide.with(context).load(R.drawable.loading).into(holder.prodImage);
            Glide.with(context).asGif().load(R.raw.load).into(holder.prodImage);

        }else{

            String url = itemofthelist.imageURL;
            Glide.with(context).load(url).into(holder.prodImage);
        }


        holder.addQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("mylogs", " Add Quantity  Clicked ");
                int curCount = itemofthelist.getCount();
                itemofthelist.setCount(curCount + 1 );
                notifyDataSetChanged();
            }
        });

        holder.subQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("mylogs", " subQuantity Clicked ");
                int curCount = itemofthelist.getCount();

                if(curCount == 1){
                    listItems.remove(position);

                }else {
                    itemofthelist.setCount(curCount - 1);
                }

                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
         return listItems.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView head;
        public TextView price;
        public TextView count;
        public ImageView prodImage;
        public ImageView addQuantity;
        public ImageView subQuantity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            head = itemView.findViewById(R.id.Heading);
            price = itemView.findViewById(R.id.price);
            count = itemView.findViewById(R.id.count);
            prodImage = itemView.findViewById(R.id.prodImage);
            addQuantity = itemView.findViewById(R.id.addd);
            subQuantity = itemView.findViewById(R.id.sub);
        }
    }
}
