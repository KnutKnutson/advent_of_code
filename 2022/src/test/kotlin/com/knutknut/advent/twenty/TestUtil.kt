package com.knutknut.advent.twenty

object TestUtil {
  fun loadResource(name: String): List<String> {
    return ClassLoader.getSystemResource(name).readText().lines()
  }
}