package com.example.exercicescours9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.exercicescours9.http.RetrofitUtil;
import com.example.exercicescours9.http.Service;
import com.example.exercicescours9.transfer.objComplexe;

import org.w3c.dom.Element;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
Adapter adapteur;
enum ValueType  {String, Long, ObjComplexe};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView1 = findViewById(R.id.rcv1);
        RecyclerView recyclerView2 = findViewById(R.id.rcv2);




        this.remplirRecycler(recyclerView1, "long", ValueType.Long);
        //this.remplirRecycler(recyclerView2, "truc", ValueType.ObjComplexe);
    }

    private void remplirRecycler(RecyclerView recyclerView, String id, ValueType valueType) {
        //Remplir Recycler
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        adapteur = new Adapter(valueType);
        recyclerView.setAdapter(adapteur);


        final Service service = RetrofitUtil.get();
        if(valueType == ValueType.Long)
        {
            // appeler un service de liste et afficher dans le log
            service.listLong(id).enqueue(new Callback<List<Long>>() {
                @Override
                public void onResponse(Call<List<Long>> call, Response<List<Long>> response) {
                    if (response.isSuccessful()) {
                        // http 200 http tout s'est bien passé
                        List<Long> resultat = response.body();
                        for (int index = 0; index < response.body().size();index++)
                        {
                            adapteur.list.add(response.body().get(index));
                        }
                        adapteur.notifyDataSetChanged();
                        Log.i("RETROFIT", resultat.size()+"");

                    } else {
                        // cas d'erreur http 400 404
                        Log.i("RETROFIT", response.code()+"");
                    }
                }

                @Override
                public void onFailure(Call<List<Long>> call, Throwable t) {
                    // erreur accès réseau ou alors GSON
                    Log.i("RETROFIT", t.getMessage());
                }
            });
        } else if (valueType == ValueType.ObjComplexe) {
            // appeler un service de liste et afficher dans le log
            service.listObj(id).enqueue(new Callback<List<objComplexe>>() {
                @Override
                public void onResponse(Call<List<objComplexe>> call, Response<List<objComplexe>> response) {
                    if (response.isSuccessful()) {
                        // http 200 http tout s'est bien passé
                        List<objComplexe> resultat = response.body();
                        for (int index = 0; index < response.body().size();index++)
                        {
                            objComplexe objtest = new objComplexe();
                            objtest.a = response.body().get(index).a;
                            objtest.b = response.body().get(index).b;
                            objtest.c = response.body().get(index).c;
                            adapteur.list.add(objtest);
                        }
                        adapteur.notifyDataSetChanged();
                        Log.i("RETROFIT", resultat.size()+"");

                    } else {
                        // cas d'erreur http 400 404
                        Log.i("RETROFIT", response.code()+"");
                    }
                }

                @Override
                public void onFailure(Call<List<objComplexe>> call, Throwable t) {
                    // erreur accès réseau ou alors GSON
                    Log.i("RETROFIT", t.getMessage());
                }
            });
        }
    }


}