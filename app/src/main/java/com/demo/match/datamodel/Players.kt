package com.demo.match.datamodel

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "playersinfo")
data class Players(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "teamid") var teamid: String ,
    @ColumnInfo(name = "teamsname")
    var teamsname: String,
    @SerializedName("Iscaptain")
    @ColumnInfo(name ="Iscaptain")
    val iscaptain: Boolean,
    @SerializedName("Iskeeper")
    @ColumnInfo(name ="Iskeeper")
    val iskeeper: Boolean,
    @SerializedName("Name_Full")
    @ColumnInfo(name ="Name_Full")
    val nameFull: String,
    @SerializedName("Position")
    @ColumnInfo(name ="Position")
    val position: String
): Parcelable