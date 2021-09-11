package ir.pchas.tayehclient.repository.network

import com.pchas.mercilady.data.repository.network.UpdateCartItemRequest
import com.pchas.mercilady.data.repository.network.UpdateCustomerProfileRequest
import ir.pchas.tayehclient.model.Address
import ir.pchas.tayehclient.model.ProductSort
import ir.pchas.tayehclient.model.*
import okhttp3.MultipartBody
import retrofit2.http.*

public interface TayehAPI {
    public companion object {
        public const val loginBaseURL: String = "https://auth.tayeh.ir/customer/send-mobile-verification"
        public const val verifyBaseURL: String = "https://auth.tayeh.ir/customer/verify-mobile"
        public const val mediaBaseURL: String = "https://blob.tayeh.ir/image"
        public const val apiBaseURL: String = "https://api.tayeh.ir/"
        private const val INSTANCE = "instance"
        private const val PRODUCT = "product"
        private const val CUSTOMER = "customer"
        private const val ADDRESS = "addresses"
    }

    // Banner
    @GET("$INSTANCE/{instanceId}/banners")
    public suspend fun getMainBanners(
        @Header("Authorization") tokenString: String,
        @Path("instanceId") instanceId: Int,
        @Query("category") category: String = "web_main",
        @Query("size") size: String = "all",
    ): List<Banner>

    @GET("$INSTANCE/{instanceId}/banners")
    public suspend fun getBrandBanners(
        @Header("Authorization") tokenString: String,
        @Path("instanceId") instanceId: Int,
        @Query("category") category: String = "brand",
        @Query("size") size: String = "all",
    ): List<Banner>

    @GET("$INSTANCE/{instanceId}/banners")
    public suspend fun getCategoryBanners(
        @Header("Authorization") tokenString: String,
        @Path("instanceId") instanceId: Int,
        @Query("category") category: String = "category",
        @Query("size") size: String = "all",
    ): List<Banner>

    // Products
    @GET("$PRODUCT/{productId}")
    public suspend fun getProduct(
        @Header("Authorization") tokenString: String,
        @Path("productId") productId: String,
    ): Product

    @GET("$INSTANCE/{instanceId}/products")
    public suspend fun getSuggestedProducts(
        @Header("Authorization") tokenString: String,
        @Path("instanceId") instanceId: Int,
        @Query("suggested") isSuggested: Boolean = true,
    ): ProductResponse

    @GET("$INSTANCE/{instanceId}/products")
    public suspend fun getBestsellerProducts(
        @Header("Authorization") tokenString: String,
        @Path("instanceId") instanceId: Int,
        @Query("sort") sort: String = ProductSort.BEST_SELLER.title,
    ): ProductResponse

    @GET("$INSTANCE/{instanceId}/products")
    public suspend fun getFreshProducts(
        @Header("Authorization") tokenString: String,
        @Path("instanceId") instanceId: Int,
        @Query("sort") sort: String = ProductSort.FRESH.title,
    ): ProductResponse

    @GET("$PRODUCT/{productId}/similar-products")
    public suspend fun getSimilarProducts(
        @Header("Authorization") tokenString: String,
        @Path("productId") productId: String,
    ): ProductResponse

    @GET("$PRODUCT/{productId}")
    public suspend fun getProductImages(
        @Header("Authorization") tokenString: String,
        @Path("productId") productId: String,
    ): ProductImages

    @GET("$PRODUCT/{productId}")
    public suspend fun getProductFavoriteState(
        @Header("Authorization") tokenString: String,
        @Path("productId") productId: String,
    ): ProductFavoriteState

    @POST("/$CUSTOMER/favorite-product")
    public suspend fun addToFavorite(
        @Header("Authorization") tokenString: String,
        @Body addToFavorite: AddToFavorite,
    )

    @GET("$PRODUCT/{productId}/features")
    public suspend fun getProductInfo(
        @Header("Authorization") tokenString: String,
        @Path("productId") productId: String,
    ): ProductInfoResponse

    @GET("$PRODUCT/{productId}/choices")
    public suspend fun getProductChoices(
        @Header("Authorization") tokenString: String,
        @Path("productId") productId: String,
    ): ProductChoiceResponse

    @GET("/$PRODUCT/{productId}/reviews")
    public suspend fun getFewComments(
        @Header("Authorization") tokenString: String,
        @Path("productId") productId: String,
        @Query("page") page: Int = 0,
        @Query("per_page") perPage: Int = 3,
    ): CommentResponse

    @POST("/$PRODUCT/{productId}/review/{commentId}/report")
    public suspend fun reportComment(
        @Header("Authorization") tokenString: String,
        @Path("productId") productId: String,
        @Path("commentId") commentId: String,
    )

    @GET("$PRODUCT/{productId}/rating-options")
    public suspend fun getProductRatingOption(
        @Header("Authorization") tokenString: String,
        @Path("productId") productId: String,
    ): List<ProductRatingOption>

    @GET("$PRODUCT/{productId}/rating-averages")
    public suspend fun getAverageRatingScore(
        @Header("Authorization") tokenString: String,
        @Path("productId") productId: String,
    ): List<ProductAverageRatingScore>

    @PUT("/$PRODUCT/{productId}/review")
    public suspend fun sendNewComment(
        @Header("Authorization") tokenString: String,
        @Path("productId") productId: String,
        @Body newCommentRequest: NewCommentRequest,
    )

