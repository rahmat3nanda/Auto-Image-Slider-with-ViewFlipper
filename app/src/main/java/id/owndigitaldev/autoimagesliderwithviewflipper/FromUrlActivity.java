package id.owndigitaldev.autoimagesliderwithviewflipper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class FromUrlActivity extends AppCompatActivity {

    private ViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_url);
        String[] images = {
                "https://wallpaperplay.com/walls/full/4/9/4/3064.jpg",
                "https://images.wallpaperscraft.com/image/road_night_light_125999_1920x1080.jpg",
                "https://wallpaperplay.com/walls/full/7/6/8/4836.jpg"
        };

        flipper=findViewById(R.id.flipperView);

        for (String image : images) {
            flipperImages(image);
        }
    }

    private void flipperImages(String image){
        ImageView imageView = new ImageView(this);
        Glide.with(this).load(image)
                .thumbnail(0.5f)
                .centerCrop()
                .transition(withCrossFade())
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(imageView);

        flipper.addView(imageView);
        flipper.setFlipInterval(2000);
        flipper.setAutoStart(true);

        flipper.setInAnimation(this, android.R.anim.slide_in_left);
        flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }
}
