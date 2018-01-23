package com.lemon.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class CodeLinesTask extends DefaultTask{

    def src
    def suffixs

    CodeLinesTask() {

    }

    @TaskAction
    def statisticsCodeLines() {
        def num
        // 空
        if (!src) {
            num = 0
        } else {
            num = countDir(src as String)
        }
        println "[$src] code lines : $num"
    }

    def countDir(String src) {
        def allLines = 0
        File dir = new File(src)
        dir.traverse {
            path -> allLines += countFile(path.getAbsolutePath())
        }
        return allLines
    }

    def countFile(String filePath) {
        File file = new File(filePath)
        def fileLines = 0
        if (file.isDirectory()) {
            return fileLines
        }
        def startIndex = file.name.indexOf('.')
        if (startIndex > 0) {
            def suffix = file.name.substring(startIndex)
            if (suffixs.contains(suffix)) {
                file.eachLine {
                    str ->
                        if (str && str.trim().size() > 1) {
                            fileLines ++
                        }
                }
            }
        }

        return fileLines
    }
}
