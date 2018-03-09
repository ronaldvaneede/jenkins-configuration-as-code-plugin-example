basePath = 'projects'

folder(basePath) {
    description 'This example shows basic folder/job creation.'
}

def projects = [
    [ name: 'project1', repo: 'git@github.com:rveede/example-project-1.git'],
    [ name: 'project2', repo: 'git@github.com:rveede/example-project-2.git']
]

projects.each { project ->
    multibranchPipelineJob("${basePath}/${project.name}") {
        branchSources {
            git {
                remote("${project.repo}")
            }
        }
        triggers {
            periodic(5)
        }
    }
}