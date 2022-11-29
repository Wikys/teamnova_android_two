package com.example.teamnova_android_two;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CustomViewHolder> {


    @NonNull
    @Override // 비어있는 커스텀 뷰홀더를 getItemCount 메서드 리턴된 값만큼 만든다
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cell, parent, false);

//        LayoutInflater 레이아웃인플레이터 = LayoutInflater.from(parent.getContext());
//        레이아웃인플레이터.inflate(R.layout.cell, parent, false);

        return new CustomViewHolder(view); //내가 밑에서 만든 이너클래스가 최종리턴값
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {


        holder.textView.setText(recyclerview.이름.get(position));


    }

    @Override
    public int getItemCount() { //아이템 몇개나 나오게할것인지
        return recyclerview.이름.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder { //이너클래스 //(새로띄우고싶은)바꾸고싶은정보?
        private final TextView textView;

        public CustomViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.textView2);


        }
    }
}
