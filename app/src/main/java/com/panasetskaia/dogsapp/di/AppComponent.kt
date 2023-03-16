package com.panasetskaia.dogsapp.di

import android.app.Application
import com.panasetskaia.dogsapp.presentation.AllDogsFragment
import com.panasetskaia.dogsapp.presentation.DogDetailsFragment
import com.panasetskaia.dogsapp.presentation.InitialFragment
import com.panasetskaia.dogsapp.presentation.MainActivity
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