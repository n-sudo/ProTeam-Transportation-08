package com.example.quicksmart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* https://www.javatpoint.com/android-recyclerview-list-example */

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {

    private String[] stops;

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView text;
        public ViewHolder(View itemView) {
            super(itemView);
            this.text = (TextView) itemView.findViewById(R.id.textView);
        }
    }

    public ScheduleAdapter(String[] stops){

        this.stops = stops;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ScheduleAdapter.ViewHolder holder, int position) {

        String string = (String) stops[position];
        System.out.println(string);
        holder.text.setText(string);

    }

    @Override
    public int getItemCount() {

        return stops.length;

    }




}




