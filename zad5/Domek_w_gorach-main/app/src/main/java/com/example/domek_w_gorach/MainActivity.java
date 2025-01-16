package com.example.domek_w_gorach;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int licznik = 0;
    TextView like_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        like_text = findViewById(R.id.like_text);
        Button likeB = findViewById(R.id.likeB);
        Button dislikeB = findViewById(R.id.dislikeB);


        likeB.setOnClickListener(v -> {
            licznik++;
            like_wyswietlanie();
        });


        dislikeB.setOnClickListener(v -> {
            if (licznik > 0) {
                licznik--;
                like_wyswietlanie();
            }
        });
    }

    void like_wyswietlanie() {
        like_text.setText(licznik + " polubień");
    }
}

