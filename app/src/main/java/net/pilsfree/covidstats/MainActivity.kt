package net.pilsfree.covidstats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import net.pilsfree.covidstats.adapter.CountryAdapter
import net.pilsfree.covidstats.model.Country
import net.pilsfree.covidstats.retrofit.DataService
import net.pilsfree.covidstats.retrofit.RetrofitClientInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service = RetrofitClientInstance.retrofit.create(DataService::class.java)

        service.getCountries().enqueue(object : Callback<List<Country>> {
            override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                Toast.makeText(this@MainActivity,"Nepovedlo se načíst seznam zemí",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                val list = response.body()!!.sortedBy { it.Country }

                val onclick = {
                    position : Int ->
                        Toast.makeText(this@MainActivity,list[position].toString(),Toast.LENGTH_LONG).show()
                }

                val adapter = CountryAdapter(list,onclick)
                recycler.adapter = adapter

                recycler.layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,false)
                recycler.addItemDecoration(DividerItemDecoration(this@MainActivity,LinearLayoutManager.VERTICAL))
            }
        })

    }
}
