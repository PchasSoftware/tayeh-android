# Tayeh client

This is official android client for Tayeh platform.

-   Easy to Use
-   Compatible
-   Comprehensive
## ![introduction](https://img.icons8.com/nolan/40/training.png) Introduction:
Hello. I hope you are well =))
We are proud that on behalf of [Pchas Company](https://pchas.ir/) , we can provide our new technology to you, dear developers and users.
### A little about Tayeh:
The tools we provide here are part of a larger project called Tayeh.
Tayeh provides a complete and convenient environment for you so that you can easily do all the steps related to the expansion of your business.
For more information, visit the [Tayeh website](https://tayeh.ir/).
### The purpose of this project:
In "Tayeh" we provide users with the opportunity to use information about themselves and expand their business online.
Now we want to give a special opportunity to developers in this regard who can use our API and no longer need to develop the server side and create data storage tables.
Finally, we went a step further and created an API client library to minimize your workload and save you a lot of time.
In short, we have made everything easier. Don't you think so? ;)
Where is this library now and how should it be used? I will tell you.
Lets start...
## ![start](https://img.icons8.com/nolan/40/start.png) get started:
You need to do something before installing the library.
Go to the [Tayeh website](https://tayeh.ir/) and get `API_KEY` as your username and `API_SECRET` as your password by following the steps described there.
We can now start the installation using this information...
### Installation and Usage:
Add this line to `gradle.build` app level :
```
implement 'tayehclent'
```
Now, in your project you can defint client object:
```kotlin
val tayehClient = TayehClient(API_KEY, API_SECRET)
```
After creating an instance in the project and sending the input arguments, a custom `API _ACCESS` will be generated for you to use in the library's internal requests.

## ![speaker](https://img.icons8.com/nolan/40/speaker.png) Requests:
Library API requests are currently categorized into `User`, `Instance`, and `Media` classes.
In this document, we try to provide you with a complete guide for using the functions of these libraries. Be sure to read this guide first.
Then it is enough to call the equivalent method from the created instance to achieve the desired result.
for example:

```kotlin
//Get a Instance with an ID 
val instance = tayehClient.getInstance(2)
```

We start the guide here...

### Instance:
Method title|Input Arguments| output
|-|-|-
| `getInstance` |`instanceId: Int`| `Instance`
| `createInstance` |`instance: Instance`|
| `updateInstance` |`instance: Instance`|
| `getInstancePage` |`pageNumber:  Int` | `Int`
| `getInstanceProducts` |`instanceId:  Int` | `List<Product>`
| `createInstanceProduct` |`instanceId:  Int, product:  Product` |
| `deleteInstanceProduct` |`instanceId:  Int, productId:  Int`|
| `updateInstanceProduct` |`instanceId:  Int, product:  Product`|
| `getInstanceTransactions` |`instanceId:  Int`| `List<Transaction>`
| `findInstanceTransactions` |`instanceId:  Int`| `List<Transaction>`
| `getProductTransactions` |`instanceId:  Int, productId:  Int`| `List<Transaction>`
| `deleteInstanceTransaction` |`instanceId:  Int, transactionId:  Int`|
| `createInstanceTransaction` |`instanceId:  Int, transaction:  Transaction`|
| `updateInstanceTransaction` |`instanceId:  Int, transaction:  Transaction`|
| `getInstanceInvoices` |`instanceId:  Int`| `List<Invoice>`
| `getInstanceInvoice` |`instanceId:  Int, invoiceId:  Int`| `Invoice`
| `deleteInstanceInvoice` |`instanceId:  Int, invoiceId:  Int`|
| `createInstanceInvoice` |`instanceId:  Int, invoice:  Invoice`|
| `updateInstanceInvoice` |`instanceId:  Int, invoice:  Invoice`|
| `getInstanceSeries` |`instanceId:  Int`| `List<Instance>`
| `getInstanceTotal` |`instanceId:  Int`| `List<Instance>`
| `getInstanceRevenue` |`instanceId:  Int`| `List<Instance>`
| `getInstanceCustomers` |`instanceId:  Int`| `List<Customer>`
| `getInstanceCustomer` |`instanceId:  Int, customerId:  Int`| `Customer`
| `deleteInstanceCustomer` |`instanceId:  Int, customerId:  Int`|
| `createInstanceCustomer` |`instanceId:  Int, customer:  Customer`|
| `updateInstanceCustomer` |`instanceId:  Int, customer:  Customer`|
| `getInstanceUsers` |`instanceId:  Int`| `List<SubUser>`
| `getInstanceUser` |`instanceId:  Int, userId:  Int`)| `SubUser`
| `deleteInstanceUser` |`instanceId:  Int, userId:  Int`|
| `createInstanceUser` |`instanceId:  Int, user:  User`|
| `updateInstanceUser` |`instanceId:  Int, user:  User`|
| `getInstanceAddresses` |`instanceId:  Int`| `List<Address>`
| `deleteInstanceAddress` |`instanceId:  Int, addressId:  Int`|
| `createInstanceAddress` |`instanceId:  Int, address:  Address`|
| `updateInstanceAddress` |`instanceId:  Int, address:  Address`|

### User:
Method title|Input Arguments|Output
|-|-|-
| `getUserMe` | | `SubUser`
| `getInstancePrimary` || `Instance`
| `createInstancePrimary` |`instance: Instance` |
| `getUserInstances` | | `Instance`
### Media:
Method title|Input Arguments|Outputs
|-|-|-
| `getMedia` | `media_id:  Int`| `Media`
| `createMedia` | `media:  Media`| -
## ![contribution](https://img.icons8.com/cotton/40/crowdfunding.png) Contribution:
Contributions are welcome. Please submit an issue if you see something broken or in need of improving.
You can also contact us through the communication channels mentioned in [Tayeh](https://tayeh.ir/) and [Pchas Company](https://pchas.ir/) websites.
Thanks for your support.
