package com.example.kotlinscopingfunctionswe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import kotlinx.android.synthetic.main.fragment_user_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserDetailsFragment : Fragment(R.layout.fragment_user_details) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnCallApi.setOnClickListener {
            callAPI()
        }
    }

    private fun callAPI() {
        val apiClient = Network.getInstance().create(ApiClient::class.java)
        apiClient.getUserDetails(2).enqueue(
            object : Callback<ResponseDTO> {
                override fun onResponse(call: Call<ResponseDTO>, response: Response<ResponseDTO>) {
                    response.body()?.data?.apply {
                        tvFirstName.text = firstName
                        tvLastName.text = lastName
                    }
                }

                override fun onFailure(call: Call<ResponseDTO>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            }
        )

    }

}
