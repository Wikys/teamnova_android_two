package com.example.teamnova_android_two.mulung_helper_scedule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamnova_android_two.R;

import java.util.ArrayList;


public class mulung_helper_schedule_Adapter extends RecyclerView.Adapter<mulung_helper_schedule_Adapter.CustomViewHolder>  {
    ArrayList<mulung_helper_schedule_data> data;
    Context context;
    int 포지션;

    public interface OnItemClickListener {
        void onClick(View v,mulung_helper_schedule_data data ); //
    }
    //인터페이스
    private OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener Listener){
        mListener = Listener;
    }


    public mulung_helper_schedule_Adapter(Context context, ArrayList<mulung_helper_schedule_data> dataModels) {
        this.data = dataModels;
        this.context = context;
    }
    //---


    @NonNull
    @Override
    public mulung_helper_schedule_Adapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mulung_helper_scedule_item, parent, false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);


//        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(mListener != null) {
//                    mulung_helper_schedule_data mulung_helper_schedule_data = data.get(viewHolder.getAdapterPosition());
//                    mListener.onClick(v, mulung_helper_schedule_data, viewHolder.getAdapterPosition());
//                }
//            }
//        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        final mulung_helper_schedule_data item = data.get(position);
//      뷰 재활용되도 상태안변하게 고정



//        holder.메모저장버튼.setTag(position);
        holder.메모저장버튼.setText(item.제목);
        holder.메모저장버튼.setTag(position);


        holder.메모저장버튼.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener != null){
                    mListener.onClick(v,item);
                }
//

            }

        });


    }
//    public int setExportPosition(int position){
//        //포지션번호 배출 (메인에서 데이터지울때 사용)
//        포지션 = position;
//        return position;
//    }
//    public int getExportPosition(){
//        //포지션번호 배출 (메인에서 데이터지울때 사용)
//        return 포지션;
//    }

    public mulung_helper_schedule_data exportData(mulung_helper_schedule_data data){
        //데이터모델 타입의 메소드 이걸로 메인에있는 텍스트뷰들 바꿔줄생각

        return data;
    }




    @Override
    public int getItemCount() {
        return (null != data ? data.size() : 0); // 3항연산자 데이터가 널이아니면 데이터사이즈 널이면 0
//        return data.size();
    }




    public class CustomViewHolder extends RecyclerView.ViewHolder { //이너클래스 뷰홀더
        public Button 메모저장버튼;

        public CustomViewHolder(View view) {
            super(view);


            메모저장버튼 = (Button) view.findViewById(R.id.메모저장버튼);


        }

    }
}
