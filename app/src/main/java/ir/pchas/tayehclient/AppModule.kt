package ir.pchas.tayehclient

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.pchas.tayehclient.repository.network.TayehNetworkDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
public object AppModule {
//    @Provides
//    @Singleton
//    public fun provideOkHttpClient(): TayehNetworkDataSource =
//        TayehNetworkDataSource(INSTANCE_ID =  11 , TOKEN = "sda")

}