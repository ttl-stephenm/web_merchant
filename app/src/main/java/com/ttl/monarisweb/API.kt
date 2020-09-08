package com.ttl.monarisweb

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

object API {
    lateinit var retro : Retrofit
    lateinit var service : MonarisAPI

    fun init() {
        retro = Retrofit.Builder()
            .baseUrl("https://esqa.moneris.com")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()

        service = retro.create(MonarisAPI::class.java)
    }


}

interface MonarisAPI {
    @FormUrlEncoded
    @POST("/HPPDP/index.php")
    fun getStoreListing(
        @Field("ps_store_id") store: String = "8J8FYtore1",
        @Field("hpp_key") key: String = "hpT4RM1L5MY1",
        @Field("charge_total") total: String = "1.00"
    ) : Call<String>


}