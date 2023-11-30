package com.example.androidscaffolding.ui.Main.MyPage.adapter

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidscaffolding.databinding.ActivityDbTestBinding

class DbTestActivity : AppCompatActivity() {

    lateinit var binding: ActivityDbTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
// 전역에 선언된 변수들을 할당하는 구조.
        binding = ActivityDbTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val pref: SharedPreferences = getSharedPreferences("loginInfo", MODE_PRIVATE)
        val emailUser = pref.getString("email", "Default값")


        binding.loginUserMyPageView.text = emailUser
//
    }

    //데이터베이스 추가하기
   }
