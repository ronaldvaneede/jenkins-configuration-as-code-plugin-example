String basePath = 'example'
String repo = 'rveede/jenkins-configuration-as-code-plugin-example'

folder(basePath) {
    description 'This example shows basic folder/job creation.'
}

multibranchPipelineJob("$basePath/job-using-jenkinsfile") {
    branchSources {
        github repo
    }
    factory {
        workflowMultiBranchProjectFactory {
            scriptPath('project2/Jenkinsfile')
        }
    }
    triggers {
        periodic(5)
    }
}
