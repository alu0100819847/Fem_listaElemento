package es.upm.miw.listadocervezas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    static final String TAG_MIW = "MiW";

    static final String CLAVE_POSICION = "CLAVE_POSICION";
    static final String CLAVE_ITEM = "CLAVE_ITEM";

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
        MiAdaptador miAdaptador = new MiAdaptador(this, R.layout.item_lista, misDatos);

        lvListado.setAdapter(miAdaptador);
        lvListado.setOnItemClickListener(this);
    }

    /**
     * Callback method to be invoked when an item in this AdapterView has
     * been clicked.
     * <p>
     * Implementers can call getItemAtPosition(position) if they need
     * to access the data associated with the selected item.
     *
     * @param parent   The AdapterView where the click happened.
     * @param view     The view within the AdapterView that was clicked (this
     *                 will be a view provided by the adapter)
     * @param position The position of the view in the adapter.
     * @param id       The row id of the item that was clicked.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String texto = "Opción elegida (posicion=" + position + ", id=" + id + "): " + misDatos[position];

        Log.i(TAG_MIW, texto);

        Bundle bundle = new Bundle();
        bundle.putInt(CLAVE_POSICION, position);
        bundle.putString(CLAVE_ITEM, misDatos[position]);

        Intent intent = new Intent(getApplicationContext(), DetalleItem.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
