package com.example.hp.oreo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hp.oreo.R;
import com.example.hp.oreo.modelo.Usuario;

import java.util.ArrayList;

/**
 * Created by HP on 11/09/2017.
 */

public class FuncionarioAdapter extends ArrayAdapter<Usuario> {

    private ArrayList<Usuario> funcionario;
    private Context context;

    public FuncionarioAdapter(Context c, ArrayList<Usuario> objects) {
        super(c, 0, objects);

        this.context = c;
        this.funcionario = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = null;

        if (funcionario != null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.lista_funcionario, parent, false);

            TextView txtViewNome = (TextView) view.findViewById(R.id.txtViewNome);
            TextView txtViewSetor = (TextView) view.findViewById(R.id.txtViewSetor);
            TextView txtViewFuncao = (TextView) view.findViewById(R.id.txtViewFuncao);

            Usuario funcionario2 = funcionario.get(position);
            txtViewNome.setText(funcionario2.getNome().toString());
            txtViewSetor.setText(funcionario2.getSetor().toString());
            txtViewFuncao.setText(funcionario2.getFuncao().toString());

        }

        return view;
    }
}


