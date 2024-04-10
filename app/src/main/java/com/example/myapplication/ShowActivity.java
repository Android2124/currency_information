package com.example.myapplication;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class ShowActivity extends AppCompatActivity {

    ImageView imgimage1;
    TextView txtsymbol1,txtname1,txtcurrentprice1;

    App app = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_show);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imgimage1 = findViewById(R.id.imgImage1);
        txtsymbol1 = findViewById(R.id.txtSymbol1);
        txtname1 = findViewById(R.id.txtName1);
        txtcurrentprice1 = findViewById(R.id.txtCurrentPrice1);

        final Object object = getIntent().getSerializableExtra("Show");
        if(object instanceof App){
            app = (App)object;
        }
        if(app != null){
            Glide.with(getApplicationContext()).load(app.getImage()).into(imgimage1);
            txtsymbol1.setText(app.getSymbol());
            txtname1.setText(app.getName());
            txtcurrentprice1.setText(app.getCurrent_price());
        }
    }
}