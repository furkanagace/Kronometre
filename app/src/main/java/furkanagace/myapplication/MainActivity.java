package furkanagace.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Chronometer kronometre;
    private Button startBtn, pauseBtn, resetBtn;


    private long pauseOffset;
    private View Ilerı;


    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kronometre = findViewById(R.id.kronometre);
        startBtn = findViewById(R.id.startBtn);
        pauseBtn = findViewById(R.id.pauseBtn);
        resetBtn = findViewById(R.id.resetBtn);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startBtn.setVisibility(View.INVISIBLE);
                pauseBtn.setVisibility(View.VISIBLE);
                kronometre.setBase(SystemClock.elapsedRealtime() - pauseOffset);
                kronometre.start();
                ImageView imageView = findViewById(R.id.imageView);
                imageView.setImageResource(R.drawable.pause);





            }
        });


        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startBtn.setVisibility(View.VISIBLE);
                pauseBtn.setVisibility(View.INVISIBLE);
                kronometre.stop();
                pauseOffset = SystemClock.elapsedRealtime() - kronometre.getBase();
                ImageView imageView = findViewById(R.id.imageView);
                imageView.setImageResource(R.drawable.start);


            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startBtn.setVisibility(View.VISIBLE);
                pauseBtn.setVisibility(View.INVISIBLE);
                kronometre.setBase(SystemClock.elapsedRealtime());
                kronometre.stop();
                pauseOffset = 0;
                ImageView imageView = findViewById(R.id.imageView);
                imageView.setImageResource(R.drawable.start);
            }
        });


    }
}