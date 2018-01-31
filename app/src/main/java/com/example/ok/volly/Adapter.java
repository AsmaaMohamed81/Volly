package com.example.ok.volly;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ok on 31/01/2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {
Context context;

List<Model> list ;


    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);

        return new Holder(view);
    }

    public Adapter(Context context, List<Model> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

       Model model=list.get(position);

        holder.title.setText(model.getTitle());
        holder.desc.setText(model.getDesc());

        Picasso.with(context).load(model.getImg()).into(holder.img);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView title,desc;




        public Holder(View itemView) {
            super(itemView);

            img=(ImageView) itemView.findViewById(R.id.img1);
            title=(TextView) itemView.findViewById(R.id.title);
            desc=(TextView) itemView.findViewById(R.id.Desc);


        }
    }
}
