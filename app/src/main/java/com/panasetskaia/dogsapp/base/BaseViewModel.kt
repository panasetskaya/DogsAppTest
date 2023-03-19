package com.panasetskaia.dogsapp.base

import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.panasetskaia.navigation.NavigationCommand
import com.panasetskaia.utils.Event
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel : ViewModel() {

    private val _navigation = MutableStateFlow<Event<NavigationCommand>?>(null)
    val navigation: StateFlow<Event<NavigationCommand>?> get() = _navigation

    fun navigate(navDirections: NavDirections) {
        _navigation.value = Event(NavigationCommand.ToDirection(navDirections))
    }

    fun navigateBack() {
        _navigation.value = Event(NavigationCommand.Back)
    }

}