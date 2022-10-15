package mx.edu.delasalle.loginapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import mx.edu.delasalle.loginapp.R

class SecondFragment : Fragment() {


    private var firstName: String? = "";
    private var lastName: String? = "";

    private lateinit var tvFullName: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       firstName = requireArguments().getString("firstName");
        lastName = requireArguments().getString("lastName");

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            tvFullName = view.findViewById(R.id.second_fragment_tv_fullname);
            tvFullName.text = "${firstName} ${lastName}";

    }

    companion object {
       private const val FIRST_NAME = "firstName";
        private const val LAST_NAME = "lastName";

        fun newInstance(firstName: String, lastName: String): SecondFragment = SecondFragment().apply {
            arguments = bundleOf(
                FIRST_NAME to firstName,
                LAST_NAME to lastName
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

}