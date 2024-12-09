package com.mkdev.data.datasource.remote.response.property


import com.google.gson.annotations.SerializedName

data class OverallRatingResponse(
    @SerializedName("numberOfRatings")
    val numberOfRatings: String,
    @SerializedName("overall")
    val overall: Int
)