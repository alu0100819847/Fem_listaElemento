package es.upm.miw.listadocervezas;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.widget.TextView;

import java.util.Locale;

public class DetalleItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_item);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Recupero los recursos asociado en la vista
        TextView tvPosicion = findViewById(R.id.tvMostrarPosicion);
        TextView tvItem = findViewById(R.id.tvMostrarÍtem);

        // Recupero del Intent el bundle con los datos
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            int idRecibido        = bundle.getInt(MainActivity.CLAVE_POSICION);
            String opcionRecibida = bundle.getString(MainActivity.CLAVE_ITEM);

            // Asignar datos en la vista
            tvPosicion.setText(String.format(Locale.getDefault(), "%2d", idRecibido));
            tvItem.setText(opcionRecibida);
        }

    }

}
