package es.upm.miw.listadocervezas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MiAdaptador extends ArrayAdapter {

    private Context contexto;
    private int idLayout;
    private String[] misDatos;

    /**
     * Constructor. This constructor will result in the underlying data collection being
     * immutable, so methods such as {@link #clear()} will throw an exception.
     *
     * @param context  The current context.
     * @param resource The resource ID for a layout file containing a TextView to use when
     *                 instantiating views.
     * @param data     The objects to represent in the ListView.
     */
    public MiAdaptador(@NonNull Context context, int resource, @NonNull String[] data) {
        super(context, resource, data);
        contexto = context;
        idLayout = resource;
        misDatos = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView vista;

        if (null != convertView) {
            vista = (TextView) convertView;
        } else {
            LayoutInflater inflador = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = (TextView) inflador.inflate(idLayout, parent, false);
        }

        vista.setText(misDatos[position]);

        return vista;
    }
}
