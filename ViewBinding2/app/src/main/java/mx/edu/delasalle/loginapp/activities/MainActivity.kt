package mx.edu.delasalle.loginapp.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.appcompat.widget.Toolbar
import mx.edu.delasalle.loginapp.R
import mx.edu.delasalle.loginapp.fragments.FirstFragment
import mx.edu.delasalle.loginapp.fragments.SecondFragment

class MainActivity : AppCompatActivity(R.layout.activity_main)  { // Otra forma

    private lateinit var tvUserName: TextView;
    private lateinit var tvPassword: TextView;
    private lateinit var bnOpenActivity: Button;
    private lateinit var tbMain: Toolbar;
    private lateinit var bnOpenActivityFragment: Button;
    private lateinit var bnOpenActivityFragment2: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main) Forma normal
        val userName = intent.getStringExtra("userName");
        val password = intent.getStringExtra("password");

        tvUserName = findViewById(R.id.main_activity_tv_username);
        tvPassword = findViewById(R.id.main_activity_tv_password);
        bnOpenActivity = findViewById(R.id.main_activity_bn_open_activity);
        bnOpenActivityFragment = findViewById(R.id.main_activity_bn_open_activity_fragments);
        bnOpenActivityFragment2 = findViewById(R.id.main_activity_bn_open_activity_fragments2);
        tbMain = findViewById(R.id.main_activity_tb);

        setSupportActionBar(tbMain);
        supportActionBar?.setDisplayHomeAsUpEnabled(true);

        tvUserName.text = userName;
        tvPassword.text = password;

        bnOpenActivity.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java);
            startActivityForResult(intent, 1);
        }

        bnOpenActivityFragment.setOnClickListener {
            val intent = Intent(this, FragmentActivity::class.java);
            startActivity(intent);
        }

        bnOpenActivityFragment2.setOnClickListener {
            val intent = Intent(this, Fragment2Activity::class.java);
            startActivity(intent);
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            val value1 = data?.getStringExtra("value1");
            Toast.makeText(this, "$value1", Toast.LENGTH_LONG).show();
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            android.R.id.home -> finish();
            R.id.main_activity_menu_item_1 -> Toast.makeText(this, "Elemento1", Toast.LENGTH_LONG).show();
            R.id.main_activity_menu_item_2 -> Toast.makeText(this, "Elemento2", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item)
    }

}