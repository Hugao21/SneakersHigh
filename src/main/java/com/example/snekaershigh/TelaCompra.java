package com.example.snekaershigh;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class TelaCompra extends AppCompatActivity {
    ImageSwitcher sw;
    ImageView img;
    int i = 1;
    TextView titulo, preco;
    Button botao, btnsw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_compra);
        img = (ImageView) findViewById(R.id.imageView1);
        titulo = (TextView) findViewById(R.id.textView1);

        final Vibrator vibra = (Vibrator) TelaCompra.this.getSystemService(Context.VIBRATOR_SERVICE);

        preco = (TextView) findViewById(R.id.textView3);
        botao = (Button) findViewById(R.id.button1);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("SnH", "SnH", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        sw = (ImageSwitcher) findViewById(R.id.imageSwitcher1);
        btnsw = (Button) findViewById(R.id.buttonsw);

        Bundle b = getIntent().getExtras();
        int valor = b.getInt("valor");
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                vibra.vibrate(300);

                NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                PendingIntent pI = PendingIntent.getActivity(TelaCompra.this, 0,
                        new Intent(TelaCompra.this, TelaInicial.class),0);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(TelaCompra.this, "SnH");
                builder.setSmallIcon(R.drawable.logo);
                builder.setTicker("Compra Realizada Sneakers High");
                builder.setContentTitle("Compra de Tênis efetuada!");
                builder.setContentText("Seu tênis já está sendo enviado!");
                builder.setContentIntent(pI);
                builder.setAutoCancel(true);
                NotificationManagerCompat mC = NotificationManagerCompat.from(TelaCompra.this);
                mC.notify(1, builder.build());
                finish();


                Uri notS = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                Ringtone toque = RingtoneManager.getRingtone(TelaCompra.this, notS);
                toque.play();


            }
        });

        switch (valor) {
            case 1:
                titulo.setText(R.string.adidas);
                img.setImageResource(R.drawable.tenisadidas);
                preco.setText(R.string.v_adidas);
                break;
            case 2:
                titulo.setText(R.string.mizuno);
                img.setImageResource(R.drawable.tenismizuno);
                preco.setText(R.string.v_mizuno);
                break;
            case 3:
                titulo.setText(R.string.nike);
                img.setImageResource(R.drawable.tenisnike);
                preco.setText(R.string.v_nike);
                break;
            case 4:
                titulo.setText(R.string.under);
                img.setImageResource(R.drawable.tenisunder);
                preco.setText(R.string.v_under);
            default:
                break;
        }
        sw.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView myView = new ImageView(getApplicationContext());
                myView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return myView;
            }
        });
        sw.setImageResource(R.drawable.pix);
        btnsw.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (i) {
                    case 1:
                        i++;
                        sw.setImageResource(R.drawable.boleto);
                        break;
                    case 2:
                        i++;
                        sw.setImageResource(R.drawable.cartao);
                        break;
                    default:
                        sw.setImageResource(R.drawable.pix);
                        i = 1;
                        break;
                }
            }
        });
    }
}