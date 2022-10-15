package mx.edu.delasalle.dogs.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import com.squareup.picasso.Picasso
import mx.edu.delasalle.dogs.R
import mx.edu.delasalle.dogs.models.Dog

class DogActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar;
    private lateinit var imageDog: ImageView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog)

        toolbar = findViewById(R.id.toolbar);
        imageDog = findViewById(R.id.img_dog);

        val dog = intent.getSerializableExtra("dog") as Dog;
        toolbar.setTitle(dog.name);
        Picasso.get().load(dog.image).into(imageDog);

        setSupportActionBar(toolbar);
        supportActionBar?.setDisplayHomeAsUpEnabled(true);

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> {
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item)
    }
}