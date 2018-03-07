String basePath = 'example'
String repo = 'https://github.com/rveede/jenkins-configuration-as-code-plugin-example.git'

folder(basePath) {
    description 'This example shows basic folder/job creation.'
}

multibranchPipelineJob("$basePath/job-using-jenkinsfile") {
    branchSources {
        git {
            remote(repo)
        }
    }
    factory {
        workflowMultiBranchProjectFactory {
            scriptPath('project1/Jenkinsfile')
        }
    }
    triggers {
        periodic(5)
    }
}

multibranchPipelineJob("$basePath/job-using-jenkinsfile") {
    branchSources {
        git {
            remote(repo)
        }
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
