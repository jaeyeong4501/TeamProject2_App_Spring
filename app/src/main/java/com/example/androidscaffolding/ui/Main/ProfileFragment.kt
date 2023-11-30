package com.example.androidscaffolding.ui.Main


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.androidscaffolding.R
import com.example.androidscaffolding.databinding.FragmentProfileBinding
import com.example.androidscaffolding.ui.Main.MyPage.Network.MyApplication
import com.example.androidscaffolding.ui.Main.MyPage.adapter.DbTestActivity


class ProfileFragment : Fragment() {

    private var mBinding: FragmentProfileBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentProfileBinding.inflate(inflater, container, false)
        mBinding = binding



        // 버튼 클릭시 회원 정보 이동
        binding.textview5.setOnClickListener {
            // Activity 시작하기 위한 Intent
            val intent = Intent(requireContext(), DbTestActivity::class.java)
            startActivity(intent)
        }

        // 버튼클릭시 :  보드 이동
        binding.textview6.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
        }


        binding.textview7.setOnClickListener {
            MyApplication.auth.signOut()
            MyApplication.email = null
            val pref = activity?.getSharedPreferences("loginInfo", AppCompatActivity.MODE_PRIVATE)
            val editor = pref?.edit()
            if (editor != null) {
                editor.clear()
            }
            if (editor != null) {
                editor.commit()
            }
        }
        binding.textview6.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
        }

        return  mBinding?.root

    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }
}