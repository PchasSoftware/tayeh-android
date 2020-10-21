package ir.pchas.tayehclient.network

import ir.pchas.tayehclient.model.shop.Instance
import ir.pchas.tayehclient.model.shop.Invoice
import ir.pchas.tayehclient.model.shop.Product
import ir.pchas.tayehclient.model.shop.Transaction
import ir.pchas.tayehclient.model.user.Address
import ir.pchas.tayehclient.model.user.Customer
import ir.pchas.tayehclient.model.user.SubUser
import ir.pchas.tayehclient.model.user.User

public class TayehClient(
    APIKey: String,
    APISecret: String,
) {

    private var token: String? = null
    private var tokenString = "Bearer $token"

    init {
        token = MyAPI().getToken(APIKey, APISecret)
    }

    public suspend fun getUserMe(): User = MyAPI().getUserMe(tokenString)
    
    public suspend fun getInstancePrimary(): Instance = MyAPI().getInstancePrimary(tokenString)

    public suspend fun createInstancePrimary(instanceId: Int): Unit =
        MyAPI().createInstancePrimary(instanceId, tokenString)

    // Instance
    public suspend fun getInstance(instanceId: Int): Instance =
        MyAPI().getInstance(instanceId, tokenString)

    public fun createInstance(instance: Instance): Unit =
        MyAPI().createInstance(instance, tokenString)

    public fun updateInstance(instance: Instance): Unit =
        MyAPI().updateInstance(instance, tokenString)

    // Product
    public fun getInstanceProducts(instanceId: Int): List<Product> =
        MyAPI().getInstanceProducts(instanceId, tokenString)

    public fun createInstanceProduct(instanceId: Int, product: Product): Unit =
        MyAPI().createInstanceProduct(instanceId, product, tokenString)

    public fun updateInstanceProduct(instanceId: Int, product: Product): Unit =
        MyAPI().updateInstanceProduct(instanceId, product, tokenString)

    public fun deleteInstanceProduct(instanceId: Int, productId: Int): Unit =
        MyAPI().deleteInstanceProduct(instanceId, productId, tokenString)

    // Transaction
    public fun getInstanceTransactions(instanceId: Int): List<Transaction> =
        MyAPI().getInstanceTransactions(instanceId, tokenString)

    public fun findInstanceTransactions(instanceId: Int): List<Transaction> =
        MyAPI().findInstanceTransactions(instanceId, tokenString)

    public fun getProductTransactions(instanceId: Int, productId: Int): List<Transaction> =
        MyAPI().getProductTransactions(instanceId, productId, tokenString)

    public fun deleteInstanceTransactions(instanceId: Int, transactionId: Int): Unit =
        MyAPI().deleteInstanceTransaction(instanceId, transactionId, tokenString)

    public fun createInstanceTransaction(instanceId: Int, transaction: Transaction): Unit =
        MyAPI().createInstanceTransaction(instanceId, transaction, tokenString)

    public fun updateInstanceTransaction(instanceId: Int, transaction: Transaction): Unit =
        MyAPI().updateInstanceTransaction(instanceId, transaction, tokenString)

    public fun getInstanceInvoices(instanceId: Int): Unit =
        MyAPI().getInstanceInvoices(instanceId, tokenString)

    public fun getInstanceInvoice(instanceId: Int, invoiceId: Int): Unit =
        MyAPI().getInstanceInvoice(instanceId, invoiceId, tokenString)

    public fun deleteInstanceInvoice(instanceId: Int, invoiceId: Int): Unit =
        MyAPI().deleteInstanceInvoice(instanceId, invoiceId, tokenString)

    public fun createInstanceInvoice(instanceId: Int, invoice: Invoice): Unit =
        MyAPI().createInstanceInvoice(instanceId, invoice, tokenString)

    public fun updateInstanceInvoice(instanceId: Int, invoice: Invoice): Unit =
        MyAPI().updateInstanceInvoice(instanceId, invoice, tokenString)

    public fun getInstanceSeries(instanceId: Int): List<Instance> =
        MyAPI().getInstanceSeries(instanceId, tokenString)

    public fun getInstanceTotal(instanceId: Int): List<Instance> =
        MyAPI().getInstanceTotal(instanceId, tokenString)

    public fun getInstanceRevenue(instanceId: Int): List<Instance> =
        MyAPI().getInstanceRevenue(instanceId, tokenString)

    // Customer
    public fun getInstanceCustomers(instanceId: Int): Customer =
        MyAPI().getCustomerMe(instanceId, tokenString)

    public fun registerCustomer(instanceId: Int, customer: Customer): Unit =
        MyAPI().registerCustomer(instanceId, customer, tokenString)

    public fun loginCustomer(instanceId: Int, customer: Customer): Unit =
        MyAPI().loginCustomer(instanceId, customer, tokenString)

    public fun setReferenterCustomer(mobileNumber: String): Unit =
        MyAPI().setReferenterCustomer(mobileNumber, tokenString)

    // User
    public fun getInstanceUsers(instanceId: Int): List<SubUser> =
        MyAPI().getInstanceUsers(instanceId, tokenString)

    public fun getInstanceUser(instanceId: Int, userId: Int): SubUser =
        MyAPI().getInstanceUser(instanceId, userId, tokenString)

    public fun deleteInstanceUser(instanceId: Int, userId: Int): Unit =
        MyAPI().deleteInstanceUser(instanceId, userId, tokenString)

    public fun createInstanceUser(instanceId: Int, user: User): Unit =
        MyAPI().createInstanceUser(instanceId, user, tokenString)

    public fun updateInstanceUser(instanceId: Int, user: User): Unit =
        MyAPI().updateInstanceUser(instanceId, user, tokenString)

    // Address
    public fun getInstanceAddresses(instanceId: Int): List<Address> =
        MyAPI().getInstanceAddresses(instanceId, tokenString)

    public fun deleteInstanceAddress(instanceId: Int, addressId: Int): Unit =
        MyAPI().deleteInstanceAddress(instanceId, addressId, tokenString)

    public fun createInstanceAddress(instanceId: Int, address: Address): Unit =
        MyAPI().createInstanceAddress(instanceId, address, tokenString)

    public fun updateInstanceAddress(instanceId: Int, address: Address): Unit =
        MyAPI().updateInstanceAddress(instanceId, address, tokenString)

    public fun getInstancePage(pageNumber: Int): List<Instance> =
        MyAPI().getInstancePage(pageNumber, tokenString)
}