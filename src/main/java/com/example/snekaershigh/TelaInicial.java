package com.example.snekaershigh;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class TelaInicial extends AppCompatActivity {
    ListView listView; Bundle b = new Bundle();
    TextView nome; String infor;
    int[] img = {R.drawable.tenisadidas, R.drawable.tenismizuno, R.drawable.tenisnike, R.drawable.tenisunder};
    String[] nomes = {"Coreracer Masculino", "Mizuno", "Air Max Infinity 2", "Under Armour Spawn 3"};
    public class Listimg extends BaseAdapter {
        @Override
        public int getCount() {
            return img.length;
        }

        @Override
        public Object getItem(int arg0) {
            return null;
        }

        @Override
        public long getItemId(int arg0) {
            return 0;
        }

        @Override
        public View getView(int arg0, View arg1, ViewGroup arg2) {
            View view = getLayoutInflater().inflate(R.layout.modelo_lista,null);
            ImageView imagem = (ImageView) view.findViewById(R.id.imageView4);
            TextView texto = (TextView) view.findViewById(R.id.textView);

            imagem.setImageResource(img[arg0]);
            texto.setText(nomes[arg0]);
            return view;
        }
    }
    public void video (View v)
    {
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=3jk7KFvjWVI");
        Intent itV = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(itV);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);


        listView = (ListView) findViewById(R.id.listView1);
        Listimg obj = new Listimg();
        listView.setAdapter(obj);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0)
                {
                    b.putInt("valor", 1);
                    Intent v1=new Intent(TelaInicial.this,TelaCompra.class);
                    v1.putExtras(b);
                    startActivity(v1);
                }
                if (position == 1)
                {
                    b.putInt("valor", 2);
                    Intent v1=new Intent(TelaInicial.this,TelaCompra.class);
                    v1.putExtras(b);
                    startActivity(v1);
                }
                if (position == 2)
                {
                    b.putInt("valor", 3);
                    Intent v1=new Intent(TelaInicial.this,TelaCompra.class);
                    v1.putExtras(b);
                    startActivity(v1);
                }
                if (position == 3)
                {
                    b.putInt("valor", 4);
                    Intent v1=new Intent(TelaInicial.this,TelaCompra.class);
                    v1.putExtras(b);
                    startActivity(v1);
                }
            }
        });
    }
}