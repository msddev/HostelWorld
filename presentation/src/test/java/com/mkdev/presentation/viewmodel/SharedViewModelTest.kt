package com.mkdev.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mkdev.presentation.factory.createMockPricePerNightModel
import com.mkdev.presentation.factory.createMockPropertyModel
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class SharedViewModelTest {

    /**
     *  This rule ensures that LiveData updates happen synchronously,
     *  avoiding the need for a main looper.
     */
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var sharedViewModel: SharedViewModel

    @Before
    fun setUp() {
        sharedViewModel = SharedViewModel()
    }

    @Test
    fun `setSelectedProperty should update selectedProperty LiveData`() {
        // Given
        val property = createMockPropertyModel()

        // When
        sharedViewModel.setSelectedProperty(property)

        // Then
        Assert.assertEquals(property, sharedViewModel.selectedProperty.value)
    }

    @Test
    fun `setPropertyBasePrice should update propertyBasePrice`() {
        // Given
        val price = createMockPricePerNightModel()

        // When
        sharedViewModel.setPropertyBasePrice(price)

        // Then
        Assert.assertEquals(price, sharedViewModel.getPropertyBasePrice())
    }
}