package com.example.teamnova_android_two.mulung_helper_scedule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamnova_android_two.R;
import com.example.teamnova_android_two.seed_24.BGM_Adapter;
import com.example.teamnova_android_two.seed_24.seed_helper_24_data;

import java.util.ArrayList;

public class mulung_helper_schedule_Adapter extends RecyclerView.Adapter<mulung_helper_schedule_Adapter.CustomViewHolder>{
    ArrayList<mulung_helper_schedule_data> data;
    Context context;

    public mulung_helper_schedule_Adapter(Context context, ArrayList<mulung_helper_schedule_data> dataModels){
        this.data = dataModels;
        this.context = context;
    }

    @NonNull
    @Override
    public mulung_helper_schedule_Adapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mulung_helper_scedule_item,parent,false);
        CustomViewHolder viewHolder = new CustomViewHolder(view) ;

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.메모저장버튼.setText(data.get(position).제목);
    }



    @Override
    public int getItemCount() {
        return (null != data ? data.size() : 0); // 3항연산자 데이터가 널이아니면 데이터사이즈 널이면 0
//        return data.size();
    }





    public class CustomViewHolder extends RecyclerView.ViewHolder { //이너클래스 //(새로띄우고싶은)바꾸고싶은정보?
        private final Button 메모저장버튼;



        public CustomViewHolder(View view) {
            super(view);
            메모저장버튼 = (Button) view.findViewById(R.id.메모저장버튼);

        }
    }
}
