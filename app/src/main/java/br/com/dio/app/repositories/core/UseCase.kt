package br.com.dio.app.repositories.core

import br.com.dio.app.repositories.data.model.Repo
import kotlinx.coroutines.flow.Flow
import retrofit2.Call

abstract class UseCase<Param, Source> {
    abstract suspend fun execute(param: Param): Flow<List<Repo>>

    open suspend operator fun invoke(param: Param) = execute(param)

    abstract class NoParam<Source> : UseCase<None, Flow<Source>>() {
        abstract suspend fun execute(): Flow<Source>

        final override suspend fun execute(param: None) =
            throw UnsupportedOperationException()

        suspend operator fun invoke(): Flow<Source> = execute()
    }

    abstract class NoSource<Params> : UseCase<Params, Unit>() {
        override suspend operator fun invoke(param: Params) = execute(param)
    }

    object None
}