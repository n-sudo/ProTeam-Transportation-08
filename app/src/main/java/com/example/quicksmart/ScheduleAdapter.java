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
    private String[][] times;

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView text1;
        public TextView text2;
        public ViewHolder(View itemView) {
            super(itemView);
            this.text1 = (TextView) itemView.findViewById(R.id.textView);
            this.text2 = (TextView) itemView.findViewById(R.id.textView2);
        }
    }

    public ScheduleAdapter(String[] stops, String[][] times){

        this.stops = stops;
        this.times = times;


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

        holder.text1.setText(stops[position]);
        holder.text2.setText(formatTimes(position));
    }

    @Override
    public int getItemCount() {

        return stops.length;

    }

    private String formatTimes(int position){

        String timeString = "";

        if(position < times.length) {

            for (int i = 0; i < times[position].length; i++) {

                timeString += times[position][i] + " ";

            }

        }else{

            timeString = "stop times not found";

        }

        return timeString;

    }


}




