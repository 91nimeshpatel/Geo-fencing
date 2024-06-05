package com.nimeshpatel.geofencing.di.module

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import androidx.work.WorkManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

/**
 * Created by Nimesh Patel on 05-Jun-24.
 * Purpose:
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    // Application level context
    @Singleton
    @Provides
    fun provideApplicationContext(app: Application): Context = app

    @Singleton // Provide always the same instance
    @Provides
    fun providesCoroutineScope(): CoroutineScope {
        // Run this code when providing an instance of CoroutineScope
        return CoroutineScope(SupervisorJob() + Dispatchers.Default)
    }
}
