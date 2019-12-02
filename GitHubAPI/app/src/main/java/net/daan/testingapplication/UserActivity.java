package net.daan.testingapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserActivity extends AppCompatActivity {

    private AppCompatImageView imgUser;
    private AppCompatTextView lblUsername;
    private AppCompatTextView lblName;
    private AppCompatTextView lblLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        imgUser = findViewById(R.id.img_user);
        lblUsername = findViewById(R.id.lbl_username);
        lblName = findViewById(R.id.lbl_name);
        lblLocation = findViewById(R.id.lbl_location);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);

        Call<User> call = service.getUser(getIntent().getStringExtra("username"));
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();

                new DownloadImageTask(imgUser).execute(user.getAvatarUrl());
                lblUsername.setText(user.getName());
                lblName.setText(user.getLogin());
                lblLocation.setText(user.getLocation());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("error", t.toString());
            }
        });
    }
}
