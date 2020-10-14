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
    public suspend fun getInstance(instanceId: Int): Instance {
        return MyAPI().getInstance(instanceId, tokenString)
    }

    @Throws(IOException::class)
    public fun createInstance(instance: Instance) {
        MyAPI().createInstance(instance, tokenString)
    }

    @Throws(IOException::class)
    public fun updateInstance(instance: Instance) {
        MyAPI().updateInstance(instance, tokenString)
    }

    // Product
    @Throws(IOException::class)
    public fun getInstanceProducts(instanceId: Int): List<Product> {
        return MyAPI().getInstanceProducts(instanceId, tokenString)
    }

    @Throws(IOException::class)
    public fun createInstanceProduct(instanceId: Int, product: Product) {
        MyAPI().createInstanceProduct(instanceId, product, tokenString)
    }

    @Throws(IOException::class)
    public fun updateInstanceProduct(instanceId: Int, product: Product) {
        MyAPI().updateInstanceProduct(instanceId, product, tokenString)
    }

    @Throws(IOException::class)
    public fun deleteInstanceProduct(instanceId: Int, productId: Int) {
        MyAPI().deleteInstanceProduct(instanceId, productId, tokenString)
    }

    // Transaction
    @Throws(IOException::class)
    public fun getInstanceTransactions(instanceId: Int): List<Transaction> {
        return MyAPI().getInstanceTransactions(instanceId, tokenString)
    }

    @Throws(IOException::class)
    public fun findInstanceTransactions(instanceId: Int): List<Transaction> {
        return MyAPI().findInstanceTransactions(instanceId, tokenString)
    }

    @Throws(IOException::class)
    public fun getProductTransactions(instanceId: Int, productId: Int): List<Transaction> {
        return MyAPI().getProductTransactions(instanceId, productId, tokenString)
    }

    @Throws(IOException::class)
    public fun deleteInstanceTransactions(instanceId: Int, transactionId: Int) {
        MyAPI().deleteInstanceTransaction(instanceId, transactionId, tokenString)
    }

    @Throws(IOException::class)
    public fun createInstanceTransaction(instanceId: Int, transaction: Transaction) {
        MyAPI().createInstanceTransaction(instanceId, transaction, tokenString)
    }

    @Throws(IOException::class)
    public fun updateInstanceTransaction(instanceId: Int, transaction: Transaction) {
        MyAPI().updateInstanceTransaction(instanceId, transaction, tokenString)
    }

    @Throws(IOException::class)
    public fun getInstanceInvoices(instanceId: Int) {
        MyAPI().getInstanceInvoices(instanceId, tokenString)
    }

    @Throws(IOException::class)
    public fun getInstanceInvoice(instanceId: Int, invoiceId: Int) {
        MyAPI().getInstanceInvoice(instanceId, invoiceId, tokenString)
    }

    @Throws(IOException::class)
    public fun deleteInstanceInvoice(instanceId: Int, invoiceId: Int) {
        MyAPI().deleteInstanceInvoice(instanceId, invoiceId, tokenString)
    }

    @Throws(IOException::class)
    public fun createInstanceInvoice(instanceId: Int, invoice: Invoice) {
        MyAPI().createInstanceInvoice(instanceId, invoice, tokenString)
    }

    @Throws(IOException::class)
    public fun updateInstanceInvoice(instanceId: Int, invoice: Invoice) {
        MyAPI().updateInstanceInvoice(instanceId, invoice, tokenString)
    }

    @Throws(IOException::class)
    public fun getInstanceSeries(instanceId: Int): List<Instance> {
        return MyAPI().getInstanceSeries(instanceId, tokenString)
    }

    @Throws(IOException::class)
    public fun getInstanceTotal(instanceId: Int): List<Instance> {
        return MyAPI().getInstanceTotal(instanceId, tokenString)
    }

    @Throws(IOException::class)
    public fun getInstanceRevenue(instanceId: Int): List<Instance> {
        return MyAPI().getInstanceRevenue(instanceId, tokenString)
    }

    // Customer
    @Throws(IOException::class)
    public fun getInstanceCustomers(instanceId: Int): List<Customer> {
        return MyAPI().getInstanceCustomers(instanceId, tokenString)
    }

    @Throws(IOException::class)
    public fun getInstanceCustomer(instanceId: Int, customerId: Int): Customer {
        return MyAPI().getInstanceCustomer(instanceId, customerId, tokenString)
    }

    @Throws(IOException::class)
    public fun deleteInstanceCustomer(instanceId: Int, customerId: Int) {
        MyAPI().deleteInstanceCustomer(instanceId, customerId, tokenString)
    }

    @Throws(IOException::class)
    public fun createInstanceCustomer(instanceId: Int, customer: Customer) {
        MyAPI().createInstanceCustomer(instanceId, customer, tokenString)
    }

    @Throws(IOException::class)
    public fun updateInstanceCustomer(instanceId: Int, customer: Customer) {
        MyAPI().updateInstanceCustomer(instanceId, customer, tokenString)
    }

    // User
    @Throws(IOException::class)
    public fun getInstanceUsers(instanceId: Int): List<SubUser> {
        return MyAPI().getInstanceUsers(instanceId, tokenString)
    }

    @Throws(IOException::class)
    public fun getInstanceUser(instanceId: Int, userId: Int): SubUser {
        return MyAPI().getInstanceUser(instanceId, userId, tokenString)
    }

    @Throws(IOException::class)
    public fun deleteInstanceUser(instanceId: Int, userId: Int) {
        MyAPI().deleteInstanceUser(instanceId, userId, tokenString)
    }

    @Throws(IOException::class)
    public fun createInstanceUser(instanceId: Int, user: User) {
        MyAPI().createInstanceUser(instanceId, user, tokenString)
    }

    @Throws(IOException::class)
    public fun updateInstanceUser(instanceId: Int, user: User) {
        MyAPI().updateInstanceUser(instanceId, user, tokenString)
    }

    // Address
    @Throws(IOException::class)
    public fun getInstanceAddresses(instanceId: Int): List<Address> {
        return MyAPI().getInstanceAddresses(instanceId, tokenString)
    }

    @Throws(IOException::class)
    public fun deleteInstanceAddress(instanceId: Int, addressId: Int) {
        MyAPI().deleteInstanceAddress(instanceId, addressId, tokenString)
    }

    @Throws(IOException::class)
    public fun createInstanceAddress(instanceId: Int, address: Address) {
        MyAPI().createInstanceAddress(instanceId, address, tokenString)
    }

    @Throws(IOException::class)
    public fun updateInstanceAddress(instanceId: Int, address: Address) {
        MyAPI().updateInstanceAddress(instanceId, address, tokenString)
    }

    @Throws(IOException::class)
    public fun getInstancePage(pageNumber: Int): List<Instance> {
        return MyAPI().getInstancePage(pageNumber, tokenString)
    }
}