package ir.pchas.tayehclient.repository.network

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.pchas.mercilady.data.repository.network.*
import ir.pchas.tayehclient.repository.PreferencesManager
import ir.pchas.tayehclient.model.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import okhttp3.MultipartBody
import javax.inject.Inject

public class TayehNetworkDataSource @Inject constructor(
    private val tayehAPI: TayehAPI,
    private val preferencesManager: PreferencesManager,
    private var INSTANCE_ID: Int,
    private var TOKEN: String,
) {
    private var token = ""
    private val preferencesFlow = preferencesManager.preferencesFlow

    public suspend fun retrieveToken(): Unit = withContext(Dispatchers.IO) {
        token = preferencesFlow.first().token
        if (token.isEmpty()) {
            token = TOKEN
            preferencesManager.saveToken(token)
        }
    }

    private suspend fun saveNewToken(newToken: String) = withContext(Dispatchers.IO) {
        token = "Bearer $newToken"
        preferencesManager.saveToken(newToken)
    }

    public suspend fun getMainBanners(): List<Banner>? {
        var banners: List<Banner>? = null
        try {
            banners = tayehAPI.getMainBanners(token, INSTANCE_ID)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return banners
    }

    public suspend fun getBrandBanners(): List<Banner>? {
        var banners: List<Banner>? = null
        try {
            banners = tayehAPI.getBrandBanners(token, INSTANCE_ID)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return banners
    }

    public suspend fun getCategoryBanners(): List<Banner>? {
        var banners: List<Banner>? = null
        try {
            banners = tayehAPI.getCategoryBanners(token, INSTANCE_ID)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return banners
    }

    public suspend fun getProductImages(product: Product): List<Image>? {
        var images: List<Image>? = null
        try {
            images = tayehAPI.getProductImages(token, product.id).images
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return images
    }

    public suspend fun getProductFavoriteState(product: Product): Result<Boolean> =
        try {
            val state = tayehAPI.getProductFavoriteState(token, product.id).favorite
            Result.Success(state)
        } catch (e: Exception) {
            Result.Error(e)
        }

    public suspend fun getProductInfo(product: Product): List<FeatureGroup>? {
        var productInfo: List<FeatureGroup>? = null
        try {
            productInfo = tayehAPI.getProductInfo(token, product.id).featureGroups
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return productInfo
    }

    public suspend fun getProductChoices(product: Product): List<ProductChoice>? {
        var productChoices: List<ProductChoice>? = null
        try {
            val response = tayehAPI.getProductChoices(token, product.id)
            productChoices = listOf(response.priceChoice).plus(response.otherChoices)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return productChoices
    }

    public suspend fun getFewComments(productId: String): List<Comment>? {
        var comments: List<Comment>? = null
        try {
            comments = tayehAPI.getFewComments(token, productId).comments
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return comments
    }

    public suspend fun reportComment(productId: String, commentId: String): Result<String> =
        try {
            tayehAPI.reportComment(token, productId, commentId)
            Result.Success("ok")
        } catch (e: Exception) {
            Result.Error(e)
        }


    public suspend fun getSimilarProducts(productId: String): List<Product>? {
        var product: List<Product>? = null
        try {
            product = tayehAPI.getSimilarProducts(token, productId).products
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return product
    }

    public suspend fun getAverageRatingScore(productId: String): List<ProductAverageRatingScore>? {
        var averageRating: List<ProductAverageRatingScore>? = null
        try {
            averageRating = tayehAPI.getAverageRatingScore(token, productId)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return averageRating
    }

    public suspend fun addToCartProduct(addToCartRequest: AddToCartRequest): Result<String> =
        try {
            tayehAPI.addToCartProduct(token, addToCartRequest)
            Result.Success("ok")
        } catch (e: Exception) {
            e.printStackTrace()
            Result.Error(e)
        }

    public suspend fun updateShopCard(updateCartItemRequest: UpdateCartItemRequest): Result<String> =
        try {
            tayehAPI.updateShopCard(token, updateCartItemRequest)
            Result.Success("ok")
        } catch (e: Exception) {
            e.printStackTrace()
            Result.Error(e)
        }

    public suspend fun deleteShopCartItem(shopCartId: String): Result<String> =
        try {
            tayehAPI.deleteShopCartItem(token, shopCartId)
            Result.Success("ok")
        } catch (e: Exception) {
            e.printStackTrace()
            Result.Error(e)
        }

    public suspend fun addToFavorite(addToFavorite: AddToFavorite) {
        try {
            tayehAPI.addToFavorite(token, addToFavorite)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    public suspend fun getProduct(productId: String): Product? {
        var product: Product? = null
        try {
            product = tayehAPI.getProduct(token, productId)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return product
    }

    public suspend fun getBestsellerProducts(): Result<List<Product>> =
        try {
            val products = tayehAPI.getBestsellerProducts(token, INSTANCE_ID).products
            Result.Success(products)
        } catch (e: Exception) {
            Result.Error(e)
        }

    public suspend fun getFreshProducts(): Result<List<Product>> =
        try {
            val products = tayehAPI.getFreshProducts(token, INSTANCE_ID).products
            Result.Success(products)
        } catch (e: Exception) {
            Result.Error(e)
        }

    public suspend fun getSuggestedProducts(): Result<List<Product>> =
        try {
            val products = tayehAPI.getSuggestedProducts(token, INSTANCE_ID).products
            Result.Success(products)
        } catch (e: Exception) {
            Result.Error(e)
        }

    public suspend fun fetchCustomerCart(): List<ShopCardItem>? {
        var customerCart: List<ShopCardItem>? = null
        try {
            customerCart = tayehAPI.getCustomerCart(token).items
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return customerCart
    }

    public suspend fun getProductRatingOption(productId: String): List<ProductRatingOption>? {
        var ratingOptions: List<ProductRatingOption>? = null
        try {
            ratingOptions = tayehAPI.getProductRatingOption(token, productId)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return ratingOptions
    }

    public suspend fun sendNewComment(newCommentRequest: NewCommentRequest): Result<String> =
        try {
            tayehAPI.sendNewComment(token, newCommentRequest.productId, newCommentRequest)
            Result.Success("ok")
        } catch (e: Exception) {
            Result.Error(e)
        }

    public suspend fun sendLoginSMSCode(mobileNumber: String): Result<String> =
        try {
            val loginRequest = LoginRequest(INSTANCE_ID, mobileNumber, null)
            tayehAPI.sendLoginSMSCode(loginRequest)
            Result.Success("ok")
        } catch (e: Exception) {
            e.printStackTrace()
            Result.Error(e)
        }

    public suspend fun verifyCode(mobileNumber: String, passCode: String): Result<String> =
        try {
            val loginRequest = LoginRequest(INSTANCE_ID, mobileNumber, passCode)
            val newToken = tayehAPI.verifyCode(loginRequest).token
            saveNewToken("Bearer $newToken")
            saveLoginStatus(true)
            Result.Success(newToken)
        } catch (e: Exception) {
            e.printStackTrace()
            Result.Error(e)
        }


    public fun getProductComments(productId: String) = Pager(
        config = PagingConfig(
            pageSize = 6,
            maxSize = 18,
            enablePlaceholders = false
        ),
        pagingSourceFactory = { CommentPagingSource(tayehAPI, token, productId) }
    ).liveData

    public fun getNotifications() = Pager(
        config = PagingConfig(
            pageSize = 6,
            maxSize = 18,
            enablePlaceholders = false
        ),
        pagingSourceFactory = { NotificationPagingSource(tayehAPI, token) }
    ).liveData

    public fun getSearchResult(
        query: String, sort: String, min_price: Int?, max_price: Int?, brands: List<String>?,
        category: String?, filter: List<String>?, only_available: Boolean?, similar_to: String?
    ) = Pager(
        config = PagingConfig(
            pageSize = 6,
            maxSize = 18,
            enablePlaceholders = false
        ),
        pagingSourceFactory = {
            ProductPagingSource(
                tayehAPI = tayehAPI,
                token = token,
                instanceId = INSTANCE_ID,
                search = query,
                sort = sort,
                min_price = min_price,
                max_price = max_price,
                brands = brands,
                category = category,
                filter = filter,
                only_available = only_available,
                similar_to = similar_to,
            )
        }
    ).liveData

    public fun getCustomerFavoriteProductList() = Pager(
        config = PagingConfig(
            pageSize = 6,
            maxSize = 18,
            enablePlaceholders = false
        ),
        pagingSourceFactory = {
            FavoriteProductPagingSource(
                tayehAPI = tayehAPI,
                token = token,
            )
        }
    ).liveData

    // Search
    public suspend fun getTopSearch(): List<String> {
        var list = listOf<String>()
        try {
            list = tayehAPI.getTopSearch(token, INSTANCE_ID)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return list
    }

    public suspend fun getSearchFilters(): SearchFilterResponse? {
        var responce: SearchFilterResponse? = null
        try {
            responce = tayehAPI.getInstanceSearchFilters(token, INSTANCE_ID)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return responce
    }

    // Profile
    public suspend fun getCustomerInfo(): Result<Customer> =
        try {
            val customer = tayehAPI.getCustomerInfo(token)
            Result.Success(customer)
        } catch (e: Exception) {
            e.printStackTrace()
            Result.Error(e)
        }

    public suspend fun updateCustomerInfo(updateCustomerProfileRequest: UpdateCustomerProfileRequest): Result<String> =
        try {
            tayehAPI.updateCustomerInfo(token, updateCustomerProfileRequest)
            Result.Success("ok")
        } catch (e: Exception) {
            Result.Error(e)
        }


    public suspend fun uploadNewAvatar(newProfile: MultipartBody.Part): AvatarResponse? {
        var response: AvatarResponse? = null
        try {
            response = tayehAPI.uploadNewAvatar(tokenString = token, file = newProfile)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return response
    }

    public suspend fun setNewAvatar(avatarId: SetAvatarRequest): Result<String> =
        try {
            tayehAPI.setNewAvatar(tokenString = token, avatar_id = avatarId)
            Result.Success("ok")
        } catch (e: Exception) {
            Result.Error(e)
        }

    public suspend fun checkLoginStatus(): Boolean = preferencesFlow.first().loginStatus
    private suspend fun saveLoginStatus(status: Boolean) =
        preferencesManager.saveLoginStatus(status)

    public suspend fun getCustomerAddress(): Result<List<Address>> =
        try {
            val addressList = tayehAPI.getCustomerAddresses(token)
            Result.Success(addressList)
        } catch (e: Exception) {
            Result.Error(e)
        }

    public suspend fun createCustomerAddress(address: Address): Result<String> =
        try {
            tayehAPI.createCustomerAddress(token, address)
            Result.Success("ok")
        } catch (e: Exception) {
            Result.Error(e)
        }

    public suspend fun updateCustomerAddress(address: Address): Result<String> =
        try {
            tayehAPI.updateCustomerAddress(token, address)
            Result.Success("ok")
        } catch (e: Exception) {
            Result.Error(e)
        }

    public suspend fun deleteCustomerAddress(addressId: String): Result<String> =
        try {
            tayehAPI.deleteCustomerAddress(token, addressId)
            Result.Success("ok")
        } catch (e: Exception) {
            Result.Error(e)
        }

    public suspend fun getStateOfIran(): List<State> {
        var stateList = listOf<State>()
        try {
            stateList = tayehAPI.getStateOfIran(token)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return stateList
    }

    public suspend fun getCityOfState(stateCode: Int): List<State> {
        var cityList = listOf<State>()
        try {
            cityList = tayehAPI.getCityOfState(token, stateCode)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return cityList
    }

    public suspend fun getDeliveredInvoice(): Result<List<Invoice>> =
        try {
            val invoices = tayehAPI.getDeliveredInvoice(tokenString = token)
            Result.Success(invoices)
        } catch (e: Exception) {
            Result.Error(e)
        }

    public suspend fun getInProgressInvoice(): Result<List<Invoice>> =
        try {
            val invoices = tayehAPI.getInProgressInvoice(tokenString = token)
            Result.Success(invoices)
        } catch (e: Exception) {
            Result.Error(e)
        }

    public suspend fun getWalletAmount(): Result<Wallet> =
        try {
            val wallet = tayehAPI.getWalletAmount(tokenString = token)
            Result.Success(wallet)
        } catch (e: Exception) {
            Result.Error(e)
        }
}