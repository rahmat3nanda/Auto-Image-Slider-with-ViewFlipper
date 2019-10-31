package id.owndigitaldev.autoimagesliderwithviewflipper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button localData = findViewById(R.id.localData);
        Button fromUrl = findViewById(R.id.fromUrl);

        initButton(localData, LocalDataActivity.class);
        initButton(fromUrl, FromUrlActivity.class);
    }

    private void initButton(Button button, final Class activity) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, activity));
            }
        });
    }
}
