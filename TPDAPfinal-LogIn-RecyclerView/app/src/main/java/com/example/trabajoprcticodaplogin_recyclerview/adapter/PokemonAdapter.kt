package com.example.trabajoprcticodaplogin_recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.trabajoprcticodaplogin_recyclerview.R
import com.example.trabajoprcticodaplogin_recyclerview.entities.Pokemon

class PokemonAdapter(var pokemonList: MutableList<Pokemon>, var onClick: (Pokemon) -> Unit) : RecyclerView.Adapter<PokemonAdapter.PokemonHolder>() {
    class PokemonHolder (v: View) : RecyclerView.ViewHolder(v) {
        private var view: View

        init {
            this.view = v
        }

        fun setName (name : String) {
            val txtTitle: TextView = view.findViewById(R.id.textViewName)
            txtTitle.text = name
        }

        fun setNum (num : String) {
            val txtTitle: TextView = view.findViewById(R.id.textViewNumber)
            txtTitle.text = num
        }

        fun setType1 (type : String) {
            val txtTitle: TextView = view.findViewById(R.id.textViewType1)
            txtTitle.text = type
        }

        fun setType2 (type : String) {
            val txtTitle: TextView = view.findViewById(R.id.textViewType2)
            txtTitle.text = type
        }


        fun getItem () : ConstraintLayout {
            return view.findViewById(R.id.itemLayout)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon,parent,false)
        return (PokemonHolder(view))
    }

    override fun onBindViewHolder(holder: PokemonHolder, position: Int) {
        holder.setName(pokemonList[position].pokeName)
        holder.setNum(pokemonList[position].pokeNum)
        holder.setType1(pokemonList[position].pokeType1)
        holder.setType2(pokemonList[position].pokeType2)
        holder.getItem().setOnClickListener {
            print("Click en título")
            onClick(pokemonList[position])
        }
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }
}