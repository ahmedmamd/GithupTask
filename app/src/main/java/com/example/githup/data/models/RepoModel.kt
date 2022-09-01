package com.example.githup.data.models

import com.google.gson.annotations.SerializedName


data class RepoModel(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("full_name")
    val full_name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("fork")
    val fork: Boolean,

    @SerializedName("owner")
    val owner: Owner
)

data class Owner(
    @SerializedName("id")
    val id: String,
    @SerializedName("login")
    val login: String,
    @SerializedName("node_id")
    val node_id: String,
)
