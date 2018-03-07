String basePath = 'projects'
String repo = 'https://github.com/rveede/jenkins-configuration-as-code-plugin-example.git'

folder(basePath) {
    description 'This example shows basic folder/job creation.'
}

multibranchPipelineJob("$basePath/project1") {
    branchSources {
        git {
            remote(repo)
        }
    }
    configure {
        it / factory(class: 'org.jenkinsci.plugins.workflow.multibranch.WorkflowBranchProjectFactory') {
            owner(class: 'org.jenkinsci.plugins.workflow.multibranch.WorkflowMultiBranchProject', reference: '../..')
            scriptPath("project1/Jenkinsfile")
        }
    }
    triggers {
        periodic(5)
    }
}

multibranchPipelineJob("$basePath/project2") {
    branchSources {
        git {
            remote(repo)
        }
    }
    configure {
        it / factory(class: 'org.jenkinsci.plugins.workflow.multibranch.WorkflowBranchProjectFactory') {
            owner(class: 'org.jenkinsci.plugins.workflow.multibranch.WorkflowMultiBranchProject', reference: '../..')
            scriptPath("project2/Jenkinsfile")
        }
    }
    triggers {
        periodic(5)
    }
}
