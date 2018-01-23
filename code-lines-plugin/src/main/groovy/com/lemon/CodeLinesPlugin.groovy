package com.lemon

import com.lemon.task.CodeLinesTask
import org.gradle.api.Plugin
import org.gradle.api.Project

class CodeLinesPlugin implements Plugin<Project> {

    def EXTENSION_NAME = 'codeLinesExtension'
    def TASK_NAME = 'codeLines'

    @Override
    void apply(Project target) {
        CodeLinesExtension extension = target.extensions.create(EXTENSION_NAME, CodeLinesExtension)
        CodeLinesTask task = target.tasks.create(TASK_NAME, CodeLinesTask)

        task.doFirst {
            if (extension.dir) {
                task.src = extension.dir
            } else {
                task.src = './'
            }
            println "Statistics code lines dir : $task.src"
            if (extension.suffixs) {
                task.suffixs = extension.suffixs
            } else {
                task.suffixs = '.java'
            }
            println "Statistics code lines file types : $task.suffixs"
        }
    }
}
