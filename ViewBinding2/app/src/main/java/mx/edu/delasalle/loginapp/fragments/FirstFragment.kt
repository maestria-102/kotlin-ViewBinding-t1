package mx.edu.delasalle.loginapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentTransaction
import mx.edu.delasalle.loginapp.R
import mx.edu.delasalle.loginapp.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {


   // private lateinit var bnGoSecondFragment: Button;
    private var _binding: FragmentFirstBinding? = null;
    private val binding get() = _binding!!;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.root;
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.firstFragmentBnGoToSecond.setOnClickListener {
            val transaction: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction();
            transaction.setReorderingAllowed(true);
            transaction.replace(R.id.fragment_activity_fv_container, SecondFragment.newInstance("Josue", "Caro"), null);
            transaction.commit();
        }

        /*
        bnGoSecondFragment = view.findViewById(R.id.first_fragment_bn_go_to_second);

        bnGoSecondFragment.setOnClickListener {
            val transaction: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction();
            transaction.setReorderingAllowed(true);
            transaction.replace(R.id.fragment_activity_fv_container, SecondFragment.newInstance("Josue", "Caro"), null);
            transaction.commit();
        }
         */
    }

}