basePath = 'projects'

folder(basePath) {
    description 'This example shows basic folder/job creation.'
}

def projects = [
        [ name: 'project1', repo: 'https://github.com/rveede/jenkins-configuration-as-code-plugin-example.git'],
        [ name: 'project2', repo: 'https://github.com/rveede/jenkins-configuration-as-code-plugin-example.git']
]

projects.each { project ->
    multibranchPipelineJob("${basePath}/${project.name}") {
        branchSources {
            git {
                remote("${project.repo}")
            }
        }
        configure {
            // This is a hack because the JobDSL does not yet have a nice way to define the scriptPath afaik
            // This is needed because the Jenkinksfile is not in the root...this happens when you do not stick to the convention
            it / factory(class: 'org.jenkinsci.plugins.workflow.multibranch.WorkflowBranchProjectFactory') {
                owner(class: 'org.jenkinsci.plugins.workflow.multibranch.WorkflowMultiBranchProject', reference: '../..')
                scriptPath("${project.name}/Jenkinsfile")
            }
        }
        triggers {
            periodic(5)
        }
    }
}