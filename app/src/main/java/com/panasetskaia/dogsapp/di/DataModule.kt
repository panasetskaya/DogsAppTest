package com.panasetskaia.dogsapp.di

import com.panasetskaia.dogsapp.data.ApiFactory
import com.panasetskaia.dogsapp.data.ApiService
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    companion object {

        @DogsAppScope
        @Provides
        fun provideApi(): ApiService {
            return ApiFactory.apiService
        }
    }
}