package com.example.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MarvelResponse(

	@field:SerializedName("code")
	val code: Int,

	@field:SerializedName("status")
	val status: String,

	@field:SerializedName("data")
	val data: Data
)

data class ItemsItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("resourceURI")
	val resourceURI: String,

	@field:SerializedName("type")
	val type: String
)

data class Data(

	@field:SerializedName("limit")
	val limit: Int,

	@field:SerializedName("results")
	val results: List<ResultsItem>
)

data class ResultsItem(

	@field:SerializedName("thumbnail")
	val thumbnail: Thumbnail,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("modified")
	val modified: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("resourceURI")
	val resourceURI: String,

)

data class Thumbnail(

	@field:SerializedName("path")
	val path: String,

	@field:SerializedName("extension")
	val extension: String
)
