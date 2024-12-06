package com.mkdev.data.datasource.remote.response


import com.google.gson.annotations.SerializedName

data class OverallRatingResponse(
    @SerializedName("numberOfRatings")
    val numberOfRatings: String,
    @SerializedName("overall")
    val overall: Int
)