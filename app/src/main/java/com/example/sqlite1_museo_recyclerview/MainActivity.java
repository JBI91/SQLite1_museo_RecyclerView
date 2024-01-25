package com.example.sqlite1_museo_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*for (Pintura p : registros) {
            Log.d("PMDM", p.toString());
        }*/

        List<Pintura> registros = getFullList();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PinturaAdapter adapter = new PinturaAdapter(registros);
        recyclerView.setAdapter(adapter);
    }

    public List<Pintura> getFullList() {
        List<Pintura> listado = new ArrayList<>();
        // Abrimos la base de datos en modo lectura
        SQLiteDatabase db = new DB_SQLite(this).getReadableDatabase();
        // Realizamos una FullQuery sobre la tabla pintura
        Cursor cursor = db.rawQuery("SELECT * FROM pintura", null);

        if (cursor.getCount() == 0) {
            Log.e("PMDM", "La base de datos está vacía.");
        } else {
            cursor.moveToFirst();
            do {  // Recorremos el conjunto de registros recibidos en el cursor
                long dataId = cursor.getLong(cursor.getColumnIndexOrThrow("id"));
                String dataTitulo = cursor.getString(cursor.getColumnIndexOrThrow("titulo"));
                String dataAutor = cursor.getString(cursor.getColumnIndexOrThrow("autor"));
                int dataAnio = cursor.getInt(cursor.getColumnIndexOrThrow("anio"));
                Pintura p = new Pintura(dataId, dataTitulo, dataAutor, dataAnio);
                listado.add(p); // almacenamos en el List cada pintura recuperada
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return listado;
    }
}