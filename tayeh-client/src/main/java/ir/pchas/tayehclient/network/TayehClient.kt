package ir.pchas.tayehclient.network

import ir.pchas.tayehclient.model.shop.Instance
import ir.pchas.tayehclient.model.shop.Product
import ir.pchas.tayehclient.model.user.User
import java.io.IOException
import kotlin.jvm.Throws

public class TayehClient(
    public val APIKey: String,
    public val APISecret: String,
) {

    private var token: String? = null
    private var tokenString = "Bearer $token"

    init {
        TODO("Get user token")
    }

    @Throws(IOException::class)
    public suspend fun getUserMe(): User {
        return MyAPI().getUserMe(tokenString)
    }

    @Throws(IOException::class)
    public suspend fun getInstancePrimary(): Instance {
        return MyAPI().getInstancePrimary(tokenString)
    }

    @Throws(IOException::class)
    public suspend fun createInstancePrimary(instanceId: Int) {
        MyAPI().createInstancePrimary(instanceId, tokenString)
    }

    // Instance
    @Throws(IOException::class)
    public suspend fun getInstance(instanceId: Int): Instance{
        return MyAPI().getInstance(instanceId, tokenString)
    }

    @Throws(IOException::class)
    public fun createInstance(instance: Instance){
        MyAPI().createInstance(instance, tokenString)
    }

    @Throws(IOException::class)
    public fun updateInstance(instance: Instance){
        MyAPI().updateInstance(instance, tokenString)
    }

    // Product
    @Throws(IOException::class)
    public fun getInstanceProducts(instanceId: Int): List<Product>{
        return MyAPI().getInstanceProducts(instanceId, tokenString)
    }

    @Throws(IOException::class)
    public fun createInstanceProduct(instanceId: Int, product: Product){
        MyAPI().createInstanceProduct(instanceId, product, tokenString)
    }

    @Throws(IOException::class)
    public fun updateInstanceProduct(instanceId: Int, product: Product){
        MyAPI().updateInstanceProduct(instanceId, product, tokenString)
    }

    @Throws(IOException::class)
    public fun deleteInstanceProduct(instanceId: Int, productId: Int){
        MyAPI().deleteInstanceProduct(instanceId, productId, tokenString)
    }

}