package mx.edu.delasalle.dogs.adapters

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import mx.edu.delasalle.dogs.R
import mx.edu.delasalle.dogs.databinding.ItemDogBinding
import mx.edu.delasalle.dogs.models.Dog

class DogAdapter(dotList: List<Dog>, private val listener: (Dog) -> Unit): RecyclerView.Adapter<DogAdapter.ViewHolder>() {

    private var dogList: List<Dog> = dotList;

    class ViewHolder(v: View): RecyclerView.ViewHolder(v) {

        var binding = ItemDogBinding.bind(v)

        //val textBreed: TextView = v.findViewById(R.id.text_breed);
        //val imageView: ImageView = v.findViewById(R.id.img_breed);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dog, parent, false);
        return ViewHolder(view);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dog: Dog = dogList[position];

        holder.binding.textBreed.text = dog.name;
        Picasso.get().load(dog.image).into(holder.binding.imgBreed);
        holder.itemView.setOnClickListener { listener(dog) }
    }

    override fun getItemCount(): Int {
        return dogList.size;
    }

}
