package ir.pchas.tayehclient.network

import ir.pchas.tayehclient.model.shop.Instance
import ir.pchas.tayehclient.model.shop.Product
import ir.pchas.tayehclient.model.user.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

internal interface MyAPI {
    companion object {
        operator fun invoke(): MyAPI {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.tayeh.ir")
                .build()
                .create(MyAPI::class.java)
        }
    }

//    @GET("/user/me")
//    suspend fun getUserMe(
//        @Query("s") s: String
//    ): User

    @GET("user/me")
    suspend fun getUserMe(@Header("Authorization") tokenString: String): User

    @GET("user/instance/primary")
    suspend fun getInstancePrimary(@Header("Authorization") tokenString: String): Instance

    // Instance

    @GET("instance/{id}")
    suspend fun createInstancePrimary(
        @Path("id") instanceId: Int,
        @Header("Authorization") tokenString: String
    )

    @GET("instance/{id}")
    suspend fun getInstance(
        @Path("id") instanceId: Int,
        @Header("Authorization") tokenString: String
    ): Instance

    @POST("instance")
    fun createInstance(
        @Body instance: Instance,
        @Header("Authorization") tokenString: String
    )

    @POST("instance/update")
    fun updateInstance(
        @Body instance: Instance,
        @Header("Authorization") tokenString: String
    )

    // Product

    @GET("instance/{id}/products")
    fun getInstanceProducts(
        @Path("id") instanceId: Int,
        @Header("Authorization") tokenString: String
    ): List<Product>

    @POST("instance/{id}/products")
    fun createInstanceProduct(
        @Path("id") instanceId: Int,
        @Body product: Product,
        @Header("Authorization") tokenString: String
    )

    @POST("instance/{id}/product/update")
    fun updateInstanceProduct(
        @Path("id") instanceId: Int,
        @Body product: Product,
        @Header("Authorization") tokenString: String
    )

    @DELETE("instance/{id}/product/{product_id}}")
    fun deleteInstanceProduct(
        @Path("id") instanceId: Int,
        @Path("product_id") productId: Int,
        @Header("Authorization") tokenString: String
    )
}