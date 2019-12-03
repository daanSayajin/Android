package net.daan.testingapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

public class ReposViewHolder extends RecyclerView.ViewHolder {

    private AppCompatTextView lblTitle;
    private AppCompatTextView lblDescription;
    private AppCompatImageView imgLanguage;
    private AppCompatTextView lblLanguage;
    private AppCompatTextView lblStars;
    private AppCompatTextView lblForks;
    public AppCompatButton btnCode;

    public ReposViewHolder(View itemView) {
        super(itemView);

        lblTitle = itemView.findViewById(R.id.lbl_title);
        lblDescription = itemView.findViewById(R.id.lbl_description);
        imgLanguage = itemView.findViewById(R.id.img_language);
        lblLanguage = itemView.findViewById(R.id.lbl_language);
        lblStars = itemView.findViewById(R.id.lbl_stars);
        lblForks = itemView.findViewById(R.id.lbl_forks);
        btnCode = itemView.findViewById(R.id.btn_code);
    }

    public void setLblTitle(String lblTitle) {
        this.lblTitle.setText(lblTitle);
    }

    public void setLblDescription(String lblDescription) {
        this.lblDescription.setText(lblDescription);
        this.lblDescription.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setImgLanguage(String language) {
        if (language == null) {
            this.imgLanguage.setBackgroundTintList(itemView.getResources().getColorStateList(R.color.defaultLanguage));
            return;
        }

        switch (language) {
            case "C++":
                this.imgLanguage.setBackgroundTintList(itemView.getResources().getColorStateList(R.color.cpp));
                break;

            case "JavaScript":
                this.imgLanguage.setBackgroundTintList(itemView.getResources().getColorStateList(R.color.js));
                break;

            case "PHP":
                this.imgLanguage.setBackgroundTintList(itemView.getResources().getColorStateList(R.color.php));
                break;

            case "CSS":
                this.imgLanguage.setBackgroundTintList(itemView.getResources().getColorStateList(R.color.css));
                break;

            case "Shell":
                this.imgLanguage.setBackgroundTintList(itemView.getResources().getColorStateList(R.color.shell));
                break;

            case "HTML":
                this.imgLanguage.setBackgroundTintList(itemView.getResources().getColorStateList(R.color.html));
                break;

            case "C#":
                this.imgLanguage.setBackgroundTintList(itemView.getResources().getColorStateList(R.color.csharp));
                break;

            case "Java":
                this.imgLanguage.setBackgroundTintList(itemView.getResources().getColorStateList(R.color.java));
                break;

            case "Python":
                this.imgLanguage.setBackgroundTintList(itemView.getResources().getColorStateList(R.color.python));
                break;

            default:
                this.imgLanguage.setBackgroundTintList(itemView.getResources().getColorStateList(R.color.defaultLanguage));
        }
    }

    public void setLblLanguage(String lblLanguage) {
        this.lblLanguage.setText(lblLanguage);
    }

    public void setLblStars(String lblStars) {
        this.lblStars.setText(lblStars);
    }

    public void setLblForks(String lblForks) {
        this.lblForks.setText(lblForks);
    }
}
