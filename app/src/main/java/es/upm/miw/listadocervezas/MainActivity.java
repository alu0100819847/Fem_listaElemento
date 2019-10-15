package es.upm.miw.listadocervezas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    static final String TAG_MIW = "MiW";

    static final String[] misDatos = {
            "Mahou", "Maestra", "Estrella Galicia",
            "Texto 03", "Texto 04", "Texto 05",
            "Texto 06", "Texto 07", "Texto 08",
            "Texto 09", "Texto 10", "Texto 11",
            "Texto 12", "Texto 13", "Texto 04"
    };

    private ListView lvListado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // asociar recurso a la vista
        lvListado = findViewById(R.id.lvListadoElementos);

        // Crear adaptador a partir de datos
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                misDatos
        );

        lvListado.setAdapter(adaptador);
    }
}
