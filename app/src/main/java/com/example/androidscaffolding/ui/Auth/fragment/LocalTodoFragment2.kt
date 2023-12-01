package com.example.androidscaffolding.ui.Auth.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidscaffolding.R
import com.example.androidscaffolding.databinding.FragmentBoardsBinding
import com.example.androidscaffolding.databinding.FragmentLocalTodo2Binding

import com.example.androidscaffolding.ui.Auth.adapter.recycleradapter
import com.example.androidscaffolding.ui.Main.BBSFragment

class LocalTodoFragment2 : Fragment() {
    lateinit var binding: FragmentLocalTodo2Binding
    //lateinit var binding: BottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLocalTodo2Binding.inflate(layoutInflater, container, false)
        val datas = mutableListOf<String>()

        binding.taskrecycler.adapter = recycleradapter(datas)

//      글자 아이콘 클릭시  홈 바텀 시트 불러옴
        val button = binding.newTaskBtn
        button.setOnClickListener { view ->
            val bottomSheet = BottomSheet()
            bottomSheet.show(childFragmentManager, bottomSheet.tag)
        }
//        binding.newTaskBtn.setOnClickListener {
//            BottomSheet().show(childFragmentManager,"newTask")
//        }
        binding.loginBtn.setOnClickListener {
            val login2Fragment = Login2Fragment()
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.tabContent, login2Fragment)?.commit()

        }

        return binding.root
    }


}