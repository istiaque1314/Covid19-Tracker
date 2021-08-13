package com.istiaque.covid19tracker;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.Model;

import java.util.ArrayList;

public class WorldAdapter extends RecyclerView.Adapter<WorldAdapter.ViewHolder>implements Filterable {

    private ArrayList<WorldModel> arrayListWorld;
    ArrayList<WorldModel> backup;
    private Context context;

    public WorldAdapter(ArrayList<WorldModel> arrayListWorld, Context context) {
        this.arrayListWorld = arrayListWorld;
        backup = new ArrayList<>(arrayListWorld);
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.designworld, parent, false);
        return new WorldAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        WorldModel temp2 = arrayListWorld.get(position);

        holder.ConName.setText(temp2.getCountry_Name());
        Glide.with(context).load(arrayListWorld.get(position).getCountry_Image()).into(holder.image);

        holder.ConName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentWorld = new Intent(context,AffectedCountry.class);

                intentWorld.putExtra("country",temp2.getCountry_Name());

                intentWorld.setFlags(intentWorld.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intentWorld);

            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayListWorld!=null?arrayListWorld.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView ConName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ConName = itemView.findViewById(R.id.State_Name);
            image = itemView.findViewById(R.id.Image);

        }
    }

    @Override
    public Filter getFilter() {
        return filter;
    }
    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence Keyword) {

            ArrayList<WorldModel> filtereddata = new ArrayList<>();

            if(Keyword.toString().isEmpty())
                filtereddata.addAll(backup);

            else
            {
                for(WorldModel obj: backup)
                {
                    if(obj.getCountry_Name().toString().toLowerCase().contains(Keyword.toString().toLowerCase()))
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

            arrayListWorld.clear();
            arrayListWorld.addAll((ArrayList<WorldModel>)results.values);
            notifyDataSetChanged();
        }
    };
}