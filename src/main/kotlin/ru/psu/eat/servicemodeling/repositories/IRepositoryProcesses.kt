package ru.psu.eat.servicemodeling.repositories

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.psu.eat.servicemodeling.model.CProcess
import java.util.*

/********************************************************************************************************
 * Интерфейс с заголовками методов для доступа к данным в СУБД.                                         *
 * @author Селетков И.П. 2023 0128.                                                                     *
 *******************************************************************************************************/
@Repository
interface IRepositoryProcesses              : CrudRepository<CProcess, UUID>
{
    //Типовые методы наследуются из интерфйса CrudRepository

    /****************************************************************************************************
     * Список студентов с именем name (реализуется средствами Spring по наименованию метода).           *
     * @param name - имя для фильтрации студентов.                                                      *
     * @return список отфильтрованных студентов.                                                        *
     ***************************************************************************************************/
    fun findByName(
        name                                : String
    )                                       : List<CProcess>
}