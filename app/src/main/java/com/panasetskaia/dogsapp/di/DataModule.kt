package com.panasetskaia.dogsapp.di

import com.panasetskaia.dogsapp.data.ApiFactory
import com.panasetskaia.dogsapp.data.ApiService
import com.panasetskaia.dogsapp.data.DogRepositoryImpl
import com.panasetskaia.dogsapp.domain.DogRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @DogsAppScope
    @Binds
    fun bindRepo(repoImpl: DogRepositoryImpl): DogRepository

    companion object {

        @DogsAppScope
        @Provides
        fun provideApi(): ApiService {
            return ApiFactory.apiService
        }
    }
}