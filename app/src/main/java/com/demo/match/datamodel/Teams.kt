package com.demo.match.datamodel

import com.google.gson.annotations.SerializedName


data class Teams(
    @SerializedName("Name_Full")
    val nameFull: String,
    @SerializedName("Players")
    val players: Players
)