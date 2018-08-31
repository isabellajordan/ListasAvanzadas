package com.example.estudiante.listasavanzadas;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NoticiaAdapter extends BaseAdapter{

    //arreglo de noticias
    ArrayList <Noticia> noticias;
    //permite utilizar la activity en este contexto
    Activity activity;

    public NoticiaAdapter(Activity activity){
        this.activity= activity;
        noticias= new ArrayList<>();


    }




    @Override
    //número de elementos
    public int getCount() {

        return noticias.size();
    }

    @Override
    public Object getItem(int i) {
        return noticias.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    //generar un renglón por objeto
    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {

        //Transformar un XML (txt) en una vista (view) para poder retornar
        LayoutInflater inflater = activity.getLayoutInflater();

        //ponemos lo que va en el renglón manualmente
        //view independiente de la lista, que no quede linkeada a ningún vista padre
        View renglon= inflater.inflate(R.layout.renglon,null,false);

        //poner los ítems
        TextView item_titulo = renglon.findViewById(R.id.item_titulo);
        TextView item_fecha = renglon.findViewById(R.id.item_fecha);
        TextView item_descripcion = renglon.findViewById(R.id.item_descripcion);

        //botón por cada ítem
        Button item_action= renglon.findViewById(R.id.item_action);

        //ubicarlos en la posición
        item_titulo.setText(noticias.get(position).getTitulo());
        item_fecha.setText(noticias.get(position).getFecha());
        item_descripcion.setText(noticias.get(position).getDescripcion());

        //agregar acción para botón para todos los renglones
item_action.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        //conocer la posición de cada uno de los ítem
        Toast.makeText(activity, "POS"+ position, Toast.LENGTH_SHORT).show();

        //Eliminar algun ítem de la lista!!
        noticias.remove(position);
        notifyDataSetChanged();

        //Ir a otra actividad en este contexto "activity"
        // contexto y a dónde se quiere ir
        Intent intent= new Intent(activity,NoticiaView.class);
        activity.startActivity(intent);

        //Si lo hiciéramos en el main
        //Intent i= new Intent(MainActivity.this,NoticiaView.class);
        //starActivity(i);



    }
});

        return renglon;
    }

    //metodo para agregar una noticia
    public void agregarNoticia (Noticia noticia){
        noticias.add(noticia);
        //actualizar la lista
        notifyDataSetChanged();


    }


}
