package com.mkdev.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mkdev.domain.repository.NetworkStatsRepository
import com.mkdev.domain.usecase.GetPropertyListUseCase
import com.mkdev.presentation.factory.createMockPropertyModel
import com.mkdev.presentation.screen.propertyList.PropertyListUiState
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
class PropertyListViewModelTest {

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
    private lateinit var getPropertyListUseCase: GetPropertyListUseCase

    @Mock
    private lateinit var networkStatsRepository: NetworkStatsRepository

    private lateinit var propertyListViewModel: PropertyListViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        propertyListViewModel = PropertyListViewModel(getPropertyListUseCase)
        propertyListViewModel.properties.observeForever { }
    }

    @Test
    fun `fetchPropertyList should update properties with Loading state initially`() {
        // Given
        `when`(getPropertyListUseCase.invoke()).thenReturn(Single.never()) // Simulate ongoing loading

        // When
        propertyListViewModel.fetchPropertyList()

        // Then
        verify(getPropertyListUseCase).invoke()
        Assert.assertTrue(propertyListViewModel.properties.value is PropertyListUiState.Loading)
    }

    @Test
    fun `fetchPropertyList should update properties with Success state on success`() {
        // Given
        val propertyModelList = listOf(createMockPropertyModel())
        `when`(getPropertyListUseCase.invoke()).thenReturn(Single.just(propertyModelList))

        // When
        propertyListViewModel.fetchPropertyList()

        // Then
        verify(getPropertyListUseCase).invoke()
        Assert.assertTrue(propertyListViewModel.properties.value is PropertyListUiState.Success)
        val successState = propertyListViewModel.properties.value as PropertyListUiState.Success
        Assert.assertEquals(propertyModelList.size, successState.data.size)
    }

    @Test
    fun `fetchPropertyList should update properties with Error state on failure`() {
        // Given
        val throwable = Throwable("Network error")
        `when`(getPropertyListUseCase.invoke()).thenReturn(Single.error(throwable))

        // When
        propertyListViewModel.fetchPropertyList()

        // Then
        verify(getPropertyListUseCase).invoke()
        Assert.assertTrue(propertyListViewModel.properties.value is PropertyListUiState.Error)
        val errorState = propertyListViewModel.properties.value as PropertyListUiState.Error
        Assert.assertEquals(throwable, errorState.throwable)
    }
}