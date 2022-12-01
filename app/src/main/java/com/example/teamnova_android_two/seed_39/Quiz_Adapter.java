package com.example.teamnova_android_two.seed_39;

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

public class Quiz_Adapter extends RecyclerView.Adapter<Quiz_Adapter.CustomViewHolder>{
    ArrayList<seed_helper_39_data> data;
    Context context;

    public Quiz_Adapter(Context context, ArrayList<seed_helper_39_data> dataModels){
        this.data = dataModels;
        this.context = context;
    }

    @NonNull
    @Override
    public Quiz_Adapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.seed_helper_39_item,parent,false);
        Quiz_Adapter.CustomViewHolder viewHolder = new Quiz_Adapter.CustomViewHolder(view) ;

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Quiz_Adapter.CustomViewHolder holder, int position) {
        holder.질문.setText(data.get(position).question);
        holder.답변1.setText(data.get(position).answer1);
        holder.답변2.setText(data.get(position).answer2);
        holder.답변3.setText(data.get(position).answer3);
        holder.답변4.setText(data.get(position).answer4);


    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public class CustomViewHolder extends RecyclerView.ViewHolder { //이너클래스 //(새로띄우고싶은)바꾸고싶은정보?
        private final TextView 질문;
        private final Button 답변1;
        private final Button 답변2;
        private final Button 답변3;
        private final Button 답변4;

        public CustomViewHolder(View view) { // 뷰홀더 뷰들 findviewid
            super(view);
            질문 = (TextView) view.findViewById(R.id.질문);
            답변1 = (Button) view.findViewById(R.id.답변1);
            답변2 = (Button) view.findViewById(R.id.답변2);
            답변3 = (Button) view.findViewById(R.id.답변3);
            답변4 = (Button) view.findViewById(R.id.답변4);

        }
    }
    public void itemfilter(ArrayList<seed_helper_39_data> filterlist){
        //여기서 변경내용 적용받고 새로고침
        data = filterlist;
        notifyDataSetChanged(); //새로고침
    }
}
