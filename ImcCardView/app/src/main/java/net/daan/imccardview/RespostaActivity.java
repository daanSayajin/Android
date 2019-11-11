package net.daan.imccardview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class RespostaActivity extends AppCompatActivity {

    private TextView lblSituacao;
    private TextView lblImc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resposta);
    }

    @Override
    protected void onResume() {
        super.onResume();

        lblImc = findViewById(R.id.text_view_imc);
        lblSituacao = findViewById(R.id.text_view_situacao);

        DecimalFormat df = new DecimalFormat("#0.00");

        String nome = getIntent().getStringExtra("nome");
        double imc = getIntent().getDoubleExtra("imc", 0);
        String situacao = getIntent().getStringExtra("situacao");

        lblImc.setText(df.format(imc).replace('.', ','));
        lblSituacao.setText(nome + ", " + situacao);
    }
}
