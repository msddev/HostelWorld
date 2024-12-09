package com.mkdev.hostelworld.di

import com.mkdev.data.datasource.remote.api.ExchangeRatesApi
import com.mkdev.data.datasource.remote.api.PropertyApi
import com.mkdev.data.repository.PropertyDetailRepositoryImpl
import com.mkdev.data.repository.PropertyRepositoryImpl
import com.mkdev.domain.repository.PropertyDetailRepository
import com.mkdev.domain.repository.PropertyRepository
import com.mkdev.domain.usecase.GetExchangeRatesUseCase
import com.mkdev.domain.usecase.GetPropertyListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    @Singleton
    fun providePropertyListUseCase(repository: PropertyRepository) =
        GetPropertyListUseCase(propertyRepository = repository)

    @Provides
    @Singleton
    fun providePropertyRepository(propertyApi: PropertyApi): PropertyRepository =
        PropertyRepositoryImpl(propertyApi = propertyApi)

    @Provides
    @Singleton
    fun provideExchangeRatesUseCase(repository: PropertyDetailRepository) =
        GetExchangeRatesUseCase(propertyDetailRepository = repository)

    @Provides
    @Singleton
    fun providePropertyDetailRepository(exchangeRatesApi: ExchangeRatesApi): PropertyDetailRepository =
        PropertyDetailRepositoryImpl(exchangeRatesApi = exchangeRatesApi)
}