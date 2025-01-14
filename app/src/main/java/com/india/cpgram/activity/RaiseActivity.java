package com.india.cpgram.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognizerIntent;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.india.cpgram.R;
import com.india.cpgram.adapter.DepartmentAdapter;
import com.india.cpgram.databinding.ActivityRaiseBinding;
import com.india.cpgram.model.request.DepartmentRequest;
import com.india.cpgram.model.request.DepartmentSuggestionRequest;
import com.india.cpgram.model.request.GrievanceDataRequest;
import com.india.cpgram.model.request.SaveGrievance;
import com.india.cpgram.model.response.DepartmentModel;
import com.india.cpgram.model.response.DepartmentResponse;
import com.india.cpgram.model.response.DepartmentSuggestionResponse;
import com.india.cpgram.model.response.GrievanceField;
import com.india.cpgram.model.response.GrievanceFieldSearch;
import com.india.cpgram.model.response.GrievanceSaveResponse;
import com.india.cpgram.model.response.GrievanceValidator;
import com.india.cpgram.model.response.UserDetails;
import com.india.cpgram.network.APIClient;
import com.india.cpgram.network.APIInterface;
import com.india.cpgram.utils.SharePrefrence;
import com.india.cpgram.utils.SnackbarUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;

public class RaiseActivity extends AppCompatActivity {

