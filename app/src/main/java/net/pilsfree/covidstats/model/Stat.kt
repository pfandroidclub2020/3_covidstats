package net.pilsfree.covidstats.model

import java.util.*

/*
{
    "Country": "Czech Republic",
    "CountryCode": "CZ",
    "Province": "",
    "City": "",
    "CityCode": "",
    "Lat": "49.82",
    "Lon": "15.47",
    "Confirmed": 0,
    "Deaths": 0,
    "Recovered": 0,
    "Active": 0,
    "Date": "2020-01-22T00:00:00Z"
}
*/

data class Stat (
    val Date : Date,
    val Deaths : Int,
    val Confirmed : Int,
    val Recovered : Int
)
