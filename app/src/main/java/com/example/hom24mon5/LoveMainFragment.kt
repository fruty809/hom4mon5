package com.example.hom24mon5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.hom24mon5.databinding.FragmentLoveMainBinding
import com.example.hom24mon5.remote.LoveModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoveMainFragment : Fragment() {

    lateinit var binding: FragmentLoveMainBinding

    val viewModel: LoveViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoveMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btnCalculate.setOnClickListener {
                viewModel.getLiveLoveModel(
                    etFirstName.text.toString(),
                    etSecondName.text.toString()
                ).observe(viewLifecycleOwner,
                    Observer {
                        App.appDatabase.loveDao().insertLove(it)
                        getData(it)
                    })
            }
        }
    }

    private fun getData(data: LoveModel) {
        val loveModel = data
        var bundle = bundleOf("love" to loveModel)
        findNavController().navigate(R.id.action_loveMainFragment_to_resultFragment, bundle)
    }
}