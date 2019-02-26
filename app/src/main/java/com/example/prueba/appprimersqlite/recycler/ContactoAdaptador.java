package com.example.prueba.appprimersqlite.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.prueba.appprimersqlite.R;
import com.example.prueba.appprimersqlite.model.Contacto;

import java.util.ArrayList;

public class ContactoAdaptador
        extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder> {

    private ArrayList<Contacto> lista;

    public ContactoAdaptador(ArrayList<Contacto> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.contacto_item, viewGroup, false);

        ContactoViewHolder cvh = new ContactoViewHolder(v);

        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder contactoViewHolder, int i) {
        contactoViewHolder.bindContacto(lista.get(i));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNombre;
        private TextView tvEmail;

        public ContactoViewHolder(View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvEmail = itemView.findViewById(R.id.tvEmail);
        }

        public void bindContacto(Contacto co) {
            tvNombre.setText(co.getName());
            tvEmail.setText(co.getEmail());
        }
    }

}
