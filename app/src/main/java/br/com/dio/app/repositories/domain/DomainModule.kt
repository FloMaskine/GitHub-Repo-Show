package br.com.dio.app.repositories.domain

import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object DomainModule {

    fun load(){
        loadKoinModules(useCaseModules())
    }

    fun useCaseModules(): Module{
        return module {
            factory {
                ListUserRepositoriesUseCase(get())
            }
        }
    }

}