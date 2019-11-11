package net.daan.bottomnavigationview;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        Fragment fragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }

    /* Detecta o click do bottomNavigationView */
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragment = null;

            switch (item.getItemId()) {
                case R.id.nav_home:
                    fragment = new HomeFragment(); break;

                case R.id.nav_favorito:
                    fragment = new FavoritoFragment(); break;

                case R.id.nav_busca:
                    fragment = new BuscarFragment(); break;
            }

            /* Obtém o gerenciador de fragmentos da activity e através dela inserir o fragmento no frameLayout, que é nosso container */
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();

            return true;
        }
    };
}
