package com.india.cpgram.ui.application;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.india.cpgram.adapter.CardViewAdapter;
import com.india.cpgram.databinding.FragmentApplicationBinding;
import com.india.cpgram.model.request.GrievanceListRequest;
import com.india.cpgram.model.response.GrievanceListResponse;
import com.india.cpgram.network.APIClient;
import com.india.cpgram.network.APIInterface;

import retrofit2.Call;
import retrofit2.Callback;

public class ApplicationFragment extends Fragment {

    APIInterface apiInterface;
    private FragmentApplicationBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentApplicationBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textDashboard;
        //dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        apiInterface = APIClient.getClient().create(APIInterface.class);


          getData();
        return root;
    }
    public void getData(){

        GrievanceListRequest grievanceListRequest = new GrievanceListRequest(15);
        Call<GrievanceListResponse> response = apiInterface.getGrievanceList(grievanceListRequest);

        response.enqueue(new Callback<GrievanceListResponse>()
        {
            @Override
            public void onResponse(Call<GrievanceListResponse> call, retrofit2.Response<GrievanceListResponse> rawResponse)
            {
                try
                {

                    if(rawResponse.isSuccessful()&&rawResponse.code()==200) {
                        try{
                            if(rawResponse.body().getResponse().size()>0) {
                                CardViewAdapter adapter = new CardViewAdapter(rawResponse.body().getResponse(), getActivity());
                                binding.mainRecyclerView.setHasFixedSize(true);
                                binding.mainRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
                                binding.mainRecyclerView.setAdapter(adapter);
                            }}catch (Exception e){

                        }
                        //   ListViewAdapter adapterList = new ListViewAdapter(rawResponse.body().getIncidentDetailsList(), getActivity());
                        //  binding.secondaryRecyclerView.setHasFixedSize(true);
                        //  binding.secondaryRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                        //  binding.secondaryRecyclerView.setAdapter(adapterList);

                    }else{

                    }
                }
                catch (Exception e)
                {

                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<GrievanceListResponse> call, Throwable throwable)
            {
                Log.e("jhkbk",""+throwable.getMessage());
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}