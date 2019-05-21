package com.aytel

import java.io.File
import java.lang.Exception
import java.lang.IllegalArgumentException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths


/** Renames all files in given directory with extensions .kt or .java, adding to their names .2019 */
class Renamer {
    companion object {
        fun rename(path: String) {
            val start: Path = Paths.get(path)

            Files.walk(start).forEach { p ->
                try {
                    val cur = File(p.toUri())
                    if (cur.isFile && (cur.extension == "java" || cur.extension == "kt")) {
                        cur.renameTo(File(cur.path + ".2019"))
                        println("Renamed ${cur.path}.")
                    }
                } catch (e: Exception) {
                    println("Can't rename ${p.fileName}.")
                }
            }
        }
    }
}