    @GET("$INSTANCE/{instanceId}/products")
    public suspend fun searchProducts(
        @Header("Authorization") tokenString: String,
        @Path("instanceId") instanceId: Int,
        @Query("search") search: String,
        @Query("sort") sort: String,
        @Query("min_price") min_price: Int?,
        @Query("max_price") max_price: Int?,
        @Query("brands") brands: List<String>?,
        @Query("category") category: String?,
        @Query("filter") filter: List<String>?,
        @Query("only_available") only_available: Boolean?,
        @Query("similar_to") similar_to: String?,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
    ): ProductResponse

    // Comment
    @GET("/$PRODUCT/{productId}/reviews")
    public suspend fun getProductComments(
        @Header("Authorization") tokenString: String,
        @Path("productId") productId: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
    ): CommentResponse

    // Customer
    @POST
    public suspend fun sendLoginSMSCode(
        @Body loginRequest: LoginRequest,
        @Url fullLoginBaseURL: String = loginBaseURL,
    )

    @POST
    public suspend fun verifyCode(
        @Body loginRequest: LoginRequest,
        @Url fullLoginBaseURL: String = verifyBaseURL,
    ): LoginResponse

    // Shop cart
    @PUT("/$CUSTOMER/cart")
    public suspend fun addToCartProduct(
        @Header("Authorization") tokenString: String,
        @Body addToCartRequest: AddToCartRequest,
    )

    @POST("/$CUSTOMER/cart")
    public suspend fun updateShopCard(
        @Header("Authorization") tokenString: String,
        @Body updateCartItemRequest: UpdateCartItemRequest,
    )

    @GET("/$CUSTOMER/cart")
    public suspend fun getCustomerCart(
        @Header("Authorization") tokenString: String,
    ): ShopCartResponse

    @DELETE("/$CUSTOMER/cart/{cartItemId}")
    public suspend fun deleteShopCartItem(
        @Header("Authorization") tokenString: String,
        @Path("cartItemId") productId: String,
    )

    // Search
    @GET("/$INSTANCE/{instanceId}/top-search-keywords")
    public suspend fun getTopSearch(
        @Header("Authorization") tokenString: String,
        @Path("instanceId") instanceId: Int,
    ): List<String>

    @GET("/$INSTANCE/{instanceId}/search-filters")
    public suspend fun getInstanceSearchFilters(
        @Header("Authorization") tokenString: String,
        @Path("instanceId") instanceId: Int,
    ): SearchFilterResponse

    // Notification
    @GET("/$CUSTOMER/notifications")
    public suspend fun getNotifications(
        @Header("Authorization") tokenString: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
    ): NotificationResponse

    // Profile
    @GET("/$CUSTOMER")
    public suspend fun getCustomerInfo(
        @Header("Authorization") tokenString: String,
    ): Customer

    @POST("/$CUSTOMER")
    public suspend fun updateCustomerInfo(
        @Header("Authorization") tokenString: String,
        @Body updateCustomerProfileRequest: UpdateCustomerProfileRequest,
    )

    @Multipart
    @POST
    public suspend fun uploadNewAvatar(
        @Header("Authorization") tokenString: String,
        @Url fullMediaBaseURL: String = mediaBaseURL,
        @Part file: MultipartBody.Part,
    ): AvatarResponse

    @POST("$CUSTOMER/avatar")
    public suspend fun setNewAvatar(
        @Header("Authorization") tokenString: String,
        @Body avatar_id: SetAvatarRequest,
    )

    @GET("/$CUSTOMER/$ADDRESS")
    public suspend fun getCustomerAddresses(
        @Header("Authorization") tokenString: String,
    ): List<Address>

    @PUT("/$CUSTOMER/address")
    public suspend fun createCustomerAddress(
        @Header("Authorization") tokenString: String,
        @Body address: Address,
    )

    @POST("/$CUSTOMER/address")
    public suspend fun updateCustomerAddress(
        @Header("Authorization") tokenString: String,
        @Body address: Address,
    )

    @DELETE("/$CUSTOMER/address/{addressId}")
    public suspend fun deleteCustomerAddress(
        @Header("Authorization") tokenString: String,
        @Path("addressId") addressId: String,
    )

    @GET("/countries/103/states")
    public suspend fun getStateOfIran(
        @Header("Authorization") tokenString: String,
        @Query("page") page: Int = 0,
        @Query("per_page") perPage: Int = 32,
    ): List<State>

    @GET("/countries/103/states/{stateId}/cities")
    public suspend fun getCityOfState(
        @Header("Authorization") tokenString: String,
        @Path("stateId") stateCode: Int,
        @Query("page") page: Int = 0,
        @Query("per_page") perPage: Int = 200,
    ): List<State>

    @GET("/$CUSTOMER/favorite-products")
    public suspend fun getCustomerFavoriteProductList(
        @Header("Authorization") tokenString: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
    ): List<Product>

    @GET("/$CUSTOMER/cart/history")
    public suspend fun getDeliveredInvoice(
        @Header("Authorization") tokenString: String,
        @Query("delivery_status") delivery_status: Int = 3,
        @Query("page") page: Int = 0,
        @Query("per_page") perPage: Int = 50,
    ): List<Invoice>

    @GET("/$CUSTOMER/cart/history")
    public suspend fun getInProgressInvoice(
        @Header("Authorization") tokenString: String,
        @Query("delivery_status") delivery_status: List<Int> = listOf(0, 1, 2),
        @Query("page") page: Int = 0,
        @Query("per_page") perPage: Int = 50,
    ): List<Invoice>

    @GET("/$CUSTOMER/credit")
    public suspend fun getWalletAmount(
        @Header("Authorization") tokenString: String,
    ): Wallet
}
