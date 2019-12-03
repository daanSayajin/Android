package net.daan.testingapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.daan.testingapplication.models.Repo;

import java.util.List;

public class ReposRecyclerAdapter extends RecyclerView.Adapter<ReposViewHolder> {

    private List<Repo> list;

    public ReposRecyclerAdapter(List<Repo> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ReposViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.repos, parent, false);
        return new ReposViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull final ReposViewHolder holder, int position) {
        final Repo repo = list.get(position);

        holder.setLblTitle(repo.getName());

        if (repo.getDescription() != null)
            holder.setLblDescription(repo.getDescription());

        holder.setImgLanguage(repo.getLanguage());

        if (repo.getLanguage() != null)
            holder.setLblLanguage(repo.getLanguage());

        holder.setLblStars(Integer.toString(repo.getStargazersCount()));
        holder.setLblForks(Integer.toString(repo.getForks()));

        holder.btnCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(repo.getHtmlUrl()));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
