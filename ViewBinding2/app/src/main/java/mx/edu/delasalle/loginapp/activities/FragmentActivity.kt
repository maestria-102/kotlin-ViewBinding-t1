package mx.edu.delasalle.loginapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.edu.delasalle.loginapp.R

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
    }
}