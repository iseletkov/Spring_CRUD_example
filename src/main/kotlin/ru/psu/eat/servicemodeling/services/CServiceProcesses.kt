package ru.psu.eat.servicemodeling.services

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import ru.psu.eat.servicemodeling.model.CProcess
import ru.psu.eat.servicemodeling.repositories.IRepositoryProcesses
import java.util.*

/********************************************************************************************************
 * Сервис с бизнес-логикой для работы со списком процессов.                                             *
 * @author Селетков И.П. 2023 0128.                                                                     *
 *******************************************************************************************************/
@Service
class CServiceProcesses
/********************************************************************************************************
 * Конструктор.                                                                                         *
 * @param repositoryProcesses - репозиторий с запросами к таблице процессов в СУБД                      *
 * (устанавливается Spring-ом).                                                                         *
 *******************************************************************************************************/
(
    val repositoryProcesses                 : IRepositoryProcesses
)                                           : IServiceProcesses
{
    /****************************************************************************************************
     * Список всех объектов.                                                                            *
     ***************************************************************************************************/
    override fun getAll(
    )                                       : Iterable<CProcess>
    {
        return repositoryProcesses.findAll()
    }
    /****************************************************************************************************
     * Поиск объекта по идентификатору.                                                                 *
     * @param id - идентификатор объекта для поиска в формате UUID.                                     *
     ***************************************************************************************************/
    override fun getById(
        id                                  : UUID
    )                                       : ResponseEntity<CProcess>
    {
        return repositoryProcesses.findById(id)
            .map { item -> ResponseEntity.ok(item) }
            .orElse(ResponseEntity.notFound().build())
    }
    /****************************************************************************************************
     * Поиск объекта по наименованию.                                                                   *
     * @param name - наименование объекта для поиска.                                                   *
     ***************************************************************************************************/
    override fun getByName(
        name                                : String
    )                                       : Iterable<CProcess>
    {
        return repositoryProcesses.findByName(name)
    }
    /****************************************************************************************************
     * Создание/изменение объекта.                                                                      *
     * @param item - данные объекта.                                                                    *
     ***************************************************************************************************/
    override fun save(
        item                                : CProcess
    )
    {
        repositoryProcesses.save(item)
    }
    /****************************************************************************************************
     * Удаление объекта.                                                                                *
     * @param item - данные объекта.                                                                    *
     ***************************************************************************************************/
    override fun delete(
        item                                : CProcess
    )
    {
        repositoryProcesses.delete(item)
    }
    /****************************************************************************************************
     * Удаление объекта по идентификатору.                                                              *
     * @param id - идентификатор объекта для удаления.                                                  *
     ***************************************************************************************************/
    override fun deleteById(
        id                                  : UUID
    )                                       : ResponseEntity<String>
    {
        return repositoryProcesses.findById(id)
            .map { process->
                repositoryProcesses.delete(process)
                ResponseEntity.ok(process.id.toString())
            }
            .orElse(ResponseEntity.notFound().build())
    }
}