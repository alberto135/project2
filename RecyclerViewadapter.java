package com.example.bew.project2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewadapter extends RecyclerView.Adapter<RecyclerViewadapter.MyViewholder> {
    private static final String TAG = "RecyclerViewadapter";
    private ArrayList<String> mImages = new ArrayList<>();
    private ArrayList<String> mNames = new ArrayList<>();
    private Context mcontext ;

    public RecyclerViewadapter(ArrayList<String> mImages, ArrayList<String> mNames, Context mcontext) {
        this.mImages = mImages;
        this.mNames = mNames;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_layout, parent,false ) ;
        MyViewholder holder = new MyViewholder(v) ;
        return holder ;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, final int position) {
        Log.d(TAG , "onBindViewHolder: called " ) ;
        Glide.with(mcontext).asBitmap().load(mImages.get(position)).into(holder.image);
        holder.name.setText(mImages.get(position));
        holder.parentlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mcontext, mImages.get(position), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {

        CircleImageView image;
        TextView name;
        LinearLayout parentlayout ;
        public MyViewholder(View itemView) {
            super(itemView);
            image =itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name) ;
            parentlayout = itemView.findViewById(R.id.parentlayout) ;
        }
    }
}