package com.example.teamnova_android_two.seed_24;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamnova_android_two.R;

import java.util.ArrayList;

public class BGM_Adapter extends RecyclerView.Adapter<BGM_Adapter.CustomViewHolder>{

    ArrayList<seed_helper_24_data> data;
    Context context;

    public BGM_Adapter(Context context, ArrayList<seed_helper_24_data> dataModels){
        this.data = dataModels;
        this.context = context;
    }

    @NonNull
    @Override
    public BGM_Adapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.seed_helper_24_item,parent,false);
        CustomViewHolder viewHolder = new CustomViewHolder(view) ;

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BGM_Adapter.CustomViewHolder holder, int position) {
        holder.마을이미지.setImageResource(data.get(position).image_path);
        holder.마을이름.setText(data.get(position).title);
        holder.마을설명.setText(data.get(position).description);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder { //이너클래스 //(새로띄우고싶은)바꾸고싶은정보?
        private final ImageView 마을이미지;
        private final TextView 마을이름;
        private final TextView 마을설명;


        public CustomViewHolder(View view) {
            super(view);
            마을이미지 = (ImageView) view.findViewById(R.id.마을이미지);
            마을이름 = (TextView) view.findViewById(R.id.마을이름);
            마을설명 = (TextView) view.findViewById(R.id.마을설명);



        }
    }
}
