package com.example.hom24mon5.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {

    @GET("getPercentage")
    fun getPercentage(@Query("fname") firstName: String,
                      @Query("sname") secondName: String,
                      @Header("X-RapidAPI-Key") key: String = "89b0cfc8b0msh6e753d9cc99945dp19bedajsnc6af87a93302",
                      @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com"
    ) : Call<LoveModel>
}