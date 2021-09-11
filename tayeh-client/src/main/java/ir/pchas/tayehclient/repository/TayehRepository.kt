package ir.pchas.tayehclient.repository

import ir.pchas.tayehclient.repository.network.TayehNetworkDataSource
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

public class TayehRepository @Inject constructor(
    private val instanceId: Int,
    private val instanceToken: String,
) {

    @Inject lateinit var tayehNetworkDataSource: TayehNetworkDataSource

    init {
        tayehNetworkDataSource.apply {
            retrieveInstanceId(instanceId)
            GlobalScope.launch {
                retrieveToken(instanceToken)
            }
        }
    }
}