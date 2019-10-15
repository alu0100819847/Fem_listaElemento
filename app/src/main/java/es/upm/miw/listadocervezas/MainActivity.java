package es.upm.miw.listadocervezas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    static final String TAG_MIW = "MiW";

    private String[] misDatos;
    private ListView lvListado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // obtener Datos
        misDatos = getResources().getStringArray(R.array.datos);

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
