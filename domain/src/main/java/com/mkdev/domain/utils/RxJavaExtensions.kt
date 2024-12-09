package com.mkdev.domain.utils

import com.mkdev.domain.repository.NetworkStatsRepository
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

// For Single
internal fun <T> Single<T>.trackNetworkStats(
    repository: NetworkStatsRepository,
    action: String
): Single<T> {
    val startTime = System.currentTimeMillis()
    return this.doOnSuccess {
        val duration = System.currentTimeMillis() - startTime
        repository.trackNetworkStats(action, duration)
            .subscribeOn(Schedulers.io())
            .onErrorComplete()
            .subscribe()
    }
}

// For Completable
internal fun Completable.trackNetworkStats(
    repository: NetworkStatsRepository,
    action: String
): Completable {
    val startTime = System.currentTimeMillis()
    return this.doOnComplete {
        val duration = System.currentTimeMillis() - startTime
        repository.trackNetworkStats(action, duration)
            .subscribeOn(Schedulers.io())
            .onErrorComplete()
            .subscribe()
    }
}

// For Observable
internal fun <T> Observable<T>.trackNetworkStats(
    repository: NetworkStatsRepository,
    action: String
): Observable<T> {
    val startTime = System.currentTimeMillis()
    return this.doOnNext {
        val duration = System.currentTimeMillis() - startTime
        repository.trackNetworkStats(action, duration)
            .subscribeOn(Schedulers.io())
            .onErrorComplete()
            .subscribe()
    }
}

// For Maybe
internal fun <T> Maybe<T>.trackNetworkStats(
    repository: NetworkStatsRepository,
    action: String
): Maybe<T> {
    val startTime = System.currentTimeMillis()
    return this.doOnSuccess {
        val duration = System.currentTimeMillis() - startTime
        repository.trackNetworkStats(action, duration)
            .subscribeOn(Schedulers.io())
            .onErrorComplete()
            .subscribe()
    }
}