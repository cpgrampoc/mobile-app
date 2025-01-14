package com.india.cpgram.network;


import com.india.cpgram.model.request.DepartmentRequest;
import com.india.cpgram.model.request.DepartmentSuggestionRequest;
import com.india.cpgram.model.request.GrievanceDetailsRequest;
import com.india.cpgram.model.request.GrievanceListRequest;
import com.india.cpgram.model.request.LoginRequest;
import com.india.cpgram.model.request.SaveGrievance;
import com.india.cpgram.model.response.DepartmentResponse;
import com.india.cpgram.model.response.DepartmentSuggestionResponse;
import com.india.cpgram.model.response.GrievanceDetailsResponse;
import com.india.cpgram.model.response.GrievanceListResponse;
import com.india.cpgram.model.response.GrievanceSaveResponse;
import com.india.cpgram.model.response.LoginModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIInterface {

    @POST("cpgram-application-service/user/login")
    Call<LoginModel> login(@Body LoginRequest loginRequest);

    @POST("search")
    Call<List<DepartmentSuggestionResponse>> searchDepartmentSuggestion(@Body DepartmentSuggestionRequest departmentSuggestionRequest);

    @POST("cpgram-application-service/grievance/search")
    Call<GrievanceListResponse> getGrievanceList(@Body GrievanceListRequest grievanceListRequest);

    @POST("cpgram-application-service/getDepartments")
    Call<DepartmentResponse> getDepartment(@Body DepartmentRequest departmentRequest);

    @POST("cpgram-application-service/grievance/create")
    Call<GrievanceSaveResponse> saveGrievance(@Body SaveGrievance saveGrievance);

    @POST("cpgram-application-service/grievance/search")
    Call<GrievanceDetailsResponse> GetGrievanceDetails(@Body GrievanceDetailsRequest grievanceDetailsRequest);

}
