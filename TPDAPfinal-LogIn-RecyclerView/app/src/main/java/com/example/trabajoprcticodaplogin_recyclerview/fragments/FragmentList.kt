package com.example.trabajoprcticodaplogin_recyclerview.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trabajoprcticodaplogin_recyclerview.R
import com.example.trabajoprcticodaplogin_recyclerview.adapter.PokemonAdapter
import com.example.trabajoprcticodaplogin_recyclerview.entities.Pokemon
import com.example.trabajoprcticodaplogin_recyclerview.entities.PokemonRepository
import com.example.trabajoprcticodaplogin_recyclerview.viewmodels.FragmentListViewModel
import com.example.trabajoprcticodaplogin_recyclerview.viewmodels.FragmentRegisterViewModel

class FragmentList : Fragment() {

    companion object {
        fun newInstance() = FragmentList()
    }

    private lateinit var viewModel: FragmentListViewModel
    private lateinit var v : View
    private lateinit var recPokemon : RecyclerView
    private var repository = PokemonRepository()
    private lateinit var pokemonList: MutableList<Pokemon>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        v =  inflater.inflate(R.layout.fragment_fragment_list, container, false)
        recPokemon = v.findViewById(R.id.recyclerPokemon)
        return v
    }

    override fun onStart() {
        super.onStart()

        recPokemon.layoutManager  = LinearLayoutManager(context)

        recPokemon.adapter = PokemonAdapter(repository.getPokemon()){
            Pokemon ->
            viewModel.pokemonNum = Pokemon.pokeNum
            viewModel.pokemonName = Pokemon.pokeName
            viewModel.pokemonType1 = Pokemon.pokeType1
            viewModel.pokemonType2 = Pokemon.pokeType2
            viewModel.pokemonWeight = Pokemon.pokeWeight
            viewModel.pokemonHeight = Pokemon.pokeHeight
            view?.findNavController()?.navigate(R.id.action_fragmentList_to_fragmentMoreOptions)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(FragmentListViewModel::class.java)
    }
}