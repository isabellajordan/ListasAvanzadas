package com.example.estudiante.listasavanzadas;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

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
    public View getView(int position, View view, ViewGroup viewGroup) {

        //Transformar un XML (txt) en una vista (view) para poder retornar
        LayoutInflater inflater = activity.getLayoutInflater();

        //ponemos lo que va en el renglón manualmente
        //view independiente de la lista, que no quede linkeada a ningún vista padre
        View renglon= inflater.inflate(R.layout.renglon,null,false);

        //poner los ítems
        TextView item_titulo = renglon.findViewById(R.id.item_titulo);
        TextView item_fecha = renglon.findViewById(R.id.item_fecha);
        TextView item_descripcion = renglon.findViewById(R.id.item_descripcion);

        //ubicarlos en la posición
        item_titulo.setText(noticias.get(position).getTitulo());
        item_fecha.setText(noticias.get(position).getFecha());
        item_descripcion.setText(noticias.get(position).getDescripcion());


        return renglon;
    }

    //metodo para agregar una noticia
    public void agregarNoticia (Noticia noticia){
        noticias.add(noticia);
        //actualizar la lista
        notifyDataSetChanged();


    }


}
