package com.example.teamnova_android_two.schedule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamnova_android_two.R;
import com.example.teamnova_android_two.seed_24.BGM_Adapter;
import com.example.teamnova_android_two.seed_24.seed_helper_24_data;

import java.util.ArrayList;

public class schedule_Adapter extends RecyclerView.Adapter<schedule_Adapter.CustomViewHolder>{
    ArrayList<schedule_data> data;
    Context context;

    public schedule_Adapter(Context context, ArrayList<schedule_data> dataModels){
        this.data = dataModels;
        this.context = context;
    }


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.schedule_item,parent,false);
        CustomViewHolder viewHolder = new CustomViewHolder(view) ;

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.텍스트.setText(data.get(0).memo);

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder { //이너클래스 //(새로띄우고싶은)바꾸고싶은정보?

        private final TextView 텍스트;



        public CustomViewHolder(View view) {
            super(view);

            텍스트 = (TextView) view.findViewById(R.id.일정텍스트);

        }
    }
}
