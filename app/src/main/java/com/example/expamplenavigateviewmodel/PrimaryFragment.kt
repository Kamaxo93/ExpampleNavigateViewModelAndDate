package com.example.expamplenavigateviewmodel

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.expamplenavigateviewmodel.databinding.FragmentPrimaryBinding

class PrimaryFragment : Fragment(R.layout.fragment_primary) {

    private var binding: FragmentPrimaryBinding? = null
    private val viewModel: MainViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPrimaryBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.primaryFragmentBtnBtnNavigate?.setOnClickListener {
        viewModel.setUser(User("Camacho", 28))
        findNavController().navigate(R.id.action_primaryFragment_to_secondFragment)

        }

        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<User>("user")?.observe(
            viewLifecycleOwner, {result ->
                Log.d("Manolete", "onViewCreated: ${result.name}, ${result.age}")
            }
        )
    }
}