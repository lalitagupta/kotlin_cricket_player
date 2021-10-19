package com.demo.match.datamodel


import com.google.gson.annotations.SerializedName

data class Matchdetail(
    @SerializedName("Team_Away")
    val teamAway: String,
    @SerializedName("Team_Home")
    val teamHome: String
)