package mx.edu.delasalle.loginapp.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import mx.edu.delasalle.loginapp.R

class DetailActivity : AppCompatActivity() {

    private lateinit var bnBack: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        bnBack = findViewById(R.id.detail_activity_bn_back);

        bnBack.setOnClickListener {
            var intent = Intent();
            intent.putExtra("value1", "Demo OMG");
            setResult(Activity.RESULT_OK, intent);
            finish();
        }

    }
}