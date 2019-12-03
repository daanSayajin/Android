package net.daan.testingapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import net.daan.testingapplication.models.Repo;
import net.daan.testingapplication.models.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    private AppCompatImageView imgLocation;
    private RecyclerView rcvRepos;
    private ReposRecyclerAdapter adapterRepos;
    private List<Repo> listRepos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        final String username = getIntent().getStringExtra("username");

        imgUser = findViewById(R.id.img_user);
        lblUsername = findViewById(R.id.lbl_username);
        lblName = findViewById(R.id.lbl_name);
        lblLocation = findViewById(R.id.lbl_location);
        imgLocation = findViewById(R.id.img_location);
        rcvRepos = findViewById(R.id.rcv_repos);

        rcvRepos.setLayoutManager(new LinearLayoutManager(this));
        adapterRepos = new ReposRecyclerAdapter(listRepos);
        rcvRepos.setAdapter(adapterRepos);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final GitHubService service = retrofit.create(GitHubService.class);

        Call<User> user = service.getUser(username);
        user.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();

                new DownloadImageTask(imgUser).execute(user.getAvatarUrl());
                lblUsername.setText(user.getName());
                lblName.setText(user.getLogin());

                if (user.getLocation() != null) {
                    lblLocation.setText(user.getLocation());
                    imgLocation.getLayoutParams().height = (int) (20 * getResources().getDisplayMetrics().density);
                }

                Call<List<Repo>> repos = service.listRepos(username);
                repos.enqueue(new Callback<List<Repo>>() {
                    @Override
                    public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                        listRepos.clear();
                        listRepos.addAll(response.body());
                        adapterRepos.notifyDataSetChanged();

                        findViewById(R.id.loading_panel).setVisibility(View.GONE);
                    }

                    @Override
                    public void onFailure(Call<List<Repo>> call, Throwable t) {
                        Log.e("error", t.toString());
                    }
                });
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("error", t.toString());
            }
        });
    }
}
