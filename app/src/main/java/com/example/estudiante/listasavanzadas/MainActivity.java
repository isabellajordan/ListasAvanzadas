package com.example.estudiante.listasavanzadas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView lv_noticias;
    //clase noticiaAdapter que tiene un customAdapter
    NoticiaAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_noticias= findViewById(R.id.lv_noticias);

        //crear adaptador para personalizar las listas
        customAdapter= new NoticiaAdapter(this);
        lv_noticias.setAdapter(customAdapter);


        //agregar noticias
        Noticia noticia1= new Noticia("Hoy es diseño","Va a haber un cambio en el logo de Hoy es Diseño","30/08/18");

        Noticia noticia2= new Noticia("Título","Hola","30/08/18");


        customAdapter.agregarNoticia(noticia1);
        customAdapter.agregarNoticia(noticia2);

        //agregarle acción de click (de manera sencilla para item sencillo)

        //OJO SI SE COLOCA UN BOTÓN SE DESHABILITA LA ACCIÓN DE SET ON ITEM CLICK...
        lv_noticias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                //se castea porque getItem devuelve object y hay que ponerle Noticia
                Noticia noticia_click = (Noticia) customAdapter.getItem(position);
                Toast.makeText(MainActivity.this, noticia_click.getTitulo(), Toast.LENGTH_SHORT ).show();

            }
        });

    }
}
