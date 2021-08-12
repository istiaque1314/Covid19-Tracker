package com.istiaque.covid19tracker;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BedsAdapter extends RecyclerView.Adapter<BedsAdapter.ViewHolder>implements Filterable {
    private ArrayList<BedsModel> arrayListBeds;
    ArrayList<BedsModel> backup;
    Context context;

    public BedsAdapter(ArrayList<BedsModel> arrayListBeds, Context context) {
        this.arrayListBeds = arrayListBeds;
        backup = new ArrayList<>(arrayListBeds);
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.designbeds,parent,false);
        return new ViewHolder (view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        BedsModel temp2 =  arrayListBeds.get(position);
        holder.stateNAME.setText(temp2.getStateName());

        holder.stateNAME.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBeds = new Intent(context,BedsAndHospitalActivity.class);

                intentBeds.putExtra("state",temp2.getStateName());

                intentBeds.setFlags(intentBeds.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intentBeds);

            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayListBeds!=null?arrayListBeds.size():0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView stateNAME;
        TextView ruralHospital;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            stateNAME = itemView.findViewById(R.id.State_Name);
            ruralHospital = itemView.findViewById(R.id.tvRuralHos);
        }
    }

    @Override
    public Filter getFilter() {
        return filter;
    }
    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence Keyword) {

            ArrayList<BedsModel> filtereddata = new ArrayList<>();

            if(Keyword.toString().isEmpty())
                filtereddata.addAll(backup);

            else
            {
                for(BedsModel obj: backup)
                {
                    if(obj.getStateName().toString().toLowerCase().contains(Keyword.toString().toLowerCase()))
                        filtereddata.add(obj);
                }
            }

            FilterResults results = new FilterResults();
            results.values = filtereddata;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results)
        {

            arrayListBeds.clear();
            arrayListBeds.addAll((ArrayList<BedsModel>)results.values);
            notifyDataSetChanged();
        }
    };
}
