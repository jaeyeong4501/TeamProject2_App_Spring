package com.example.androidscaffolding.ui.Auth.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidscaffolding.databinding.FragmentLocalTodoBinding
import com.example.androidscaffolding.ui.Auth.AuthActivity
import com.example.androidscaffolding.ui.Auth.adapter.recycleradapter
import com.example.androidscaffolding.ui.Main.LoginAuthActivity


class LocalTodoFragment : Fragment() {
    lateinit var binding: FragmentLocalTodoBinding
    // TODO: Rename and change types of parameters


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLocalTodoBinding.inflate(layoutInflater, container, false)


        val datas= mutableListOf<String>()

        binding.taskrecycler.adapter=recycleradapter(datas)


//        binding.newTaskBtn.setOnClickListener {
//            BottomSheet().show(childFragmentManager,"newTask")
//        }
        binding.loginBtn.setOnClickListener {
            val intent = Intent(activity, LoginAuthActivity::class.java)

            startActivity(intent)

        }

        return binding.root

    }


}