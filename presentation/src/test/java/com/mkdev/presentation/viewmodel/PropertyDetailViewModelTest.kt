package com.mkdev.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mkdev.domain.usecase.GetExchangeRatesUseCase
import com.mkdev.presentation.factory.createMockExchangeRatesEntity
import com.mkdev.presentation.mapper.toExchangeRatesModel
import com.mkdev.presentation.screen.propertyDetail.ExchangeRateUiState
import com.mkdev.presentation.util.RxImmediateSchedulerRule
import io.reactivex.Single
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PropertyDetailViewModelTest {

    /**
     *  This code ensures that when you're testing code that uses RxJava,
     *  all the asynchronous operations happen immediately and on the same thread as your test.
     *  This makes your tests more reliable and easier to write.
     */
    @get:Rule
    val schedulers = RxImmediateSchedulerRule()

    /**
     *  This rule ensures that LiveData updates happen synchronously,
     *  avoiding the need for a main looper.
     */
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var getExchangeRatesUseCase: GetExchangeRatesUseCase

    private lateinit var propertyDetailViewModel: PropertyDetailViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        propertyDetailViewModel = PropertyDetailViewModel(getExchangeRatesUseCase)
        propertyDetailViewModel.exchangeRates.observeForever { }
    }

    @Test
    fun `fetchExchangeRates should update exchangeRates with Loading state initially`() {
        // Given
        `when`(getExchangeRatesUseCase.invoke()).thenReturn(Single.never())

        // When
        propertyDetailViewModel.fetchExchangeRates()

        // Then
        verify(getExchangeRatesUseCase).invoke()
        Assert.assertTrue(propertyDetailViewModel.exchangeRates.value is ExchangeRateUiState.Loading)
    }

    @Test
    fun `fetchExchangeRates should update exchangeRates with Success state on success`() {
        // Given
        val exchangeRatesEntity = createMockExchangeRatesEntity()
        `when`(getExchangeRatesUseCase.invoke()).thenReturn(Single.just(exchangeRatesEntity))

        // When
        propertyDetailViewModel.fetchExchangeRates()

        // Then
        verify(getExchangeRatesUseCase).invoke()
        Assert.assertTrue(propertyDetailViewModel.exchangeRates.value is ExchangeRateUiState.Success)
        val successState =
            propertyDetailViewModel.exchangeRates.value as ExchangeRateUiState.Success
        Assert.assertEquals(
            exchangeRatesEntity.toExchangeRatesModel(),
            successState.data
        )
    }

    @Test
    fun `fetchExchangeRates should update exchangeRates with Error state on failure`() {
        // Given
        val throwable = Throwable("Network error")
        `when`(getExchangeRatesUseCase.invoke()).thenReturn(Single.error(throwable))

        // When
        propertyDetailViewModel.fetchExchangeRates()

        // Then
        verify(getExchangeRatesUseCase).invoke()
        Assert.assertTrue(propertyDetailViewModel.exchangeRates.value is ExchangeRateUiState.Error)
        val errorState = propertyDetailViewModel.exchangeRates.value as ExchangeRateUiState.Error
        Assert.assertEquals(throwable, errorState.throwable)
    }
}