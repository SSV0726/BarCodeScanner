package com.example.admin.barcodescanneractivity;

import android.content.Context;
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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ListItem itemofthelist = listItems.get(position);

        holder.head.setText( itemofthelist.getHeading());
        holder.desc.setText(itemofthelist.getDesc());
        holder.count.setText(Integer.toString(itemofthelist.getCount()));

        if( itemofthelist.imageURL.compareTo("loading") == 0) {
            holder.prodImage.setImageResource(R.drawable.loading);
        }else{

            String url = itemofthelist.imageURL;
            Glide.with(context).load(url).into(holder.prodImage);
        }
    }

    @Override
    public int getItemCount() {
         return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView head;
        public TextView desc;
        public TextView count;
        public ImageView prodImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            head = itemView.findViewById(R.id.Heading);
            desc = itemView.findViewById(R.id.description);
            count = itemView.findViewById(R.id.count);
            prodImage = itemView.findViewById(R.id.prodImage);
        }
    }
}
