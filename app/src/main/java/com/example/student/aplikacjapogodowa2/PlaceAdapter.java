package com.example.student.aplikacjapogodowa2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;



/**
 * Created by student on 2018-01-03.
 */

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder>  {


    private ArrayList<Place> places = new ArrayList<>();
    private OnPlaceClick listener;

    PlaceAdapter(ArrayList<Place> places,OnPlaceClick listener) {
        this.places = places;
        this.listener=listener;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, null);
        return new ViewHolder(itemLayoutView,listener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setPlaceName(places.get(position).getPlaceName());
        holder.setInfo(places.get(position).getInformation() + "");
    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.city_name)
        TextView city_name;

        @BindView(R.id.info)
        TextView info;

        private OnPlaceClick listener;

        public ViewHolder(View itemView,OnPlaceClick listener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        private void setPlaceName(String placeName) {
            city_name.setText(placeName);
        }

        public void setInfo(String information) {
            info.setText(information);
        }

        @Override
        public void onClick(View view) {
            listener.onPlaceClick(view, getAdapterPosition());
        }
    }
}
