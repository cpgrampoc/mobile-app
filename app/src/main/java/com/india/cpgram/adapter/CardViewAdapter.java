package com.india.cpgram.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.india.cpgram.R;
import com.india.cpgram.activity.DetailsActivity;
import com.india.cpgram.model.response.GrievanceResponse;

import java.util.List;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.ViewHolder>{
    private List<GrievanceResponse>  listdata;
    private Context context;
    public CardViewAdapter(List<GrievanceResponse> listdata, Context context) {
        this.listdata = listdata;
        this.context=context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.event_card_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final GrievanceResponse grievanceModel = listdata.get(position);
//        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        DateFormat outputFormat = new SimpleDateFormat("dd MMM yyyy");
//        String inputDateStr=""+incidentDetails.getSubmittedOn();
//        Date date = null;
//        try {
//            date = inputFormat.parse(inputDateStr);
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//        String outputDateStr = outputFormat.format(date);

        holder.tvStatus.setText("Status: "+ grievanceModel.getStatus());
        holder.tvDate.setText(grievanceModel.getCreatedAt());
        holder.tvGrievanceNo.setText(""+grievanceModel.getGrievanceId());
        holder.tvCategory.setText(grievanceModel.getCategory());
        holder.tvDescription.setText(grievanceModel.getDescriptionEn());
       // holder.imageView.setImageResource(R.drawable.baseline_insert_drive_file_24);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(context, DetailsActivity.class);
                i.putExtra("id",grievanceModel.getGrievanceId());
                context.startActivity(i);
               // Toast.makeText(view.getContext(),"click on item: ",Toast.LENGTH_LONG).show();
            }
        });
        holder.rlInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(context, DetailsActivity.class);
                i.putExtra("id",grievanceModel.getGrievanceId());
                context.startActivity(i);
                // Toast.makeText(view.getContext(),"click on item: ",Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
       // public ImageView imageView;
        public TextView tvDate;
        public TextView tvStatus;
        public TextView tvGrievanceNo,tvCategory,tvDescription;
        public RelativeLayout rlInfo;
        public LinearLayout linearLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.tvCategory = itemView.findViewById(R.id.tvCategory);
            this.tvDescription = itemView.findViewById(R.id.tvDescription);

           // this.imageView = (ImageView) itemView.findViewById(R.id.image);
            this.tvDate = (TextView) itemView.findViewById(R.id.tvDate);
            this.tvStatus = (TextView) itemView.findViewById(R.id.tvStatus);
            this.tvGrievanceNo = (TextView)itemView.findViewById(R.id.tvGrievanceNo);
            linearLayout = itemView.findViewById(R.id.linearLayout);
            this.rlInfo=(RelativeLayout) itemView.findViewById(R.id.rlInfo);
        }
    }
}