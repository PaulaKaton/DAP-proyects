package com.example.trabajoprcticodaplogin_recyclerview.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.trabajoprcticodaplogin_recyclerview.R
import com.example.trabajoprcticodaplogin_recyclerview.viewmodels.FragmentListViewModel
import com.example.trabajoprcticodaplogin_recyclerview.viewmodels.FragmentMoreOptionsViewModel

class FragmentMoreOptions : Fragment() {

    companion object;

    private lateinit var viewModelMoreOpt: FragmentMoreOptionsViewModel
    private lateinit var viewModelList: FragmentListViewModel
    private lateinit var v : View
    private lateinit var number : TextView
    private lateinit var name : TextView
    private lateinit var type1 : TextView
    private lateinit var type2 : TextView
    private lateinit var weight : TextView
    private lateinit var height : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_fragment_list, container, false)
        number = v.findViewById(R.id.tvPokeNumOpt)
        name = v.findViewById(R.id.tvPokeNameOpt)
        type1 = v.findViewById(R.id.tvPokeType1Opt)
        type2 = v.findViewById(R.id.tvPokeType2Opt)
        weight = v.findViewById(R.id.tvPokeWeightOpt)
        height = v.findViewById(R.id.tvPokeHeightOpt)
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModelMoreOpt = ViewModelProvider(requireActivity()).get(FragmentMoreOptionsViewModel::class.java)
        viewModelList = ViewModelProvider(requireActivity()).get(FragmentListViewModel::class.java)

        number.text = viewModelList.pokemonNum
        name.text = viewModelList.pokemonName
        type1.text = viewModelList.pokemonType1
        type2.text = viewModelList.pokemonType2
        weight.text = viewModelList.pokemonWeight
        height.text = viewModelList.pokemonHeight
    }

}