package com.india.cpgram.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.india.cpgram.R;
import com.india.cpgram.activity.DetailsActivity;
import com.india.cpgram.activity.RaiseActivity;
import com.india.cpgram.model.response.DepartmentSuggestionResponse;
import com.india.cpgram.model.response.GrievanceResponse;

import java.util.List;

public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentAdapter.ViewHolder>{
    private List<DepartmentSuggestionResponse>  listdata;
    private Context context;
    private int selectedPosition;

    public DepartmentAdapter(List<DepartmentSuggestionResponse> listdata, Context context) {
        this.listdata = listdata;
        this.context=context;
        selectedPosition =0;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.department_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final DepartmentSuggestionResponse departmentSuggestionResponse = listdata.get(position);

        if(position == selectedPosition){
            holder.relativeLayout.setBackgroundColor(context.getColor(R.color.light_grey));
        }else{
            holder.relativeLayout.setBackgroundColor(context.getColor(R.color.white));

        }

        holder.tvDepartment.setText(departmentSuggestionResponse.getStage1Details().get(0).getDescription());
        holder.tvLevel1.setText(departmentSuggestionResponse.getStage2Details().get(0).getDescription());
        holder.tvLevel2.setText(departmentSuggestionResponse.getStage3Details().getDescription());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int previousSelectedPosition = selectedPosition;
                selectedPosition = position;
                notifyItemChanged(previousSelectedPosition);
                notifyItemChanged(selectedPosition);
                try {
                    if (departmentSuggestionResponse.getStage3Details().getFieldDetails() != null && departmentSuggestionResponse.getStage3Details().getFieldDetails().size() > 0) {
                        ((RaiseActivity) context).addDynamicEditText(departmentSuggestionResponse.getStage3Details().getFieldDetails());
                    }else {
                        ((RaiseActivity) context).removeAllEditText();
                    }
                }catch (Exception e ){
                    ((RaiseActivity) context).removeAllEditText();
                }
            }
        });

    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        public TextView tvDepartment,tvLevel1,tvLevel2;
        public RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.tvDepartment = itemView.findViewById(R.id.tvDepartment);
            this.tvLevel1 = itemView.findViewById(R.id.tvLevel1);

            this.tvLevel2 =  itemView.findViewById(R.id.tvLevel2);
            relativeLayout = itemView.findViewById(R.id.relativeLayout);
        }
    }
}