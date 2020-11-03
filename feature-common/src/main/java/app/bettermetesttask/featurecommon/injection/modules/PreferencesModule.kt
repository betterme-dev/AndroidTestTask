package app.bettermetesttask.featurecommon.injection.modules

import android.content.Context
import android.content.SharedPreferences
import app.bettermetesttask.domaincore.utils.preferences.Preferences
import app.bettermetesttask.featurecommon.R
import app.bettermetesttask.featurecommon.utils.preference.PreferencesImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class PreferencesModule {

    companion object {
        private const val PREFERENCE = "Preference"

        @Provides
        @Singleton
        fun provideSharedPreferencesInstance(context: Context): SharedPreferences =
            context.getSharedPreferences(context.getString(R.string.app_name) + PREFERENCE,
                Context.MODE_PRIVATE)
    }

    @Binds
    @Singleton
    abstract fun bindPreferences(preferencesImpl: PreferencesImpl): Preferences
}