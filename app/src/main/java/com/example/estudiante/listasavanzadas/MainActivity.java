package com.example.estudiante.listasavanzadas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private ListView lv_noticias;
    //clase noticiaAdapter que tiene un customAdapter
    NoticiaAdapter customAdapter;
    EditText et_titulo;
    Button btn_generar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_noticias= findViewById(R.id.lv_noticias);
        et_titulo= findViewById(R.id.et_titulo);
        btn_generar=findViewById(R.id.btn_generar);

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

        //agregar noticia
        btn_generar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //adquirir el título
                String titulo=et_titulo.getText().toString();

                //traer la fecha actual
                Calendar c= Calendar.getInstance();

                //sacar los números de fecha
                int year= c.get(Calendar.YEAR);
                int month= c.get(Calendar.MONTH);
                month++;
                int day= c.get(Calendar.DAY_OF_MONTH);

                String fecha= day+"/"+month+"/"+year+"/";


                //generar objeto de noticia
                Noticia newNoticia= new Noticia(titulo,"NO DESCRIPTION", fecha);
                customAdapter.agregarNoticia(newNoticia);





            }
        });

    }
}
