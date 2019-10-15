package es.upm.miw.listadocervezas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
        LinearLayout vista;

        if (null != convertView) {
            vista = (LinearLayout) convertView;
        } else {
            LayoutInflater inflador = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = (LinearLayout) inflador.inflate(idLayout, parent, false);
        }

        // Asignar contenido a los elementos de la vista
        TextView tvLinea1 = vista.findViewById(R.id.tvItemLinea1);
        TextView tvLinea2 = vista.findViewById(R.id.tvItemLinea2);
        ImageView imgItem = vista.findViewById(R.id.imgItem);

        tvLinea1.setText(contexto.getString(R.string.txtPosicion) + position);
        tvLinea2.setText(misDatos[position]);
        imgItem.setImageResource(
                (position % 2 == 0)
                    ? R.mipmap.miw_launcher
                    : R.mipmap.miw_launcher_rounded
        );

        return vista;
    }
}
