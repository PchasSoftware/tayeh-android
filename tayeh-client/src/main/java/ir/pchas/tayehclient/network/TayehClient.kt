package ir.pchas.tayehclient.network

import ir.pchas.tayehclient.model.shop.Instance
import ir.pchas.tayehclient.model.shop.Invoice
import ir.pchas.tayehclient.model.shop.Product
import ir.pchas.tayehclient.model.shop.Transaction
import ir.pchas.tayehclient.model.user.Address
import ir.pchas.tayehclient.model.user.Customer
import ir.pchas.tayehclient.model.user.SubUser
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
    public suspend fun getUserMe(): User = MyAPI().getUserMe(tokenString)

    @Throws(IOException::class)
    public suspend fun getInstancePrimary(): Instance = MyAPI().getInstancePrimary(tokenString)

    @Throws(IOException::class)
    public suspend fun createInstancePrimary(instanceId: Int): Unit =
        MyAPI().createInstancePrimary(instanceId, tokenString)

    // Instance
    @Throws(IOException::class)
    public suspend fun getInstance(instanceId: Int): Instance =
        MyAPI().getInstance(instanceId, tokenString)

    @Throws(IOException::class)
    public fun createInstance(instance: Instance): Unit =
        MyAPI().createInstance(instance, tokenString)

    @Throws(IOException::class)
    public fun updateInstance(instance: Instance): Unit =
        MyAPI().updateInstance(instance, tokenString)

    // Product
    @Throws(IOException::class)
    public fun getInstanceProducts(instanceId: Int): List<Product> =
        MyAPI().getInstanceProducts(instanceId, tokenString)

    @Throws(IOException::class)
    public fun createInstanceProduct(instanceId: Int, product: Product): Unit =
        MyAPI().createInstanceProduct(instanceId, product, tokenString)

    @Throws(IOException::class)
    public fun updateInstanceProduct(instanceId: Int, product: Product): Unit =
        MyAPI().updateInstanceProduct(instanceId, product, tokenString)

    @Throws(IOException::class)
    public fun deleteInstanceProduct(instanceId: Int, productId: Int): Unit =
        MyAPI().deleteInstanceProduct(instanceId, productId, tokenString)

    // Transaction
    @Throws(IOException::class)
    public fun getInstanceTransactions(instanceId: Int): List<Transaction> =
        MyAPI().getInstanceTransactions(instanceId, tokenString)

    @Throws(IOException::class)
    public fun findInstanceTransactions(instanceId: Int): List<Transaction> =
        MyAPI().findInstanceTransactions(instanceId, tokenString)

    @Throws(IOException::class)
    public fun getProductTransactions(instanceId: Int, productId: Int): List<Transaction> =
        MyAPI().getProductTransactions(instanceId, productId, tokenString)

    @Throws(IOException::class)
    public fun deleteInstanceTransactions(instanceId: Int, transactionId: Int): Unit =
        MyAPI().deleteInstanceTransaction(instanceId, transactionId, tokenString)

    @Throws(IOException::class)
    public fun createInstanceTransaction(instanceId: Int, transaction: Transaction): Unit =
        MyAPI().createInstanceTransaction(instanceId, transaction, tokenString)

    @Throws(IOException::class)
    public fun updateInstanceTransaction(instanceId: Int, transaction: Transaction): Unit =
        MyAPI().updateInstanceTransaction(instanceId, transaction, tokenString)

    @Throws(IOException::class)
    public fun getInstanceInvoices(instanceId: Int): Unit =
        MyAPI().getInstanceInvoices(instanceId, tokenString)

    @Throws(IOException::class)
    public fun getInstanceInvoice(instanceId: Int, invoiceId: Int): Unit =
        MyAPI().getInstanceInvoice(instanceId, invoiceId, tokenString)

    @Throws(IOException::class)
    public fun deleteInstanceInvoice(instanceId: Int, invoiceId: Int): Unit =
        MyAPI().deleteInstanceInvoice(instanceId, invoiceId, tokenString)

    @Throws(IOException::class)
    public fun createInstanceInvoice(instanceId: Int, invoice: Invoice): Unit =
        MyAPI().createInstanceInvoice(instanceId, invoice, tokenString)

    @Throws(IOException::class)
    public fun updateInstanceInvoice(instanceId: Int, invoice: Invoice): Unit =
        MyAPI().updateInstanceInvoice(instanceId, invoice, tokenString)

    @Throws(IOException::class)
    public fun getInstanceSeries(instanceId: Int): List<Instance> =
        MyAPI().getInstanceSeries(instanceId, tokenString)

    @Throws(IOException::class)
    public fun getInstanceTotal(instanceId: Int): List<Instance> =
        MyAPI().getInstanceTotal(instanceId, tokenString)

    @Throws(IOException::class)
    public fun getInstanceRevenue(instanceId: Int): List<Instance> =
        MyAPI().getInstanceRevenue(instanceId, tokenString)

    // Customer
    @Throws(IOException::class)
    public fun getInstanceCustomers(instanceId: Int): List<Customer> =
        MyAPI().getInstanceCustomers(instanceId, tokenString)

    @Throws(IOException::class)
    public fun getInstanceCustomer(instanceId: Int, customerId: Int): Customer =
        MyAPI().getInstanceCustomer(instanceId, customerId, tokenString)

    @Throws(IOException::class)
    public fun deleteInstanceCustomer(instanceId: Int, customerId: Int): Unit =
        MyAPI().deleteInstanceCustomer(instanceId, customerId, tokenString)

    @Throws(IOException::class)
    public fun createInstanceCustomer(instanceId: Int, customer: Customer): Unit =
        MyAPI().createInstanceCustomer(instanceId, customer, tokenString)

    @Throws(IOException::class)
    public fun updateInstanceCustomer(instanceId: Int, customer: Customer): Unit =
        MyAPI().updateInstanceCustomer(instanceId, customer, tokenString)

    // User
    @Throws(IOException::class)
    public fun getInstanceUsers(instanceId: Int): List<SubUser> =
        MyAPI().getInstanceUsers(instanceId, tokenString)

    @Throws(IOException::class)
    public fun getInstanceUser(instanceId: Int, userId: Int): SubUser =
        MyAPI().getInstanceUser(instanceId, userId, tokenString)

    @Throws(IOException::class)
    public fun deleteInstanceUser(instanceId: Int, userId: Int): Unit =
        MyAPI().deleteInstanceUser(instanceId, userId, tokenString)

    @Throws(IOException::class)
    public fun createInstanceUser(instanceId: Int, user: User): Unit =
        MyAPI().createInstanceUser(instanceId, user, tokenString)

    @Throws(IOException::class)
    public fun updateInstanceUser(instanceId: Int, user: User): Unit =
        MyAPI().updateInstanceUser(instanceId, user, tokenString)

    // Address
    @Throws(IOException::class)
    public fun getInstanceAddresses(instanceId: Int): List<Address> =
        MyAPI().getInstanceAddresses(instanceId, tokenString)

    @Throws(IOException::class)
    public fun deleteInstanceAddress(instanceId: Int, addressId: Int): Unit =
        MyAPI().deleteInstanceAddress(instanceId, addressId, tokenString)

    @Throws(IOException::class)
    public fun createInstanceAddress(instanceId: Int, address: Address): Unit =
        MyAPI().createInstanceAddress(instanceId, address, tokenString)

    @Throws(IOException::class)
    public fun updateInstanceAddress(instanceId: Int, address: Address): Unit =
        MyAPI().updateInstanceAddress(instanceId, address, tokenString)

    @Throws(IOException::class)
    public fun getInstancePage(pageNumber: Int): List<Instance> =
        MyAPI().getInstancePage(pageNumber, tokenString)
}