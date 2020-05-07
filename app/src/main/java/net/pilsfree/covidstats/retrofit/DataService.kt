package net.pilsfree.covidstats.retrofit

import net.pilsfree.covidstats.model.Country
import net.pilsfree.covidstats.model.Stat
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DataService {
    @GET("/countries")
    fun getCountries() : Call<List<Country>>

    @GET("/country/{country}")
    fun getCountryStats(@Path("country") country: String) : Call<List<Stat>>
}