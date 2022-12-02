package com.example.teamnova_android_two.seed_49;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamnova_android_two.R;
import com.example.teamnova_android_two.seed_39.Quiz_Adapter;
import com.example.teamnova_android_two.seed_39.seed_helper_39_data;

import java.util.ArrayList;

public class Monster_Quiz_Adapter extends RecyclerView.Adapter<Monster_Quiz_Adapter.CustomViewHolder> {
    ArrayList<seed_helper_49_data> data;
    Context context;

    public Monster_Quiz_Adapter(Context context, ArrayList<seed_helper_49_data> dataModels) {
        this.data = dataModels;
        this.context = context;
    }

    @NonNull
    @Override
    public Monster_Quiz_Adapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("Monster_Quiz_Adapter", "onCreateViewHolder: ");
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.seed_helper_49_item, parent, false);

        Monster_Quiz_Adapter.CustomViewHolder viewHolder = new Monster_Quiz_Adapter.CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Monster_Quiz_Adapter.CustomViewHolder holder, int position) {
        Log.d("Monster_Quiz_Adapter", "onBindViewHolder: ");
        holder.area.setText(data.get(position).area);
        holder.monsterName.setText(data.get(position).monsterName);
        holder.monsterImage.setImageResource(data.get(position).image_path);

    }

    @Override
    public int getItemCount() {
        Log.d("Monster_Quiz_Adapter", "getItemCount: ");
        return data.size();
    }
    public class CustomViewHolder extends RecyclerView.ViewHolder { //이너클래스 //(새로띄우고싶은)바꾸고싶은정보?
        TextView area;
        TextView monsterName;
        ImageView monsterImage;
//        private final Button 정답;

        public CustomViewHolder(View view) { // 뷰홀더 뷰들 findviewid
            super(view);
            Log.d("Monster_Quiz_Adapter", "CustomViewHolder: ");
            area = (TextView) view.findViewById(R.id.등장장소);
            monsterName = (TextView) view.findViewById(R.id.몬스터이름);
            monsterImage = (ImageView) view.findViewById(R.id.몬스터이미지);


//            정답 = (Button) view.findViewById(R.id.답변4);

        }
    }

    public void itemfilter(ArrayList<seed_helper_49_data> filterlist) {
        Log.d("Monster_Quiz_Adapter", "itemfilter: ");
        //여기서 변경내용 데이터에 넣어주고 새로고침
        data = filterlist;
        notifyDataSetChanged(); //새로고침
    }
}
