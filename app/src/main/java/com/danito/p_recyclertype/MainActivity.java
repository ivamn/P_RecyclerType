package com.danito.p_recyclertype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener, View.OnClickListener {

    public static final int TYPE_ITEM_1 = 1;
    public static final int TYPE_ITEM_2 = 2;
    public static final int TYPE_ITEM_3 = 3;

    public ArrayList<Dato> datos;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cargarDatos();
        recyclerView = findViewById(R.id.lista);
        Adaptador adaptador = new Adaptador(this);
        adaptador.setClickListener(this);
        adaptador.setLongClickListener(this);
        adaptador.setImageClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Has pulsado el elemento interno de la CardView", Toast.LENGTH_LONG).show();
            }
        });
        recyclerView.setAdapter(adaptador);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }

    private void cargarDatos() {
        datos = new ArrayList<>();
        datos.add(new Dato("Cohete espacial", "Soy un cohete espacial que viajo por el espacio interestela", BitmapFactory.decodeResource(this.getResources(), R.drawable.cohete_flat), TYPE_ITEM_1));
        datos.add(new Dato("Coordillera de noche", "No hay nada como una noche plácida en la montaña, ¿verdad?", BitmapFactory.decodeResource(this.getResources(), R.drawable.material_flat), TYPE_ITEM_2));
        datos.add(new Dato("London city", "No hay nada como pasear por la orilla del Támesis en una mañana con niebla", BitmapFactory.decodeResource(this.getResources(), R.drawable.london_flat), TYPE_ITEM_3));
        datos.add(new Dato("Discovery en la noche", "Viajar al epacio, recorrer la vía láctea, y volver a casa con mi Discovery...", BitmapFactory.decodeResource(this.getResources(), R.drawable.moon_flat), TYPE_ITEM_3));
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Pulsación corta sobre " +
                datos.get(recyclerView.getChildAdapterPosition(v)).getTextoCorto(), Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onLongClick(View v) {
        Toast.makeText(this, "Pulsación larga sobre " +
                datos.get(recyclerView.getChildAdapterPosition(v)).getTextoCorto(), Toast.LENGTH_LONG).show();
        return false;
    }
}
