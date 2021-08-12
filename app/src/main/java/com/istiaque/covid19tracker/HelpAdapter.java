package com.istiaque.covid19tracker;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HelpAdapter extends RecyclerView.Adapter<HelpAdapter.ViewHolder>implements Filterable   {

    private ArrayList<HelpModel> arrayList;
    ArrayList<HelpModel> backup;
    Context context;


    public HelpAdapter(ArrayList<HelpModel> arrayList, Context context) {
        this.arrayList = arrayList;
        backup = new ArrayList<>(arrayList);
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.singlerow, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        HelpModel temp1 = arrayList.get(position);

        holder.StateName.setText(temp1.getStateName());
        holder.HelpLine_Number.setText(String.valueOf(temp1.getContactNumber()));



    }

    @Override
    public int getItemCount() {
        return arrayList!=null?arrayList.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        ImageView img;
        TextView StateName,HelpLine_Number;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            StateName = itemView.findViewById(R.id.State_Name);
            HelpLine_Number = itemView.findViewById(R.id.Contact_Number);
            img = itemView.findViewById(R.id.img1);
        }
    }

    @Override
    public Filter getFilter() {
        return filter;
    }
    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence Keyword) {

            ArrayList<HelpModel> filtereddata = new ArrayList<>();

            if(Keyword.toString().isEmpty())
                filtereddata.addAll(backup);

            else
            {
                for(HelpModel obj: backup)
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

            arrayList.clear();
            arrayList.addAll((ArrayList<HelpModel>)results.values);
            notifyDataSetChanged();
        }
    };
}