package net.daan.secondactivityproject;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder {

    private ImageView imgArticle;
    private TextView lblTitle;
    private TextView lblDescription;
    public Button btnRead;

    public ViewHolder(View itemView) {
        super(itemView);

        imgArticle = itemView.findViewById(R.id.img_article);
        lblTitle = itemView.findViewById(R.id.lbl_title);
        lblDescription = itemView.findViewById(R.id.lbl_description);
        btnRead = itemView.findViewById(R.id.btn_read);
    }

    public ImageView getImgArticle() {
        return this.imgArticle;
    }

    public void setLblTitle(String lblTitle) {
        this.lblTitle.setText(lblTitle);
    }

    public void setLblDescription(String lblDescription) {
        this.lblDescription.setText(lblDescription);
    }
}
