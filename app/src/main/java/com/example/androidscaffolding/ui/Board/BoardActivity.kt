package com.example.androidscaffolding.ui.Board

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.androidscaffolding.R
import com.example.androidscaffolding.databinding.ActivityBoardBinding
import com.example.androidscaffolding.ui.Main.MyPage.Network.Board
import com.example.androidscaffolding.ui.Main.MyPage.Network.Boards
import com.example.androidscaffolding.ui.Main.MyPage.Network.MyApplication
import com.example.androidscaffolding.ui.Main.MyPage.adapter.BoardAdapter
import com.example.androidscaffolding.ui.Main.MyPage.adapter.BoardsAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BoardActivity : AppCompatActivity() {
    lateinit var binding: ActivityBoardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 리사이클러뷰 붙이기.
        // 준비물
        // 1) 어댑터, 2) 뷰홀더 3) , 목록요소 뷰  4) 네트워크 서비스 5) MyApplication baseurl
        // 중요한일
//        binding.textrecycler.layoutManager = LayoutManager()
//        binding.textrecycler.adapter =

        // text 뷰 취소선 속성.
        // TextView!!.setPaintFlags(TextView!!.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)

        val networkService = (applicationContext as MyApplication).networkService
        val boardListCall = networkService.getList2()
        boardListCall.enqueue(object : Callback<List<Boards>> {
            override fun onResponse(
                call: Call<List<Boards>>,
                response: Response<List<Boards>>
            ) {
                val boardListModel = response.body()
                if (boardListModel != null) {
                    Log.d("lsy", "BoardListModel 값 : ${boardListModel}")
                    val layoutManager = LinearLayoutManager(this@BoardActivity)
                    // 리사이클러뷰에 어댑터 연결
                    // 인자값은 : 현재 context : this@HttpTestReqResActivity
                    // 2번째 인자값은 : 데이터 , 네트워크 ,레트로핏2 통신으로 받아온 데이터 리스트

                    //변경7
                    binding.textrecycler.layoutManager = layoutManager
                    // 변경9 주의사항, 객체 안에 배열 또 있다.
                    binding.textrecycler.adapter = BoardsAdapter(this@BoardActivity,boardListModel)
                }
            }

            override fun onFailure(call: Call<List<Boards>>, t: Throwable) {
                Log.d("lsy", "데이터를 못 받아옴")
                call.cancel()
            }
        })

    }
}

