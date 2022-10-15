package mx.edu.delasalle.loginapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import mx.edu.delasalle.loginapp.R


class MainFragment : Fragment(R.layout.fragment_main) {


    private lateinit var bnGo: Button;



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bnGo = view.findViewById(R.id.main_fragment_bn_go);

        bnGo.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_detailFragment, bundleOf(DetailFragment.FIRST_NAME to "Juan", DetailFragment.LAST_NAME to "Perez"));

        }
    }

}