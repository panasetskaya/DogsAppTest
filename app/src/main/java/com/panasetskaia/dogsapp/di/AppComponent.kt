package com.panasetskaia.dogsapp.di

import android.app.Application
import com.panasetskaia.dogsapp.presentation.screen_all_dogs.AllDogsFragment
import com.panasetskaia.dogsapp.presentation.screen_initial.InitialFragment
import com.panasetskaia.dogsapp.presentation.MainActivity
import com.panasetskaia.dogsapp.presentation.screen_details.DogDetailsFragment
import dagger.BindsInstance
import dagger.Component

@DogsAppScope
@Component(modules = [DataModule::class, ViewModelModule::class])
interface AppComponent {

    fun inject(activity: MainActivity)

    fun inject(fragment: AllDogsFragment)

    fun inject(fragment: InitialFragment)

    fun inject(fragment: DogDetailsFragment)

    @Component.Factory
    interface AppComponentFactory {
        fun create(@BindsInstance application: Application): AppComponent
    }

}