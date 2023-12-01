package com.example.androidscaffolding.ui.Main.MyPage.adapter


import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidscaffolding.databinding.ActivityBoardBinding
import com.example.androidscaffolding.databinding.AuthtaskRecyclerBinding
import com.example.androidscaffolding.databinding.ItemImportantBinding
import com.example.androidscaffolding.ui.Main.MyPage.Network.Board
import com.example.androidscaffolding.ui.Main.MyPage.Network.Boards

//class ViewHolder2 (val binding: ItemImportantBinding) : RecyclerView.ViewHolder(binding.root)
class ViewHolder2 (val binding: AuthtaskRecyclerBinding) : RecyclerView.ViewHolder(binding.root)


// 뷰와 데이터 연결 한다.
// 리사이클러뷰에서 , 뷰페이저2에서도 같은 패턴으로 사용할 예정.
// 지금은 더미 데이터 :datas , 공공데이터 내지, 백에서 연결된 데이터
class BoardsAdapter (val context: Context, val datas: List<Boards>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    // 리사이클러 뷰의 어댑터를 상속 받으면, 필수적으로 재정의 해야하는 함수들입니다.
    // 자동 완성으로 생성했음.

    // 뷰 생성해주는 역할
    val pref: SharedPreferences = context.getSharedPreferences("loginInfo",
        Context.MODE_PRIVATE
    )
    val emailUser = pref.getString("email", "Default값")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolder2( AuthtaskRecyclerBinding.inflate(
            LayoutInflater.from(parent.context),parent,false))

    // 출력할 목록 아이템의 크기 (사이즈), 더미 데이터를 사용할 예정.
    override fun getItemCount(): Int {
        Log.d("LJY","getItemCount : ${datas.size}")
        return datas.size
    }



    // 뷰에 데이터를 연동(바인딩) 해주는 작업.
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("LJY", "onBindViewHolder : $position")
        val binding = (holder as ViewHolder2).binding
        // 뷰 데이터 출력
            binding.headlineView.text = emailUser
        binding.taskdescView.text = datas[position].user_id
        binding.taskdateView.text = datas[position].regTime
        }
    }


// 목록 아이템의 요소 뷰를 만들기.