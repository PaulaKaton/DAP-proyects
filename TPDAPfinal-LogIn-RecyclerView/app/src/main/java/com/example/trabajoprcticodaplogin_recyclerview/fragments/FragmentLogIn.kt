package com.example.trabajoprcticodaplogin_recyclerview.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.trabajoprcticodaplogin_recyclerview.R
import com.example.trabajoprcticodaplogin_recyclerview.entities.Users
import com.example.trabajoprcticodaplogin_recyclerview.viewmodels.FragmentLogInViewModel

class FragmentLogIn : Fragment() {

    companion object {
        fun newInstance() = FragmentLogIn()
    }

    private lateinit var viewModelLogIn: FragmentLogInViewModel
    private lateinit var v: View
    private lateinit var emailUser: EditText
    private lateinit var passUser: EditText
    private lateinit var logInButton: Button
    private lateinit var registerButton: Button

    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_fragment_log_in, container, false)
        emailUser = v.findViewById(R.id.etLogInEmail)
        passUser = v.findViewById(R.id.etLogInPass)
        logInButton = v.findViewById(R.id.LogInButton)
        registerButton = v.findViewById(R.id.goRegisterButton)
        return v
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //Manda los usuarios al ViewModel donde esta usersList para guardarlos
        viewModelLogIn = ViewModelProvider(requireActivity())[FragmentLogInViewModel::class.java]
        //La lista de usuarios
        viewModelLogIn.usersList.add(Users("luka", "1234"))
        viewModelLogIn.usersList.add(Users("ari", "papa"))
        viewModelLogIn.usersList.add(Users("cele", "azul"))
        viewModelLogIn.usersList.add(Users("pau", "0000"))

        //Registra el click del Botón para ir al fragment de registro
        registerButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_fragmentLogIn_to_fragmentRegister)
        }

        //Inicia Sesión en la aplicación
        logInButton.setOnClickListener{
            val user: String = emailUser.text.toString()
            val pass: String = passUser.text.toString()

            //Encuentra si el usuario existe
            val findUser: Users? = viewModelLogIn.usersList.find {
                us -> us.username == user
            }

            //Si el user existe
            if (findUser != null){
                //Si la contraseña coincide con el usuario
                if (findUser.password == pass){
                    Toast.makeText(context,"Iniciaste Sesión!", Toast.LENGTH_SHORT).show()
                    view?.findNavController()?.navigate(R.id.action_fragmentLogIn_to_fragmentList)
                }
                //Si la contraseña no coincide con el usuario
                else {
                    Toast.makeText(context,"Usuario/Contraseña Incorrecta", Toast.LENGTH_SHORT).show()
                }
            }
            //Si no se puso nada en los EditText(s)
            else if(user.isEmpty() && pass.isEmpty()) {
                Toast.makeText(context,"Inserte su Usuario y Contraseña", Toast.LENGTH_SHORT).show()
            }
            // Si nada de lo anterior se cumple
            else {
                Toast.makeText(context  ,"Tu usuario no existe", Toast.LENGTH_SHORT).show()
            }
        }
    }
}