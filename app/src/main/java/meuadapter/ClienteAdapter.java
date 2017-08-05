package meuadapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.soseletronica.maurolcsilva.soseletronica.R;

import java.util.ArrayList;

import modelo.Cliente;

/**
 * Created by maurolcsilva on 22/06/2017.
 */

public class ClienteAdapter extends BaseAdapter {

    private Activity act;
    private ArrayList<Cliente> listadeclientes;

    public ClienteAdapter(Activity actparam, ArrayList<Cliente> listaparam){
        this.act = actparam;
        this.listadeclientes = listaparam;
    }

    @Override
    public int getCount() {
        return listadeclientes.size();
    }

    @Override
    public Object getItem(int position) {
        return listadeclientes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listadeclientes.get(position).getIdclientes();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View linha = act.getLayoutInflater().inflate(R.layout.listadeclientes_layout,parent,false);
        TextView nomecliente = (TextView) linha.findViewById(R.id.lblListaNomeCliente);
        //TextView emailcliente = (TextView) linha.findViewById(R.id.lblListaEmailCliente);

        Cliente c = listadeclientes.get(position);
        nomecliente.setText(c.getNome());
        //emailcliente.setText(c.getEmail());
        return linha;
    }
}
