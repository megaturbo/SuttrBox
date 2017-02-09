package ch.foufouillons.suttrbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private GiggleAdapter giggleAdapter;

    private ArrayList<Giggle> giggles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        giggles = getGiggles();

        giggleAdapter = new GiggleAdapter(giggles, this);
        recyclerView.setAdapter(giggleAdapter);
    }

    public ArrayList<Giggle> getGiggles() {
        ArrayList<Giggle> list = new ArrayList<>();

        //TODO smarter
        list.add(new Giggle("Flageolets", "flageolets"));
        list.add(new Giggle("Soupe d'ours", "bearsoup"));

        return list;
    }
}
