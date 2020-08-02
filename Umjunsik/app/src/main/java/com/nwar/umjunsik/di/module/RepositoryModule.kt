package com.nwar.umjunsik.di.module

import com.nwar.data.builder.API
import com.nwar.data.repository.*
import com.nwar.domain.repository.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule() {
    @Singleton
    @Provides
    fun accountRepository(api : API) : AccountRepository = AccountRepositoryImpl(api)

    @Singleton
    @Provides
    fun checkDuplicateRepository(api : API) : CheckDuplicateRepository = CheckDuplicateRepositoryImpl(api)

    @Singleton
    @Provides
    fun likeItemRepository(api : API) : LikeItemRepository = LikeItemRepositoryImpl(api)

    @Singleton
    @Provides
    fun loadListRepository(api : API) : LoadListRepository = LoadListRepositoryImpl(api)

    @Singleton
    @Provides
    fun videoURLRepository(api : API) : VideoURLRepository = VideoURLRepositoryImpl(api)

    @Singleton
    @Provides
    fun voteRepository(api : API) : VoteRepository = VoteRepositoryImpl(api)
}