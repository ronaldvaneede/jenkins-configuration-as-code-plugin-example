pipeline {
    agent any
    tools {
        gradle '4.6'
    }
    stages {
        stage('Example Build') {
            steps {
                echo 'Hello, Build'
                sh 'gradle --version'
            }
        }
        stage('Example Test') {
            steps {
                echo 'Hello, Test'
            }
        }
    }
}
