package ru.psu.eat.servicemodeling

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CApplication

fun main(args: Array<String>) {
	runApplication<CApplication>(*args)
}
