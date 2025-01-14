package com.india.cpgram.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.india.cpgram.R;
import com.india.cpgram.databinding.ActivityDetailsBinding;
import com.india.cpgram.model.request.GrievanceDetailsRequest;
import com.india.cpgram.model.response.GrievanceDetailsResponse;
import com.india.cpgram.model.response.GrievanceField;
import com.india.cpgram.model.response.GrievanceFieldSearch;
import com.india.cpgram.model.response.GrievanceResponse;
import com.india.cpgram.network.APIClient;
import com.india.cpgram.network.APIInterface;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class DetailsActivity extends AppCompatActivity {
    APIInterface apiInterface;
    ActivityDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        apiInterface = APIClient.getClient().create(APIInterface.class);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Grievance Details");
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient_header));

        String gId= getIntent().getExtras().getString("id");
        getData(gId);


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    public void getData(String gId){
        GrievanceDetailsRequest grievanceDetailsRequest = new GrievanceDetailsRequest(gId);

         Call<GrievanceDetailsResponse> response = apiInterface.GetGrievanceDetails(grievanceDetailsRequest);

        response.enqueue(new Callback<GrievanceDetailsResponse>()
        {
            @Override
            public void onResponse(Call<GrievanceDetailsResponse> call, retrofit2.Response<GrievanceDetailsResponse> rawResponse)
            {
              //  try
              //  {

                    if(rawResponse.isSuccessful()&&rawResponse.code()==200) {
                        try{
                            if(rawResponse.body().getResponse().size()>0) {
                                final GrievanceResponse incidentDetails = rawResponse.body().getResponse().get(0);
                               /* DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                                DateFormat outputFormat = new SimpleDateFormat("dd MMM yyyy");
                                String inputDateStr=""+incidentDetails.getCreatedAt();
                                Date date = null;
                                try {
                                    date = inputFormat.parse(inputDateStr);
                                } catch (ParseException e) {
                                    throw new RuntimeException(e);
                                }
                                String outputDateStr = outputFormat.format(date);
*/
                              //  binding.tvStatus.setText("Status: "+ incidentDetails.getStatus());
                             //   binding.tvDate.setText("Raised On: "+outputDateStr);
                                binding.tvCategory.setText(incidentDetails.getCategory());
                                binding.tvDescription.setText(incidentDetails.getDescriptionEn());
                                binding.tvCountry.setText(incidentDetails.getCountry());
                                binding.tvName.setText(incidentDetails.getName());
                                binding.tvEmail.setText(incidentDetails.getEmailId());
                                binding.tvMobile.setText(incidentDetails.getMobileNo());

                                try {
                                    if (incidentDetails.getField1() != null && incidentDetails.getField1().size() > 0) {
                                        addDynamicEditText(incidentDetails.getField1());
                                    }
                                }catch (Exception e){

                                }
                            }}catch (Exception e){

                        }
                        //   ListViewAdapter adapterList = new ListViewAdapter(rawResponse.body().getIncidentDetailsList(), getActivity());
                        //  binding.secondaryRecyclerView.setHasFixedSize(true);
                        //  binding.secondaryRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                        //  binding.secondaryRecyclerView.setAdapter(adapterList);

                    }else{

                    }
//                }
//                catch (Exception e)
//                {
//
//                    e.printStackTrace();
//                }
            }

            @Override
            public void onFailure(Call<GrievanceDetailsResponse> call, Throwable throwable)
            {
                Log.e("jhkbk",""+throwable.getMessage());
            }
        });
    }
    public void addDynamicEditText(List<GrievanceField> fieldSearchList) {

        binding.lvDynamic.removeAllViews();
        fieldSearchList.forEach(fieldItem->{

            final TextView textView = new TextView(this);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(10, 10, 10, 10); // Add margin to the EditText
            textView.setLayoutParams(params);
            textView.setText(fieldItem.getLabel()+" : "+ fieldItem.getValue());

            binding.lvDynamic.addView(textView);
        });

    }
    public void removeAllEditText() {

        binding.lvDynamic.removeAllViews();

    }
}