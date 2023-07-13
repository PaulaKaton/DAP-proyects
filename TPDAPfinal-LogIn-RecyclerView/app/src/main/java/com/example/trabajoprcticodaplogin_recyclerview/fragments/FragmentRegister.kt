package com.example.trabajoprcticodaplogin_recyclerview.fragments

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
import com.example.trabajoprcticodaplogin_recyclerview.viewmodels.FragmentRegisterViewModel

class FragmentRegister : Fragment() {

    companion object {
        fun newInstance() = FragmentRegister()
    }

    private lateinit var viewModelSignIn: FragmentRegisterViewModel
    private lateinit var viewModelLogin : FragmentLogInViewModel
    private lateinit var v: View
    private lateinit var emailUser: EditText
    private lateinit var passUser: EditText
    private lateinit var registerButton: Button
    private lateinit var LogInButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        v = inflater.inflate(R.layout.fragment_fragment_register, container, false)
        emailUser = v.findViewById(R.id.etRegisterEmail)
        passUser = v.findViewById(R.id.etRegisterPass)
        registerButton = v.findViewById(R.id.RegisterButton)
        LogInButton = v.findViewById(R.id.goLogInButton)
        return v
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModelSignIn = ViewModelProvider(requireActivity())[FragmentRegisterViewModel::class.java]
        viewModelLogin = ViewModelProvider(requireActivity())[FragmentLogInViewModel::class.java]

        registerButton.setOnClickListener{
            val newUser: String = emailUser.text.toString()
            val newPass: String = passUser.text.toString()

            //Creo una variable que me dice si el usuario que se le da ya existe en el código
            val userExists: Users? = viewModelLogin.usersList.find {
                u -> u.username == newUser
            }
            //Si se deja vacía alguna casilla:
            if (newUser.isEmpty() || newPass.isEmpty()) {
                Toast.makeText(context,"Inserte su Usuario y Contraseña", Toast.LENGTH_SHORT).show()
            }
            //Si este usuario ya existe:
            else if (userExists != null) {
                Toast.makeText(context,"Este Usuario ya existe!", Toast.LENGTH_SHORT).show()
            }
            //Si nada de lo anterior secede, es decir que se puede crear el usuario:
            else {
                viewModelLogin.usersList.add(Users(newUser, newPass))
                Toast.makeText(context,"Usuario Creado", Toast.LENGTH_SHORT).show()
                view?.findNavController()?.navigate(R.id.action_fragmentRegister_to_fragmentLogIn)
            }
        }

        LogInButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_fragmentRegister_to_fragmentLogIn)
        }
    }
}