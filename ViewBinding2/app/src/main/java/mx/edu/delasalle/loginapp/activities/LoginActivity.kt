package mx.edu.delasalle.loginapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import mx.edu.delasalle.loginapp.R

class LoginActivity : AppCompatActivity() {

    private lateinit var bnSignIn: Button;
    private lateinit var etName: EditText;
    private lateinit var etPassword: EditText;

    private val TAG = "LOGIN APP";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        bnSignIn = findViewById(R.id.login_activity_bn_sign_in);
        etName = findViewById(R.id.login_activity_et_name);
        etPassword = findViewById(R.id.login_activity_et_password);

        //bnSignIn.setOnClickListener {  }
        bnSignIn.setOnClickListener(::onClick);
    }

    private fun onClick(view: View) {
        val text = (view as Button).text;
        val userName = etName.text.toString();
        val password = etPassword.text.toString();

        val intent = Intent(this, MainActivity::class.java);

        intent.putExtra("userName", userName);
        intent.putExtra("password", password);

        startActivity(intent);

        Toast.makeText(this, "${text}", Toast.LENGTH_SHORT).show();

        Log.e(TAG, "This is an error");
        Log.d(TAG, "This is for debug");
        Log.w(TAG, "This is a warning");
        Log.i(TAG, "Informative Log");
    }
}