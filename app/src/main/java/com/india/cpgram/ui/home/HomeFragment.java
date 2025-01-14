package com.india.cpgram.ui.home;

import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.india.cpgram.adapter.CardViewAdapter;
import com.india.cpgram.model.request.GrievanceListRequest;
import com.india.cpgram.model.response.GrievanceListResponse;
import com.india.cpgram.network.APIClient;
import com.india.cpgram.network.APIInterface;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.india.cpgram.databinding.FragmentHomeBinding;

import retrofit2.Call;
import retrofit2.Callback;

public class HomeFragment extends Fragment {
    APIInterface apiInterface;
    private FragmentHomeBinding binding;
    private FusedLocationProviderClient fusedLocationClient;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);

        View root = binding.getRoot();
        apiInterface = APIClient.getClient().create(APIInterface.class);
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(getActivity());

        binding.textUser.setText(Html.fromHtml("<font color=#000000>Hi, </font>" +
                "<font color=#2E57A7> Pawan!</font>"));
//        GrievanceModel[] myListData2 = new GrievanceModel[] {
//                new GrievanceModel(1, "Technical", "Server is down", "Open", "2025-01-08"),
//        new GrievanceModel(2, "Billing", "Invoice discrepancy", "Closed", "2025-01-05"),
//        new GrievanceModel(3, "HR", "Leave request not processed", "In Progress", "2025-01-02"),
//        new GrievanceModel(4, "Technical", "App crash on login", "Open", "2025-01-07"),
//        new GrievanceModel(5, "Customer Service", "Delay in response", "Closed", "2025-01-01")
//        };




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
                            Log.e("Error",""+e.getMessage());
                        }
                      //   ListViewAdapter adapterList = new ListViewAdapter(rawResponse.body().getIncidentDetailsList(), getActivity());
                      //  binding.secondaryRecyclerView.setHasFixedSize(true);
                      //  binding.secondaryRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                      //  binding.secondaryRecyclerView.setAdapter(adapterList);

                    }else{

                        Log.e("Error"," No Data found");
                    }
                }
                catch (Exception e)
                {
                    Log.e("Error",""+e.getMessage());
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