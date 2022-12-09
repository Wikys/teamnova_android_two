package com.example.teamnova_android_two.mulung_helper_scedule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamnova_android_two.R;
import com.example.teamnova_android_two.seed_24.BGM_Adapter;
import com.example.teamnova_android_two.seed_24.seed_helper_24_data;

import java.util.ArrayList;

public class mulung_helper_schedule_Adapter extends RecyclerView.Adapter<mulung_helper_schedule_Adapter.CustomViewHolder>{
    ArrayList<mulung_helper_schedule_data> data;
    Context context;
    private int checkPosition = -1; //포지션 체크하는변수

    public mulung_helper_schedule_Adapter(Context context, ArrayList<mulung_helper_schedule_data> dataModels){
        this.data = dataModels;
        this.context = context;
    }
//    public void deleteItem(int position) {
//        data.remove(position);
//        notifyItemRemoved(position);
//        notifyItemRangeChanged(position, data.size());
//    }


    //커스텀리스너 인터페이스 (외부에서 클릭효과주기위해서 작성)
    public interface OnItemClickListener {
        void onItemClick(View v, int position) ;
        //클릭한뷰의포지션정보를 가짐
    }
    private OnItemClickListener ItemClickListener = new OnItemClickListener() {
        @Override
        public void onItemClick(View v, int position) {
            notifyItemChanged(checkPosition, null);
            checkPosition = position;
            notifyItemChanged(position, null);
        }
    };


    private OnItemClickListener itemClickListener = new OnItemClickListener() {
        //커스텀 리스너
        @Override
        public void onItemClick(View v, int position) {
            notifyItemChanged(checkPosition, null);
            checkPosition = position;
            //클릭했을때 아이템의 포지션정보를 체크포지션에 넣어줌
            notifyItemChanged(position, null);
        }
    };
//    // 리스너 객체 참조를 저장하는 변수
//    private OnItemClickListener mListener;
//
//    // OnItemClickListener 리스너 객체 참조를 어댑터에 전달하는 메서드
//    public void setOnItemClickListener(OnItemClickListener listener) {
//        mListener = listener ;
//    }

    @NonNull
    @Override
    public mulung_helper_schedule_Adapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mulung_helper_scedule_item,parent,false);
        CustomViewHolder viewHolder = new CustomViewHolder(view, itemClickListener) ;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        final mulung_helper_schedule_data item = data.get(position);
        holder.메모저장버튼.setText(item.제목);



    }
    public mulung_helper_schedule_data getSelected(){
        if(checkPosition > -1){
            //포지션체크변수가 -1보다크면
         return data.get(checkPosition);
//         포지션체크번째의 데이터 출력
        }
        return null;
        //아니면 널값리턴
    }
    public int getCheckedPosition() {

        return checkPosition;
    }
    //포지션번호찾는 메소드
    public void clearSelected(){
        checkPosition = -1;
    }



    @Override
    public int getItemCount() {
        return (null != data ? data.size() : 0); // 3항연산자 데이터가 널이아니면 데이터사이즈 널이면 0
//        return data.size();
    }





    public class CustomViewHolder extends RecyclerView.ViewHolder { //이너클래스 뷰홀더
        private final Button 메모저장버튼;

        public CustomViewHolder(View view, final OnItemClickListener itemClickListener) {
            super(view);
            메모저장버튼 = (Button) view.findViewById(R.id.메모저장버튼);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        itemClickListener.onItemClick(v,position);
                        //포지션이 있으면 포지션번호넣어주고

                    }
                }
            });



        }

    }
}
