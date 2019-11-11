package net.daan.imccardview;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnCalcular;
    private TextInputLayout txtlPeso;
    private TextInputLayout txtlAltura;
    private EditText txtNome;
    private EditText txtPeso;
    private EditText txtAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnCalcular = findViewById(R.id.button_calcular);
        txtNome = findViewById(R.id.edit_text_nome);
        txtlPeso = findViewById(R.id.text_input_layout_peso);
        txtPeso = findViewById(R.id.edit_text_peso);
        txtlAltura = findViewById(R.id.text_input_layout_altura);
        txtAltura = findViewById(R.id.edit_text_altura);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (txtPeso.getText().toString().trim().isEmpty()) {
                    txtlPeso.setErrorEnabled(true);
                    txtlPeso.setError("Peso é obrigatório!");
                } else
                    txtlPeso.setErrorEnabled(false);

                if (txtAltura.getText().toString().trim().isEmpty()) {
                    txtlAltura.setErrorEnabled(true);
                    txtlAltura.setError("Altura é obrigatório!");
                } else
                    txtlAltura.setErrorEnabled(false);

                if (!isNumeric(txtPeso.getText().toString().trim()) && !txtPeso.getText().toString().trim().isEmpty()) {

                    txtlPeso.setErrorEnabled(true);
                    txtlPeso.setError("Só é permitida entrada de números!");

                } else if (!txtPeso.getText().toString().trim().isEmpty())
                    txtlPeso.setErrorEnabled(false);

                if (!isNumeric(txtAltura.getText().toString().trim()) && !txtAltura.getText().toString().trim().isEmpty()) {

                    txtlAltura.setErrorEnabled(true);
                    txtlAltura.setError("Só é permitida entrada de números!");

                } else if (!txtAltura.getText().toString().trim().isEmpty())
                    txtlAltura.setErrorEnabled(false);

                if (!txtPeso.getText().toString().trim().isEmpty()
                        && !txtAltura.getText().toString().trim().isEmpty()
                        && isNumeric(txtPeso.getText().toString().trim())
                        && isNumeric(txtAltura.getText().toString().trim())) {

                    String nome = txtNome.getText().toString();
                    double peso = Double.parseDouble(txtPeso.getText().toString().trim().replace(',', '.'));
                    double altura = Double.parseDouble(txtAltura.getText().toString().trim().replace(',', '.'));

                    double imc = peso / (altura * altura);
                    String situacao = "";

                    if (imc >= 40)
                        situacao = "você está com obesidade de terceiro grau";
                    else if (imc >= 35)
                        situacao = "você está com obesidade de segundo grau";
                    else if (imc >= 30)
                        situacao = "você está com obesidade de primeiro grau";
                    else if (imc >= 25)
                        situacao = "você está acima do seu peso ideal";
                    else if (imc >= 18.5)
                        situacao = "parabéns! Você está em seu peso ideal";
                    else if (imc >= 17)
                        situacao = "você está abaixo do seu peso ideal";
                    else
                        situacao = "você está muito abaixo do seu peso ideal";

                    Intent showRespostaActivity = new Intent(MainActivity.this, RespostaActivity.class);

                    showRespostaActivity.putExtra("nome", nome);
                    showRespostaActivity.putExtra("imc", imc);
                    showRespostaActivity.putExtra("situacao", situacao);

                    startActivity(showRespostaActivity);
                }
            }
        });
    }

    protected boolean isNumeric(String txt) {
        try {
            double test = Double.parseDouble(txt);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }
}
