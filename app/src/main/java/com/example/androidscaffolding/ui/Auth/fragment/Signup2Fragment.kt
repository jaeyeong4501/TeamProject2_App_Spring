package com.example.androidscaffolding.ui.Auth.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.androidscaffolding.R

import com.example.androidscaffolding.databinding.FragmentSignup2Binding
import com.example.androidscaffolding.ui.Main.BoardsFragment
import com.example.androidscaffolding.ui.Main.MyPage.Network.Boards
import com.example.androidscaffolding.ui.Main.MyPage.Network.MyApplication
import com.example.androidscaffolding.ui.Main.MyPage.Network.UserDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Signup2Fragment : Fragment() {

lateinit var binding : FragmentSignup2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignup2Binding.inflate(layoutInflater, container, false)

        // 입력정보 받아서, , 스프링에 넣기.
        binding.joinBtn.setOnClickListener {
            val userName = binding.joinNameEdt.text
            val userEmail = binding.joinEmailEdt.text
            val userPassword = binding.joinPasswordEdt.text
// 1차로, 토스트, 로그캣 다 찍고,

            // 2차, 백에 보내기. 쓰기 작업.
            val networkService = (context?.applicationContext as MyApplication).networkService

            var userDto = UserDto()
            userDto.userName = userName.toString()
            userDto.userEmail = userEmail.toString()
            userDto.userPassword = userPassword.toString()
            val boardsWriteCall: Call<Unit> = networkService.join(userDto)

            //변경3
            // 실제 통신이 시작이 되는 부분, 이 함수를 통해서 데이터를 받아옴.
            boardsWriteCall.enqueue(object : Callback<Unit> {
                //익명 클래스가, Callback , 레트로핏2에서 제공하는 인터페이스를 구현했고,
                // 반드시 재정의해야하는 함수들이 있음.
                // 변경4
                override fun onResponse(call: Call<Unit>, response: Response<Unit>) {

                    Toast.makeText(context,"회원가입을 축하합니다.",Toast.LENGTH_SHORT).show()
                    val localTodoFragment2 = LocalTodoFragment2()
                    activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.tabContent,localTodoFragment2)?.commit()
                }

                //변경5
                override fun onFailure(call: Call<Unit>, t: Throwable) {
                    Log.d("lsy"," 통신실패")
                    // 데이터를 못 받았을 때 수행되는 함수
                    call.cancel()
                }


            })


        }


        return binding.root
    }

}