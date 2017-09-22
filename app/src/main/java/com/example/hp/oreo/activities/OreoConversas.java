package com.example.hp.oreo.activities;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.hp.oreo.R;
import com.google.firebase.auth.FirebaseAuth;

public class OreoConversas extends AppCompatActivity {

    private FirebaseAuth usuarioFirebase;
    private Button btnSair;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oreo_conversas);

       // btnSair = (Button) findViewById(R.id.btnSair);
       // btnSair.setOnClickListener(new View.OnClickListener() {
       //     @Override
       //     public void onClick(View view) {
       //         deslogarUsuario();
       //     }
      //  });



         FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(OreoConversas.this, OreoContatos.class);
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuItem sobre = menu.add("Sobre");
        MenuItem sair = menu.add("Sair");

      return true;
    }

    private void deslogarUsuario() {
        usuarioFirebase.signOut();
        Intent intent = new Intent(OreoConversas.this, OreoLogin.class);
        startActivity(intent);
        finish();
    }

   // private void setSearchTextColour(SearchView searchView) {
      //  EditText searchPlate = (EditText) searchView.findViewById(R.id.search_src_text);
      //  searchPlate.setTextColor();
     //   searchPlate.setTextColor(getActivity().getResources().getColor(R.color.corBranca));
   // }

}
