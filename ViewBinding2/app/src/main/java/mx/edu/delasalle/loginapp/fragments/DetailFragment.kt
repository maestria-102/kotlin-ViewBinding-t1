package mx.edu.delasalle.loginapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import mx.edu.delasalle.loginapp.R



class DetailFragment : Fragment(R.layout.fragment_detail) {

    private var firstName: String? = "";
    private var lastName: String? = "";
    private lateinit var tvDetail: TextView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);


        firstName = requireArguments().getString("firstName");
        lastName = requireArguments().getString("lastName");

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvDetail = view.findViewById(R.id.detail_fragment_tv_detail);

        tvDetail.text = "Hola $firstName $lastName";
    }

    companion object {
        const val FIRST_NAME = "firstName";
        const val LAST_NAME = "lastName";
    }
}