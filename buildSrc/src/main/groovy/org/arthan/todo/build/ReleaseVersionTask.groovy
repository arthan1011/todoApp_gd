package org.arthan.todo.build

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

/**
 * Created by arthan on 24.11.2016. | Project todoApp_gd
 */
class ReleaseVersionTask extends DefaultTask {
    @Input Boolean release
    @OutputFile File destFile

    ReleaseVersionTask() {
        group = 'versioning'
        description = 'Makes project a release version (CustomTask).'
    }

    @TaskAction
    void start() {
        project.version.release = true
        ant.propertyfile(file: destFile) {
            entry(key: 'release', type: 'string', operation: '=', value: 'true')
        }
    }
}
