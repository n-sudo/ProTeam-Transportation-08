package com.example.quicksmart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TransportationAdapter extends RecyclerView.Adapter<TransportationAdapter.ViewHolder>{

    private String[] transInfo;

    private int[] resIds = {
        R.drawable.untitled__2_,
        R.drawable.untitled__3_,
        R.drawable.untitled__4_,
        R.drawable.dude_walking,
        R.drawable.warning
    };

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView text1;
        public ImageView icon;
        public ViewHolder(View itemView) {
            super(itemView);
            this.text1 = (TextView) itemView.findViewById(R.id.transInfo);
            this.icon = (ImageView) itemView.findViewById(R.id.transIcon);
        }
    }

    public TransportationAdapter(String[] transInfo){

        this.transInfo = transInfo;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.transportation_option, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TransportationAdapter.ViewHolder holder, int position) {

        holder.text1.setText(transInfo[position]);

        if (transInfo[position].contains("walk")) {
            holder.icon.setImageResource(resIds[3]);
        } else if (transInfo[position].contains("bike")) {
            holder.icon.setImageResource(resIds[0]);
        } else if (transInfo[position].contains("bus")) {
            holder.icon.setImageResource(resIds[1]);
        } else if (transInfo[position].contains("train")) {
            holder.icon.setImageResource(resIds[2]);
        }else{
            holder.icon.setImageResource(resIds[4]);
        }

    }

    @Override
    public int getItemCount() {

        return transInfo.length;

    }


}