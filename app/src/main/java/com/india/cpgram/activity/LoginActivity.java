package com.india.cpgram.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.Html;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.india.cpgram.R;
import com.india.cpgram.databinding.ActivityLoginBinding;
import com.india.cpgram.model.request.LoginRequest;
import com.india.cpgram.model.response.LoginModel;
import com.india.cpgram.network.APIClient;
import com.india.cpgram.network.APIInterface;
import com.india.cpgram.utils.InternetConnection;
import com.india.cpgram.utils.SharePrefrence;
import com.india.cpgram.utils.SnackbarUtil;

import retrofit2.Call;
import retrofit2.Callback;

public class LoginActivity extends AppCompatActivity {

    APIInterface apiInterface;
    ActivityLoginBinding activityLoginBinding;
    boolean otpFlag=false;
    String type="Citizen";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLoginBinding=  ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(activityLoginBinding.getRoot());
        getSupportActionBar().hide();

        apiInterface = APIClient.getClientLogin().create(APIInterface.class);
        activityLoginBinding.tvlogin.setTextColor(getColor(R.color.gradient1));
        Shader textShader = new LinearGradient(0, 0, activityLoginBinding.tvlogin.getPaint().measureText(activityLoginBinding.tvlogin.getText().toString()), activityLoginBinding.tvlogin.getTextSize(),
                new int[]{ getColor(R.color.gradient1), getColor(R.color.gradient2),},
                new float[]{0, 1}, Shader.TileMode.CLAMP);
        activityLoginBinding.tvlogin.getPaint().setShader(textShader);

        activityLoginBinding.tvregister.setText(Html.fromHtml("<font color=#000000>Don’t have an account? </font>" +
                "<font color=#2E57A7> Click here</font>"));

        activityLoginBinding.tvregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });
        String[] spinnerItems = {"English","Hindi", "Bengali", "Telugu", "Marathi", "Tamil", "Urdu", "Gujarati", "Malayalam", "Kannada", "Odia", "Punjabi", "Assamese", "Maithili", "Sanskrit", "Konkani", "Sindhi", "Dogri", "Manipuri", "Bodo", "Santali", "Kashmiri", "Nepali", "Kurumbo", "Tulu", "Mizo", "Sikkimese"};

        // Create an ArrayAdapter for the spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerItems);

        // Set the adapter to the spinner
        activityLoginBinding.spinner.setAdapter(adapter);
        activityLoginBinding.inputPassword.setVisibility(View.GONE);
        activityLoginBinding.txtPassword.setVisibility(View.GONE);
        activityLoginBinding.inputPassword.setInputType(InputType.TYPE_CLASS_NUMBER);
        activityLoginBinding.inputUsername.setHint("Mobile Number");
        activityLoginBinding.inputPassword.setHint("OTP");
       // activityLoginBinding.inputPassword.setText("123456");
       // activityLoginBinding.inputUsername.setText("pawan");
        activityLoginBinding.radioGroupType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Find the selected RadioButton by ID
                RadioButton selectedRadioButton = findViewById(checkedId);

                // Get the text of the selected RadioButton
                 type = selectedRadioButton.getText().toString();

                 if(type.equalsIgnoreCase("Citizen")){
                     activityLoginBinding.inputPassword.setVisibility(View.GONE);
                     activityLoginBinding.txtPassword.setVisibility(View.GONE);
                     activityLoginBinding.inputPassword.setInputType(InputType.TYPE_CLASS_NUMBER);
                     activityLoginBinding.inputUsername.setHint("Mobile Number");
                     activityLoginBinding.inputPassword.setHint("OTP");
                     activityLoginBinding.txtPassword.setHint("OTP");

                 }else if(type.equalsIgnoreCase("Officer")){
                     activityLoginBinding.inputPassword.setVisibility(View.VISIBLE);
                     activityLoginBinding.txtPassword.setVisibility(View.VISIBLE);
                     activityLoginBinding.inputPassword.setInputType(InputType.TYPE_CLASS_TEXT);
                     activityLoginBinding.inputUsername.setHint("Email Id");
                    activityLoginBinding.txtUsername.setHint("Email Id");
                     activityLoginBinding.inputPassword.setHint("Password");
                     activityLoginBinding.txtPassword.setHint("Password");
                     activityLoginBinding.login.setText("Login");
                 }
            }
        });
        activityLoginBinding.txtPassword.passwordVisibilityToggleRequested(true);
        activityLoginBinding.login.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                 if(InternetConnection.checkConnection(getApplicationContext())) {
                     if(!otpFlag) {
                         if (activityLoginBinding.inputUsername.length() == 0) {
                             SnackbarUtil.showSnackbar(LoginActivity.this, getString(R.string.mobile_error), getColor(R.color.semi_grey), getColor(R.color.white));
                             // Toast.makeText(getApplicationContext(),getString(R.string.username_error),Toast.LENGTH_LONG).show();
                         } else if (activityLoginBinding.inputUsername.length() != 10) {
                             SnackbarUtil.showSnackbar(LoginActivity.this, getString(R.string.mobile_validation_error), getColor(R.color.semi_grey), getColor(R.color.white));
                         } else {
                             SnackbarUtil.showSnackbar(LoginActivity.this, getString(R.string.otp_sent), getColor(R.color.green_300), getColor(R.color.white));

                             otpFlag = true;
                             activityLoginBinding.inputPassword.setVisibility(View.VISIBLE);
                             activityLoginBinding.txtPassword.setVisibility(View.VISIBLE);
                             activityLoginBinding.login.setText("Verify OTP");

                         }
                     }else if(otpFlag){
                         if (activityLoginBinding.inputPassword.length() == 0) {
                             SnackbarUtil.showSnackbar(LoginActivity.this, getString(R.string.otp_error), getColor(R.color.semi_grey), getColor(R.color.white));
                         } else if (activityLoginBinding.inputPassword.length() != 6) {
                             SnackbarUtil.showSnackbar(LoginActivity.this, getString(R.string.otp_validation_error), getColor(R.color.semi_grey), getColor(R.color.white));
                         }else{

                            Login(type,activityLoginBinding.inputUsername.getText().toString(),activityLoginBinding.inputPassword.getText().toString());
                         }

                     }
                }else{
                     Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();
                 }
              }
          });
    }
    public void Login(String type,String userName,String passord){

        LoginRequest loginRequest= new LoginRequest(type,userName,passord);
        Call<LoginModel> response = apiInterface.login(loginRequest);

        response.enqueue(new Callback<LoginModel>()
        {
            @Override
            public void onResponse(Call<LoginModel> call, retrofit2.Response<LoginModel> rawResponse)
            {
                try
                {
                    if(rawResponse.isSuccessful()&&rawResponse.code()==200) {

                        SharePrefrence.saveLogin(LoginActivity.this,"cpgram");
                        SharePrefrence.saveObjectToSharedPreference(LoginActivity.this,"cpgram","userProfile",rawResponse.body().getUser().get(0));
                        Intent i = new Intent(LoginActivity.this, MainActivity.class);
                         startActivity(i);


                    }else{

                    }
                }
                catch (Exception e)
                {

                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable throwable)
            {
                Log.e("jhkbk",""+throwable.getMessage());
                // other stuff...
            }
        });
    }
}