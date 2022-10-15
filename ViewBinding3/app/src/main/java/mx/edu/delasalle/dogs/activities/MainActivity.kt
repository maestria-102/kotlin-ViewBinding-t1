package mx.edu.delasalle.dogs.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mx.edu.delasalle.dogs.R
import mx.edu.delasalle.dogs.adapters.DogAdapter
import mx.edu.delasalle.dogs.models.Dog



class MainActivity : AppCompatActivity() {

    private lateinit var breedRecyclerView: RecyclerView;
    private lateinit var breedAdapter: DogAdapter;

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar);
        breedRecyclerView = findViewById(R.id.recycler_breeds);

        breedRecyclerView.layoutManager = LinearLayoutManager(this);

        setAdapter(getData());

    }

    private fun getData(): MutableList<Dog> {
        val dogList: MutableList<Dog> = mutableListOf(
            Dog("Affenpinscher","https://images.dog.ceo/breeds/affenpinscher/n02110627_12431.jpg"),
            Dog("Redbone","https://images.dog.ceo/breeds/redbone/n02090379_1006.jpg"),
            Dog("Pug","https://images.dog.ceo/breeds/pug/n02110958_3644.jpg"),
            Dog("Affenpinscher","https://images.dog.ceo/breeds/affenpinscher/n02110627_12431.jpg"),
            Dog("Redbone","https://images.dog.ceo/breeds/redbone/n02090379_1006.jpg"),
            Dog("Pug","https://images.dog.ceo/breeds/pug/n02110958_3644.jpg"),
        );
        return dogList;
    }

    private fun setAdapter(list: MutableList<Dog>) {
        breedAdapter = DogAdapter(list) { dog: Dog -> onDogClick(dog) };
        breedRecyclerView.adapter = breedAdapter;
    }

    private fun onDogClick(dog: Dog) {
        val intent = Intent(this, DogActivity::class.java);
        intent.putExtra("dog", dog);
        startActivity(intent);
    }

}