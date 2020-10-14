package ir.pchas.tayehclient.network

import ir.pchas.tayehclient.model.shop.Instance
import ir.pchas.tayehclient.model.shop.Invoice
import ir.pchas.tayehclient.model.shop.Product
import ir.pchas.tayehclient.model.shop.Transaction
import ir.pchas.tayehclient.model.user.Address
import ir.pchas.tayehclient.model.user.Customer
import ir.pchas.tayehclient.model.user.SubUser
import ir.pchas.tayehclient.model.user.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

private const val INSTANCE = "instance"
private const val TRANSACTIONS = "transactions"
private const val PRODUCT = "product"
private const val INVOICES = "invoices"
private const val CUSTOMER = "customer"
private const val USER = "user"
private const val ADDRESS = "addresses"

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

    @GET("user/me")
    suspend fun getUserMe(@Header("Authorization") tokenString: String): User

    @GET("user/$INSTANCE/primary")
    suspend fun getInstancePrimary(@Header("Authorization") tokenString: String): Instance

    // Instance

    @GET("$INSTANCE/{id}")
    suspend fun createInstancePrimary(
        @Path("id") instanceId: Int,
        @Header("Authorization") tokenString: String
    )

    @GET("instance/{id}")
    suspend fun getInstance(
        @Path("id") instanceId: Int,
        @Header("Authorization") tokenString: String
    ): Instance

    @POST(INSTANCE)
    fun createInstance(
        @Body instance: Instance,
        @Header("Authorization") tokenString: String
    )

    @POST("$INSTANCE/update")
    fun updateInstance(
        @Body instance: Instance,
        @Header("Authorization") tokenString: String
    )

    // Product

    @GET("$INSTANCE/{id}/products")
    fun getInstanceProducts(
        @Path("id") instanceId: Int,
        @Header("Authorization") tokenString: String
    ): List<Product>

    @POST("$INSTANCE/{id}/products")
    fun createInstanceProduct(
        @Path("id") instanceId: Int,
        @Body product: Product,
        @Header("Authorization") tokenString: String
    )

    @POST("$INSTANCE/{id}$PRODUCT/update")
    fun updateInstanceProduct(
        @Path("id") instanceId: Int,
        @Body product: Product,
        @Header("Authorization") tokenString: String
    )

    @DELETE("$INSTANCE/{id}$PRODUCT/{product_id}}")
    fun deleteInstanceProduct(
        @Path("id") instanceId: Int,
        @Path("product_id") productId: Int,
        @Header("Authorization") tokenString: String
    )

    // Transaction

    @GET("$INSTANCE/{id}$TRANSACTIONS")
    fun getInstanceTransactions(
        @Path("id") instanceId: Int,
        @Header("Authorization") tokenString: String
    ): List<Transaction>

    @GET("$INSTANCE/{id}$TRANSACTIONS/open")
    fun findInstanceTransactions(
        @Path("id") instanceId: Int,
        @Header("Authorization") tokenString: String
    ): List<Transaction>

    @GET("$INSTANCE/{id}$TRANSACTIONS$PRODUCT/{product_id}")
    fun getProductTransactions(
        @Path("id") instanceId: Int,
        @Path("product_id") productId: Int,
        @Header("Authorization") tokenString: String
    ): List<Transaction>

    @DELETE("$INSTANCE/{id}$TRANSACTIONS/{transaction_id}")
    fun deleteInstanceTransaction(
        @Path("id") instanceId: Int,
        @Path("transaction_id") transactionId: Int,
        @Header("Authorization") tokenString: String
    )

    @POST("$INSTANCE/{id}$TRANSACTIONS")
    fun createInstanceTransaction(
        @Path("id") instanceId: Int,
        @Body transaction: Transaction,
        @Header("Authorization") tokenString: String
    )

    @POST("$INSTANCE/{id}$TRANSACTIONS/update")
    fun updateInstanceTransaction(
        @Path("id") instanceId: Int,
        @Body transaction: Transaction,
        @Header("Authorization") tokenString: String
    )

    // Invoice

    @GET("$INSTANCE/{id}/$INVOICES")
    fun getInstanceInvoices(
        @Path("id") instanceId: Int,
        @Header("Authorization") tokenString: String
    )

    @GET("$INSTANCE/{id}/$INVOICES/{invoice_id")
    fun getInstanceInvoice(
        @Path("id") instanceId: Int,
        @Path("invoice_id") invoiceId: Int,
        @Header("Authorization") tokenString: String
    )

    @DELETE("$INSTANCE/{id}/$INVOICES/{invoice_id")
    fun deleteInstanceInvoice(
        @Path("id") instanceId: Int,
        @Path("invoice_id") invoiceId: Int,
        @Header("Authorization") tokenString: String
    )

    @POST("$INSTANCE/{id}/$INVOICES")
    fun createInstanceInvoice(
        @Path("id") instanceId: Int,
        @Body invoice: Invoice,
        @Header("Authorization") tokenString: String
    )

    @POST("$INSTANCE/{id}/$INVOICES/update")
    fun updateInstanceInvoice(
        @Path("id") instanceId: Int,
        @Body invoice: Invoice,
        @Header("Authorization") tokenString: String
    )

    @GET("$INSTANCE/{id}/series")
    fun getInstanceSeries(
        @Path("id") instanceId: Int,
        @Header("Authorization") tokenString: String
    ): List<Instance>

    @GET("$INSTANCE/{id}/total/monthly")
    fun getInstanceTotal(
        @Path("id") instanceId: Int,
        @Header("Authorization") tokenString: String
    ): List<Instance>

    @GET("$INSTANCE/{id}/revenue")
    fun getInstanceRevenue(
        @Path("id") instanceId: Int,
        @Header("Authorization") tokenString: String
    ): List<Instance>

    // Customer

    @GET("$INSTANCE/{id}/customers")
    fun getInstanceCustomers(
        @Path("id") instanceId: Int,
        @Header("Authorization") tokenString: String
    ): List<Customer>

    @GET("$INSTANCE/{id}/$CUSTOMER/{customer_id}")
    fun getInstanceCustomer(
        @Path("id") instanceId: Int,
        @Path("customer_id") customerId: Int,
        @Header("Authorization") tokenString: String
    ): Customer

    @DELETE("$INSTANCE/{id}/$CUSTOMER/{customer_id}")
    fun deleteInstanceCustomer(
        @Path("id") instanceId: Int,
        @Path("customer_id") customerId: Int,
        @Header("Authorization") tokenString: String
    )

    @POST("$INSTANCE/{id}/$CUSTOMER")
    fun createInstanceCustomer(
        @Path("id") instanceId: Int,
        @Body customer: Customer,
        @Header("Authorization") tokenString: String
    )

    @POST("$INSTANCE/{id}/$CUSTOMER/update")
    fun updateInstanceCustomer(
        @Path("id") instanceId: Int,
        @Body customer: Customer,
        @Header("Authorization") tokenString: String
    )

    // User

    @GET("$INSTANCE/{id}/users")
    fun getInstanceUsers(
        @Path("id") instanceId: Int,
        @Header("Authorization") tokenString: String
    ): List<SubUser>

    @GET("$INSTANCE/{id}/$USER/{}user_id")
    fun getInstanceUser(
        @Path("id") instanceId: Int,
        @Path("user_id") userId: Int,
        @Header("Authorization") tokenString: String
    ): SubUser

    @DELETE("$INSTANCE/{id}/$USER/{user_id}")
    fun deleteInstanceUser(
        @Path("id") instanceId: Int,
        @Path("user_id") userId: Int,
        @Header("Authorization") tokenString: String
    )

    @POST("$INSTANCE/{id}/$USER")
    fun createInstanceUser(
        @Path("id") instanceId: Int,
        @Body user: User,
        @Header("Authorization") tokenString: String
    )

    @POST("$INSTANCE/{id}/$USER/update")
    fun updateInstanceUser(
        @Path("id") instanceId: Int,
        @Body user: User,
        @Header("Authorization") tokenString: String
    )

    // Addresses

    @GET("$INSTANCE/{id}/addresses")
    fun getInstanceAddresses(
        @Path("id") instanceId: Int,
        @Header("Authorization") tokenString: String
    ): List<Address>

    @DELETE("$INSTANCE/{id}/$ADDRESS/{address_id}")
    fun deleteInstanceAddress(
        @Path("id") instanceId: Int,
        @Path("address_id") addressId: Int,
        @Header("Authorization") tokenString: String
    )

    @POST("$INSTANCE/{id}/$ADDRESS")
    fun createInstanceAddress(
        @Path("id") instanceId: Int,
        @Body address: Address,
        @Header("Authorization") tokenString: String
    )

    @POST("$INSTANCE/{id}/$ADDRESS/update")
    fun updateInstanceAddress(
        @Path("id") instanceId: Int,
        @Body address: Address,
        @Header("Authorization") tokenString: String
    )

    @GET("$INSTANCE/page/{page_number}")
    fun getInstancePage(
        @Path("page_number") pageNumber: Int,
        @Header("Authorization") tokenString: String
    ): List<Instance>
}