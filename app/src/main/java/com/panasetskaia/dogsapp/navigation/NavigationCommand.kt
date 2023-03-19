package com.panasetskaia.dogsapp.navigation

import androidx.navigation.NavDirections

sealed class NavigationCommand {
    data class ToDirection(val directions: NavDirections) : NavigationCommand()
    object Back : NavigationCommand()
}