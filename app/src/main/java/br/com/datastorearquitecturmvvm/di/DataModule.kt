package br.com.datastorearquitecturmvvm.di

import android.content.Context
import br.com.datastorearquitecturmvvm.repository.UserDataStoreImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {


    @Singleton
    @Provides
    fun provideDataStoreRepository(@ApplicationContext context: Context) = UserDataStoreImpl(context)
}