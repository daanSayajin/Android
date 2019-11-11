package net.daan.toolbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
            O "setSupportActionBar" diz para o Java que a toolbar que está sendo importada
            é a toolbar da activity, assim, o Java irá reconhece-la.
        */
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    /*
        Durante a criação da activity o menu é criado. Dessa forma, sobreescrevemos o
        método "onCreateOptionsMenu" para atribuir o nosso menu manualmente a toolbar.
    */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /*
            Substitui o menu padrão (que não existe) pelo menu criado por nós.
        */
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_buscar:
                Toast.makeText(this, "Buscar...", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu_carrinho:
                Toast.makeText(this, "Carrinho...", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu_configuracoes:
                Toast.makeText(this, "Configurações...", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu_sobre:
                Toast.makeText(this, "Sobre...", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