    APIInterface apiInterface;
    ActivityRaiseBinding binding;
    List<String> departmentList,categoryList,subCategoryList;
    List<DepartmentModel> departmentModelList,categoryModelList,subCategoryModelList;
    private Handler handler;
    private Runnable runnable;
    UserDetails userDetails;
    private static final int REQUEST_CODE_SPEECH_INPUT = 1;
    List<DepartmentSuggestionResponse> departmentSuggestionResponseList;
    int selectId=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRaiseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        departmentList= new ArrayList<>();
        categoryList= new ArrayList<>();
        subCategoryList= new ArrayList<>();
        departmentModelList= new ArrayList<>();
        categoryModelList= new ArrayList<>();
        subCategoryModelList= new ArrayList<>();
        departmentSuggestionResponseList = new ArrayList<>();
        apiInterface = APIClient.getClient().create(APIInterface.class);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("File Your Grievance");
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient_header));
        userDetails = SharePrefrence.getSavedObjectFromPreference(RaiseActivity.this,"cpgram","userProfile",UserDetails.class);
        binding.mainRecyclerView.setVisibility(View.VISIBLE);
        binding.rlMannually.setVisibility(View.GONE);
        binding.tvSelectList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.mainRecyclerView.setVisibility(View.VISIBLE);
                binding.rlMannually.setVisibility(View.GONE);
            }
        });

        binding.tvSelectManually.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.mainRecyclerView.setVisibility(View.GONE);
                binding.rlMannually.setVisibility(View.VISIBLE);
            }
        });

        String[] spinnerItems = {"English","Hindi", "Bengali", "Telugu", "Marathi", "Tamil", "Urdu", "Gujarati", "Malayalam", "Kannada", "Odia", "Punjabi", "Assamese", "Maithili", "Sanskrit", "Konkani", "Sindhi", "Dogri", "Manipuri", "Bodo", "Santali", "Kashmiri", "Nepali", "Kurumbo", "Tulu", "Mizo", "Sikkimese"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerItems);
        binding.spinner.setAdapter(adapter);

        departmentList.add("Select Department");
        categoryList.add("Select Category");
        subCategoryList.add("Select Sub-Category");

        searchDepartment(0,0);


       ArrayAdapter<String> adapterDepartment = new ArrayAdapter<>(RaiseActivity.this, android.R.layout.simple_spinner_item, departmentList);
       binding.spDepartment.setAdapter(adapterDepartment);
       ArrayAdapter<String> adapterCategory = new ArrayAdapter<>(RaiseActivity.this, android.R.layout.simple_spinner_item, categoryList);
       binding.spCategory.setAdapter(adapterCategory);
       ArrayAdapter<String> adapterSubCategory = new ArrayAdapter<>(RaiseActivity.this, android.R.layout.simple_spinner_item,subCategoryList);
       binding.spSubCategory.setAdapter(adapterSubCategory);

       binding.spDepartment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position>0) {
                    searchDepartment(departmentModelList.get(position).getId(), 1);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        binding.spCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position>0) {
                    searchDepartment(categoryModelList.get(position).getId(), 2);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        binding.spSubCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position>1) {
                    try {
                        int m=position+1;
                        if (subCategoryModelList.get(m).getFieldDetails()!= null && subCategoryModelList.get(m).getFieldDetails().size() > 0) {
                           addDynamicEditText(subCategoryModelList.get(m).getFieldDetails());
                        } else {
                           removeAllEditText();
                        }
                    } catch (Exception e) {
                        removeAllEditText();
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                searchDepartmentSuggestion();
            }
        };
        binding.inputDescription.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                if (charSequence.length()>0) {

                    handler.removeCallbacks(runnable);


                }
            }

            @Override
            public void afterTextChanged(Editable editable) {


                handler.postDelayed(runnable, 3000);

            }
        });
        binding.ivMic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak to text");

                try {
                    startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT);
                }
                catch (Exception e) {
                    Toast
                            .makeText(RaiseActivity.this, " " + e.getMessage(),
                                    Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });

        binding.btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.btnContinue.setVisibility(View.GONE);
                binding.txtMobileNo.setVisibility(View.VISIBLE);
                binding.txtUsername.setVisibility(View.VISIBLE);
                binding.lvButton.setVisibility(View.VISIBLE);
                binding.lvDynamic.setVisibility(View.VISIBLE);
            }
        });

        binding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(binding.inputUsername.getText().toString().isEmpty()){
                    SnackbarUtil.showSnackbar(RaiseActivity.this,getString(R.string.fullname_error), getColor(R.color.semi_grey), getColor(R.color.white));
                }else if(binding.inputMobileNo.getText().toString().isEmpty()){
                    SnackbarUtil.showSnackbar(RaiseActivity.this,getString(R.string.mobile_error), getColor(R.color.semi_grey), getColor(R.color.white));
                }else {
                    saveGrievance();
                }
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SPEECH_INPUT) {
            if (resultCode == RESULT_OK && data != null) {
                ArrayList<String> result = data.getStringArrayListExtra(
                        RecognizerIntent.EXTRA_RESULTS);
                binding.inputDescription.setText(
                        Objects.requireNonNull(result).get(0));
            }
        }
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

    public void searchDepartmentSuggestion(){

        DepartmentSuggestionRequest departmentSuggestionRequest= new DepartmentSuggestionRequest("My name is Rajat my mobile network is not working");
        Call<List<DepartmentSuggestionResponse>> response = apiInterface.searchDepartmentSuggestion(departmentSuggestionRequest);

        response.enqueue(new Callback<List<DepartmentSuggestionResponse>>()
        {
            @Override
            public void onResponse(Call<List<DepartmentSuggestionResponse>> call, retrofit2.Response<List<DepartmentSuggestionResponse>> rawResponse)
            {
                try
                {
                    if(rawResponse.isSuccessful()&&rawResponse.code()==200) {

                        departmentSuggestionResponseList = rawResponse.body();
                        DepartmentAdapter adapter = new DepartmentAdapter(rawResponse.body(), RaiseActivity.this);
                        binding.mainRecyclerView.setHasFixedSize(true);
                        binding.mainRecyclerView.setLayoutManager(new LinearLayoutManager(RaiseActivity.this, LinearLayoutManager.HORIZONTAL, false));
                        binding.mainRecyclerView.setAdapter(adapter);


                       // Toast.makeText(RaiseActivity.this,""+rawResponse.body().getMsg(),Toast.LENGTH_SHORT).show();
                    }else{

                    }
                }
                catch (Exception e)
                {

                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<DepartmentSuggestionResponse>> call, Throwable throwable)
            {
                Log.e("jhkbk",""+throwable.getMessage());
                // other stuff...
            }
        });
    }
    public void searchDepartment(int parent,int level){

        DepartmentRequest departmentRequest= new DepartmentRequest(parent);
        Call<DepartmentResponse> response = apiInterface.getDepartment(departmentRequest);

        response.enqueue(new Callback<DepartmentResponse>()
        {
            @Override
            public void onResponse(Call<DepartmentResponse> call, retrofit2.Response<DepartmentResponse> rawResponse)
            {
                try
                {
                    if(rawResponse.isSuccessful()&&rawResponse.code()==200) {
                        if(level==0) {
                            binding.lvDepartment.setVisibility(View.VISIBLE);
                            departmentModelList = rawResponse.body().getResponse();
                            departmentModelList.forEach(item->{
                                departmentList.add(item.getName());
                            });
                            ArrayAdapter<String> adapter = new ArrayAdapter<>(RaiseActivity.this, android.R.layout.simple_spinner_item, departmentList);
                            binding.spDepartment.setAdapter(adapter);
                        }else if(level==1){
                            binding.lvCategory.setVisibility(View.VISIBLE);
                            categoryModelList = rawResponse.body().getResponse();
                            categoryModelList.forEach(item->{
                                categoryList.add(item.getName());
                            });
                            ArrayAdapter<String> adapter = new ArrayAdapter<>(RaiseActivity.this, android.R.layout.simple_spinner_item, categoryList);
                            binding.spCategory.setAdapter(adapter);
                        }else if(level==2){
                            binding.lvSubCategory.setVisibility(View.VISIBLE);
                            subCategoryModelList = rawResponse.body().getResponse();
                            subCategoryModelList.forEach(item->{
                                subCategoryList.add(item.getName());
                            });
                            ArrayAdapter<String> adapter = new ArrayAdapter<>(RaiseActivity.this, android.R.layout.simple_spinner_item,subCategoryList);
                            binding.spSubCategory.setAdapter(adapter);

                        }
                    }else{

                    }
                }
                catch (Exception e)
                {

                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<DepartmentResponse> call, Throwable throwable)
            {
                Log.e("jhkbk",""+throwable.getMessage());
                // other stuff...
            }
        });
    }
    public void saveGrievance(){

        int DeptId = 0;
        String assignTo = "";
        List<GrievanceField> grievanceFieldList = new ArrayList<>();
        if(departmentSuggestionResponseList.size()>0) {
            for (int i = 0; i < departmentSuggestionResponseList.get(selectId).getStage3Details().getFieldDetails().size(); i++) {
                DeptId = departmentSuggestionResponseList.get(selectId).getStage3Details().getId();
                assignTo = departmentSuggestionResponseList.get(selectId).getStage3Details().getMonitoringcode();
                GrievanceValidator grievanceValidator = new GrievanceValidator(departmentSuggestionResponseList.get(selectId).getStage3Details().getFieldDetails().get(i).getIsMandetory());
                GrievanceField grievanceField = new GrievanceField();
                grievanceField.setLabel(departmentSuggestionResponseList.get(selectId).getStage3Details().getFieldDetails().get(i).getFieldName());
                grievanceField.setName(departmentSuggestionResponseList.get(selectId).getStage3Details().getFieldDetails().get(i).getModelName());
                grievanceField.setType(departmentSuggestionResponseList.get(selectId).getStage3Details().getFieldDetails().get(i).getFieldType().getCode());
                grievanceField.setPlaceholder(departmentSuggestionResponseList.get(selectId).getStage3Details().getFieldDetails().get(i).getFieldName());
                try {
                    EditText editText = (EditText) binding.lvDynamic.getChildAt(i);
                    String value = editText.getText().toString();
                    if(departmentSuggestionResponseList.get(selectId).getStage3Details().getFieldDetails().get(i).getIsMandetory()){
                        if(value.isEmpty()){
                            editText.setError(getString(R.string.required));
                            return;
                        }
                    }
                    grievanceField.setValue(value);
                }catch (Exception e){
                    grievanceField.setValue("");
                }
                grievanceField.setValidators(grievanceValidator);
                grievanceFieldList.add(grievanceField);
            }
        }
        GrievanceDataRequest grievanceDataRequest = new GrievanceDataRequest();

        grievanceDataRequest.setName(userDetails.getName());
        grievanceDataRequest.setCountry("India");
        grievanceDataRequest.setState("");
        grievanceDataRequest.setDistrict("");
        grievanceDataRequest.setAddress(userDetails.getAddress());
        grievanceDataRequest.setAddress2(null);
        grievanceDataRequest.setPinCode("");
        grievanceDataRequest.setEmailId(userDetails.getEmail());
        grievanceDataRequest.setMobileNo(userDetails.getMobileNo());
        grievanceDataRequest.setFieldDetails(grievanceFieldList);
        grievanceDataRequest.setRaisedBy(userDetails.getId());
        grievanceDataRequest.setDescriptionEn(binding.inputDescription.getText().toString());
        grievanceDataRequest.setDescriptionOther("");
        grievanceDataRequest.setAssignBy(userDetails.getId());
        grievanceDataRequest.setAssignTo(assignTo);
        grievanceDataRequest.setDeptid(DeptId);
        grievanceDataRequest.setChannel("Mobile App");
        SaveGrievance saveGrievance = new SaveGrievance();
        saveGrievance.setData(grievanceDataRequest);

        Call<GrievanceSaveResponse> response = apiInterface.saveGrievance(saveGrievance);
        response.enqueue(new Callback<GrievanceSaveResponse>()
        {
            @Override
            public void onResponse(Call<GrievanceSaveResponse> call, retrofit2.Response<GrievanceSaveResponse> rawResponse)
            {
                try
                {
                    if(rawResponse.isSuccessful()&&rawResponse.code()==200) {

                    }else{

                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<GrievanceSaveResponse> call, Throwable throwable)
            {
                Log.e("jhkbk",""+throwable.getMessage());
                // other stuff...
            }
        });
    }
    public void addDynamicEditText(List<GrievanceFieldSearch> fieldSearchList) {

        binding.lvDynamic.removeAllViews();
        fieldSearchList.forEach(fieldItem->{

            final EditText editText = new EditText(this);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(10, 10, 10, 10); // Add margin to the EditText
            editText.setLayoutParams(params);
            editText.setHint("Enter " + fieldItem.getModelName());
            if(fieldItem.getFieldType().getName().equalsIgnoreCase("text")) {
                editText.setInputType(InputType.TYPE_CLASS_TEXT);
            }else if(fieldItem.getFieldType().getName().equalsIgnoreCase("number")) {
                editText.setInputType(InputType.TYPE_CLASS_NUMBER);
            } else {
                editText.setInputType(InputType.TYPE_CLASS_TEXT);
            }
            binding.lvDynamic.addView(editText);
        });

    }
    public void removeAllEditText() {

        binding.lvDynamic.removeAllViews();

    }

}