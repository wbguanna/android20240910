package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    private List<String> itemList;

    public MyAdapter(List<String> itemList) {
        this.itemList = itemList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        super.onBindViewHolder(holder, position, payloads);
        String item = itemList.get(position);
        holder.itemText.setText(item);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // RecyclerView의 각 아이템에 표시될 텍스트를 담당하는 TextVIew
        public TextView itemText;

        public MyViewHolder(View view) {
            // View 객체 인자는 RecyclerView의 각 아이템 뷰
            // super(view)를 통해 부모 클래스인 RecyclerView.ViewHolder의 생성자를 호출.
            // 이렇게 해서 ViewHolder가 해당 아이템 뷰를 관리할 수 있다.
            super(view);
            // view.findViewById(R.id.item_text)로 itemText 멤버변수 초기화
            // RecyclerView의 각 아이템에 표시될 TextView 참조
            itemText = view.findViewById(R.id.item_text);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        // itemList는 어뎁터에 있는데?
                        String clickedItem = itemList.get(position);
                        // 토스트 이벤트 // Long 또는 Short으로 설정할수 있다..
                        Toast.makeText(v.getContext(), "Clicked: "+ clickedItem, Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

}
