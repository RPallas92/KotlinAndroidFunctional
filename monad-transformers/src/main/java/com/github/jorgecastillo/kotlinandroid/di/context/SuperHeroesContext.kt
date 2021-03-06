package com.github.jorgecastillo.kotlinandroid.di.context

import android.content.Context
import com.github.jorgecastillo.kotlinandroid.BuildConfig
import com.github.jorgecastillo.kotlinandroid.presentation.HeroesView
import com.github.jorgecastillo.kotlinandroid.presentation.SuperHeroDetailView
import com.github.jorgecastillo.kotlinandroid.presentation.SuperHeroesListView
import com.github.jorgecastillo.kotlinandroid.presentation.navigation.HeroDetailsPage
import com.karumi.marvelapiclient.CharacterApiClient
import com.karumi.marvelapiclient.MarvelApiConfig.Builder

sealed class SuperHeroesContext(ctx: Context) {

  abstract val view: HeroesView

  val heroDetailsPage = HeroDetailsPage()
  val apiClient
    get() = CharacterApiClient(Builder(
        BuildConfig.MARVEL_PUBLIC_KEY,
        BuildConfig.MARVEL_PRIVATE_KEY).debug().build())

  data class GetHeroesContext(val ctx: Context, override val view: SuperHeroesListView) : SuperHeroesContext(ctx)
  data class GetHeroDetailsContext(val ctx: Context, override val view: SuperHeroDetailView) : SuperHeroesContext(ctx)
}
